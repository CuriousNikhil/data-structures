public class App {

    public static void main(String[] v){

        Tree<Integer> bst = new BinarySearchTree<>();

        bst.insert(15);
        bst.insert(22);
        bst.insert(33);
        bst.insert(13);
        bst.insert(17);

        bst.traverse();
        System.out.println();
        System.out.println(bst.getMax());
        System.out.println(bst.getMin());

        bst.remove(15);
        bst.traverse();
    }

}
