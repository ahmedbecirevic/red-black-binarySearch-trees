package binary_search_tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTree <Key extends Comparable<Key>, Value>{
    public static BinarySearchTree<Integer, Student> studentData = new BinarySearchTree<>();
    private Node<Key, Value> root;
    private int numOfSearches = 1;

    public Value get (Key key) {
        Node<Key, Value> node = root;
        while (node != null) {
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

    public void put (Key key, Value value) {
        root = put(root, key, value);
    }

    private Node<Key, Value> put (Node<Key, Value> node, Key key, Value value) {
        if (node == null) return new Node<>(key, value);

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public int size () {
        return size(root);
    }
    private int size(Node<Key, Value> node) {
        if (node == null) return 0;
        return node.size;
    }

    public Key findMin () {
        return findMin(root).key;
    }

    private Node<Key, Value> findMin (Node<Key, Value> node) {
        if (node.left == null) return node;
        return findMin(node.left);
    }

    public Key findMax () {
        return findMax(root).key;
    }

    private Node<Key, Value> findMax (Node<Key, Value> node) {
        if (node.right == null) return node;
        return findMax(node.right);
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

    public void setNumOfSearches(int numOfSearches) {
        this.numOfSearches = numOfSearches;
    }

    public int getNumOfSearches() {
        return numOfSearches;
    }
}
