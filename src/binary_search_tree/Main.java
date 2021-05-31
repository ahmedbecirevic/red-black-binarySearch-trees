package binary_search_tree;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree.readFileToTree("C:\\Users\\User\\Documents\\Global_University_Students.csv");
        System.out.println(BinarySearchTree.studentData.get(11067546));

    }
}
