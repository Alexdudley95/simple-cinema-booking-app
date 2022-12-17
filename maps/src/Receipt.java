
import java.io.*;

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


    //TODO: read and append transaction number, bring transaction number var across to this class.

    static void generateReceipt(int requestedNumberOfSeats,double totalPrice, String customer, int transactionNumber){
        System.out.println("You have purchased; " +requestedNumberOfSeats+ " Seats, Total cost is; "+totalPrice+" Thank you: "+customer +" Transaction number; "+transactionNumber);

        File previousTransactions = new File("C:/users/alex_/IdeaProjects/maps/src/previousTransactions.txt");
        try{
            if (previousTransactions.exists()){
                System.out.println("Creating new log file");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (PrintWriter out = new PrintWriter( new FileWriter(previousTransactions, true))){
            out.append("You have purchased; ").append(String.valueOf(requestedNumberOfSeats)).append(" Seats, Total cost is; ").append(String.valueOf(totalPrice)).append(" Thank you: ").append(customer).append(" Transaction number; ").append(String.valueOf(transactionNumber)).append("\n");
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    static void clearTransactions() {
        File previousTransactions = new File("C:/users/alex_/IdeaProjects/maps/src/previousTransactions.txt");
        if(previousTransactions.exists()){
            previousTransactions.deleteOnExit();
            System.out.println("Clearing previous transactions....");
        }else {
            System.out.println("No previous transactions....");
        }

    }
}

