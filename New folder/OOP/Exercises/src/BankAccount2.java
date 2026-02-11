
public class BankAccount2 {
	private String ownersName;
	private double accountSum;
    private int accountNr;

    public BankAccount2(String ownersName, double accountSum, int accountNr) {
    	this.ownersName = ownersName;
    	this.accountSum = accountSum;
        this.accountNr = accountNr;
    }
    
    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }
    
    public double getAccountSum() {
        return accountSum;
    }

    public void setAccountSum(double accountSum) {
        this.accountSum = accountSum;
    }	

	public int getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(int accountNr) {
        this.accountNr = accountNr;
    }	  
    
    @Override
    public String toString() {
        return "Name: " + ownersName + ", Sum: " + accountSum + ", Account Nr: " + accountNr;
    }
}


