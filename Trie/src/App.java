import java.util.List;

public class App {

    /**
    * Caution:
    * The below code is only for the small letter strings, it will not work
    * for the capital letter strings as implemented with ascii code.    
    */

    public static void main(String[] a){

        Trie trie = new Trie();

        trie.insert("noidea");
        trie.insert("noideaatall");
        trie.insert("noideaatatall");
        trie.insert("idkaman");

        System.out.println(trie.search("noi"));

        List<String> list = trie.allWordsWithPrefix("no");
        for (String x:list){
            System.out.println(x);
        }

    }
}
