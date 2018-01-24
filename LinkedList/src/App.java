public class App {


    public static void main(String args[]){

        LinkedList<Integer> list = new LinkedList<>();

        list.insert(4);
        list.insert(10);
        list.insert(5);
        list.insert(18);

        System.out.println(list.size());

        list.traverse();

        if (list.remove(10)){
            System.out.println("\nItem deleted\n");
        }else {
            System.out.println("\nNo Item to delete\n");
        }

        if (list.remove(15)){
            System.out.println("\nItem deleted\n");
        }else {
            System.out.println("\nNo Item to delete\n");
        }

        list.traverse();

        list.insertAtEnd(33);
        list.insertAtEnd(44);
        list.insertAtEnd(55);

        list.traverse();

    }
}
