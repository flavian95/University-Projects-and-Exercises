
public class HiperMarket extends Shop{
	 private int nrOfEmployees;

	 public HiperMarket(String name, int startYear, String address, int nrOfEmployees) {
	     super(name, startYear, address);
	     this.nrOfEmployees = nrOfEmployees;
	 }
	    
	 public int getNrOfEmployees() {
        return nrOfEmployees;
    }

    public void setNrOfEmployees(int nrOfEmployees) {
        this.nrOfEmployees = nrOfEmployees;
    }
    
    @Override
    public String toString() {
        return String.format("Name %s   StartYear: %d   Address: %s   NrOfEmployees: %d", getName(), getStartYear(), getAddress(), getNrOfEmployees());
    }
}

