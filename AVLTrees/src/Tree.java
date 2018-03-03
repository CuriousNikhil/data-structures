public interface Tree<T extends Comparable<T>> {

    void insert(T data);
    void traverse();
    void delete(T data);
}
