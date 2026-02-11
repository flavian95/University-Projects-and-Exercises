
public class ThePersons2 extends TheCity2{
  private String name;
  private int income;
  
  public ThePersons2(String cityName, double size, String country, String name, int income) {
	  super(cityName, size, country);
      this.name = name;
      this.income = income;
  }
  
  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getIncome() {
      return income;
  }

  public void setIncome(int income) {
      this.income = income;
  }
  
  public String toString() {
	  return String.format("%s %d\n", getName(), getIncome(), getCityName(), getSize(), getCountry());  
  }
}
