public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    public Node<T> root;


    @Override
    public void insert(T data) {
        root = insert(root, data);
    }


    private Node<T> insert(Node<T> node, T data) {

        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        return balanceTree(data, node);

    }

    private Node<T> balanceTree(T data, Node<T> node) {

        int balance = getBalance(node);
        //doubly left
        if (balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0) {
            return rightRotation(node);
        }

        //left-right
        if (balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0) {
            node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }

        //right right
        if (balance < -1 && data.compareTo(node.getRightNode().getData()) > 0) {
            return leftRotation(node);
        }
        //right left
        if (balance < -1 && data.compareTo(node.getRightNode().getData()) < 0) {
            node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }

        return node;

    }

    private Node<T> rightRotation(Node<T> node) {

        Node<T> left = node.getLeftNode();
        Node<T> right = left.getRightNode();

        node.setLeftNode(right);
        left.setRightNode(node);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        left.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);


        return left;

    }

    private Node<T> leftRotation(Node<T> node) {
        Node<T> right = node.getRightNode();
        Node<T> left = right.getLeftNode();

        node.setRightNode(left);
        right.setLeftNode(node);

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        right.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        return right;
    }


    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }

        return (Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

    }

    private int getBalance(Node<T> node) {

        if (node == null) {
            return 0;
        }
        return (height(node.getLeftNode()) - height(node.getRightNode()));
    }


    @Override
    public void traverse() {

        if (root == null){
            return;
        }
        inorder(root);
    }

    void inorder(Node<T> node) {

        if (node.getLeftNode() != null)
            inorder(node.getLeftNode());

        System.out.println(node);

        if (node.getRightNode() != null)
            inorder(node.getRightNode());

    }


    @Override
    public void delete(T data) {

        root = deleteNode(data, root);

    }


    private Node<T> deleteNode(T data, Node<T> node) {

        if (node == null) {
            return node;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(deleteNode(data, node.getLeftNode()));
        } else if (data.compareTo(node.getData())>0){
            node.setRightNode(deleteNode(data,node.getRightNode()));
        }else{

            //leaf node
            if (node.getRightNode() == null && node.getLeftNode() == null){
                return null;
            }
            if (node.getLeftNode() == null){
                Node<T> tempRight = node.getRightNode();
                node =null;
                return tempRight;
            }

            if (node.getRightNode() == null){
                Node<T> tempLeft = node.getLeftNode();
                node=null;
                return tempLeft;
            }

            Node<T> tempNode = predecessor(node.getLeftNode());
            node.setData(tempNode.getData());
            node.setLeftNode(deleteNode(tempNode.data,node.getLeftNode()));

        }

        node.setHeight(Math.max(height(node.getLeftNode()),height(node.getRightNode())+1));
        return balanceDeletion(node);

    }


    private Node<T> balanceDeletion(Node<T> node){

        int balance = getBalance(node);
        if (balance>1){

            if (getBalance(node.getLeftNode())<0){
                leftRotation(node.getLeftNode());
            }
            return rightRotation(node);

        }

        if (balance<-1){

            if (getBalance(node.getRightNode())>0){
                rightRotation(node.getRightNode());
            }
            return leftRotation(node);
        }

        return node;

    }


    private Node<T> predecessor(Node<T> node){

        if (node.getRightNode() == null){
            return node;
        }
        else {
            return predecessor(node.getRightNode());
        }
    }
}
