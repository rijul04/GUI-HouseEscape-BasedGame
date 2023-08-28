package OOP.ec22623.MP;

class houseTest { //To use just in case MP_ec22623.java isn't running
    public static void main (String[]args) {
        House h = new House_ec22623();
        Visitor v = new MP_ec22623(System.out,System.in);
//        Visitor v = new IOVisitor(System.out,System.in);
        Direction d = h.visit(v, Direction.FROM_SOUTH);
    }
}