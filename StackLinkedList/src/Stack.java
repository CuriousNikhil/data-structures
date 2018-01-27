public class Stack<T extends Comparable<T>> {

    private Node<T> head;
    private int size;

    public void push(T data) {

        size++;
        if (head == null){
            head = new Node<>(data);
        }else{

            Node<T> temp = new Node<>(data);
            temp.setNextNode(head);
            this.head = temp;
        }

    }

    public T pop(){

        if (head == null){
            return null;
        }else{
            size--;
            T item = head.getData();
            head = head.getNextNode();
            return item;
        }

    }

    public T peek(){
        return head.getData();
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        return size;
    }

}
