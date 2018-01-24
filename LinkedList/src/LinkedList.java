public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;

    private int size;

    @Override
    public void traverse() {
        Node<T> temp = head;

        while (temp != null){
            System.out.print(temp+"-->");

            temp = temp.getNextNode();
        }
    }

    @Override
    public boolean remove(T data) {

        Node<T> current = head;
        Node<T> prev = head;

        if (head == null){
            return false;
        }


        if (head.getData().compareTo(data) == 0){
            size--;
            head = head.getNextNode();
            return true;
        }else{

            while (current != null){

                if (current.getData() == data){
                    size--;
                    prev.setNextNode(current.getNextNode());
                    return true;
                }

                prev = current;
                current = current.getNextNode();
            }
        }


        return false;
    }

    @Override
    public void insert(T data) {
        size++;

        if (head == null){
            head = new Node<>(data);
        }else{

            Node<T> temp = new Node<>(data);
            temp.setNextNode(head);
            head = temp;
        }


    }

    //insert at end
    public void insertAtEnd(T data){
        size++;

        Node<T> temp = head;
        if (head == null) {
            head = new Node<>(data);
        }

        while (temp.getNextNode() != null){
            temp = temp.getNextNode();
        }

        temp.setNextNode(new Node<>(data));

    }

    @Override
    public int size() {
        return this.size;
    }
}
