import java.util.*;

public class HomeWork_03_03_23 {

    /**
     * Описание задания.
     * <p>
     * 1 уровень сложности: Task 1.
     * Даны два ArrayList, элементы которых упорядочены. Объединить их в трерий ArrayList, элементы которого тоже должны быть отсортированы.
     * Example 1:
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * Example 2:
     * Input: list1 = [], list2 = []
     * Output: []
     * Example 3:
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     * <p>
     * Task 2.
     * Пусть дан ArrayList нечетной длины. Используя только Iterator (не прибегая к индексам и длине списка),
     * вывести на экран элемент, находящийся ровно посередине списка.
     * Example 1:
     * Input: list = [1,2,4]
     * Output: 2
     * Example 2:
     * Input: list = [1,2,3,4,5]
     * Output: 3
     * Example 3:
     * Input: list = [1]
     * Output: 1
     */
    private static final ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
    private static final ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6, 8, 9));

    public static void main(String[] args) {
        System.out.println(getNewArrSort(list1, list2));
        System.out.println(getMiddleElement(list2));

    }

    // Task 1.
    public static ArrayList<Integer> getNewArrSort(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> uniteArrList = new ArrayList<>();

        for (int i = 0; i <= list1.size()-1 + list2.size()-1; i++) {
            if (i < list1.size() && i < list2.size()) {
                if (list1.get(i) < list2.get(i)) {
                    uniteArrList.add(list1.get(i));
                    uniteArrList.add(list2.get(i));
                } else {
                    uniteArrList.add(list2.get(i));
                    uniteArrList.add(list1.get(i));
                }
            } else if (i < list1.size()) {
                uniteArrList.add(list1.get(i));
            } else if (i < list2.size()) {
                uniteArrList.add(list2.get(i));
            }
        }
        /* Example with Iterator */
        //       ListIterator <Integer> itList1 = list1.listIterator(0);
//        ListIterator <Integer> itList2 = list2.listIterator(0);
//        int tmpList1 = 0;
//        int tmpList2 = 0;

//        while (itList1.hasNext() || itList2.hasNext()) {
//            if (itList1.hasNext() && itList2.hasNext()) {
//                tmpList1 = itList1.next();
//                tmpList2 = itList2.next();
//                if (tmpList1 < tmpList2) {
//                    uniteArrList.add(tmpList1);
//                    uniteArrList.add(tmpList2);
//                } else {
//                    uniteArrList.add(tmpList2);
//                    uniteArrList.add(tmpList1);
//                }
//            } else if (itList1.hasNext()) {
//                tmpList1 = itList1.next();
//                uniteArrList.add(tmpList1);
//            } else if (itList2.hasNext()) {
//                tmpList2 = itList2.next();
//                uniteArrList.add(tmpList2);
//            }
//        }
//        Collections.sort(uniteArrList);
        return uniteArrList;
    }

    //  Task 2.

    public static int getMiddleElement (ArrayList<Integer> nums) {
        int x = 0;
        int count = 0;
        int tmp = 0;

        Iterator<Integer> iterator = nums.iterator();
        Iterator<Integer> it = nums.iterator();

        while (iterator.hasNext()) {
            tmp = iterator.next();
            count++;
        }
        for (int i = 0; i <= count / 2; i++) {
        if (it.hasNext())  tmp = it.next();
        }
         x = tmp;
        return x;
    }

}

