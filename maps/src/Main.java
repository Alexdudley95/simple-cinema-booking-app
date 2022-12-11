import java.util.Scanner;


public class Main {

    static int setup(Seats amountOfSeats){

        Scanner amountSeats = new Scanner(System.in);
        System.out.println("There are "+amountOfSeats.getTotalSeats()+ " Seats remaining ");
        System.out.println("How many seats would you like? ");
        return amountSeats.nextInt();
    }

    static void generateReceipt(int requestedNumberOfSeats, Seats amountOfSeats){

        Scanner newCustomer = new Scanner(System.in);

        System.out.println("Enter your name to receive a discount, type N if you would not like to ");
        String customerName = newCustomer.nextLine();

        if (customerName.equals("N")) {
            Receipt newReceipt = new Receipt("No Name Given", amountOfSeats.getSeatPrice());
            double totalPrice = requestedNumberOfSeats * amountOfSeats.getSeatPrice();
            System.out.println(newReceipt.getCustomer() + "    " + totalPrice);

        } else {
            //creating a var called x and making that do the 20% discount
            double x = 0;
            x = amountOfSeats.getSeatPrice() * 0.2;
            amountOfSeats.setSeatPrice(amountOfSeats.getSeatPrice() - x );
            
            Receipt newReceipt = new Receipt(customerName, amountOfSeats.getSeatPrice());
            double totalPrice = requestedNumberOfSeats * amountOfSeats.getSeatPrice();
            System.out.println(newReceipt.getCustomer() + "    " + totalPrice);
        }
    }

    public static void main(String[] args){

        Seats amountOfSeats = new Seats();
        int requestedNumberOfSeats = setup(amountOfSeats);
        while(requestedNumberOfSeats> amountOfSeats.getTotalSeats()){
            System.out.println("There are not enough seats.");
            requestedNumberOfSeats = setup(amountOfSeats);
        }

        generateReceipt(requestedNumberOfSeats, amountOfSeats);


    }
}
// to do, separate user input from the class seats, and compare against the seats class
// generate an actual discount amount
// refactor seats class to be called screen/seatsInformation
