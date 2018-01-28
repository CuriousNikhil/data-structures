public class App {
    public static void main(String[] v){

        Queue<Integer> queue = new Queue<>();

        queue.enqueue(45);
        queue.enqueue(77);
        queue.enqueue(88);
        queue.enqueue(18);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.size());

        System.out.println(queue.isEmpty());
    }
}
