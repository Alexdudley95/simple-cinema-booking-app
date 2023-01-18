package main;

import java.util.Scanner;



public class Transaction {

    private double price;

    private int transactionNumber = 1;



    public Transaction(double price){
        this.setPrice(price);
    }

    static void pushTransaction(int requestedNumberOfSeats, ScreenInformation amountOfSeats){


        // pass boolean into transactions with transcactions y/n
        // make it so it returns back to main
        //

        Scanner newCustomer = new Scanner(System.in);
        System.out.println("Enter your name to receive a discount, type N if you would not like to ");
        String customerName = newCustomer.nextLine();
        CustomerInformation newCustomerName = new CustomerInformation(customerName);
        newCustomerName.setCustomerName(customerName);

        if (newCustomerName.getCustomerName().equals("N")) {
            // inputting no name, and generating a new receipt with no discount

            newCustomerName.setCustomerName("No Name Provided");
            //pushing customer information to receipt
            Transaction newTransaction = new Transaction( amountOfSeats.getSeatPrice());
            double totalPrice = requestedNumberOfSeats * amountOfSeats.getSeatPrice();

            newTransaction.setTransactionNumber();

            Receipt.generateReceipt(requestedNumberOfSeats, totalPrice, customerName,newTransaction.getTransactionNumber());
        } else {
            //creating a var called x and making that do the 20% discount
            double x = amountOfSeats.getSeatPrice() * 0.2;

            amountOfSeats.setSeatPrice(amountOfSeats.getSeatPrice() - x );
            // generating a new receipt with customers name
            Receipt newReceipt = new Receipt(newCustomerName.getCustomerName(), amountOfSeats.getSeatPrice());
            newReceipt.setTotalPrice( requestedNumberOfSeats * amountOfSeats.getSeatPrice());
            Transaction newTransaction = new Transaction( amountOfSeats.getSeatPrice());
            newTransaction.setTransactionNumber();
            Receipt.generateReceipt(requestedNumberOfSeats, newReceipt.getTotalPrice(), customerName, newTransaction.getTransactionNumber());
        }

    }




    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber() {
        this.transactionNumber = transactionNumber++;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


