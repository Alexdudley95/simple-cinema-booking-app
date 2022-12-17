
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




    static void generateReceipt(int requestedNumberOfSeats,double totalPrice, String customer, int transactionNumber){
        System.out.println("You have purchased; " +requestedNumberOfSeats+ " Seats, Total cost is; "+totalPrice+" Thank you: "+customer +" Transaction number; "+transactionNumber);

        File previousTransactions = new File("C:/users/alex_/IdeaProjects/maps/src/previousTransactions.txt");
        try{
            if (previousTransactions.exists()==false){
                System.out.println("Creating new log file");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try (PrintWriter out = new PrintWriter( new FileWriter(previousTransactions, true))){
            out.append("You have purchased; " +requestedNumberOfSeats+ " Seats, Total cost is; "+totalPrice+" Thank you: "+customer +" Transaction number; "+transactionNumber + "\n");
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

