
public class TheCity2 {
  private String cityName;
  private double size;
  private String country;

  public TheCity2(String cityName, double size, String country) {
    this.cityName = cityName;
    this.size = size;
    this.country = country;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
  
  public String toString() {
	  return String.format("%s %f %s", getCityName(), getSize(), getCountry());
  }
}
