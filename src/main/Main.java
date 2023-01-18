package main;

import java.util.Scanner;


public class Main {

    static void setup(ScreenInformation amountOfSeats){

        Scanner requestedAmountOfSeats = new Scanner(System.in);
        System.out.println("There are "+amountOfSeats.getTotalSeats()+ " Seats remaining ");
        System.out.println("How many seats would you like? ");
     /*   String userInput = requestedAmountOfSeats.next();*/

        // TODO; make user input not case sensitive

        userInput(amountOfSeats, requestedAmountOfSeats);

    }

    public static String userInput(ScreenInformation amountOfSeats, Scanner requestedAmountOfSeats) {

        //enums - hard coded values, prevents user error and good for refactoring
        if(requestedAmountOfSeats.hasNextInt()){
            runLoop(requestedAmountOfSeats.nextInt(), amountOfSeats);
            requestedAmountOfSeats.nextInt();
            return "committed to Run loop";

        } else if (requestedAmountOfSeats.hasNext("exit")) {
            System.out.println("Exiting");
            System.exit(0);
            return "exit";

        } else if (requestedAmountOfSeats.hasNext("Clear")) {
            Receipt.clearTransactions();
            setup(amountOfSeats);
            return  "clear";
        } else {
            System.out.println("Sorry, our system did not recognise that input, please try again.");
            setup(amountOfSeats);
            return "invalid input";
        }

    }

    public static void main(String[] args){
        ScreenInformation amountOfSeats = new ScreenInformation();
        setup(amountOfSeats);
    }

    static void runLoop(int requestedNumberOfSeats, ScreenInformation amountOfSeats){
        if(requestedNumberOfSeats > amountOfSeats.getTotalSeats()){
            System.out.println("There are not enough seats.");
            setup(amountOfSeats);
        }
        Transaction.pushTransaction(requestedNumberOfSeats, amountOfSeats);
        setup(amountOfSeats);
    }
}


