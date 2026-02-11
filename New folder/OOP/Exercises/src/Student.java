
public class Student {
    private String firstName;
    private String lastName;
    private String city;
    
    public Student(String firstName, String lastName, String city) {
    	this.firstName= firstName;
    	this.lastName = lastName;
    	this.city= city;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void display(){
        System.out.println("First name:" + firstName);
        System.out.println("Last name:" + lastName);
        System.out.println("City:" + city);
        System.out.println();
      }

    
	public static void main(String[] args) {
	      Student s1,s2,s3;
	      
	      s1= new Student("John","Smith","London");
	      s2= new Student("Johnson","Doe","Brussels");
	      s3= new Student("Jan","Alfieri","Boston");
	      
	      s1.display();
	      s2.display();
	      s3.display();
	      
	      s1.setCity("New York");
	      s2.setCity("Berlin");
	      s3.setCity("Rotterdam");
	      
	       s1.display();
	       s2.display();
	       s3.display();

	}
}
