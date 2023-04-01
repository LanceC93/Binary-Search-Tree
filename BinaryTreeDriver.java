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
                    BinarySearchTree<String> b1 = new BinarySearchTree<String>();
                    while(console.hasNext()) {
                        b1.insert(console.next());
                    }
                    b1.inOrder();
                } else if (inputType.equals("i")) {
                    BinarySearchTree<Integer> b1 = new BinarySearchTree<Integer>();
                    while(console.hasNext()) {
                        b1.insert(Integer.parseInt(console.next()));
                    }
                    b1.inOrder();
                } else {
                    BinarySearchTree<Double> b1 = new BinarySearchTree<Double>();
                    while(console.hasNext()) {
                        b1.insert(Double.parseDouble(console.next()));
                    }
                    b1.inOrder();
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

}
