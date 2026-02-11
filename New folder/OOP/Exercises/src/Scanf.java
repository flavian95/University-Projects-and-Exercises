
import java.util.Scanner;

class Scanf {

    static int mul(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        int product = mul(a, b);

        System.out.printf("The product of %d and %d is %d", a, b, product);

        scanner.close();
    }
}