public class App {

    public static void main(String[] v){

        Stack<String> stack = new Stack<>();

        stack.push("Hello");
        stack.push("World");

        System.out.println(stack.pop());

        System.out.println(stack.size());
    }
}
