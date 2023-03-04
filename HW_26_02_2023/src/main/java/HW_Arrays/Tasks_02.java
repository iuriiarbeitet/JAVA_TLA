package HW_Arrays;

import java.util.Arrays;
import java.util.List;

public class Tasks_02 {
    /**
                 * * Дано целое число, представленное его разрядами, которые записаны в массив. Например,
                 * число 123 представляется массивом [1, 2, 3].
                 * Получите массив, который преставляет сумму исходного числа и 1.
     * Example 1:
     *          * Input: digits = [1,2,3]
                * Output: [1,2,4]
                * Explanation: The array represents the integer 123.
                * Incrementing by one gives 123 + 1 = 124.
                * Thus, the result should be [1,2,4].
     *Example 2:
                 * Input: digits = [4,3,2,1]
                 * Output: [4,3,2,2]
                 * Explanation: The array represents the integer 4321.
                 * Incrementing by one gives 4321 + 1 = 4322.
                 * Thus, the result should be [4,3,2,2].
     * Example 3:
                 * Input: digits = [9]
                 * Output: [1,0]
                 * Explanation: The array represents the integer 9.
                 * Incrementing by one gives 9 + 1 = 10.
                 * Thus, the result should be [1,0].
     */

    public static void main(String[] args) {
        int[] num = {1, 9 , 9};
        int count = 1;
//        addNumberArray(num, count);
        addNumberArrEx2(num, count);
    }
    public static void addNumberArray (int[] num, int count) {
        String str = "";

        int result;
        for (int i = 0; i < num.length; i++) {
            str = str + num[i];
        }
        result = Integer.parseInt(str) + count;
        str = "" + result;
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        System.out.println("old array: " + Arrays.toString(num));
        System.out.println("new array: " + Arrays.toString(arr));
    }

    public static void addNumberArrEx2(int[] nums, int count) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 9) {
                nums[i] = nums[i] + 1;
                break;
            } else {
                nums[i] = 0;
            }
        }
        if (nums[0] == 0) {
            int[] array = new int[nums.length + 1];
            array[0] = 1;
            nums = array;
        }
        System.out.println(Arrays.toString(nums));

    }
}

