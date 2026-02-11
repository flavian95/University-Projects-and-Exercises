
public class Town extends theCity {
    private int nrOfUniversities;
    
    public Town(String name, int population, String state, int nrOfUniversities) {
    	super(name, population, state);
        this.nrOfUniversities = nrOfUniversities;
    }

    public int getNrOfUniversities() {
        return nrOfUniversities;
    }

    public void setNrOfUniversities(int nrOfUniversities) {
        this.nrOfUniversities = nrOfUniversities;
    }
    
    public static void main(String[] args) {
    	Town town1 = new Town("Constanta", 300000, "CT", 3);
    	
    	System.out.println("The city name is:");
    	System.out.println(town1.getName());
    	
    	System.out.println("The population is:");
    	System.out.println(town1.getPopulation());
    	
    	System.out.println("The state is:");
    	System.out.println(town1.getState());
    	
    	System.out.println("The number of universities:");
    	System.out.println(town1.getNrOfUniversities());
    }
}