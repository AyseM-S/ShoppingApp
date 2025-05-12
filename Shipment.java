
public class Shipment {
    private String address;
    private String status;

    public Shipment(String address) {
        this.address = address;
        this.status = "Pending";
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void displayShippingDetails() {
        System.out.println("Shipping to: " + address);
        System.out.println("Status: " + status);
    }	

}
