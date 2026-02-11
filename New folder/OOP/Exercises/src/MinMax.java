import java.util.Scanner;

public class MinMax {
    
    public static void main(String[] args) {
        int[] array = new int[5];
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 integers:");
        
        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        
        int min = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
            if(array[i] > max) {
                max = array[i];
            }
        }
        
        System.out.println("Array elements:");
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
        
        scanner.close();
    }
}