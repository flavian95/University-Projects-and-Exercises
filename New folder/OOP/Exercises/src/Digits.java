import java.util.Scanner;

class Digits {

    static int sumOfDigits(int nr) {
        int digit;
        int sum = 0;

        while (nr > 0) {
            digit = nr % 10;
            nr = nr / 10;

            sum += digit;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of the nr: ");
        int nr = scanner.nextInt();

        int digitsSum = sumOfDigits(nr);

        System.out.printf("The sum of digits for the number %d is %d", nr, digitsSum);

        scanner.close();
    }
}