//Name: Lance Cross 
//Due Date: 03/30/23
//driver for a binary search tree

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryTreeDriver {

    public static void main(String[] args) {
        //checks that a file was given to read from
        if(args.length == 0) {
            System.out.println("Sorry. Please include a file.");
        } else {
            //makes sure the file exists
            try {
                File input = new File(args[0]);
                Scanner console = new Scanner(System.in);

                //gets input type
                String inputType = getInput(console);
                //reads file into tree
                console = new Scanner(input);
                if(inputType.equals("s")) {
                    stringTree(console);
                } else if (inputType.equals("i")) {
                    intTree(console);
                } else {
                    doubleTree(console);
                }
            }     
            catch (FileNotFoundException e) {
                System.out.println("File was not found.");
            }
        }
    }

    /**
     * @param console reads from the command line 
     * @return returns string representing the input type
     */
    public static String getInput(Scanner console) {
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        String inputType = console.next();
        while(!inputType.equals("i") && !inputType.equals("d") && !inputType.equals("s")) {
            System.out.print("Enter list type (i - int, d - double, s - string): ");
            inputType = console.next();
        }
        return inputType;
    }

    /**
     * allows the user to interact with a tree of Strings
     * @param console reads command line input
     */
    public static void stringTree(Scanner console) {
        BinarySearchTree<String> b1 = new BinarySearchTree<>();
        while(console.hasNext()) {
            b1.insert(console.next());
        }
        commands();
        console = new Scanner(System.in);
        System.out.print("Enter Command: ");
        String s = console.next();
        while(!s.equals("q")) {
            //executes commmand given a corresponding input
            switch(s) {
                case "i":
                    b1.inOrder();
                    System.out.print("Enter a string to insert: ");
                    b1.insert(console.next());
                    b1.inOrder();
                    break;
                case "d":
                    b1.inOrder();
                    System.out.print("Enter a string to delete: ");
                    b1.delete(console.next());
                    b1.inOrder();
                    break;
                case "p":
                    b1.inOrder();
                    break;
                case "s":
                    b1.inOrder();
                    System.out.print("Enter a string to search: ");
                    if(b1.search(console.next())) {
                        System.out.println("Item is present in the tree.");
                    } else {
                        System.out.println("Item is not present in the tree.");
                    }
                    break;
                case "sp":
                    System.out.print("Single Parents: ");
                    b1.getSingleParent(b1.getRoot());
                    System.out.println();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Invalid Command.");
            }
            System.out.print("Enter Command: ");
            s = console.next();
        }
        console.close();
    }

    /**
     * allows the user to interact with a tree of Integers
     * @param console reads command line input
     */
    public static void intTree(Scanner console) {
        BinarySearchTree<Integer> b1 = new BinarySearchTree<>();
        while(console.hasNext()) {
            b1.insert(Integer.parseInt(console.next()));
        }
        commands();
        console = new Scanner(System.in);
        System.out.print("Enter Command: ");
        String s = console.next();
        while(!s.equals("q")) {
            //executes commmand given a corresponding input
            switch(s) {
                case "i":
                    b1.inOrder();
                    System.out.print("Enter a number to insert: ");
                    b1.insert(Integer.parseInt(console.next()));
                    b1.inOrder();
                    break;
                case "d":
                    b1.inOrder();
                    System.out.print("Enter a number to delete: ");
                    b1.delete(Integer.parseInt(console.next()));
                    b1.inOrder();
                    break;
                case "p":
                    b1.inOrder();
                    break;
                case "s":
                    b1.inOrder();
                    System.out.print("Enter a number to search: ");
                    if(b1.search(Integer.parseInt(console.next()))) {
                        System.out.println("Item is present in the tree.");
                    } else {
                        System.out.println("Item is not present in the tree.");
                    }
                    break;
                case "sp":
                    System.out.print("Single Parents: ");
                    b1.getSingleParent(b1.getRoot());
                    System.out.println();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Invalid Command.");
            }
            System.out.print("Enter Command: ");
            s = console.next();
        }
        console.close();
    }

    /**
     * allows the user to interact with a tree of Doubles
     * @param console reads command line input
     */
    public static void doubleTree(Scanner console) {
        BinarySearchTree<Double> b1 = new BinarySearchTree<>();
        while(console.hasNext()) {
            b1.insert(Double.parseDouble(console.next()));
        }
        commands();
        console = new Scanner(System.in);
        System.out.print("Enter Command: ");
        String s = console.next();
        while(!s.equals("q")) {
            //executes commmand given a corresponding input
            switch(s) {
                case "i":
                    b1.inOrder();
                    System.out.print("Enter a number to insert: ");
                    b1.insert(Double.parseDouble(console.next()));
                    b1.inOrder();
                    break;
                case "d":
                    b1.inOrder();
                    System.out.print("Enter a number to delete: ");
                    b1.delete(Double.parseDouble(console.next()));
                    b1.inOrder();
                    break;
                case "p":
                    b1.inOrder();
                    break;
                case "s":
                    b1.inOrder();
                    System.out.print("Enter a number to search: ");
                    if(b1.search(Double.parseDouble(console.next()))) {
                        System.out.println("Item is present in the tree.");
                    } else {
                        System.out.println("Item is not present in the tree.");
                    }
                    break;
                case "sp":
                    System.out.print("Single Parents: ");
                    b1.getSingleParent(b1.getRoot());
                    System.out.println();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Invalid Command.");
            }
            System.out.print("Enter Command: ");
            s = console.next();
        }
        console.close();
    }

    /**
     * prints the available commmands
     */
    public static void commands() {
        System.out.println("Commands: ");
        System.out.println("(i) - insert item");
        System.out.println("(d) - delete item");
        System.out.println("(p) - print tree");
        System.out.println("(s) - search item");
        System.out.println("(sp) - find single parents");
        System.out.println("(q) - quit");
    }
}