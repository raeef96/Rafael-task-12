/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  Raeef Bechara
 * @version 2021-02-13
 */
public class Postfix {
    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr  Arithmetic expression in postfix notation
     * @return      The value of the evaluated expression
     * @throws      ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        //Remove leading and trailing whitespace.
        expr = expr.trim();
        //Split string into tokens.
        String[] tokens = expr.split("\\s+");
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        for(String token: tokens) {
            if(isInteger(token)) {
                int number = Integer.parseInt(token);
                stack.push(number);
            }
            else if(isOperator(token)) {
                String operator = token;
                int b = stack.pop();
                int a = stack.pop();
                switch(operator) {
                    case "+":
                        stack.push(a+b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                    default:
                        throw new RuntimeException("Syntax error: Invalid operator. Failed with expression: ("+expr+")");
                }
            }
            else {
                throw new RuntimeException("Syntax error. Invalid construct. Failed with expression: ("+expr+")");
            }
        }
        int result = stack.pop();
        if(!stack.isEmpty()) {
            throw new RuntimeException("Stack not empty on completion. Failed with expression: ("+expr+")");
        }
        return result;
    }

    /**
     * Returns true if s is an operator.
     * An operator is one of '+', '-', '*', '/'.
     */
    /**
     * Returns true if s is an operator.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        return s.matches("^[+\\-*/]$");
    }

    /**
     * Returns true if s is an integer.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * We accept two types of integers:
     *
     * - the first type consists of an optional '-'
     *   followed by a non-zero digit
     *   followed by zero or more digits,
     *
     * - the second type consists of an optional '-'
     *   followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        boolean nonZeroNumber = s.matches("-?[1-9]\\d*");
        boolean zeroNumber = s.matches("-?0");
        return nonZeroNumber || zeroNumber;
    }
}
