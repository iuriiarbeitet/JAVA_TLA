/**
 * 3. Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает вхождения x в arr[].
 * Ожидаемая временная сложность O(Log n)
 * arr[] = {1, 1, 2, 2, 2, 2, 3,}
 * x = 2
 * Вывод: 4 раза
 */

public class Task3 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3};
        int w = 1;
        System.out.println("Количество элементов в массиве равно " + w + " -->  " + binaryserch(nums, w));

    }

    public static int binaryserch(int[] nums, int w) {
        int first = 0;
        int second = nums.length - 1;
        int index = 0;
        int count = 0;

        boolean flag = true;
        while (first <= second) {
            int middle = first + (second - first) / 2;
            if (nums[middle] == w) {
                count++;
                index = middle;
                    if (nums[0] == w) {count++;}
                    if (nums[nums.length - 1] == w) {count++;}
                int plus = index + 1;
                int minus = index - 1;

                while (flag) {
                    if (w == nums[plus] && plus < second) {
                        plus++;
                        count++;
                    } else if (w == nums[minus] && minus > 0) {
                        count++;
                        minus--;
                    } else flag = false;
                }
                return count;
            }
            if (nums[middle] < w) {
                first = middle + 1;
            } else {
                second = middle - 1;
            }
        }
        return count;
    }
}
