import java.util.Scanner;


public class Main {

    static int setup(ScreenInformation amountOfSeats){

        Scanner amountSeats = new Scanner(System.in);
        System.out.println("There are "+amountOfSeats.getTotalSeats()+ " Seats remaining ");
        System.out.println("How many seats would you like? ");
/*        String userInput = amountSeats.next();*/

        // TODO; fix exit loop

        if(amountSeats.hasNextInt()){
            runLoop(amountSeats.nextInt(), amountOfSeats);
            return amountSeats.nextInt();
        } else if (amountSeats.hasNext("exit")) {
            System.out.println("Exiting");
            return 0;
        } else if (amountSeats.hasNext("Clear")) {
            Receipt.clearTransactions();
            setup(amountOfSeats);
        } else {
            System.out.println("Sorry, our system did not recognise that input, please try again.");
            setup(amountOfSeats);
        }
        return 0;
    }


    public static void main(String[] args){

        ScreenInformation amountOfSeats = new ScreenInformation();
        setup(amountOfSeats);


    }

    static void runLoop(int requestedNumberOfSeats, ScreenInformation amountOfSeats){
        while(requestedNumberOfSeats > amountOfSeats.getTotalSeats()){
            System.out.println("There are not enough seats.");
            requestedNumberOfSeats = setup(amountOfSeats);
        }
        Transaction.pushTransaction(requestedNumberOfSeats, amountOfSeats);
        setup(amountOfSeats);
    }
}


