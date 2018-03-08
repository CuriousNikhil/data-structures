public class Node {

    private Node[] children;
    private int value;
    private boolean leaf;
    private String character;

    public Node(String character) {
        this.character = character;
        this.children = new Node[26];
    }

    public void setChild(int index, Node node){
        this.children[index] = node;
    }

    public Node getChild(int index){
        return children[index];
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Override
    public String toString() {
        return this.character;
    }
}


