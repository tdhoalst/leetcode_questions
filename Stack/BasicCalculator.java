package Stack;

import java.util.Stack;

public class BasicCalculator {
        public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "1 + 1",
            " 2-1 + 2 ",
            "(1+(4+5+2)-3)+(6+8)"
        };
        BasicCalculator bc = new BasicCalculator();
        for (String testCase : testCases) {
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Result: " + bc.calculate(testCase));
            System.out.println();
        }
    }
}
