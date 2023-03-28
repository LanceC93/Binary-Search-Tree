//Name: Lance Cross 
//Due Date: 03/30/23
//implements a binary search tree

public class BinarySearchTree<T extends Comparable<T>> {
    
    private NodeType<T> root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * adds a new node to the BST
     * @param key value that needs to be added to tree
     */
    public void insert(T key) {
        //adds to empty tree
        if(root==null) {
            root = new NodeType<T>(key, null, null);
            return;
        }
        NodeType<T> current = root;
        NodeType<T> prev = null;

        //finds where the node needs to be added
        while(current != null) {
            if(key.compareTo(current.info) < 0) {
                prev = current;
                current = current.left;
            } else if(key.compareTo(current.info) > 0) {
                prev = current;
                current = current.right;
            } else {
                System.out.println("The item already exists in the tree.");
                return;
            }
        }
        //adds node to tree
        if(key.compareTo(prev.info) < 0) {
            prev.left = new NodeType<T>(key,null,null);
        } else if(key.compareTo(prev.info) > 0) {
            prev.right = new NodeType<T>(key,null,null);
        }

    }

}
