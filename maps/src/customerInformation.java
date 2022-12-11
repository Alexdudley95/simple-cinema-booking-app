

public class customerInformation {

    private String customerName;
    private int requestedAmountOfSeats;

    public customerInformation(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRequestedAmountOfSeats() {
        return requestedAmountOfSeats;
    }

    public void setRequestedAmountOfSeats(int requestedAmountOfSeats) {
        this.requestedAmountOfSeats = requestedAmountOfSeats;
    }
}
