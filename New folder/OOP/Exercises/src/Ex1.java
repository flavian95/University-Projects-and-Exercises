
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
    	
        ThePerson2[] collection = new ThePerson2[10];
        collection[0] = new ThePerson2("Name1", 2500);
        collection[1] = new ThePerson2("Name2", 3000);
        collection[2] = new ThePerson2("Name3", 2800);

        int counter = 2;

        for (int i = 0; i <= counter; i++) {
            System.out.println(collection[i]); 	
        }

        Scanner input = new Scanner(System.in);

        System.out.print("Name 4: ");
        String name = input.nextLine();

        System.out.print("Income 4: ");
        double income = input.nextDouble();

        collection[counter + 1] = new ThePerson2(name, income);
        counter+= 2;

        for (int i = 0; i < counter; i++) {
            System.out.println(collection[i]);
        }
    }
}