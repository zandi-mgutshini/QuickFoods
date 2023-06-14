import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Restaurant> restaurantsList = new ArrayList<>();

        // Opening the scanner for all user input
        Scanner scannerUserInput = new Scanner(System.in);

        System.out.println("Enter your Name and Surname: ");
        String customerName = scannerUserInput.nextLine();
        System.out.println("Hello, " + customerName + "!");
        System.out.println("Name: " + customerName);

        System.out.println("Enter your email address: ");
        String customerEmail = scannerUserInput.nextLine();
        System.out.println("Email address: " + customerEmail );

        System.out.println("Enter your phone number: ");
        String customerPhone = scannerUserInput.nextLine();
        System.out.println("Phone number: " + customerPhone);

        System.out.println("Enter your city: ");
        String customerLocation = scannerUserInput.nextLine();
        System.out.println("Location: " + customerLocation );

        System.out.println("Enter your street address: ");
        String customerAddress = scannerUserInput.nextLine();
        System.out.println("Street address: " + customerAddress);

        Customer newCustomer = new Customer(customerName, customerEmail, customerPhone, customerLocation, customerAddress);
        newCustomer.printCustomerSummary();
        customerList.add(newCustomer);

        boolean isMakingNewRestaurant;
        System.out.println("Would you like to make a new restaurant? Enter 'yes' or 'no' ");
        String isMakingARestaurantInput = scannerUserInput.nextLine();
        isMakingARestaurantInput = isMakingARestaurantInput.toLowerCase();

        switch (isMakingARestaurantInput) {
            case "yes", "y" -> isMakingNewRestaurant = true;
            case "no", "n" -> isMakingNewRestaurant = false;
            default -> {
                isMakingNewRestaurant = false;
                System.out.println("Your response could not be identified.");
            }
        }

        while (isMakingNewRestaurant) {
            System.out.println("You are now creating a new restaurant.");

            System.out.println("What is the name of your new restaurant? Enter restaurant name: ");
            String newRestaurantName = scannerUserInput.nextLine();
            System.out.println("Creating the restaurant called " + newRestaurantName);

            System.out.println("Enter restaurant location: ");
            String newRestaurantLocation = scannerUserInput.nextLine();
            System.out.println("Restaurant Location: " + newRestaurantLocation);

            System.out.println("Enter restaurant phone: ");
            String newRestaurantPhone = scannerUserInput.nextLine();
            System.out.println("Restaurant Phone Number: " + newRestaurantPhone);

            System.out.println("Now let's add items to " + newRestaurantName + "'s menu.");
            System.out.println("How many menu items would you like to add to " + newRestaurantName + "'s menu? Enter an integer greater than 0 :");
            String menuItemCountString = scannerUserInput.nextLine();
            int menuItemCount = Integer.parseInt(menuItemCountString);
            if (menuItemCount <= 0) {
                menuItemCount = 1;
                System.out.println("You must add at least 1 item to your menu");
            }
            System.out.println("You are adding " + menuItemCount + " items to the menu for " + newRestaurantName);
            ArrayList<MenuItem> newRestaurantMenu = new ArrayList<>();
            for (int k=1; k<= menuItemCount; k++) {
                System.out.println("Enter menu item #" + k + "'s name. (e.g. Chicken Curry): ");
                String mealName = scannerUserInput.nextLine();
                System.out.println("Added " + mealName);

                System.out.println("Enter the price of " + mealName + " without any currency symbols. (e.g. 24.95): ");
                String mealPriceString = scannerUserInput.nextLine();
                double mealPrice = Double.parseDouble(mealPriceString);
                MenuItem newMenuItem = new MenuItem(mealName,mealPrice);
                newRestaurantMenu.add(newMenuItem);
            }
            Restaurant newRestaurant = new Restaurant(newRestaurantName, newRestaurantLocation, newRestaurantPhone, newRestaurantMenu);
            restaurantsList.add(newRestaurant);
            System.out.println("You've successfully created a new restaurant.");
            newRestaurant.printRestaurantSummary();
            System.out.println("****************************************");

            System.out.println("You have created" + restaurantsList.size() + " restaurant(s). Would you like to make another restaurant? Enter 'yes' or 'no' ");
            isMakingARestaurantInput = scannerUserInput.nextLine();
            isMakingARestaurantInput = isMakingARestaurantInput.toLowerCase();

            switch (isMakingARestaurantInput) {
                case "yes", "y" -> isMakingNewRestaurant = true;
                case "no", "n" -> isMakingNewRestaurant = false;
                default -> {
                    isMakingNewRestaurant = false;
                    System.out.println("Your response could not be identified.");
                }
            }
        }

    }
}




