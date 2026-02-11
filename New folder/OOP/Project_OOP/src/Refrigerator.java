
public class Refrigerator extends Device{
    private int capacity;
    private String energeticClass;

    public Refrigerator(String brand, int price, int capacity, String energeticClass) {
        super(brand, price);
        this.capacity = capacity;
        this.energeticClass = energeticClass;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEnergeticClass() {
        return energeticClass;
    }

    public void setEnergeticClass(String energeticClass) {
        this.energeticClass = energeticClass;
    }

   @Override
    public String toString() {
         return String.format("Refrigerator:   Brand: %s   Price: %d$   Capacity: %d   EnergeticClass: %s", getBrand(), getPrice(), capacity, energeticClass);
    }
}