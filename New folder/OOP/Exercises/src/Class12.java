import java.util.ArrayList;

public class Class12 {

    public static void displayComplexNumbers(ArrayList<ComplexNumber> complexNumberList, String title) {
        System.out.print(title);
        for (ComplexNumber complexNumber : complexNumberList) {
            System.out.printf(" %s", complexNumber);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        ComplexNumber z1 = new ComplexNumber(-2, 3);
        ComplexNumber z2 = new ComplexNumber(-2, 3);
        ComplexNumber z3 = new ComplexNumber(4, -7);

        System.out.println("z1 equals z2: " + z1.equals(z2));
        System.out.println("z1 equals z3: " + z1.equals(z3)); 

        
        ArrayList<ComplexNumber> complexNumberList = new ArrayList<ComplexNumber>();
        ComplexNumber complexNumber1 = new ComplexNumber(1, 2);

        complexNumberList.add(complexNumber1);
        complexNumberList.add(new ComplexNumber(3, 4));
        complexNumberList.add(new ComplexNumber(5, 6));

        displayComplexNumbers(complexNumberList, "List: ");
        complexNumberList.remove(1);
        displayComplexNumbers(complexNumberList, "List after deleting from index 1: ");
    }
}

