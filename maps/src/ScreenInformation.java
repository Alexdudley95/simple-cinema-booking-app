public class ScreenInformation {


    private double SeatPrice = 5;
    private int totalSeats = 25;

    public ScreenInformation(){
        this.getSeatPrice();
        this.getTotalSeats();

    }


    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public double getSeatPrice() {
        return SeatPrice;
    }

    public void setSeatPrice(double price) {
        SeatPrice = price;
    }
}
