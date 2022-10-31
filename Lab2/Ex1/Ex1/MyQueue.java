public class MyQueue<E> implements QueueInterface <E> {
    private Node<E> front;
    private Node<E> rear;
    private int numNode;

    public MyQueue(){
        front = null;
        rear = null;
        numNode = 0;
    }

    @Override
    public void enQueue(E item){
        Node<E> tmp = new Node<E>(item);
        if(rear == null){
            front = rear = tmp;
        }
        rear.setNext(tmp);
        rear = tmp;
        numNode++;
    }

    @Override
    public E deQueue(){
        if(front == null)
            return null;
        Node<E> tmp = front; // Lấy front
        front = front.getNext(); //update
        numNode--;
        return tmp.getData(); 
    }

    @Override
    public int size(){
        return numNode;
    }

    @Override
    public boolean contains(E item){
        Node<E> tmp = front;
        while((tmp != null)){
            if(tmp.getData().equals(item)){
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    @Override
    public void print(){
        if(front == null){
            System.out.println("Linked List is empty");
        }
        else{
            Node<E> tmp = front;
            while(tmp != null){
                System.out.println(tmp.getData());
                tmp = tmp.getNext();
                if(tmp != null){
                    System.out.println(" -> ");
                }
                else{
                    System.out.println();
                } 

            }
        }
    }

    @Override
    public boolean isEmpty(){
        if(front == null)
            return true;
        return false;
    }

    @Override
    public E getFront(){
        if(front != null)
            return front.getData();
        return null;
    }
}
