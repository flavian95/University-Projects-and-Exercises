
public class RightAngleTriangle extends Triangle{
   private double b;
   private double c;
   
   public RightAngleTriangle(double b, double c) {
	   super (b, c, b);
   }
   
   @Override
   public String toString() {
   	return String.format("%f %f", b, c);
   }
}
