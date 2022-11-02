public class main {
    public static void main(String[] args) {
        CharLinkedList cl = new CharLinkedList();
        cl.addFirst('c');
        cl.addFirst('b');
        cl.addFirst('A');
        cl.addFirst('d');
        cl.addFirst('t');
        cl.addFirst('f');
        cl.print();
        //System.out.println(cl.addAfterFirstKey('R', 'b'));
        System.out.println(cl.numNode);
        cl.print();
    }
}
