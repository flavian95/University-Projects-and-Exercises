
public class Village extends theCity {
    private int nrOfVillages;
    
    public Village(String name, int population, String state, int nrOfVillages) {
    	super(name, population, state);
        this.nrOfVillages = nrOfVillages;
    }

    public int getNrOfVillages() {
        return nrOfVillages;
    }

    public void setnrOfVillages(int nrOfVillages) {
        this.nrOfVillages = nrOfVillages;
    }
    
    public static void main(String[] args) {
    	Village village1 = new Village("Bucharest", 2000000, "B", 5);
    	
    	System.out.println("The city name is:");
    	System.out.println(village1.getName());
    	
    	System.out.println("The population is:");
    	System.out.println(village1.getPopulation());
    	
    	System.out.println("The state is:");
    	System.out.println(village1.getState());
    	
    	System.out.println("The number of villages:");
    	System.out.println(village1.getNrOfVillages());
    }
}
