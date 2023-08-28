package OOP.ec22623.MP;

public class Room_ec22623 extends Room {

    Item item = new Item("Coat");
    boolean temp; // true=cold false=warm

    public Direction visit(Visitor visitor, Direction crimson) {
        char[] yesNo = {'y', 'n'};

        if (crimson == Direction.FROM_EAST) {

            visitor.tell("You come from east, so you are cold");
            visitor.tell("You are cold so you may freeze.");

            if (visitor.hasEqualItem(item) || visitor.hasIdenticalItem(item)) {
                visitor.tell("You find a coat");
                visitor.tell("You are already wearing one.");
            }
            else {
                char choice = visitor.getChoice("You see a wardrobe do you want to get some clothes from the wardrobe?(y/n)", yesNo);

                if (choice == 'y') {
                    visitor.tell("You find a coat.");
                    visitor.giveItem(item);
                    visitor.tell("You now have a coat.");
                }
                else {
                    visitor.giveGold(2);
                    visitor.giveItem(item);
                    visitor.tell("You are still cold. However, someone walks by giving you a coat with some money");
                }
            }
        }
        else {
            visitor.tell("You are not cold.");
            visitor.tell("Lucky you. Just pay to leave the room now. (You have no choice in this)");
            int gold_taken = visitor.takeGold(1);
            visitor.tell("You have lost " + gold_taken + " in this room.");
        }
        visitor.tell("You are forced to leave the room.");
        return Direction.opposite(crimson);
    }

}
