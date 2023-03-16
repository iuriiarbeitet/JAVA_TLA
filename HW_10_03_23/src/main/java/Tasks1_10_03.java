import java.lang.reflect.Array;
import java.util.*;

public class Tasks1_10_03 {
    /**
     * Описание задания.
     *
     *  1 уровень сложности: Task 1.
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
     * element appears only once. The relative order of the elements should be kept the same.
     *
     * Example 1:
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     *
     * Example 2:
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,,,,,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     * */

    public static void main(String[] args) {
       removeDublicate();
    }

    public static void removeDublicate () {

        Integer [] nums = {0,0,1,1,1,2,2,3,3,4};
        List list = new ArrayList<>();
        int tmp = 0;
        int count = 0;
        boolean flag = false;
       for (int i = 0; i < nums.length; i++) {
           for (int j = i + 1; j < nums.length; j++) {
               if (i != j && nums[i] != nums[j])  flag = true;
               if (i != j && nums[i] == nums[j])  nums[i] = -1;
               if (nums[i] == -1) {
                   tmp = nums[j];
                   nums[j] = nums[i];
                   nums[i] = tmp;
               }
           }
           if (flag && tmp != -1) {
               list.add(count, tmp);
               list.add(list.size(), '_');
               count++;
           }
           flag = false;
       }

        System.out.println(Arrays.toString(nums));
        System.out.println("Output: " + count + ", nums " + list);
    }
}
