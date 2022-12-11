
public class Receipt {
    private String customer;
    private double totalPrice;

    public Receipt(String customer, double price) {
        this.customer = customer;
        this.totalPrice = price;
    }

    public String getCustomer() {
        return customer;
    }

    public double getPrice() {
        return totalPrice;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setPrice(double price) {
        this.totalPrice = price;


    }
}