
import java.util.ArrayList;
import java.util.List;

public class SalariedEmployee2 extends theEmployee implements calculateSalary, SalaryCompare {
    private double salary;
    private static List<SalariedEmployee2> employees = new ArrayList<>();

    public SalariedEmployee2(String employeeName, int employeeId, double salary) {
        super(employeeName, employeeId);
        this.salary = salary;
        employees.add(this);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String getEmployeeWithHighestSalary() {
        double maxSalary = Double.MIN_VALUE;
        String highestSalaryName = "";

        for (SalariedEmployee2 employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                highestSalaryName = employee.getEmployeeName();
            }
        }
        return highestSalaryName;
    }

    public static void main(String[] args) {
        SalariedEmployee2 employee1 = new SalariedEmployee2("Employee1", 456, 1200);
        SalariedEmployee2 employee2 = new SalariedEmployee2("Employee2", 453, 1900);
        SalariedEmployee2 employee3 = new SalariedEmployee2("Employee3", 865, 2700);
        SalariedEmployee2 employee4 = new SalariedEmployee2("Employee4", 223, 800);

        System.out.println("The employee with the highest salary is: ");
        System.out.println(employee1.getEmployeeWithHighestSalary());
    }
}

