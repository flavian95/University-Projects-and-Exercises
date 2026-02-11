

public class CommissionEmployee extends Employee {
    private double commissionRate;
    private double projectCost;

    public CommissionEmployee(String name, int id, double commissionRate, double projectCost) {
        super(name, id);
        this.commissionRate = commissionRate;
        this.projectCost = projectCost;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(double projectCost) {
        this.projectCost = projectCost;
    }

    @Override
    public double calculatePay() {
        return (commissionRate / 100) * projectCost;
    }
    
    public static void main(String[] args) {
        CommissionEmployee employee1 = new CommissionEmployee("Employee3", 3, 30, 3000);
        
        System.out.println(employee1.getName() + " " + employee1.getId() + " " + employee1.getCommissionRate() + " " + employee1.getProjectCost());
        System.out.println("The pay of the employee is: ");
        System.out.println(employee1.calculatePay());
    }
}
