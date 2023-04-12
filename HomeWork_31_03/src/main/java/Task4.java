/**
 * 4* Найдите пиковый элемент в двумерном массиве
 * Элемент является пиковым, если он больше или равен своим четырем соседям слева, справа, сверху и снизу.
 * Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1 ].
 * Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
 * 10 20 15
 * 21 30 14
 * 7 16 32
 * Выход: 30
 * 30 — пиковый элемент, потому что все его
 * соседи меньше или равны ему.
 * 32 также можно выбрать в качестве пика.
 * <p>
 * note
 * 1 Смежная диагональ не считается соседней.
 * 2 Пиковый элемент не обязательно является максимальным элементом.
 * 3 Таких элементов может быть несколько.
 * 4 Всегда есть пиковый элемент.
 */

public class Task4 {
    public static void main(String[] args) {
       findPick(3, 3); // поиск пиков
    }

    static void findPick(int r, int l) {
        int pick;
        int[][] biArr = new int[r + 2][l + 2];
        for (int i = 0; i < biArr.length; i++) {
            for (int j = 0; j < biArr[i].length; j++) {
                if (i == 0 | j == 0 | i == biArr.length - 1 | j == biArr[i].length - 1) {
                    biArr[i][j] = -1;
                } else {
                    biArr[i][j] = (int) (Math.random() * 100);
                    if (biArr[i][j] < 10) System.out.print("  " + biArr[i][j]);
                    else System.out.print(" " + biArr[i][j]);
                }
            }
            System.out.println();
        }
        for (int i = 1; i < biArr.length - 1; i++) {
            for (int j = 1; j < biArr[i].length - 1; j++) {

                if (biArr[i][j] >= biArr[i - 1][j] && biArr[i][j] >= biArr[i][j - 1]
                        && biArr[i][j] >= biArr[i + 1][j] && biArr[i][j] >= biArr[i][j + 1]) {
                    pick = biArr[i][j];
                    System.out.println(pick + " --> пиковый элемент");
                }
            }
        }
    }
}
