import java.util.function.Function;

/**
 * Создайте класс со статическими методами, реализующими следующие математические
 * функции: y = x*x, y = 3x+5, y = 1/x, y = x*x*x, y = |x|.
 * В основной программе создайте метод test(), который будет принимать  в качестве аргумента
 * ссылку на один из методов, реализующих математическую функцию,
 * и выводить в консоль результат вычисления функции для целых чисел x в интервале -10 < x < -1.
 */

public class MathFunctions {

    public static void main(String[] args) {
        MathFunctions.test(MathFunctions::square);
        MathFunctions.test(MathFunctions::linearFunction);
        MathFunctions.test(MathFunctions::inverseFunction);
        MathFunctions.test(MathFunctions::cube);
        MathFunctions.test(MathFunctions::absoluteValue);
    }

    public static int square(int x) {
        return x * x;
    }
    public static int linearFunction(int x) {
        return 3 * x + 5;
    }
    public static int inverseFunction(int x) {
        return 1 / x;
    }
    public static int cube(int x) {
        return x * x * x;
    }
    public static int absoluteValue(int x) {
        return Math.abs(x);
    }
    public static void test(Function<Integer, Integer> function) {
        for (int x = -10; x < -1; x++) {
            int result = function.apply(x);
            System.out.println("Function result: " + result + ", x: " + x);
        }
    }

}
