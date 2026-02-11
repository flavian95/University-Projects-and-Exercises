
import javax.swing.JOptionPane;

public class BankAccount {
    private int accountNr;
    private String ownersName;
    private double accountSum;

    public BankAccount(int accountNr, String ownersName, double accountSum) {
        this.accountNr = accountNr;
        this.ownersName = ownersName;
        this.accountSum = accountSum;
    }

    public int getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(int accountNr) {
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

    public static void main(String[] args) {	   	
    	int accountNr1 = Integer.parseInt(JOptionPane.showInputDialog("Enter First Account Number:"));
        String ownersName1 = JOptionPane.showInputDialog("Enter First Owner's Name:");
        double accountSum1 = Double.parseDouble(JOptionPane.showInputDialog("Enter First Account Sum:"));

        BankAccount account1 = new BankAccount(accountNr1, ownersName1, accountSum1);

        int accountNr2 = Integer.parseInt(JOptionPane.showInputDialog("Enter Second Account Number:"));
        String ownersName2 = JOptionPane.showInputDialog("Enter Second Owner's Name:");
        double accountSum2 = Double.parseDouble(JOptionPane.showInputDialog("Enter Second Account Sum:"));

        BankAccount account2 = new BankAccount(accountNr2, ownersName2, accountSum2);

        JOptionPane.showMessageDialog(null,
                "Account 1:\n" +
                "Account Number: " + account1.getAccountNr() +
                "\nOwner's Name: " + account1.getOwnersName() +
                "\nAccount Sum: " + account1.getAccountSum() +
                "\n\n" +
                "Account 2:\n" +
                "Account Number: " + account2.getAccountNr() +
                "\nOwner's Name: " + account2.getOwnersName() +
                "\nAccount Sum: " + account2.getAccountSum());
  }
}