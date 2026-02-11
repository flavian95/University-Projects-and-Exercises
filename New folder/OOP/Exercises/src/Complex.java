   
import java.util.ArrayList;

class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return "( " + realPart + " , " + imaginaryPart + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ComplexNumber complexNumber = (ComplexNumber) obj;

        return Double.compare(complexNumber.realPart, realPart) == 0 &&
               Double.compare(complexNumber.imaginaryPart, imaginaryPart) == 0;
    }
}
