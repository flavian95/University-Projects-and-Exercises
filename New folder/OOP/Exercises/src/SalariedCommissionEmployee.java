
public class SalariedCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public SalariedCommissionEmployee(String name, int id, double commissionRate, double projectCost, double baseSalary) {
        super(name, id, commissionRate, projectCost);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
    	return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculatePay() {
    	return super.calculatePay() + baseSalary;
    }
    
    public static void main(String[] args) {
    	SalariedCommissionEmployee employee1 = new SalariedCommissionEmployee("Employee4", 4, 35, 4000, 1000);
        
        System.out.println("The name of the employee is: ");
        System.out.println(employee1.getName());
        
        System.out.println("The id of the employee is: ");
        System.out.println(employee1.getId());
        
        System.out.println("The commission rate of the employee is: ");
        System.out.println(employee1.getCommissionRate() + "%");
        
        System.out.println("The cost of the project is: ");
        System.out.println(employee1.getProjectCost());
        
        System.out.println("The base salary of the employee is: ");
        System.out.println(employee1.getBaseSalary());
        
        System.out.println("The pay of the employee is: ");
        System.out.println(employee1.calculatePay());
    }
}
