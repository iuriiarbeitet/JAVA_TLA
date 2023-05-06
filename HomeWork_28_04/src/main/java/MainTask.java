/**
 *  Given an input string s and a pattern p, implement regular expression matching with support for '.' and '' where:
 * '.' Matches any single character.​​​​
 * '' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input: s = "aa", p = "a"
 * Output: true
 * Explanation: '' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input: s = "ab", p = "."
 * Output: true
 * Explanation: "." means "zero or more (*) of any character (.)".
 *
 * Попытайтесь реализовать обработку регулярного выражения вручную, без использования Pattern, Matcher и т.п.
 */

public class MainTask {
    public static void main(String[] args) {
        System.out.println(isFound("b", "ba*"));
    }
    public static boolean isFound(String s, String p) {
        int a = s.length();
        int b = p.length();
        boolean[][] dp = new boolean[a+1][b+1];
        dp[0][0] = true;
        for (int i = 0; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (p.charAt(j-1) != '*') {
                    dp[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') && dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
                }
            }
        }
        return dp[a][b];
    }
}
/*
Для решения этой задачи можно использовать алгоритм динамического программирования.
Для начала нужно создать таблицу dp, где dp[i][j] будет означать, подходит ли подстрока s[0:i-1] под шаблон p[0:j-1].
Тогда, если p[j-1] не является символом '*', то:
если s[i-1] и p[j-1] совпадают или p[j-1] равен '.', то dp[i][j] равен dp[i-1][j-1];
иначе dp[i][j] равен false.
Если p[j-1] является символом '*', то нужно рассмотреть два случая:
'*' соответствует 0 символов: тогда dp[i][j] равен dp[i][j-2];
'*' соответствует более чем 0 символам: тогда dp[i][j] равен dp[i-1][j],
если s[i-1] и p[j-2] совпадают или p[j-2] равен '.'. В противном случае dp[i][j] также равен dp[i][j-2].

 */
