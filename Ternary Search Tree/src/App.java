public class App {

    public static void main(String[] a){

        TST tst = new TST();
        tst.insert("abcd",9);
        tst.insert("abcc",10);
        tst.insert("apbcc",1);
        tst.insert("agbcc",11);

        System.out.println(tst.get("abcc"));
        System.out.println(tst.get("acc"));

    }
}
