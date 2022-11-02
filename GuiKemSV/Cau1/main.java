public class main {
    public static void main(String[] args) {
        CharLinkedList cl = new CharLinkedList();
        cl.addFirst('c');
        cl.addFirst('b');
        cl.addFirst('A');
        cl.print();
        System.out.println(cl.addAfterFirstKey('R', 'b'));
        cl.print();
    }
}
