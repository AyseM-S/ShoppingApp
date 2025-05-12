
interface ShipmentMethod {
	public void setShippingCost(double cost);
	public void updateDeliveryStatus(String status);
	public void displayShippingInfo();
	public double getShippingCost();
}

class StandardShipping implements ShipmentMethod {
    private double shippingCost = 50.0;
    private String deliveryStatus = "Your requests has been notified to seller.";
    
    public double getShippingCost() {
    	return shippingCost;
    }
    
    public void setShippingCost(double cost) {
    	this.shippingCost = cost;
    }

  
    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

   
    public void displayShippingInfo() {
        System.out.println("Shipping Method: Standard Shipping");
        System.out.println("Shipping Cost: $" + shippingCost);
        System.out.println("Delivery Status: " + deliveryStatus);
    }
}


class FastShipping implements ShipmentMethod {
    private double shippingCost = 100.0;
    private String deliveryStatus = "Your requests has been notified to seller.";
    
    public void setShippingCost(double cost) {
    	this.shippingCost = cost;
    }
    
    public double getShippingCost() {
    	return shippingCost;
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

    public void displayShippingInfo() {
        System.out.println("Shipping Method: Fast Shipping");
        System.out.println("Shipping Cost: $" + shippingCost);
        System.out.println("Delivery Status: " + deliveryStatus);
    }
}
