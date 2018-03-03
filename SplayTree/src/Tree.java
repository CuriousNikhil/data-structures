public interface Tree<T extends Comparable<T>> {

    void insert(T data);
    void traverse();
    boolean find(T data);
}
