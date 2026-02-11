
public class SuperMarket extends Shop {
    private int salesVolume;

    public SuperMarket(String name, int startYear, String address, int salesVolume) {
        super(name, startYear, address);
        this.salesVolume = salesVolume;
    }

    public int getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(int salesVolume) {
        this.salesVolume = salesVolume;
    }
    
    @Override
    public String toString() {
        return String.format("Name: %s   StartYear: %d   Address: %s   SalesVolume: %d", getName(), getStartYear(), getAddress(), getSalesVolume());
    }
}

