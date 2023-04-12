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
        int r = 5;
        int l = 5;
        int[][] dobleArray = new int[r][l];
        findPick(r, l); // поиск пиков
    }

    static void findPick(int r, int l) {
        int pick;
        int[][] helpArray = new int[r + 2][l + 2];
        for (int i = 0; i < helpArray.length; i++) {
            for (int j = 0; j < helpArray[i].length; j++) {
                if (i == 0 | j == 0 | i == helpArray.length - 1 | j == helpArray[i].length - 1) {
                    helpArray[i][j] = -1;
                } else {
                    helpArray[i][j] = (int) (Math.random() * 30);
                    System.out.print(helpArray[i][j] + " ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i < helpArray.length - 1; i++) {
            for (int j = 1; j < helpArray[i].length - 1; j++) {

                if (helpArray[i][j] >= helpArray[i - 1][j] && helpArray[i][j] >= helpArray[i][j - 1]
                        && helpArray[i][j] >= helpArray[i + 1][j] && helpArray[i][j] >= helpArray[i][j + 1]) {
                    pick = helpArray[i][j];
                    System.out.println(pick + " является пиковым числом");
                }
            }
        }
    }
}
