public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> node;

    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return node;
    }

    public void setNextNode(Node<T> node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
