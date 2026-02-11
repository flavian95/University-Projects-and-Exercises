
abstract public class Polygon {
    private int sidesNr;
    
	public Polygon(int sidesNr) {
		this.sidesNr = sidesNr;
	}
	
	public int getSideNr() {
		return sidesNr;
	}
	
	public void setSidesNr(int sidesNr) {
		this.sidesNr = sidesNr;
	}
	
	abstract double calculatePerimeter();
    abstract double calculateArea();
	
	public String toString() {
		return String.format("%d", sidesNr);
	}
}
