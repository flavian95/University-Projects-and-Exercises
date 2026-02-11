
public class Invoice implements calculateInvoice{
   private double billAmount;
   private double taxes;
   
   public Invoice(double billAmount, double taxes) {
       this.billAmount = billAmount;
       this.taxes = taxes;
   }

   public double getBillAmount() {
       return billAmount;
   }

   public void setBillAmount(double billAmount) {
       this.billAmount = billAmount;
   }

   public double getTaxes() {
       return taxes;
   }

   public void setTaxes(double taxes) {
       this.taxes = taxes;
   }
   
   @Override
   public double calculateInvoice() {
	   return billAmount + (billAmount * (taxes / 100.0));
   }

	public static void main(String[] args) {
		Invoice invoice1 = new Invoice(1500, 20);
		
		System.out.println("The invoice is: ");
		System.out.println(invoice1.calculateInvoice());

	}
}
