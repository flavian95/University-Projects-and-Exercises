
public abstract class Shop {
    private String name;
    private int startYear;
    private String address;

    public Shop(String name, int startYear, String address) {
        this.name = name;
        this.startYear = startYear;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public abstract String toString();
}
