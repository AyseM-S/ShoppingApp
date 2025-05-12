public class Product {
	private String productName;
	private double price;
	private int stockQuantity;
	private int itemID;
	
	public Product(String name, double price, int stock, int itemId) {
		this.productName=name;
		this.price=price;
		this.stockQuantity=stock;
		this.itemID=itemId;
		
	}

	public boolean isInStock(int quantity) {
		return stockQuantity >= quantity;
	}
	
	public void reduceStock(int quantity) {
		if (isInStock(quantity)) {
			stockQuantity -= quantity;
		}
	}
	
	public void increaseStock(int quantity) {
		stockQuantity += quantity;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public int getItemID() {
		return itemID;
	}
	
}
