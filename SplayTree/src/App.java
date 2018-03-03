public class App {

    public static void main(String[] a){

        Tree<Integer> splayTree = new SplayTree<>();

        splayTree.insert(5);
        splayTree.insert(4);
        splayTree.insert(6);
        splayTree.insert(2);
        splayTree.insert(7);

//        splayTree.traverse();
        System.out.println(splayTree.find(3));

        ((SplayTree)splayTree).printRoot();


    }
}
