import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;  // Import the Scanner class

class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Restaurant> restaurantsList = new ArrayList<>();

        // Creating a customer object with user input and scanner
        Scanner scannerName = new Scanner(System.in);
        System.out.println("Enter your Name and Surname: ");
        String customerName = scannerName.nextLine();
        System.out.println("Hello, " + customerName + "!");
        System.out.println("Name: " + customerName);
        scannerName.close();

        Scanner scannerEmail = new Scanner(System.in);
        System.out.println("Enter your email address: ");
        String customerEmail;
        try {
            customerEmail = scannerEmail.nextLine();
            System.out.println("Email address: " + customerEmail );
            scannerEmail.close();
        }
        catch (NoSuchElementException e) {
            System.out.println("There was no next()");
            customerEmail = "email@email.com";
        }

        Scanner scannerPhone = new Scanner(System.in);
        System.out.println("Enter your email address: ");
        String customerPhone = scannerPhone.nextLine();
        System.out.println("Phone number: " + customerPhone);
        scannerPhone.close();

        Scanner scannerLocation = new Scanner(System.in);
        System.out.println("Enter your city: ");
        String customerLocation = scannerLocation.nextLine();
        System.out.println("Location: " + customerLocation );
        scannerLocation.close();

        Scanner scannerAddress = new Scanner(System.in);
        System.out.println("Enter your street address: ");
        String customerAddress = scannerAddress.nextLine();
        System.out.println("Street address: " + customerAddress);
        scannerAddress.close();
        Customer newCustomer = new Customer(customerName, customerEmail, customerPhone, customerLocation, customerAddress);
        newCustomer.printCustomerSummary();

        Boolean isMakingNewRestaurant;
        Scanner scannerIsMakingRestaurant = new Scanner(System.in);
        System.out.println("Would you like to make a new restaurant? Enter 'yes' or 'no' ");
        String isMakingARestaurantInput = scannerIsMakingRestaurant.nextLine();
        isMakingARestaurantInput = isMakingARestaurantInput.toLowerCase();
        scannerIsMakingRestaurant.close();

        switch(isMakingARestaurantInput) {
            case "yes", "y":
                isMakingNewRestaurant = true;
                break;
            case "no", "n":
                isMakingNewRestaurant = false;
                break;
            default:
                isMakingNewRestaurant = false;
                System.out.println("Your response could not be identified.");
        }

        while (isMakingNewRestaurant == true) {
            System.out.println("You are now creating a new restaurant.");
            Scanner scannerRestaurantName = new Scanner(System.in);
            System.out.println("What is the name of your new restaurant? Enter restaurant name: ");
            String restaurantName = scannerRestaurantName.nextLine();
            System.out.println("Restaurant Name: " + restaurantName);
            scannerRestaurantName.close();

            Scanner scannerRestaurantLocation = new Scanner(System.in);
            System.out.println("Enter restaurant location: ");
            String restaurantLocation = scannerRestaurantLocation.nextLine();
            System.out.println("Restaurant Location: " + restaurantLocation);
            scannerRestaurantLocation.close();

            Scanner scannerRestaurantPhone = new Scanner(System.in);
            System.out.println("Enter restaurant phone: ");
            String restaurantPhone = scannerRestaurantPhone.nextLine();
            System.out.println("Restaurant Phone Number: " + restaurantPhone);
            scannerRestaurantPhone.close();

            System.out.println("Now let's add items to " + restaurantName + "'s" + "menu.");



            /*
            Scanner scannerIsMakingRestaurant = new Scanner(System.in);
            System.out.println("Would you like to make a new restaurant? ");
            String isMakingARestaurant = scannerIsMakingRestaurant.nextLine();
            scannerIsMakingRestaurant.close();
            */
        }

        System.out.println("Email address: " + customerEmail );
    }
}




