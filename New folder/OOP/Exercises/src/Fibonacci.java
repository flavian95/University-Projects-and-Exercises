
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciModified(int n) {
        if (n <= 2) {
            return 1;
        }
        int a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            if (c <= 2) {
                a = b;
                b = c;
            } else {
                a = b;
                b = c;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int m = 10;
        System.out.println("The " + m + "-th element of Fibonacci sequence: " + fibonacciModified(m));
    }
}