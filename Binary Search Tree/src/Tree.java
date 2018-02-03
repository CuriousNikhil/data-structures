public interface Tree<T> {
    public void traverse();
    public void insert(T data);
    public void remove(T data);
    public T getMax();
    public T getMin();
}
