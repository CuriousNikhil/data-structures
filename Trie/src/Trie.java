import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root;
    private int single;

    public Trie() {
        this.root = new Node("");
    }

    public void insert(String key) {

        Node temp = root;

        for (int i = 0; i < key.length(); i++) {

            char c = key.charAt(i);
            int index = c - 'a';
            if (temp.getChild(index) == null) {
                Node node = new Node(String.valueOf(c));
                temp.setChild(index, node);
                temp = node;
            } else {
                temp = temp.getChild(index);
            }

        }

        // insert with key and along with value: pass parameter as value and
        // set temp.setValue(value); here

        temp.setLeaf(true);
    }

    public boolean search(String key){
        Node temp = root;
        for (int i=0;i<key.length();i++){

            char c = key.charAt(i);
            int index = c-'a';

            if (temp.getChild(index) == null){
                return false;
            }else {
                temp = temp.getChild(index);
            }
        }
        return true;

    }

    public List<String> allWordsWithPrefix(String prefix) {

        Node trieNode = root;
        List<String> allWords = new ArrayList<>();

        for(int i = 0;i<prefix.length();++i) {

            char c = prefix.charAt(i);
            int index = c-'a';
            trieNode = trieNode.getChild(index);
        }

        collect(trieNode, prefix, allWords);

        return allWords;
    }


    public String longestCommonPrefix() {

        Node trieNode = root;
        String lcp = "";

        while( countChildren(trieNode) == 1 && !trieNode.isLeaf() ) {
            trieNode = trieNode.getChild(single);
            lcp = lcp + String.valueOf((char) (single+'a'));
        }

        return lcp;
    }

    private int countChildren(Node trieNode) {

        int numOfChildren = 0;

        for(int i=0;i<trieNode.getChildren().length;++i) {
            if( trieNode.getChild(i) != null ) {
                numOfChildren++;
                single = i;
            }
        }

        return numOfChildren;
    }

    private void collect(Node node, String prefix, List<String> allWords) {

        if( node == null ) return;

        if( node.isLeaf() ){
            allWords.add(prefix);
        }

        for(Node childNode : node.getChildren()) {
            if( childNode == null ) continue;
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefix+childCharacter, allWords);
        }
    }

}
