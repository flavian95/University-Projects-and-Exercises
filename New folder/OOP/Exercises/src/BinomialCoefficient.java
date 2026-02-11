
public class BinomialCoefficient {
	
    static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    static long binomialCoefficient(int n, int k) {
        if (k > n) {
            return 0;
        }
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static void main(String[] args) {
        int n = 5; 
        int k = 2; 

        long result = binomialCoefficient(n, k);
        System.out.println("C(" + n + ", " + k + ") = " + result);
    }
}
