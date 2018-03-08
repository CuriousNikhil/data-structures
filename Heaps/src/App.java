public class App {

    public static void main(String[] a){

        Heap heap = new Heap(10);
        heap.insert(5);
        heap.insert(2);
        heap.insert(1);
        heap.insert(10);
        heap.insert(15);

        System.out.println(heap.getMax());
        System.out.println(heap.getMax());
        System.out.println(heap.getMax());
        System.out.println(heap.getMax());


    }

}
