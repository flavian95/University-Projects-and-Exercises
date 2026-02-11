
public class City {
    private String cityName;
    private String country;
    private int citySize;

    public City(String cityName, String country, int citySize) {
        this.cityName = cityName;
        this.country = country;
        this.citySize = citySize;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public int getCitySize() {
        return citySize;
    }

    public void setCitySize(int citySize) {
        this.citySize = citySize;
    }
    
    public static void main(String[] args) {
        City city = new City("Bucharest", "Romania", 150);

        System.out.println("City: " + city.getCityName());
        System.out.println("Country: " + city.getCountry());
        System.out.println("CitySize: " + city.getCitySize()); 
    }
}
