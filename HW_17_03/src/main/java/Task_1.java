import java.util.*;

/**
 * Task 1. Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * Подсказка: можно решить, используя HashMap.
 */


public class Task_1 {

    public static void main(String[] args) {
        System.out.println(getUniqueCharacter("leetcode"));
    }

    public static int getUniqueCharacter(String str) {
        int result = -1;
        char[] ch = str.toCharArray();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i != j && ch[i] == ch[j]) {
                    flag = false; break;
                }
            }
            if (flag) {
                return i;
            }
            flag = true;
        }
        return result;
    }


}
