package binary_search_tree;

public class Node <Key extends Comparable<Key>, Value> {
    public Key key;
    public Value value;
    public Node<Key, Value> right, left;
    public int size = 1;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
