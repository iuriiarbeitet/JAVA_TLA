public class Task2 {
    /**
     *
     * Task 2.
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * Example 1:
     * Input: nums = [2,2,1]
     * Output: 1
     *
     *
     * Example 2:
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     *
     *
     * Example 3:
     * Input: nums = [1]
     * Output: 1
     */
    private static int[] nums = {1, 2, 1, 4, 2};


    public static void main(String[] args) {
        System.out.println(findSingleOne(nums));
    }

    public static int findSingleOne (int[] arr) {
        int num = -1;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                num = arr[i];
            }
            flag = false;
        }
        return num;
    }

}
