package main;

public class ScreenInformation {


    private double SeatPrice = 5;
    // Big decimal - more accurate than double and float

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
