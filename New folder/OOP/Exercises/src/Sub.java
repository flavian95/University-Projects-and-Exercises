import java.util.Scanner;

public class Sub {
	
	public static int subtract(int a, int b) {
        return a - b;
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first nr: ");
        int firstNr = scanner.nextInt();
        
        System.out.print("Enter the second nr: ");
        int secondNr = scanner.nextInt();
        
        int result = subtract(firstNr, secondNr);
        System.out.println("Result of subtraction: " + result);

        scanner.close();
    }
}
