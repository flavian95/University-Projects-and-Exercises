
public class TV extends Device{
    private int size;
    private String colour;

    public TV(String brand, int price, int size, String colour) {
        super(brand, price);
        this.size = size;
        this.colour = colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
 
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
    @Override
    public String toString() {
        return String.format("TV:   Brand: %s   Price: %d$   Size: %d   Colour: %s", getBrand(), getPrice(), size, colour);
    }
}