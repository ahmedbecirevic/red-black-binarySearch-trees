package red_black_tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RedBlackTree <Key extends Comparable<Key>, Value> {
    public static RedBlackTree<Integer, Student> studentData = new RedBlackTree<>();
    private Node<Key, Value> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    public static int numOfSearches;

    public Value get (Key key) {
        Node<Key, Value> node = root;
        numOfSearches = 1;
        while (node != null) {
            numOfSearches++;
            int compare = key.compareTo(node.key);
            if (compare < 0) {
                node = node.left;
            } else if (compare > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    private Node<Key, Value> rotateLeft (Node<Key, Value> node) {
        Node<Key, Value> x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node<Key, Value> rotateRight (Node<Key, Value> node) {
        Node<Key, Value> x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private boolean isRed (Node<Key, Value> node) {
        if (node == null) return false;
        return node.color == RED;
    }

    private void flipColor (Node<Key, Value> node) {
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }

    public void put (Key key, Value value) {
        root = put(root, key, value);
    }

    private Node<Key, Value> put (Node<Key, Value> node, Key key, Value value) {
        if (node == null) return new Node<>(key, value, RED);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.right) && isRed(node.left)) flipColor(node);
        if (isRed(node.left)  && isRed(node.left.left)) node = rotateRight(node);

        return node;
    }

    public static void readFileToTree (String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner readFile = new Scanner(file);

        while(readFile.hasNextLine()) {
            String[] line = readFile.nextLine().split(";");
            studentData.put(Integer.parseInt(line[0]),
                    new Student( Integer.parseInt(line[0]),
                            line[1],
                            line[2],
                            line[3],
                            line[4],
                            line[5],
                            Integer.parseInt(line[6])
                    )
            );
        }
        readFile.close();
    }

    public static int getNumOfSearches() {
        return numOfSearches;
    }
}