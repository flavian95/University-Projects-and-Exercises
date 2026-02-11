
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Person2 {
    private String name;
    private int income;

    public Person2(String name, int income) {
        this.name = name;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name for the fourth person:");
        String name = scanner.nextLine();

        System.out.println("Enter income for the fourth person:");
        int income = scanner.nextInt();

        String nameDialog = JOptionPane.showInputDialog(null, "Enter name for the fifth person:");
        int incomeDialog = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter income for the fifth person:"));

        Person2 person1 = new Person2("Name1", 1500);
        Person2 person2 = new Person2("Name2", 1600);
        Person2 person3 = new Person2("Name3", 1700);
        Person2 person4 = new Person2(name, income);
        Person2 person5 = new Person2(nameDialog, incomeDialog);

        System.out.println("First person:");
        System.out.println("Name: " + person1.getName());
        System.out.println("Income: " + person1.getIncome());

        System.out.println("Second person:");
        System.out.println("Name: " + person2.getName());
        System.out.println("Income: " + person2.getIncome());

        System.out.println("Third person:");
        System.out.println("Name: " + person3.getName());
        System.out.println("Income: " + person3.getIncome());

        System.out.println("Fourth person:");
        System.out.println("Name: " + person4.getName());
        System.out.println("Income: " + person4.getIncome());

        System.out.println("Fifth person:");
        System.out.println("Name: " + person5.getName());
        System.out.println("Income: " + person5.getIncome());

        scanner.close();
    }
}
