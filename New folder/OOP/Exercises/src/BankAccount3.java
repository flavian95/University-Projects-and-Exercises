
public class BankAccount3 {
    public int accountNumber;
    public String ownerName;
    public double balance;
  
    public BankAccount3(int accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
  
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) 
            throw new IllegalArgumentException("Withdrawal amount exceeds balance");
        
        else balance -= amount;
    }
  
    @Override
    public String toString() {
        return String.format("%d %s %.2f", accountNumber, ownerName, balance);
    }

    public static void main(String[] args) {
        BankAccount3 account = new BankAccount3(1234, "John Doe", 1000);
        
        System.out.printf("Initial Account Details:\n%s\n", account);
        
        account.deposit(200);
        System.out.printf("After depositing 200:\n%s\n", account);
        
        account.withdraw(500); 
        System.out.printf("After withdrawing 500:\n%s\n", account);
        
        try {
            System.out.printf("Attempting to withdraw 900:\n%s\n", account);
            account.withdraw(900);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    } 
}

