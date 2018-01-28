public class Queue<T extends Comparable<T>> {

    private Node<T> firstNode;
    private Node<T> lastNode;

    private int size;

    public void enqueue(T data){

        size++;

        Node<T> newNode = lastNode;
        lastNode = new Node<>(data);
        lastNode.setNextNode(null);

        if (isEmpty()){
            firstNode = lastNode;
        }else {
            newNode.setNextNode(lastNode);
        }

    }

    public T dequeue(){
        this.size--;

        T data = firstNode.getData();
        firstNode = firstNode.getNextNode();

        if( isEmpty() ){
            this.lastNode = null;
        }

        return data;
    }


    public boolean isEmpty(){
        return this.firstNode == null;
    }

    public int size(){
        return this.size;
    }
}
