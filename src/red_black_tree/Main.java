package red_black_tree;

import binary_search_tree.BinarySearchTree;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        RedBlackTree.readFileToTree("C:\\Users\\User\\Documents\\Global_University_Students.csv");
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the ID of the student you want to retrieve: ");
        int id = reader.nextInt();
        if (RedBlackTree.studentData.get(id) != null) {
            System.out.println(RedBlackTree.studentData.get(id));
            System.out.println("The search was completed in " + RedBlackTree.getNumOfSearches() + " steps.");
        } else {
            System.out.println("The student with the given ID does not exist :(");
            System.out.println("The search was completed in " + RedBlackTree.getNumOfSearches() + " steps.");
        }
        reader.close();
    }
}
