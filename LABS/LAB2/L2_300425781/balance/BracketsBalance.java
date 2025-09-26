import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.ArrayList;

/*
 * CSI2110 Lab 3 - lab3.java
 * 
 * Class to check balanced brackets in math expressions
 *
 * Usage: java BracketsBalance <exp> 
 * Example true: java BracketsBalance '{(x+y)-[2*z]}'
 * Example false: java BracketsBalance '{(x+y}-[2*z])'
 * 
 * Lucia Moura, updated 2021
 * Billy Bolton, updated 2021
 *
 */

class BracketsBalance {

    /**
     * A method that uses an ArrayStack to identify if a String has balanced
     * brackets.
     * 
     * @param exp
     * @return boolean
     */
    private boolean isBalanced(String exp) {
        String frontBrackets = "({[";
        String backBrackets = "]})";
        ArrayList<Character> charsF = new ArrayList<>();
        ArrayList<Character> charsB = new ArrayList<>();

        for (int i = 0; i < exp.length(); i++) {
            if (frontBrackets.indexOf(exp.charAt(i)) != -1)
                charsF.add(exp.charAt(i));
            else if (backBrackets.indexOf(exp.charAt(i)) != -1)
                charsB.add(exp.charAt(i));
        }

        if (charsF.size() != charsB.size()) { return false; } // different number of front and back brackets
        
        if (charsF.isEmpty() && charsB.isEmpty()) { return true; } // if there are no brackets, its balanced

        int counter = 0; // counting the pairs of equal brackets

        // number of brackets is now equal
        for (int i = 0; i < charsF.size(); i++) {
            for (int j = 0; j < charsB.size(); j++) {
                if (bracketPair(charsF.get(i), charsB.get(j)) == true) {
                    counter++;
                    break;
                }
            }

            // if the number of matching pairs equal the number of pairs, its true!
            if (counter == charsF.size()) { return true; }
        }
    
        return false; // dummy answer for startup code
    }

    /**
     * Compares an open and a closed bracket. Returns true if they match, false otherwise.
     * This method was made for better code readability -> see isBalanced(String exp)
     * 
     * @param front The front bracket to be compared
     * @param back The back bracket to be compared
     * @return If front and back are a matching pair of brackets
     */
    private boolean bracketPair(Character front, Character back) { return ((front == '(' && back == ')') || (front == '{' && back == '}') || (front == '[' && back == ']')); }

    /**
     * The main driver code that will test isBalanced(String) using CLI inputs or
     * using the tests.txt file. Using CLI will help you find test cases quickly.
     * Add these tests to your tests.txt file. You may run the tests in test.txt in
     * full when you provide no CLI arguments. ie: java BalancedBrackets
     * 
     * @param args Command line aguments. See top of file CLI examples.
     */
    public static void main(String[] args) throws IOException { // testing method isBalanced

        if (args.length > 0) {
            testInput(args);
        } else {
            testDoc();
        }

    }

    /**
     * Helper method that streams the tests.txt file into the isBalanced(String)
     * method.
     * 
     * @throws IOException
     */
    private static void testDoc() throws IOException {
        // Path path = Paths.get("balance/tests.txt");
        Path path = Paths.get("LABS/LAB2/lab2/balance/tests.txt");// adjust your path depending on where the file is placed

        try (Stream<String> input = Files.lines(path)) {
            input.forEach(expression -> {
                if (!expression.equals(""))
                    checkBrackets(expression);
            });
        } catch (IOException e) {
            System.out.println("Cannot find file.");
        }
    }

    /**
     * Helper method to take inputs from CLI and forward them to isBalanced(String);
     * 
     * @param args
     */
    private static void testInput(String[] args) {
        for (String expression : args) {
            checkBrackets(expression);
        }
    }

    /**
     * Helper method to print the test results from isBalanced(String).
     * 
     * @param expression
     */
    private static void checkBrackets(String expression) {
        BracketsBalance brackets = new BracketsBalance();
        System.out.println("Checking expression:" + expression);
        if (brackets.isBalanced(expression))
            System.out.println("The expression is balanced.\n");
        else
            System.out.println("The expression is NOT balanced.\n");
    }
}
