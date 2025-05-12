import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Product product1 = new Product("Laptop", 30000.00, 10, 1);
	     Product product2 = new Product("Headphones", 499.99, 20, 2);
	     Product product3 = new Product("Smartphone", 7800.00, 15, 3);
	     
	     ShoppingBasket basket = new ShoppingBasket();
	     Scanner scanner = new Scanner(System.in);
	     
	     System.out.println("Welcome to the Shopiest.com !");
	     while(true) {
	    	 System.out.println("Please press 1 to ADD product, 2 to REMOVE, 3 to VIEW basket, 4 to CHECKOUT, 5 to EXIT !");
	    	 int choice = scanner.nextInt();
	    	 
	    	 switch (choice) {
	    	 	case 1:
		   	    	System.out.println("Please enter Product ID ( 1 for Laptop, 2 for Headphones, 3 for Smartphone ! )");
		   	    	System.out.println("Stocks in order: " + product1.getStockQuantity() +" "+ product2.getStockQuantity()+ " " + product3.getStockQuantity());
		    	 	int id = scanner.nextInt();
			    	System.out.println("Please enter Quantity: ");
			    	int quantity = scanner.nextInt();
			    	 
			    	if (id == 1) {
			    		basket.addItem(product1, quantity); 
			    		System.out.println("Stock: " + product1.getStockQuantity());
			    	} else if (id == 2) {
			    		basket.addItem(product2, quantity);
			    		System.out.println("Stock :" + product2.getStockQuantity());
			    	} else if (id == 3) {
			    		basket.addItem(product3, quantity);
			    		System.out.println("Stock: " + product3.getStockQuantity());
			    	} else {
				    	System.out.println("Please enter a valid Product ID !!!");
			    	}
			    	break;
		    	 
	    	 	case 2:
	   	    	  	System.out.println("Please enter Product ID to to remove  ( 1 for Laptop, 2 for Headphones, 3 for Smartphone) !");
	   	    	  	int removeProductID = scanner.nextInt();
	   	    	  	System.out.println("Please enter quantity to remove : ");
	   	    	  	int removeQuantity = scanner.nextInt();
	   	    	  	
	   	    	 if (removeProductID == 1) {
			    		basket.removeItem(product1, removeQuantity); 
			    	} else if (removeProductID == 2) {
			    		basket.removeItem(product2, removeQuantity);
			    	} else if (removeProductID == 3) {
			    		basket.removeItem(product3, removeQuantity);
			    	} else {
				    	System.out.println("Please enter a valid Product ID !!!");
			    	}
	   	    	 
			    	break;
			    	
	    	 	case 3:
	    	 		basket.displayBasket();
	    	 		System.out.println(basket.calculateTotalPrice() + "₺");
	    	 		break;
	    	 		
	    	 	case 4:
	    	 		double total = basket.calculateTotalPrice();
	    	 		System.out.println("TOTAL AMOUNT : " + total + "₺");
	    	 		System.out.println("Please press 1 for Credit Card , 2 for Paypal. ");
	    	 		int paymentMethod = scanner.nextInt();
	    	 		
	    	 		if (paymentMethod == 1) {
	    	 			System.out.println("Please enter card details.");
	    	 			System.out.println("CARD NUMBER : ");
	    	 			String cardNum = scanner.nextLine();
	    	 			scanner.nextLine();
	    	 			System.out.println("EXPIRATION DATE : ");
	    	 			String expDate = scanner.nextLine();
	    	 			System.out.println("CVV :");
	    	 			String cvv = scanner.nextLine();
	    	 			Payment payment = new CreditCard(total, cardNum, expDate, cvv);
	    	 			payment.paymentTransaction();			
	    	 		}
	    	 		else if (paymentMethod == 2){
	    	 	        System.out.println("Please enter PayPal email:");
	    	 	        String email = scanner.nextLine();
	    	 	        scanner.nextLine();
	    	 	        System.out.println("Please enter PayPal password:");
	    	 	        String password = scanner.nextLine();
	    	 	        Payment payment = new PayPal(total, email, password);
	    	 	        payment.paymentTransaction();
	    	 		}
	    	 		else {
	    	 			System.out.println("Entered invalid payment method.");
	    	 		}
	    	 		
                    System.out.println("Please enter your address: ");
                    String address = scanner.nextLine();
                    Shipment shipment = new Shipment(address);
                    shipment.displayShippingDetails();
                    scanner.nextLine();
                    
                    System.out.println("Choose a shipping method: 1 for Standard, 2 for Fast. ");
                    int shippingChoice = scanner.nextInt();

                    ShipmentMethod shipmentMethod;
                    if (shippingChoice == 1) {
                        shipmentMethod = new StandardShipping();
                    } else if (shippingChoice == 2) {
                        shipmentMethod = new FastShipping();
                    } else {
                        System.out.println("Invalid choice. Defaulting to Standard Shipping.");
                        shipmentMethod = new StandardShipping();
                    }

                    shipmentMethod.getShippingCost();
                    shipmentMethod.updateDeliveryStatus("Processing");
                    shipmentMethod.displayShippingInfo();
                    basket.clearBasket();
                    break;
	    	 	
	    	 	case 5:
	    	 		System.out.println("Exiting...");
	    	 		scanner.close();
	    	 		return; 		
	    	 		
	    	 	default:
	    	 		System.out.println("Invalid choice...");
	    	 }
	    	 
	     }

	}

}
