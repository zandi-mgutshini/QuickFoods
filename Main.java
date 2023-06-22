import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customersList = new ArrayList<>();
        ArrayList<Restaurant> restaurantsList = new ArrayList<>();
        ArrayList<Driver> driversList = new ArrayList<>();
        ArrayList<Invoice> invoice = new ArrayList<>();

        // Opening the scanner for all user input
        Scanner scannerUserInput = new Scanner(System.in);
        // User input to create a customer instance
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
        // Creating customer called newCustomer
        Customer newCustomer = new Customer(customerName, customerEmail, customerPhone, customerLocation, customerAddress);
        newCustomer.printCustomerSummary();
        customersList.add(newCustomer);
        // Enquire with user about making a new restaurant
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
        System.out.println();
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
            int menuItemCount;
            try {
                menuItemCount = Integer.parseInt(menuItemCountString);
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid integer so the menu item count has been set to the default of 2 items.");
                menuItemCount = 2;
            }

            if (menuItemCount <= 0) {
                menuItemCount = 1;
                System.out.println("You must add at least 1 item to your menu");
            }
            System.out.println("You are adding " + menuItemCount + " items to the menu for " + newRestaurantName);
            ArrayList<MenuItem> newRestaurantMenu = new ArrayList<>();
            for (int i=1; i<= menuItemCount; i++) {
                System.out.println();
                System.out.println("Enter menu item #" + i + "'s name. (e.g. Chicken Curry): ");
                String mealName = scannerUserInput.nextLine();
                System.out.println("Added " + mealName);

                System.out.println("Enter the price of " + mealName + " without any currency symbols. (e.g. 24.95): ");
                String mealPriceString = scannerUserInput.nextLine();
                System.out.println();
                double mealPrice;
                try {
                     mealPrice= Double.parseDouble(mealPriceString);
                } catch (NumberFormatException e) {
                    System.out.println("You did not enter a valid real number. The meal price has been set to the default of 100.00. ");
                    mealPrice = 100.00;
                }

                MenuItem newMenuItem = new MenuItem(mealName,mealPrice);
                newRestaurantMenu.add(newMenuItem);
            }
            Restaurant newRestaurant = new Restaurant(newRestaurantName, newRestaurantLocation, newRestaurantPhone, newRestaurantMenu);
            restaurantsList.add(newRestaurant);
            System.out.println("You've successfully created a new restaurant.");
            newRestaurant.printRestaurantSummary();
            System.out.println();
            System.out.println("****************************************");
            System.out.println();
            System.out.println("You have created" + restaurantsList.size() + " restaurant(s). Would you like to make another restaurant? Enter 'yes' or 'no' ");
            isMakingARestaurantInput = scannerUserInput.nextLine();
            isMakingARestaurantInput = isMakingARestaurantInput.toLowerCase();

            switch (isMakingARestaurantInput) {
                case "yes", "y" -> System.out.println(" ");
                case "no", "n" -> isMakingNewRestaurant = false;
                default -> {
                    isMakingNewRestaurant = false;
                    System.out.println("Your response could not recognised identified. You are not creating a new restaurant.");
                }
            }
        }
        // User decision to create an order. If isOrdering is false, subsequent while loop block is not executed
        boolean isOrdering;
        System.out.println("Would you like to create a new order? Enter 'yes' or 'no' ");
        String isOrderingInput= scannerUserInput.nextLine().toLowerCase();
        switch (isOrderingInput) {
            case "yes", "y" -> isOrdering = true;
            case "no", "n" -> isOrdering = false;
            default -> {
                isOrdering = false;
                System.out.println("Your response could not be recognised. You are not creating a new order.");
            }
        }

        /* While loop to create an Invoice to be stored in Invoice ArrayList
        * From the customer array list, the user selects the customer that is ordering.
        * From the restaurants array list, the user selects the restaurant they would like to order from
        * Using the aforementioned restaurant's menu, the user inputs the menu item and the quantity they would like to order
        * The order items are added to an order item array list. The order number, customer instance, restaurant instance and order item array list
        * are used as parameters to create an Invoice instance. This invoice instance is then added to the invoice array list.
        * The value of isOrdering is updated at the end of the loop allowing the user to create another order or exit the ordering process */
        while (isOrdering) {
            System.out.println("Which customer would you like to create an order for?");
            printCustomersList(customersList);
            System.out.println("Enter the customer number for the customer you would like to create an order for: ");
            String customerNumberInput = scannerUserInput.nextLine();
            int customerNumber;
            try {
                customerNumber = Integer.parseInt(customerNumberInput);
                if (customerNumber <= 0 || customerNumber > customersList.size()) {
                    System.out.println("The customer number you entered is not valid. The customer number has been set to the most recent customer on record.");
                    customerNumber = customersList.size();
                }
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid integer customer number. The customer number has been set to the most recent customer on record.");
                customerNumber = customersList.size();
            }
            // Converting customer number to customer index by subtracting 1.
            int customerIndex = customerNumber - 1;
            Customer invoiceCustomer = customersList.get(customerIndex);
            System.out.println("You have selected " + invoiceCustomer.getCustomerName() + " as the customer for this order.");

            // Selecting the restaurant to order from
            int restaurantNumber;
            System.out.println();
            System.out.println("Which restaurant would you like to order from? ");
            printRestaurantsList(restaurantsList);
            System.out.println("Enter the restaurant number for the restaurant you would like to order from: ");
            String restaurantNumberInput = scannerUserInput.nextLine();
            try {
                restaurantNumber = Integer.parseInt(restaurantNumberInput);
                if (restaurantNumber <= 0 || restaurantNumber > restaurantsList.size()) {
                    System.out.println("The customer number you entered is not valid. The customer number has been set to the most recent restaurant on record.");
                    restaurantNumber = restaurantsList.size();
                }
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid integer restaurant number. The restaurant number has been set to the most recent restaurant on record.");
                restaurantNumber = restaurantsList.size();
            }
            // Converting restaurant number to restaurant index
            int restaurantIndex = restaurantNumber - 1;
            Restaurant invoiceRestaurant = restaurantsList.get(restaurantIndex);

            System.out.println("You have selected " + invoiceRestaurant.getRestaurantName() + ".");
            invoiceRestaurant.printRestaurantMenu();

            // Collecting Customer Order information
            ArrayList<InvoiceItem> invoiceItemArrayList = new ArrayList<>();
            while(true) {
                invoiceRestaurant.printRestaurantMenu();
                System.out.println("Enter the menu item number for the item you would like to order (Enter 0 to Exit):");
                int menuItemNumber;
                try {
                    menuItemNumber = scannerUserInput.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("You did not input a valid integer.");
                    break;
                }

                if(menuItemNumber == 0) {
                    break;
                }
                if(menuItemNumber < 1 || menuItemNumber > invoiceRestaurant.getRestaurantMenu().size()) {
                    System.out.println("You entered an invalid menu item number. Please try again.");
                    continue;
                }
                MenuItem selectedItem = invoiceRestaurant.getRestaurantMenu().get(menuItemNumber - 1);
                System.out.print("Enter the quantity: ");
                int selectedItemQuantity;
                 try {
                     selectedItemQuantity = scannerUserInput.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("You did not input a valid integer. The quantity has been set to 1.");
                     selectedItemQuantity = 1;
                }
                 if (selectedItemQuantity < 0) {
                     selectedItemQuantity = 0;
                 }
                 InvoiceItem selectedInvoiceItem = new InvoiceItem(selectedItemQuantity, selectedItem);
                 invoiceItemArrayList.add(selectedInvoiceItem);

            }






            //
        }

    }

    public static void printRestaurantsList(ArrayList<Restaurant> restaurantsList) {
        for(int i = 0; i<restaurantsList.size(); i++ ) {
            int j = i + 1;
            System.out.println( j + ". " + restaurantsList.get(i).getRestaurantName() + " in " + restaurantsList.get(i).getRestaurantLocation());
        }
    }

    public static void printCustomersList(ArrayList<Customer> customersList) {
        for(int i = 0; i<customersList.size(); i++ ) {
            int j = i + 1;
            System.out.println( j + ". " + customersList.get(i).getCustomerName() + " (" + customersList.get(i).getCustomerEmail() + ")");
        }
    }
}




