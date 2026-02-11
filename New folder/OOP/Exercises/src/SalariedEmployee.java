

public class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public double calculatePay() {
        return salary;
    }
    
    public static void main(String[] args) {
        SalariedEmployee employee1 = new SalariedEmployee("Employee2", 2, 1000);
        
        System.out.println(employee1.getName() + " " + employee1.getId() + " " + employee1.getSalary());
    }
}
