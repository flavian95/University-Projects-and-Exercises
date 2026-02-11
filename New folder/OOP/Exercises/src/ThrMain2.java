
public class ThrMain2 {	
	public static int returnHighestIncome(ThePersons2[] personsList){
		   int maxIncome = personsList[0].getIncome();
		   
		  for(ThePersons2 person: personsList) {
			if(person.getIncome() > maxIncome) {
				maxIncome = person.getIncome();
			}
		  }
			
			return maxIncome;
		  }	 
	  
	  public static String returnHighestEarner(ThePersons2[] personsList, int maxIncome){
		   String maxIncomeName = personsList[0].getName();
		   
		  for(ThePersons2 person: personsList) {
			if(person.getIncome() == maxIncome) {
				maxIncomeName = person.getName();
				break;
			}
		  }
			
			return maxIncomeName;
		  }	
	  
  public static void main(String[] args) {
	  
	  ThePersons2[] personsList = {
	    new ThePersons2("Person1", 3400),
	    new ThePersons2("Person2", 3200),
	    new ThePersons2("Person3", 2000),
	    new ThePersons2("Person4", 5100)
	  };
	  
	  int maxIncome = returnHighestIncome(personsList);
		String maxIncomeName = returnHighestEarner(personsList, maxIncome);
		
		System.out.println("Highest earner: " + maxIncomeName);
  }
}
