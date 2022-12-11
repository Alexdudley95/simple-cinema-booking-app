
public class Receipt {
    private String customer;
    private double totalPrice;

    public Receipt(String customer, double price) {
        this.setCustomer(customer);
        this.setTotalPrice(price);
    }

    public String getCustomer() {
        return customer;
    }

    public void setTotalPrice(double price) {
        this.totalPrice = price;


    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}