
public class Square extends Polygon{
   public double sideLength;
   
   public Square(double sideLength) {	   
	   super(4);
	   this.sideLength = sideLength;
   }
   
   public double getSideLength(){
     return sideLength;
   }
   
   public void setSideLength(double sideLength) {
	   this.sideLength = sideLength;
   }
   
   @Override
   double calculatePerimeter() {
       return sideLength * 4;
   }

   @Override
   double calculateArea() {
       return sideLength * sideLength;
   }
	
	public String toString() {
		return String.format("%.2f", sideLength);
	}
	
	public static void main(String[] args) {
		Square[] squareCollection = {
			new Square(5),
			new Square(7),
			new Square(8)
		};
		
		for(int i = 0; i < squareCollection.length; i++) {
			System.out.printf("Side of square %d : %.2f \n", i + 1, squareCollection[i].getSideLength());
			System.out.printf("Perimeter of square %d : %.2f \n",i + 1, squareCollection[i].calculatePerimeter());
			System.out.printf("Area of square %d : %.2f \n",i + 1, squareCollection[i].calculateArea());
		}
	}
}