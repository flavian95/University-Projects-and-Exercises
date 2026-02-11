
public class theCity {
    private String name;
    private int population;
    private String state;
    
    public theCity(String name, int population, String state) {
        this.name = name;
        this.population = population;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}