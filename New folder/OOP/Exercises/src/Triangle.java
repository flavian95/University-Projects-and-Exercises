
public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    public double calculatePerimeter() {
    	double perimeter = a+ b+ c;
    	return perimeter;
    }
    
    public double calculateArea() {
    	double semiPerimeter= (a+ b+ c) / 2;
    	double area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b)* (semiPerimeter - c));
    	return area;
    }
    
    public String toString() {
    	return String.format("%f %f %f", a, b, c);
    }
}