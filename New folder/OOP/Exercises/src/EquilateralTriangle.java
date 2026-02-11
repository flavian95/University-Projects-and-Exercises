
public class EquilateralTriangle extends Triangle{
   private double a;
   
   public EquilateralTriangle(double a) {
	   super (a, a, a);
   }
   
   @Override
   public String toString() {
   	return String.format("%f", a);
   }
}
