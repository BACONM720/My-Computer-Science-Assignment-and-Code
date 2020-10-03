import javax.swing.*;

public class Assignment2{


    public static boolean validate(String a) {
        int b1= 0;
        int b2 = 0;
        //string of valid characters
        String validator = "()0123456789*^+-/";
        //check to see if the expression is between 3 & 20
        if (a.length() < 3 || a.length() > 20) {

            return false;
        }

        //loop through input string, if any of the characters do not match the characters in the validator string it will return a -1, if so return false
        for (int i = 0; i < a.length(); i++) {
            int v = validator.indexOf(a.charAt(i));
            if (v == -1) {
                return false;
            }
        }
        //else return true
        return true;
    }
//simple utility method to return the appropriate precedence of operators passed in
    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String inToPost(String a) {

        StringBuilder result = new StringBuilder();// string builder for our output
        ArrayStack stack = new ArrayStack();
       //loop through our input string, storing each character as a char as we go
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);


            //check if char is operator
            if (precedence(c) > 0) {
                //make sure stack isn't empty and if the operator is greater than one already on the stack pop it for the output then push the new operator
                while (!stack.isEmpty() && precedence((char) stack.top()) >= precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            // if its a closing bracket pop
            } else if (c == ')') {
                char x = (char) stack.pop();
                // while its not an opening bracket append the output then pop off the stack
                while (x != '(') {
                    result.append(x);
                    x = (char) stack.pop();

                }
            // if the char is an opening bracket push it to the stack
            } else if (c == '(') {
                stack.push(c);

            } else {
                //character is neither operator nor (
                result.append(c);
            }
        }
        //append whatever's left on the stack to the result
        for (int i = 0; i <= stack.size(); i++) {
            result.append(stack.pop());
        }

        return result.toString();//return the result as a string
    }


    public static double calculate(String a) {

        ArrayStack stack = new ArrayStack();
        double ans = 0;
//scan through our postfix input
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            double a1 =  0;
            double a2 =  0;
//if the character is a digit push it to the stack
            if (Character.isDigit(c)) {
                //this piece of code is turning the character in to a double which we push to the stack
                double l = Character.getNumericValue(c);
                 stack.push(l);
            }
            //if the character is an operator we pop the next two items(numbers) on the stack and carry out the operation and push the resultant to the stack
                if (c == '+') {
                    a1 = (double) stack.pop();
                    a2 = (double) stack.pop();
                    double exp = a2 + a1;
                    stack.push(exp);

                }
                if (c == '-') {
                a1 = (double) stack.pop();
                a2 = (double) stack.pop();
                    double exp = a2 - a1;
                    stack.push(exp);

                }
                if (c == '*') {
                a1 = (double) stack.pop();
                a2 = (double) stack.pop();
                    double exp = a2 * a1;
                    stack.push(exp);

                }
                if (c == '/') {
                a1 = (double) stack.pop();
                a2 = (double) stack.pop();
                    double exp = a2 / a1;
                    stack.push(exp);

                }
                if (c == '^') {
                a1 = (double) stack.pop();
                a2 = (double) stack.pop();
                    double exp = Math.pow(a2, a1);
                    stack.push(exp);

                }

            }
        //the answer is the number left on top of the stack so pop it off and return it
        ans = (double) stack.pop();
        return ans;
    }


    public static void run() {
        String input = JOptionPane.showInputDialog("Enter a valid expression in infix notation!!!");
        boolean valid = validate(input);// validate our input

        if (valid) {
            //if it is valid we can convert it to postfix
            String input2 = inToPost(input);

            double res = calculate(input2);//calculate the result using our postfix expression
            JOptionPane.showMessageDialog(null, "Infix: " + input + "\n" + "Postfix: " + input2 + "\n" + "Result: " + res);

        } else {
            JOptionPane.showMessageDialog(null, "Expression is not Valid, Valid Characters Include: ()0123456789*^+-/ !!!");
             run();//if the input is invalid allow the user to enter another expression

        }
    }


    public static void main(String[] args) {
        //main just calls the run method which contains logic for user input
    run();
    }
}

