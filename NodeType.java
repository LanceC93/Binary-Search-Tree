//Name: Lance Cross 
//Due Date: 03/30/23
//implements generic nodes of a BST

public class NodeType<T extends Comparable<T>> {

    public T info;

    public NodeType<T> left;

    public NodeType<T> right;

    public NodeType(T key, NodeType<T> l, NodeType<T> r) {
        info = key;
        left = l;
        right = r;
    }
}