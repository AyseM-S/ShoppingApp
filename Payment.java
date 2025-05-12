
public abstract class Payment {
	protected double totalAmount;
	
	public Payment(double totalAmount) {
		this.totalAmount=totalAmount;
	}
	
	public abstract void paymentTransaction();
}

class CreditCard extends Payment {
	private String cardNumber;
	private String expirationDate;
	private String cvv;
	
	public CreditCard(double totalAmount, String cardNumber,  String expirationDate, String cvv) {
		super(totalAmount);
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
        this.cvv = cvv;
	}
	 public void paymentTransaction() {
	        System.out.println("Thank you for the credit card payment of " + totalAmount + "₺");
	 }
	
}

class PayPal extends Payment{
	private String email;
	private String password;
	
	public PayPal(double totalAmount, String email, String password) {
        super(totalAmount);
        this.email = email;
        this.password = password;
	}
	
	public void paymentTransaction() {
	        System.out.println("Thank you for the paypal payment of " + totalAmount + "₺");
	 }
}

	
