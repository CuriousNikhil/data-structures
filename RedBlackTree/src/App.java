public class App {

    public static void main(String[] args){

        RBTree tree = new RBTree();

        tree.insert(10);
        tree.traverse();
        tree.insert(20);
        tree.traverse();
        tree.insert(30);
        tree.traverse();
        tree.insert(15);

    }
}
