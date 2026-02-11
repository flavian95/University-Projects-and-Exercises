import java.util.Scanner;

public class ArrSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the limit of the array: ");
        int limit = scanner.nextInt();

        int[] array = new int[limit];
        int sum = 0;

        for (int i = 0; i < limit; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            sum += array[i];
        }
       
        
        System.out.print("The elements in the array are: ");
        for (int i = 0; i < limit; i++) {
            System.out.println(array[i]);
        }
        
        System.out.print("Ther sum of the elements in the array is: ");
        System.out.println(sum);
        
        scanner.close();
    }
}

