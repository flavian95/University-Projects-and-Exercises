
public class Person1 {
    private String name;
    private int salary;

    public Person1 (String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public static void main(String[] args) {
        Person1 person = new Person1("John", 1500);

        System.out.println("City: " + person.getName());
        System.out.println("Country: " + person.getSalary());
    }
}
