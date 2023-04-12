

public class Task1 {
    public static void main(String[] args) {
        System.out.println(xPowNrecursive(3, 7));
        System.out.println(xPowNexample1(3, 7));
        System.out.println(xPowNexample2(3, 7));
    }

    /**
    1. Даны два целых числа x и n, напишите функцию для вычисления x^n
        решение 1 - рекурсивно O(n)
        решение 2 - улучшить решение 1 до O(lon n)
    */

    public static int xPowNrecursive (int x, int n) {
        int result;
        if (n == 1) {
            return x;
        } else {
           result = x * xPowNrecursive(x, n  - 1);
        }
        return result;
    }

    public static int xPowNexample1 (int x, int n) {
        int result = 1;
       for (int i = 0; i < n / 2; i++) result = result * x;
        if (n % 2 != 0) result = result * result * x;
        else result = result * result;
        return result;
    }
    public static int xPowNexample2 (int x, int n) {
        int result = 1;
        int j = 1;
        int nCount = 0;
        int xAdd = x;
        while (n > nCount) {
            if (n - nCount > j) {
                xAdd = xAdd * x;
                j = j + 1;
                result = result * xAdd;
                nCount = j + nCount;
            } else {
                result = result * x;
                nCount++;
            }
        }
        return result;
    }
}
