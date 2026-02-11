
public class TheMain2 {
	
	public static void returnPersons(ThePersons2[] personsList){
		   
		  for(ThePersons2 person: personsList) {
			 System.out.println(person.getCityName() + " " + person.getName() + " " + person.getIncome());
		  }		
	}	 

	public static void main(String[] args) {
		ThePersons2[] personsList = {
			    new ThePersons2("London", 110, "UK", "Person1", 3400),
			    new ThePersons2("New York", 140, "US", "Person2", 3200),
			    new ThePersons2("Berlin", 220, "Germany", "Person3", 2300),
			    new ThePersons2("Rotterdam", 80, "Netherlands", "Person4", 3900),
			    new ThePersons2("Zurich", 20, "Switzerland", "Person5", 6000),
			  };
		
		returnPersons(personsList);
	}

}
