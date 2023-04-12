import java.util.Arrays;

/**
 * 2. Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
 *         который будет находиться на k-й позиции в конечном отсортированном массиве.
 *         Массив 1 - 100 112 256 349 770
 *         Массив 2 - 72 86 113 119 265 445 892
 *         к = 7
 *         Вывод : 256
 *         Окончательный отсортированный массив -
 *         72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
 *         7-й элемент этого массива равен 256.
 */

public class Task2 {
    public static void main(String[] args) {
        int[] array1={100, 112, 256, 349, 770};
        int[] array2={72, 86, 113, 119, 265, 445, 892};
        int k = 10;
        System.out.println( "значение позиции "+ k + " в итоговом массиве равно " + findNumberByIndex(array1,array2,k));
    }

    public static int findNumberByIndex(int[] array1, int[] array2, int k) {
        int[] arraySummary=new int[array1.length + array2.length];
        int j1=0;
        int j2=0;
        for (int i = 0; i < arraySummary.length; i++) {
            if (array1[j1] <= array2[j2]) {
                arraySummary[i]=array1[j1];
                if (j1 < array1.length - 1) {
                    j1++;
                }
            } else {
                arraySummary[i]=array2[j2];
                if (j2 < array2.length - 1) {
                    j2++;
                }
            }
        }
        System.out.println(Arrays.toString(arraySummary));
        return arraySummary[k - 1];
    }
}
