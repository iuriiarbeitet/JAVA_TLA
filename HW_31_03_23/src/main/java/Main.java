import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static List<String> list = Arrays.asList("Highload", "High", "Load", "Highload");
    public static int[] nums = {3, 0, 1};

    public static void main(String[] args) {

        System.out.println("1. объект «High» встречается в коллекции: " + findCountStringList(list, "High") + " раз.");
        System.out.println("2. строка начинается буквой “J”или “N” и заканчивается “A”: " + checkStringStartEnd("JOANA"));
        System.out.println("3. the missing number is: " + isMissingNumberArray(nums));

    }

    /**
     * Task1:
     * Допустим, у нас есть коллекция состоящая из строк. Arrays.asList(«Highload», «High», «Load», «Highload»).
     * Посчитайте, сколько раз объект «High» встречается в коллекции. Используйте Stream API.
     */
    public static long findCountStringList(List<String> list, String str) {
        return list.stream().filter(s -> s.contains(str)).count();
    }

    /**
     * Task2:
     * Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и заканчивается “A”.
     * Используем функциональный интерфейс Predicate.
     */
    public static boolean checkStringStartEnd(String str) {
        Predicate<String> checkString = s -> (s.startsWith("J") || s.startsWith("N")) && s.endsWith("A");
        return checkString.test(str);
    }

    /**
     * Task3:
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     * <p>
     * Example 1:
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are in
     * the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
     * <p>
     * Example 2:
     * Input: nums = [0,1]
     * Output: 2
     * Explanation: n = 2 since there are 2 numbers, so all numbers are
     * in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
     */
    public static int isMissingNumberArray(int[] arr) {
        int n = nums.length;
        int rightSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();
       return rightSum - actualSum;
    }
}
