
public class ComplexNr1 {
	private double realPart;    
	private double imaginaryPart;
	  
	public ComplexNr1(double realPart, double imaginaryPart) {    
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	  
	public String display() {		
		return String.format("(%.2f, %.2f)", realPart, imaginaryPart);
	}	

	public static ComplexNr1 sum(ComplexNr1 number1, ComplexNr1 number2) {
		double real= number1.realPart + number2.realPart;
		double imaginary = number1.imaginaryPart + number2.imaginaryPart;
		
		return new ComplexNr1(real, imaginary);
	}
		
	public static ComplexNr1 sub(ComplexNr1 number1, ComplexNr1 number2) {
		double real= number1.realPart - number2.realPart;
		double imaginary = number1.imaginaryPart - number2.imaginaryPart;
		
		return new ComplexNr1(real, imaginary);
	}
	
	 public static ComplexNr1 mul(ComplexNr1 number1, ComplexNr1 number2) {
	        double real = number1.realPart * number2.realPart - number1.imaginaryPart * number2.imaginaryPart;
	        double imaginary = number1.realPart * number2.imaginaryPart + number1.imaginaryPart * number2.realPart;
	        
	        return new ComplexNr1(real, imaginary);
	 }
	 
	 public static ComplexNr1 div(ComplexNr1 number1, ComplexNr1 number2) {
		 double divisor = number2.realPart * number2.realPart + number2.imaginaryPart * number2.imaginaryPart;
		    double real = (number1.realPart * number2.realPart + number1.imaginaryPart * number2.imaginaryPart) / divisor;
		    double imaginary = (number1.imaginaryPart * number2.realPart - number1.realPart * number2.imaginaryPart) / divisor;
		    
		    return new ComplexNr1(real, imaginary);
	 }
	 
	 public static ComplexNr1 arrSum(ComplexNr1 number1, ComplexNr1 number2) {
		 int count = ComplexNrCollection.length;
		 
			double real= number1.realPart + number2.realPart;
			double imaginary = number1.imaginaryPart + number2.imaginaryPart;
			
			return new ComplexNr1(real, imaginary);
		}

	public static void main(String[] args) {
		ComplexNr1 number1 = new ComplexNr1(2, 3);
		ComplexNr1 number2 = new ComplexNr1(4, 5);
		
		ComplexNr1[] ComplexNrCollection = {
			    new ComplexNr1(2, 3),
			    new ComplexNr1(4, 5),
			    new ComplexNr1(2, 1),
			    new ComplexNr1(3, 7),
			    new ComplexNr1(2, 4)
			};

		System.out.printf("number1 = %s\n", number1.display()); 
		System.out.printf("number2 = %s\n", number2.display()); 
		
		System.out.printf("Addition\n");
		System.out.printf("z1+z2=%s\n",sum(number1, number2).display()); 
		
		System.out.printf("Addition from all elements\n");
		System.out.printf(arrSum(number1, number2).display()); 
		
		System.out.printf("Addition\n");
		System.out.printf("z1-z2=%s\n",sub(number1, number2).display());
		
		System.out.printf("Division\n");
		System.out.printf("z1/z2=%s\n",div(number1, number2).display());

	}
}

