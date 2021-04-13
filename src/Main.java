import java.util.*;

public class Main {

    public static boolean checkBalance(String s) {

        //Stack to store characters
        Stack<Character> cs = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);

            //right Parenthesis if condition
            if (cc == '}' || cc == ')' || cc == ']') {

                // Stack is False if left Parenthesis is empty
                if (cs.isEmpty()) {
                    return false;
                }

                //last character to see if is there
                char lc = cs.peek();

                // Remove from stack if the condition of current character is right and last character is from left Parenthesis
                if ((cc == '}' && lc == '{') || (cc == ')' && lc == '(') ||
                        (cc == ']' && lc == '[')) {
                    cs.pop();
                }
                else {
                    return false;
                }
            }

            //Check for left Parenthesis
            if (cc == '{' || cc == '(' || cc == '[') {
                cs.push(cc);
            }
        }

        // If String is empty
        if (s.isEmpty()) {
            return true;
        }

        return cs.isEmpty();
    }

    public static void main(String[] args)  {

        // Change this to scanner and ask user for String input
        // Not closed
        System.out.println(checkBalance("[{["));
        // Nested
        System.out.println(checkBalance("{()}"));
        // Closed
        System.out.println(checkBalance("{Abcd}"));

    }
}