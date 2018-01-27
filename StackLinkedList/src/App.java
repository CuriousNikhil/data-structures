public class App {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        stack.push(12);
        stack.push(15);
        stack.push(17);
        stack.push(10);

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.size());

        System.out.println(stack.isEmpty());
    }
}
