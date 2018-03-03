public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;
    private int size=0;

    @Override
    public void insert(T data) {
        this.size++;

        Node<T> tempNode = root;
        Node<T> parent = null;
        while (tempNode!=null){

            parent = tempNode;

            if (tempNode.getData().compareTo(data)<0){
                tempNode = tempNode.getRightNode();
            }else {
                tempNode = tempNode.getLeftNode();
            }

        }

        tempNode = new Node<>(data);
        tempNode.setParentNode(parent);

        if (parent == null){
            this.root = tempNode;
        }else if (parent.getData().compareTo(tempNode.getData())<0){
            parent.setRightNode(tempNode);
        }else {
            parent.setLeftNode(tempNode);
        }

        splaying(tempNode);
    }

    private void splaying(Node<T> node) {

        while (node.getParentNode() != null){

            //zig case
            if (node.getParentNode().getParentNode() == null){

                if (node.getParentNode().getLeftNode() == node){
                    rightRotation(node.getParentNode());
                }else {
                    leftRotation(node.getParentNode());
                }

            }
            //zig-zig case
            else if(node.getParentNode().getLeftNode() == node && node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()){
                rightRotation(node.getParentNode().getParentNode());
                rightRotation(node.getParentNode());
            }else if (node.getParentNode().getRightNode() == node && node.getParentNode().getParentNode().getRightNode() == node.getParentNode()){
                leftRotation(node.getParentNode().getParentNode());
                leftRotation(node.getParentNode());
            }
            //zig-zag case
            else if(node.getParentNode().getLeftNode() == node && node.getParentNode().getParentNode().getRightNode() == node.getParentNode()){
                rightRotation(node.getParentNode());
                leftRotation(node.getParentNode());
            }else {
                leftRotation(node.getParentNode());
                rightRotation(node.getParentNode());
            }


        }


    }


    private void rightRotation(Node<T> node){
        Node<T> tempLeft = node.getLeftNode();

        if (tempLeft!=null){
            node.setLeftNode(tempLeft.getRightNode());

            if (tempLeft.getRightNode() != null){
                tempLeft.getRightNode().setParentNode(node);
            }
            tempLeft.setParentNode(node.getParentNode());
        }

        if (node.getParentNode() == null){
            root = tempLeft;
        }else if (node == node.getParentNode().getRightNode()){
            node.getParentNode().setRightNode(tempLeft);
        }else {
            node.getParentNode().setLeftNode(tempLeft);
        }

        if (tempLeft != null){
            tempLeft.setRightNode(node);
        }

        node.setParentNode(tempLeft);

    }

    private void leftRotation(Node<T> node){
        Node<T> tempNode = node.getRightNode();

        if (tempNode != null) {

            node.setRightNode(tempNode.getLeftNode());

            if (tempNode.getLeftNode() != null) {
                tempNode.getLeftNode().setParentNode(node);
            }

            tempNode.setParentNode(node.getParentNode());
        }

        if (node.getParentNode() == null) {
            this.root = tempNode;
        } else if (node == node.getParentNode().getLeftNode()) {
            node.getParentNode().setLeftNode(tempNode);
        } else {
            node.getParentNode().setRightNode(tempNode);
        }

        if (tempNode != null) {
            tempNode.setLeftNode(node);
        }

        node.setParentNode(tempNode);
    }

    @Override
    public void traverse() {
        if (root!=null){
            inorder(root);
        }

    }

    private void inorder(Node<T> node){
        if (node.getLeftNode()!=null) {
            inorder(node.getLeftNode());
        }

        System.out.println(node+" ");

        if (node.getRightNode()!=null) {
            inorder(node.getLeftNode());
        }
    }


    @Override
    public boolean find(T data) {

        Node<T> tempNode = root;
        while (tempNode!=null){

            if (data.compareTo(tempNode.getData())<0){
                tempNode = tempNode.getLeftNode();
            }else if (data.compareTo(tempNode.getData())>0){
                tempNode = tempNode.getRightNode();
            }else {
                splaying(tempNode);
                return true;
            }

        }
        splaying(tempNode);
        return false;
    }

    public void printRoot(){
        System.out.println(root);
    }

}
