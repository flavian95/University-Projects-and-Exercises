
public class Person {
	private int age;
    private boolean isEmployed;
    private double salary;
    private String name;
	
	private Person(int age, boolean isEmployed, double salary, String name) {
	  this.age = age;
	  this.isEmployed = isEmployed;
	  this.salary = salary;
	  this.name = name;
	}
	
	public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean getEmployment() {
        return isEmployed;
    }

    public void setEmployment(boolean isEmployed) {
        this.isEmployed = isEmployed;
    }
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
	public static void main(String[] args) {
		Person[] persons = {
		     new Person(22, true, 1100, "Person1"),
		     new Person(32, false, 1300, "Person2"),
		     new Person(43, false, 1500, "Person3"),
		     new Person(27, true, 1800, "Person4")
		};

	    double maxSalary = 0;
	    
	    for (Person person : persons) {
	        if (person.getSalary() > maxSalary) {
	            maxSalary = person.getSalary();
	        }
	    }
	    
	    String maxSalaryPerson = "";
	    
	    for (Person person : persons) {
	        if (maxSalary == person.getSalary()) {
	            maxSalaryPerson = person.getName();
	        }
	    }

	    System.out.println("Maximum salary: " + maxSalary);
	    System.out.println("Maximum salary: " + maxSalaryPerson);
	}
}
