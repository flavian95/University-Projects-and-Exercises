
class exercise1{
	
public static double calculatePolynomialValue(float[] coefficients, float xValue) {
    int degree = coefficients.length -1;
    float polynomialValue = 0;
    
    for (int i = 0; i <= degree; i++) {
        polynomialValue += coefficients[i] * Math.pow(xValue, degree - i);
    }
    
    return polynomialValue;
}

public static void displayPolynomial(float[] coefficients) {
    int degree = coefficients.length - 1;
   
    System.out.print("The polynomial is ");
    
    for (int i = 0; i <= degree; i++) {
        System.out.printf("%.0fx^%d", coefficients[i], degree - i);
        if (i < degree) System.out.print(" + ");
    }
}

public static void main(String[] args) {
    float[] coefficients = {4, 3, 2, 1};
    float xValue = 2;
    
    displayPolynomial(coefficients);
    System.out.printf("\nThe polynomial value for x = %.0f is %.0f\n", xValue, calculatePolynomialValue(coefficients, xValue));
}
}