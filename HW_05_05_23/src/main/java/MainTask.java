import java.util.Stack;

/**
 *  Given a string containing just the characters '(' and ')',
 *  return the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 * Input: s = ""
 * Output: 0
 */

public class MainTask {
    public static void main(String[] args) {
        System.out.println("result --> " + getParEx1("(()))"));
        System.out.println("result --> " + getParEx2(")()()())()("));
        System.out.println("result --> " + getParEx3(")()()())()("));
    }
    public static int getParEx1(String s) {
        int count = 0;
        StringBuffer sb = new StringBuffer(s);
         for (int i = 0; i < sb.length(); i++) {
             for (int j = i; j < sb.length(); j++) {
                 if((((sb.charAt(i) == '(') && (sb.charAt(j) == ')')) || ((sb.charAt(j) == '(') && (sb.charAt(i) == ')')))) {
                     count++;
                     sb.replace(i, i+1, "X");
                     sb.replace(j, j+1, "X");
                 }
             }
        }
        return count*2;
    }

    public static int getParEx2(String s) {
        int count = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                a++;
            } else if (s.charAt(i) == ')') {
                b++;
            }
        }
        if (a == b) count = a * 2;
        if (a > b) count = ((a + b) - (a - b));
        if (a < b) count = ((a + b) - (b - a));

        return count;
    }

    public static int getParEx3(String s){

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack1.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                stack2.push(s.charAt(i));
            }
        }
        return stack1.size() < stack2.size() ? stack1.size() * 2 : stack2.size() * 2;
    }
}
