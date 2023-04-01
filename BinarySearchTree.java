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

    /**
     * deletes a value from the tree
     * @param key value that needs to be deleted
     */
    /*public void delete(T key) {

    }*/

    /**
     * searches tree for the key value
     * @param key value that is being searched for in tree
     * @return true if item is present, false otherwise
     */
    public boolean search(T key) {
            //returns false for empty trees
            if(root==null) {
                return false;
            }
            NodeType<T> current = root;
            boolean present = false;
    
            //finds where the node is
            while(current != null) {
                if(key.compareTo(current.info) < 0) {
                    current = current.left;
                } else if(key.compareTo(current.info) > 0) {
                    current = current.right;
                } else {
                    present = true;
                }
            }

            return present;
    }

    /**
     * prints the tree out in order
     */
    public void inOrder() {
        System.out.print("In order: ");
        inOrder(root);
        System.out.println();
    }

    /**
     * goes through the tree printing each node in order
     * @param node root of the subtree being traversed
     */
    private void inOrder(NodeType<T> node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.info + " ");
            inOrder(node.right);
        } else {
            return;
        }
    }
}
