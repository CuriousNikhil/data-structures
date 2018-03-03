public class App {
    public static void main(String[] v){

        Tree<Integer> avlTree = new AVLTree<Integer>();

        avlTree.insert(2);
        avlTree.insert(4);
        avlTree.insert(6);
        avlTree.insert(1);


        avlTree.delete(2);
        avlTree.traverse();

    }
}
