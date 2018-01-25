public class App {

    public static void main(String[] v) {

        LinkedList<Integer> list = new LinkedList<>();

        list.insert(4);
        list.insert(8);
        list.insert(7);

        list.traverse();

        list.remove(4);

        list.traverse();

        System.out.println(list.size());
    }
}
