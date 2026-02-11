
public class ThePerson2 {
  private String name;
  private double income;
  
  public ThePerson2(String name, double income) {
    this.name= name;
    this.income= income;
  } 
  
  public String getName() { return name;}
  public double getSalary() { return income;}

  
  public String toString(){
     return String.format("%s %.0f", name, income);
  }
}