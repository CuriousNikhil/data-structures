public class LinkedList<T extends Comparable<T>> implements List<T> {

    private int size;
    private Node<T> head;


    @Override
    public void traverse() {
        Node<T> temp = head;
        while (temp!=null){
            System.out.print(temp.getData()+ "<-->");
            temp = temp.getNext();
        }
        System.out.println();

    }

    @Override
    public boolean remove(T data) {

        Node<T> temp = head;

        if (head == null){
            return false;
        }
        if (head.getData().compareTo(data) == 0){
            size--;
            head.getNext().setPrev(null);
            head = head.getNext();
            return true;

        }
        if (head.getNext().getData().compareTo(data) == 0 && head.getNext().getNext() == null){
            head.setNext(null);
            size--;
            return true;
        }

        else{

            while (temp!=null){

                if (temp.getData().compareTo(data) == 0){
                    size--;
                    if (temp.getNext() != null){
                        temp.getPrev().setNext(temp.getNext());
                        temp.getNext().setPrev(temp.getPrev());
                    }else {
                        temp.getPrev().setNext(null);
                    }

                    return true;
                }

                temp = temp.getNext();

            }

        }

        return false;
    }

    @Override
    public void insert(T data) {
        size++;
        if (head == null){
            head = new Node<>(data);
            head.setNext(null);
            head.setPrev(null);
            return;
        }
        else{
            Node<T> temp = new Node<>(data);
            temp.setNext(head);
            temp.setPrev(null);
            head.setPrev(temp);
            head = temp;
        }

    }

    //inserting at the end
    public void insertAtEnd(T data){
        size++;
        if (head == null){
            head = new Node<>(data);
            head.setNext(null);
            head.setPrev(null);
        } else{

            Node<T> temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            Node<T> item = new Node<>(data);
            temp.setNext(item);
            item.setNext(null);
            item.setPrev(temp);
        }
    }

    //inserting at any middle position

    public void insertAtMiddle(T data, int position){
        size++;
        int index = -1;
        Node<T> temp = head;

        while (temp != null){

            if (index == position-1){

                Node<T> item = new Node<>(data);
                item.setNext(temp.getNext());
                temp.getNext().setPrev(item);
                temp.setNext(item);
                item.setPrev(temp);

            }
            temp = temp.getNext();
            index++;

        }


    }


    @Override
    public int size() {
        return this.size;
    }
}
