import java.util.NoSuchElementException;

public class CharLinkedList implements ListInterface {
    private Node head;
    public int numNode;
    public CharLinkedList(){
        head = null;
        numNode = -1;
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public void addFirst(char data) {
        head = new Node(data,head);
        numNode++;
    }

    @Override
    public boolean addAfterFirstKey(char data, char key) {
        Node curr = head;
        while(curr != null){
            if(curr.getData() == key){
                Node newNode = new Node(data, curr.getNext());
                curr.setNext(newNode);
                numNode++;
                return true;
            }
            curr=curr.getNext();
        }
        return false;
    }

    @Override
    public int largestCharPostition() {
        if(head==null){
            return -1;
        }
        Node curr = head;
        int a = curr.getData();
        int b = numNode;
        int c = 0;
        while(curr!=null){
            if(a<curr.getData()){
                a = curr.getData();
                c = b;
            }
            curr = curr.getNext();
            b--;
        }
        return c;
    }

    public void print() {
        if(head != null){
            Node tmp = head;
            System.out.print("List:");
            while(tmp != null){
                System.out.print(" "+ tmp.getData());
                tmp = tmp.getNext();
            }
            System.out.println();
        }else{
            throw new NoSuchElementException("null");
        }

    }
}
