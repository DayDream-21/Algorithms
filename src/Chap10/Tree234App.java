package Chap10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Tree234App {
    public static void main(String[] args) throws IOException {
        long value;
        Tree234 theTree = new Tree234();
        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);
        while (true) {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's' -> theTree.displayTree();
                case 'i' -> {
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                }
                case 'f' -> {
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if (found != -1)
                        System.out.println("Found " + value);
                    else
                        System.out.println("Could not find " + value);
                }
                default -> System.out.print("Invalid entry\n");
            }
        }
    }

    //--------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    //--------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}