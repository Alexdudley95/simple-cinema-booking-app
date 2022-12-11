import java.util.Scanner;


public class Main {

    static int setup(ScreenInformation amountOfSeats){

        Scanner amountSeats = new Scanner(System.in);
        System.out.println("There are "+amountOfSeats.getTotalSeats()+ " Seats remaining ");
        System.out.println("How many seats would you like? ");
        return amountSeats.nextInt();
    }

    static void generateReceipt(int requestedNumberOfSeats, ScreenInformation amountOfSeats){

        Scanner newCustomer = new Scanner(System.in);


        System.out.println("Enter your name to receive a discount, type N if you would not like to ");
        String customerName = newCustomer.nextLine();
        customerInformation newCustomerName = new customerInformation(customerName);
        newCustomerName.setCustomerName(customerName);

        if (customerName.equals("N")) {
            // inputting no name, and generating a new receipt with no discount

            newCustomerName.setCustomerName("No Name Provided");
            //pushing customer information to receipt
            Receipt newReceipt = new Receipt(newCustomerName.getCustomerName(), amountOfSeats.getSeatPrice());
            newReceipt.setCustomer(newCustomerName.getCustomerName());
            double totalPrice = requestedNumberOfSeats * amountOfSeats.getSeatPrice();
            System.out.println(newReceipt.getCustomer() + "    " + totalPrice);

        } else {
            //creating a var called x and making that do the 20% discount
            double x = amountOfSeats.getSeatPrice() * 0.2;

            amountOfSeats.setSeatPrice(amountOfSeats.getSeatPrice() - x );
            // generating a new receipt with customers name
            Receipt newReceipt = new Receipt(newCustomerName.getCustomerName(), amountOfSeats.getSeatPrice());
            newReceipt.setTotalPrice( requestedNumberOfSeats * amountOfSeats.getSeatPrice());
            System.out.println(newReceipt.getCustomer() + "    " + newReceipt.getTotalPrice());
        }
    }

    public static void main(String[] args){

        ScreenInformation amountOfSeats = new ScreenInformation();
        int requestedNumberOfSeats = setup(amountOfSeats);
        while(requestedNumberOfSeats> amountOfSeats.getTotalSeats()){
            System.out.println("There are not enough seats.");
            requestedNumberOfSeats = setup(amountOfSeats);
        }

        generateReceipt(requestedNumberOfSeats, amountOfSeats);


    }
}
// to do, separate user input from the class seats, and compare against the seats class

