import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingBasket {
	private HashMap<String,Integer> items = new HashMap<String, Integer>();
	private ArrayList<Double> prices = new ArrayList<Double>();
	
	public void addItem(Product product, int quantity) {
		if (product.isInStock(quantity)) {
			
				if (items.containsKey(product.getProductName())){
					items.put(product.getProductName(), items.get(product.getProductName()) + quantity);
					prices.add(product.getPrice()*quantity);
					product.reduceStock(quantity);
				}
				else {
					items.put(product.getProductName(), quantity);
					prices.add(product.getPrice()*quantity);
					product.reduceStock(quantity);
				}
			
		}
		else {
			System.out.println("There isn't enough stock for " + product.getProductName());
		}
		
	}
	
	public void removeItem(Product product, int quantity) {
		
			if (items.containsKey(product.getProductName())){
				if (items.get(product.getProductName())==quantity) {
					items.remove(product.getProductName());
					product.increaseStock(quantity);
					prices.add(-product.getPrice()*quantity);
				}
				else if (items.get(product.getProductName())>quantity) {
					items.put(product.getProductName(), items.get(product.getProductName())-quantity);
					product.increaseStock(quantity);
					prices.add(-product.getPrice()*quantity);
				}
				else {
					System.out.println("Please enter a valid quantity to remove this item.");
				}	
			}
			
			else {
				System.out.println("The product that you want to remove from basket already does not exist!");
			}
					
	}
	
	public void displayBasket() {
		if (items.isEmpty()) {
			System.out.println("Your shopping basket is empty.");
		}
		
		else {
			for (String item : items.keySet()) {
				System.out.println(items.get(item) + " x " + item );
			}
		}
	}
	
	public double calculateTotalPrice() {
		double total = 0;
		for (double price : prices) {
			total += price;
		}
		return total;	
	}
	
	public void clearBasket() {
		items.clear();
		prices.clear();
	}
}
