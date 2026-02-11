
public class IsoscelesTrapezoid extends Polygon{
  private double largerBase;
  private double smallerBase;
  private double side;
  
  public IsoscelesTrapezoid(double largerBase, double smallerBase, double side){
	  super(4);
	  this.largerBase = largerBase;
	  this.smallerBase = smallerBase;
	  this.side = side;
  }
  
  public double getLagerBase(){
	  return largerBase;
  }
  
  public void setLargerBase(double largerBase) {
	  this.largerBase = largerBase;
  }
  
  public double getSmallerBase(){
	  return smallerBase;
  }
  
  public void setSmallerBase(double smallerBase) {
	  this.smallerBase = smallerBase;
  }
  
  public double getSide() {
	  return side;
  }
  
  public void setSide(double side) {
	  this.side = side;
  }
  
   @Override
   double calculatePerimeter() {
	  return largerBase + smallerBase + (side * 2);
  }
   
   @Override
   double calculateArea() {
	   double differenceBtwBases = (largerBase - smallerBase) / 2;
	   double height = Math.sqrt((side * side) - (differenceBtwBases * differenceBtwBases));
	   return ((largerBase + smallerBase) * height) / 2;
   }
  
  public String toString() {
	  return String.format("%f %f %f", largerBase, smallerBase, side);
  }
  
  public static void main(String[] args) {
	  IsoscelesTrapezoid[] isoscelesTrapezoidCollection = {
			new IsoscelesTrapezoid(10, 6, 5),
			new IsoscelesTrapezoid(15, 9, 7),
			new IsoscelesTrapezoid(8, 4, 5)
		};
		
		for(int i = 0; i < isoscelesTrapezoidCollection.length; i++) {
			System.out.printf("Perimeter of square %d : %.2f \n",i + 1, isoscelesTrapezoidCollection[i].calculatePerimeter());
			System.out.printf("Area of square %d : %.2f \n",i + 1, isoscelesTrapezoidCollection[i].calculateArea());
		}
	}
}
