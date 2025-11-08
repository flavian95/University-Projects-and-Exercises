package Lab2;

public class Book {
    private String title, publishers;
    private double price;
    private String currency;

    public Book(String t, String p) {
        title = t;
        publishers = p;
    }

    public Book(String t, String e, String p, String v) {
        title = t;
        publishers = e;
        price = p;
        currency = v;
    }

    public String toString() {
        var sb = new StringBuffer();
        sb.append(title);
        sb.append(".");
        sb.append(publishers);
        return sb.toString();
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return this.currency;
    }
}
