import java.util.Scanner;

public class Nr {
	private int firstNr;
	private int secondNr;
	
	public Nr(int firstNr, int secondNr) {
        this.firstNr = firstNr;
        this.secondNr = secondNr;
	}
	
	public int getFirstNr() {
        return firstNr;
    }
    
    public void setTitle(int firstNr) {
        this.firstNr = firstNr;
    }
    
    public int getSecondNr() {
        return secondNr;
    }
    
    public void setSecondNr(int secondNr) {
        this.secondNr = secondNr;
    }
    
    public static int add(int firstNr, int secondNr) {
    	return firstNr + secondNr;
    }
    
    public static int sub(int firstNr, int secondNr) {
    	return firstNr - secondNr;
    }
    
    public static int mul(int firstNr, int secondNr) {
    	return firstNr * secondNr;
    }
    
    public static int absFirstNr(int firstNr) {
    	
    	if( firstNr < 0) {
    		firstNr = firstNr * (-1);
    	}
    	
    	return firstNr;
    }
    
    public static int absSecondNr(int secondNr) {
    	
    	if( secondNr < 0) {
    		secondNr = secondNr * (-1);
    	}
    	
    	return secondNr;
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        int firstNr = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter the first number: ");
        int secondNr = Integer.parseInt(scanner.nextLine());
        
        Nr NumberPair = new Nr(firstNr, secondNr);
        int sum = add(firstNr, secondNr);
        int sub = sub(firstNr, secondNr);
        int mul = mul(firstNr, secondNr);
        
        System.out.println("First Number is: " + NumberPair.getFirstNr());
        System.out.println("Second Nr is: " + NumberPair.getSecondNr());
        System.out.println("The sum of the two numbers is: " + sum);
        System.out.println("The sub of the 2 numbers is: " + sub);
        System.out.println("The mul of the 2 numbers is: " + mul);
        System.out.println("The absoulte value of the first nr is: " + absFirstNr(firstNr));
        System.out.println("The absoulte value of the first nr is: " + absSecondNr(secondNr));
        
        scanner.close();
	}

}
