package HW_Arrays;

public class Tasks_01 {
/**
    Описание занятия: Task 1:
            Дан массив nums целых чисел и целое число target, найдите индексы двух элементов массива,
             чтобы сумма этих значений была равна target. Предполагается,
             что существует всегда только одно решение и нельзя использовать один и тот же элемент массива дважды.

    Example 1:
                Input: nums = [2,7,11,15], target = 9
                Output: [0,1]
                Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:
                Input: nums = [3,2,4], target = 6
                Output: [1,2]
    Example 3:
                Input: nums = [3,3], target = 6
                Output: [0,1]
*/

public static void main(String[] args) {
    int [] nums = {2, 7, 11, 15, 9};
    int target = 9;
    sumTarget(nums, target);
}
public static void sumTarget (int[] nums, int target) {

    for (int i = 0; i < nums.length-1; i++) {
        for (int j = i+1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                System.out.println("Сумма значений двух элементов массива равно " + target + ", индексы :  " + i + " and " + j);
        }
      }
    }
}
}
