public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;


    @Override
    public void traverse() {
        //inorder traversal
        if (root == null) return;
        else{
            inorderTraverse(root);
        }

    }

    private void inorderTraverse(Node<T> node) {
        if (node.getLeftChild() != null){
            inorderTraverse(node.getLeftChild());
        }
        System.out.print(node+"---");
        if (node.getRightChild() != null) {
            inorderTraverse(node.getRightChild());
        }
    }


    @Override
    public void insert(T data) {

        if (root == null){
            root = new Node<>(data);
        }else{
            insertNode(root,data);
        }
    }

    private void insertNode(Node<T> node,T newdata){

        if (newdata.compareTo(node.getData()) < 0){

            if (node.getLeftChild() != null){
                insertNode(node.getLeftChild(),newdata);
            }else{
                Node<T> temp = new Node<>(newdata);
                node.setLeftChild(temp);
            }
        }else{
            if (node.getRightChild() != null){
                insertNode(node.getRightChild(),newdata);
            }else{
                Node<T> temp = new Node<>(newdata);
                node.setRightChild(temp);
            }
        }

    }



    @Override
    public void remove(T data) {

        if (root != null){
            root = delete(root,data);
        }

    }

    private Node<T> delete(Node<T> node,T data){
        if (node == null)return node;

        if (data.compareTo(node.getData())<0){
            node.setLeftChild(delete(node.getLeftChild(),data));
        }else if (data.compareTo(node.getData())>0){
            node.setRightChild(delete(node.getRightChild(),data));
        }else{
            //node found
            //leaf node
            if (node.getLeftChild() == null && node.getRightChild() == null){
                return null;
            }

            //node with right child
            if (node.getLeftChild() == null){
                Node<T> temp = node.getRightChild();
                node = null;
                return temp;
            }
            //node with left child
            if (node.getRightChild() == null){
                Node<T> temp = node.getLeftChild();
                node = null;
                return temp;
            }
            //node with two children
            Node<T> predecessor = getPredecessor(node.getLeftChild());
            node.setData(predecessor.getData());
            node.setLeftChild(delete(node.getLeftChild(),predecessor.getData()));
        }

        return node;
    }



    private Node<T> getPredecessor(Node<T> node){
        //finding the maximum element in the left subtree of given node
        if (node.getRightChild() != null){
            return getPredecessor(node.getRightChild());
        }
        return node;
    }


    @Override
    public T getMax() {
        if (root == null){
            return null;
        }else{
           return getMaxValue(root);
        }
    }

    private T getMaxValue(Node<T> node){
        if (node.getRightChild() != null){
            return getMaxValue(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public T getMin() {
        if (root == null){
            return null;
        }else{
            return getMinValue(root);
        }
    }

    private T getMinValue(Node<T> node){
        if (node.getLeftChild() != null){
            return getMinValue(node.getLeftChild());
        }
        return node.getData();
    }
}
