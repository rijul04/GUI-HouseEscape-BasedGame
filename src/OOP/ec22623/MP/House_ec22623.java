package OOP.ec22623.MP;

class House_ec22623 extends House {

    Room room1 = new Room_ec22623();
    Room room2 = new Room_ec221148();
    Room room3 = new Room_ec22436();
    Room room4 = new Room_ec221136();
    Room room5 = new Room_ec221208();

    public Direction visit(Visitor visitor, Direction d) {

        char[] NESW = new char[4];
        NESW[0] = 'N';
        NESW[1] = 'E';
        NESW[2] = 'S';
        NESW[3] = 'W';
        int[] place = {0,1,2,3,4,5,6};
        int position = place[0];
        visitor.map(position);
        boolean escaped = false;
        boolean first = false;

        visitor.tell("You are in a house with 6 rooms. They are located as follows: 2 rooms to the left and right which are next to each other and one room to the end of the corridor. It is like a 3 x 3.");


        while(!escaped) {
            if(position==place[0] && !first) {
                char choice1 = visitor.getChoice("You have the options of going: North, East, South, West. Where would you like to go first? (N,E,S,W)", NESW);
                if(choice1==('N')) {
                    visitor.tell("You move one step up you can now go forward, left, right to enter a room or take a step back. (N,E,S,W)");
                    position = place[6];
                    visitor.map(position);
//                    first = true;
                }
                else if(choice1==('E')) {
                    visitor.tell("You are now in Room 2. (N,E,S,W)");
                    position = place[2];
                    visitor.map(position);
                    d = Direction.FROM_WEST;
                    d = room2.visit(visitor, d);
//                    first = true;
                }
                else if(choice1==('W')) {
                    visitor.tell("You are now in Room 1. (N,E,S,W)");
                    position = place[1];
                    visitor.map(position);
                    d = Direction.FROM_EAST;
                    d = room1.visit(visitor, d);
//                    first = true;
                }
                else if(choice1==('S')) {
                    visitor.tell("You can't leave, through that way. (N,E,S,W)");
//                    first = true;
                }
            }
//            else if(position==place[0]) {
//                if(d==Direction.TO_NORTH) {
//                    visitor.tell("You move one step up you can now go forward, left, right to enter a room or take a step back. (N,E,S,W)");
//                    position = place[6];
//                }
//                else if(d==Direction.TO_EAST) {
//                    visitor.tell("You are now in Room 2. (N,E,S,W)");
//                    position = place[2];
//                    d = Direction.FROM_WEST;
//                    d = room2.visit(visitor, d);
//                }
//                else if(d==Direction.TO_SOUTH) {
//                    visitor.tell("You can't leave, through that way. (N,E,S,W)");
//                }
//                else if(d==Direction.TO_WEST) {
//                    visitor.tell("You are now in Room 2. (N,E,S,W)");
//                    position = place[2];
//                    d = Direction.FROM_EAST;
//                    d = room2.visit(visitor, d);
//                }
//            }
            else if(position==place[1]) {
                if(d==Direction.TO_NORTH) {
                    visitor.tell("You are now in room 3. (N,E,S,W)");
                    position = place[3];
                    visitor.map(position);
                    d = Direction.FROM_SOUTH;
                    d = room3.visit(visitor, d);
                }
                else if(d==Direction.TO_EAST) {
                    visitor.tell("You are back in the corridor you can go any direction now except leave through south :))). (N,E,S,W)");
                    position = place[0];
                    visitor.map(position);
                }
                else if(d==Direction.TO_SOUTH) {
                    visitor.tell("You are now in Room 3. (N,E,S,W)");
                    position = place[3];
                    visitor.map(position);
                    d = Direction.FROM_NORTH;
                    d = room3.visit(visitor, d);
                }
                else if(d==Direction.TO_WEST) {
                    visitor.tell("You are now in Room 1. (N,E,S,W)");
                    position = place[1];
                    visitor.map(position);
                    d = Direction.FROM_EAST;
                    d = room1.visit(visitor, d);
                }
            }
            else if(position==place[2]) {
                if(d==Direction.TO_NORTH) {
                    visitor.tell("You are now in room 4. (N,E,S,W)");
                    position = place[4];
                    visitor.map(position);
                    d = Direction.FROM_SOUTH;
                    d = room4.visit(visitor, d);
                }
                else if(d==Direction.TO_EAST) {
                    visitor.tell("You are now in room 1. (N,E,S,W)");
                    position = place[1];
                    visitor.map(position);
                    d = Direction.FROM_WEST;
                    d = room1.visit(visitor, d);
                }
                else if(d==Direction.TO_SOUTH) {
                    visitor.tell("You are now in Room 4. (N,E,S,W)");
                    position = place[4];
                    visitor.map(position);
                    d = Direction.FROM_NORTH;
                    d = room4.visit(visitor, d);
                }
                else if(d==Direction.TO_WEST) {
                    visitor.tell("You are back in the corridor you can go any direction now except leave through south :))). (N,E,S,W)");
                    position = place[0];
                    visitor.map(position);
                }
            }
            else if(position==place[3]) {
                if(d==Direction.TO_NORTH) {
                    visitor.tell("You are now in room 1. (N,E,S,W)");
                    position = place[1];
                    visitor.map(position);
                    d = Direction.FROM_SOUTH;
                    d = room1.visit(visitor, d);
                }
                else if(d==Direction.TO_EAST) {
                    visitor.tell("You are back in the corridor you can go any direction now except leave :))). (N,E,S,W)");
                    position = place[6];
                    visitor.map(position);
                }
                else if(d==Direction.TO_SOUTH) {
                    visitor.tell("You are now in Room 1. (N,E,S,W)");
                    position = place[1];
                    visitor.map(position);
                    d = Direction.FROM_NORTH;
                    d = room1.visit(visitor, d);
                }
                else if(d==Direction.TO_WEST) {
                    visitor.tell("You are now in Room 1. (N,E,S,W)");
                    position = place[4];
                    visitor.map(position);
                    d = Direction.FROM_EAST;
                    d = room4.visit(visitor, d);
                }
            }
            else if(position==place[4]) {
                if(d==Direction.TO_NORTH) {
                    visitor.tell("You are now in room 2. (N,E,S,W)");
                    position = place[2];
                    visitor.map(position);
                    d = Direction.FROM_SOUTH;
                    d = room2.visit(visitor, d);
                }
                else if(d==Direction.TO_EAST) {
                    visitor.tell("You are now in Room 3. (N,E,S,W)");
                    position = place[3];
                    visitor.map(position);
                    d = Direction.FROM_WEST;
                    d = room3.visit(visitor, d);
                }
                else if(d==Direction.TO_SOUTH) {
                    visitor.tell("You are now in Room 2. (N,E,S,W)");
                    position = place[2];
                    visitor.map(position);
                    d = Direction.FROM_NORTH;
                    d = room2.visit(visitor, d);
                }
                else if(d==Direction.TO_WEST) {
                    visitor.tell("You are back in the corridor you can go any direction now except leave :))). (N,E,S,W)");
                    position = place[6];
                    visitor.map(position);
                }
            }
            else if(position==place[5]) {
                if(d==Direction.TO_NORTH) {
                    escaped = true;
                }
                else if(d==Direction.TO_EAST) {
                    escaped = true;
                }
                else if(d==Direction.TO_SOUTH) {
                    visitor.tell("You are back in the corridor you can go any direction now except leave :))). (N,E,S,W)");
                    position = place[6];
                    visitor.map(position);
                }
                else if(d==Direction.TO_WEST) {
                    escaped = true;
                }
            }
            else if(position==place[6]) {
                char choice2 = visitor.getChoice("You have the options of going: North, East, South, West. Where would you like to go first? (N,E,S,W)", NESW);
                if(choice2=='N') {
                    visitor.tell("You are now in room 5. (N,E,S,W)");
                    position = place[5];
                    visitor.map(position);
                    d = Direction.FROM_SOUTH;
                    d = room5.visit(visitor, d);
                }
                else if(choice2=='E') {
                    visitor.tell("You are now in Room 4. (N,E,S,W)");
                    position = place[4];
                    visitor.map(position);
                    d = Direction.FROM_WEST;
                    d = room4.visit(visitor, d);
                }
                else if(choice2=='S') {
                    visitor.tell("You are still in the corridor. (N,E,S,W)");
                    position = place[0];
                    visitor.map(position);
                }
                else if(choice2=='W') {
                    visitor.tell("You are now in Room 3. (N,E,S,W)");
                    position = place[3];
                    visitor.map(position);
                    d = Direction.FROM_EAST;
                    d = room3.visit(visitor, d);
                }
            }

        }


//        public void Directionn(Direction d) {
//
//        }

        visitor.tell("You have now escaped well done!");
        visitor.leave();


        return d;
    }
}
