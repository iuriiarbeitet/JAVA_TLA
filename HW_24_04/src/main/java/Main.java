/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '' where:
 * '.' Matches any single character.​​​​
 * '' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 *
 * Example 2:
 * Input: s = "aa", p = "a"
 * Output: true
 * Explanation: '' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 *
 * Example 3:
 * Input: s = "ab", p = "."
 * Output: true
 * Explanation: "." means "zero or more (*) of any character (.)".
 *
 *
 * Попытайтесь реализовать обработку регулярного выражения вручную, без использования Pattern, Matcher и т.п.
 */



public class Main {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "\\."));
    }

        public static boolean isMatch(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
            } else {
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }
        }
    }

