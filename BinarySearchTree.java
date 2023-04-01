//Name: Lance Cross 
//Due Date: 03/30/23
//implements a binary search tree

public class BinarySearchTree<T extends Comparable<T>> {
    
    private NodeType<T> root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * allows retrieval of the root node
     * @return root of the tree
     */
    public NodeType<T> getRoot() {
        return root;
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
        } else {
            prev.right = new NodeType<T>(key,null,null);
        }

    }

    /**
     * deletes a value from the tree
     * @param key value that needs to be deleted
     */
    public void delete(T key) {
        //says item not present if tree is empty or item isnt found
        if(root!=null) {
            NodeType<T> current = root;
            NodeType<T> prev = null;

            //finds where the node is
            while(current != null) {
                if(key.compareTo(current.info) < 0) {
                    prev = current;
                    current = current.left;
                } else if(key.compareTo(current.info) > 0) {
                    prev = current;
                    current = current.right;
                } else {
                    if(current.right == null && current.left == null) { //case where node is a leaf
                        if(current.info.compareTo(prev.info) < 0) {
                            prev.left = null;
                        } else {
                            prev.right = null;
                        }
                    } else if(current.right == null) { //cases where there is a single child
                        if(current.info.compareTo(prev.info) < 0) {
                            prev.left = current.left;
                        } else {
                            prev.right = current.left;
                        }
                    } else if(current.left == null) {
                        if(current.info.compareTo(prev.info) < 0) {
                            prev.left = current.right;
                        } else {
                            prev.right = current.right;
                        }
                    } else { //case where node has two children so it finds predecessor
                        NodeType<T> pred = current.left;
                        prev = current;
                        if(pred.right != null) {
                            while(pred.right != null) {
                                prev = pred;
                                pred = pred.right;
                            }
                            current.info = pred.info;
                            prev.right = null;
                        } else {
                            current.info = pred.info;
                            current.left = pred.left;
                        }
                    }
                    return;
                }
            }
        } 
        System.out.println("Item is not present in the tree.");
    }

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
                    current = null;
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

    /**
     * prints all single parent nodes
     * @param node current node that is being traversed
     */
    public void getSingleParent(NodeType<T> node) {
        if(node != null) {
            getSingleParent(node.left);
            if((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
                System.out.print(node.info + " ");
            }
            getSingleParent(node.right);
        } else {
            return;
        }
    }
}
