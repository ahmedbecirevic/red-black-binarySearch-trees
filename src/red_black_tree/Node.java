package red_black_tree;

public class Node<Key extends Comparable<Key>, Value> {
    public Key key;
    public Value value;
    public Node<Key, Value> right, left;
    public boolean color;

    public Node (Key key, Value value, boolean color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }
}
