import java.util.Scanner;

public class Module {
	
	public static int moduleNr(int a) {
       if( a < 0) {
    	   a = a * (-1);
       }
       
       return a;
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first nr: ");
        int firstNr = scanner.nextInt();
        
        System.out.print("Enter the second nr: ");
        int secondNr = scanner.nextInt();
        
        System.out.println("The module of the first number is: " + moduleNr(firstNr));
        System.out.println("The module of the second number is: " + moduleNr(secondNr));

        scanner.close();
    }
}