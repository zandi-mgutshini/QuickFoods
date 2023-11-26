import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

// Note to self: Add functionality to ensure user input is not an empty string especially for createRestaurant & createCustomer name location, phone and address
// Note to self: Write newCustomer and new restaurant text files.
class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customersArrayList = new ArrayList<>();
        ArrayList<String> restaurantsDirectoryFiles = new ArrayList<>();
        ArrayList<Restaurant> restaurantsArrayList = new ArrayList<>();
        ArrayList<DeliveryDriver> deliveryDriversArrayList = new ArrayList<>();
        ArrayList<Invoice> invoicesArrayList = new ArrayList<>();

        // Fetching each restaurant filepath from src/restaurants directory and adding them to restaurantsDirectoryFiles
        try (Stream<Path> filepath = Files.walk(Paths.get("src/restaurants"))) {
                filepath.forEach(x -> restaurantsDirectoryFiles.add(String.valueOf(x)));
        } catch (IOException e) {
            try {
                throw new IOException("Directory Not Present!");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        // Removing each restaurant filepath that does not contain restaurant text files from the restaurantsDirectoryFiles array list
        for(int i = 0; i < restaurantsDirectoryFiles.size(); i++){
            if(!restaurantsDirectoryFiles.get(i).contains(".txt") || restaurantsDirectoryFiles.get(i).equals("src/restaurants/restaurantTemplate.txt")){
                //noinspection SuspiciousListRemoveInLoop
                restaurantsDirectoryFiles.remove(i);
            }
        }
        // Populating restaurantsArrayList with files from src/restaurants with each restaurant filepath in restaurantsDirectoryFiles array list
        for (String filepath: restaurantsDirectoryFiles) {
            restaurantsArrayList.add(restaurantMaker(filepath));
        }

        // Populating the customersArrayList with Customer instances from file customers.txt
        try {
            File customersText = new File("src/customers.txt");
            Scanner customerScanner = new Scanner(customersText);
            while (customerScanner.hasNext()) {
                String nextLine = customerScanner.nextLine();
                String[] nextLineArray = nextLine.split(", ");
                Customer generatedCustomer= new Customer(nextLineArray[0],nextLineArray[1],nextLineArray[2],nextLineArray[3], nextLineArray[4]);
                customersArrayList.add(generatedCustomer);
            }
            customerScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Populating the driversArrayList with DeliveryDriver instances from file drivers.txt
        try {
            File deliveryDriversText = new File("src/drivers.txt");
            Scanner driverScanner = new Scanner(deliveryDriversText);
            while (driverScanner.hasNext()) {
                String nextLine = driverScanner.nextLine();
                DeliveryDriver generatedDriver= new DeliveryDriver(nextLine);
                deliveryDriversArrayList.add(generatedDriver);
            }
            driverScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("***********************************");
        System.out.println("***** WELCOME TO QUICK FOODS! *****");
        while(true) {
            System.out.println("***********************************");
            System.out.println("""
                    Options:\s
                     A. Create a new invoice\s
                     B. View Customer List\s
                     C. View Restaurant List\s
                     D. View Driver List\s
                     E. Exit Program\s""");
            System.out.println("Enter A, B, C, D or E:");
            String userChoice = userInputScanner.nextLine().toUpperCase();
            switch (userChoice) {
                case "A" -> {
                    Invoice newInvoice = createInvoice(userInputScanner, customersArrayList, restaurantsArrayList, deliveryDriversArrayList);
                    invoicesArrayList.add(newInvoice);
                    System.out.println();
                    if (newInvoice.getInvoiceDriver() == null) {
                        System.out.println("Order No: " + newInvoice.getInvoiceNumber() + " unsuccessful.");
                        System.out.println("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
                        try {
                            Formatter f = new Formatter("src/invoicesfolder/invoice_" + newInvoice.getInvoiceNumber() + ".txt");
                            f.format("%s", "Sorry! Our drivers are too far away from you to be able to deliver to your location.");
                            f.close();
                        } catch (Exception e) {
                            System.out.println("Error creating document");
                        }
                    } else {
                        System.out.println(newInvoice);
                        try {
                            Formatter f = new Formatter("src/invoicesfolder/invoice_" + newInvoice.getInvoiceNumber() + ".txt");
                            f.format("%s", newInvoice);
                            f.close();
                        } catch (Exception e) {
                            System.out.println("Error creating document");
                        }
                    }
                }
                case "B" -> printCustomersList(customersArrayList);
                case "C" -> printRestaurantsList(restaurantsArrayList);
                case "D" -> {
                    for (DeliveryDriver deliveryDriver : deliveryDriversArrayList) {
                        System.out.println(deliveryDriver);
                    }
                }
                case "E" -> {
                    System.out.println("Exiting the program.");
                    // Closing scanner
                    userInputScanner.close();
                    System.out.println("You've generated " + invoicesArrayList.size() + " invoices!");
                    // Exiting the program
                    System.exit(0);
                }
                default -> System.out.println("Your choice is not valid. Please enter A, B, C, D or E.");
            }
        }


    }
    /* createCustomer() Method Notes
     * Method that returns a customer to be appended manually to customersArrayList
     * Parameters are an existing scanner scannerCustomerUserInput
     * Using the scannerCustomerUserInput.nextLine() method the user inputs customer full name, email, telephone, location, and address.
     * The values of name, email, telephone, location, and address are parsed to a customer constructor creating a new customer instance
     * A new customer is returned.
     * Notes to self:
     * Functionality to ensure scannerCustomerUserInput.nextLine() does not return an empty String  needed*/
    private static Customer createCustomer(Scanner scannerCustomerUserInput) {
        // Note: Scanner is opened in main method
        System.out.println("Creating a new customer...");
        System.out.println("Enter Customer Name and Surname: ");
        String customerName = scannerCustomerUserInput.nextLine();


        System.out.println("Enter email address: ");
        String customerEmail = scannerCustomerUserInput.nextLine();

        System.out.println("Enter phone number: ");
        String customerPhone = scannerCustomerUserInput.nextLine();

        System.out.println("Enter city: ");
        String customerLocation = scannerCustomerUserInput.nextLine();

        System.out.println("Enter street address: ");
        String customerAddress = scannerCustomerUserInput.nextLine();

        // Creating customer called newCustomer
        Customer newCustomer = new Customer(customerName, customerEmail, customerPhone, customerLocation, customerAddress);
        System.out.println();
        System.out.println("****** You've successfully created a new customer. ******");
        newCustomer.printCustomerSummary();
        System.out.println("****************************************");

        // Note: scanner is closed in main method
        return newCustomer;
    }
    /* createRestaurant() Method Notes
     * Method that returns a restaurant to be appended manually to restaurantsArrayList
     * Parameters are an existing scanner scannerRestaurantUserInput
     * Using the scannerRestaurantUserInput.nextLine() method the user inputs restaurant name, location, and telephone.
     * The user inputs the menu length or count.
     * The menu length is used as the control variable for a for loop to add menu items to an array list that is the restaurant menu
     * A new restaurant is created using name, location, phone and the restaurant menu array list.
     * The new restaurant is returned
     * * Notes to self:
     * Functionality to ensure scannerRestaurantUserInput.nextLine() does not return an empty String  needed*/
    private static Restaurant createRestaurant(Scanner scannerRestaurantUserInput) {
        // Note: Scanner is opened in main
        System.out.println("Creating a new restaurant...");

        // User input to create a restaurant instance
        System.out.println("Enter Restaurant Name: ");
        String newRestaurantName = scannerRestaurantUserInput.nextLine();

        System.out.println("Enter Location: ");
        String newRestaurantLocation = scannerRestaurantUserInput.nextLine();
        //System.out.println("Restaurant Location: " + newRestaurantLocation);

        System.out.println("Enter Phone Number: ");
        String newRestaurantPhone = scannerRestaurantUserInput.nextLine();
        //System.out.println("Restaurant Phone Number: " + newRestaurantPhone);

        // Creating restaurant menu
        System.out.println("How many menu items would you like to add to " + newRestaurantName + "'s menu? Enter integer greater than 0 :");
        String menuItemCountString = scannerRestaurantUserInput.nextLine();
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

        System.out.println("Adding " + menuItemCount + " item(s) to " +  newRestaurantName + "'s menu... ");
        ArrayList<MenuItem> newRestaurantMenu = new ArrayList<>();
        for (int i=1; i<= menuItemCount; i++) {
            // For loop to add menu items to array list with exception handling for number format errors
            System.out.println("Enter menu item " + i + "'s name (e.g. Chicken Curry): ");
            String mealName = scannerRestaurantUserInput.nextLine();

            System.out.println("Enter price of " + mealName + " (e.g. 24.95): ");
            String mealPriceString = scannerRestaurantUserInput.nextLine();
            double mealPrice;
            try {
                mealPrice= Double.parseDouble(mealPriceString);
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid real number. The meal price has been set to the default of 100.00. ");
                mealPrice = 100.00;
            }
            MenuItem newMenuItem = new MenuItem(mealName,mealPrice);
            newRestaurantMenu.add(newMenuItem);
            System.out.println("Added " + newMenuItem.getMenuItemString());
        }
        Restaurant newRestaurant = new Restaurant(newRestaurantName, newRestaurantLocation, newRestaurantPhone, newRestaurantMenu);
        System.out.println();
        System.out.println("****** You've successfully created a new restaurant. ******");
        newRestaurant.printRestaurantSummary();
        System.out.println("****************************************");

        // Note: Scanner is closed in main
        return newRestaurant;
    }

    /* printCustomersList(...) method notes:
     * Prints a numbered list of the customers names and emails stored in customersArrayList
     * Used in createInvoice() for customer selection*/
    public static void printCustomersList(ArrayList<Customer> customersArrayList) {
        for(int i = 0; i<customersArrayList.size(); i++ ) {
            int j = i + 1;
            System.out.println( j + ". " + customersArrayList.get(i).getCustomerName() + " (" + customersArrayList.get(i).getCustomerEmail() + ")");
        }
    }
    /* printRestaurantsList(...) method notes:
    * Prints a numbered list of the restaurant names stored in restaurantsArrayList
    * Used in createInvoice() for restaurant selection*/
    public static void printRestaurantsList(ArrayList<Restaurant> restaurantsList) {
        for(int i = 0; i<restaurantsList.size(); i++ ) {
            int j = i + 1;
            System.out.println( j + ". " + restaurantsList.get(i).getRestaurantName() + " in " + restaurantsList.get(i).getRestaurantLocation());
        }
    }
    /* createInvoice() Method Notes
     * Method that returns an Invoice to be appended to invoicesArrayList
     * Parameters are the scanner scannerInvoiceUserInput, customersArrayList , restaurantsArrayList, and deliveryDriversArrayList
     * From the customersArrayList, the user selects the customer that is ordering.
     * From the restaurantsArrayList, the user selects the restaurant they would like to order from
     * Using the aforementioned restaurant's menu, the user inputs the menu item and the quantity they would like to order
     * The menu items are added to an array list and a quantity list.
     * An appropriate driver is selected from the populated deliveryDriversArrayList
     * a new invoice item is populated with customer, restaurant, order number, and driver
     * If no driver is in restaurant/customer location, driver is set to null
     * Recommendations: in future driver array list should increment driver load (i.e. driverLoad + 1) for each order assigned to the driver */
    public static Invoice createInvoice(Scanner scannerInvoiceUserInput, ArrayList<Customer> customersArrayList, ArrayList<Restaurant> restaurantArrayList, ArrayList<DeliveryDriver> deliveryDriversArrayList) {
        Invoice newInvoice = new Invoice();

        System.out.println("Which customer would you like to create an order for? (Enter 0 to create a new customer):");
        printCustomersList(customersArrayList);
        System.out.println("Enter the customer number for the customer you would like to create an order for (Enter 0 to create a new customer): ");
        String customerNumberInput = scannerInvoiceUserInput.nextLine();
        int customerNumber;
        try {
            customerNumber = Integer.parseInt(customerNumberInput);
            if (customerNumber < 0 || customerNumber > customersArrayList.size()) {
                System.out.println("The customer number you entered is not valid. The customer number has been set to the most recent customer on record.");
                customerNumber = customersArrayList.size();
            }
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid integer customer number. The customer number has been set to the most recent customer on record.");
                customerNumber = customersArrayList.size();
            }

        int customerIndex;
        Customer invoiceCustomer;
        if (customerNumber > 0){
            //Converting customer number to customer index by subtracting 1.
            customerIndex = customerNumber - 1;
            //Setting customer for newInvoice
            invoiceCustomer = customersArrayList.get(customerIndex);
            newInvoice.setInvoiceCustomer(invoiceCustomer);
        } else {
            invoiceCustomer = createCustomer(scannerInvoiceUserInput);
            customersArrayList.add(invoiceCustomer);
            newInvoice.setInvoiceCustomer(invoiceCustomer);
        }
        System.out.println("Ordering for " + newInvoice.getInvoiceCustomer().getCustomerName() + " in " + newInvoice.getInvoiceCustomer().getCustomerLocation() + " ... ");

        //Selecting newInvoice restaurant for newInvoice
        int restaurantNumber;
        System.out.println();
        System.out.println("Which restaurant would you like to order from? (Enter 0 to create a new restaurant):");
        printRestaurantsList(restaurantArrayList);
        System.out.println("Enter the restaurant number for the restaurant you would like to order from (Enter 0 to create a new restaurant): ");
        String restaurantNumberInput = scannerInvoiceUserInput.nextLine();
        try {
            restaurantNumber = Integer.parseInt(restaurantNumberInput);
            if (restaurantNumber < 0 || restaurantNumber > restaurantArrayList.size()) {
                System.out.println("The restaurant number you entered is not valid. The restaurant number has been set to the most recent restaurant on record.");
                restaurantNumber = restaurantArrayList.size();
            }
        } catch (NumberFormatException e) {
            System.out.println("You did not enter a valid integer restaurant number. The restaurant number has been set to the most recent restaurant on record.");
            restaurantNumber = restaurantArrayList.size();
        }
        // Set newInvoice restaurant
        Restaurant invoiceRestaurant;
        if (restaurantNumber > 0) {
            int restaurantIndex = restaurantNumber - 1;
            invoiceRestaurant = restaurantArrayList.get(restaurantIndex);

        } else {
            invoiceRestaurant = createRestaurant(scannerInvoiceUserInput);
        }
        newInvoice.setInvoiceRestaurant(invoiceRestaurant);
        System.out.println("Ordering from " + newInvoice.getInvoiceRestaurant().getRestaurantName() + "...");

        ArrayList<MenuItem> invoiceItemsArray = new ArrayList<>();
        ArrayList<Integer> invoiceQuantitiesArray = new ArrayList<>();
        System.out.println("Enter order notes: ");
        String invoiceSpecialInstructions = scannerInvoiceUserInput.nextLine();
        if(invoiceSpecialInstructions.equals("")){
            invoiceSpecialInstructions ="N/A";
        }
        newInvoice.setInvoiceSpecialInstructions(invoiceSpecialInstructions);

        while(true) {
            invoiceRestaurant.printRestaurantMenu();
            System.out.println("Enter the menu item number for the item you would like to order (Enter 0 to Exit):");
            int menuItemNumber;
            try {
                menuItemNumber = scannerInvoiceUserInput.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("You did not input a valid integer.");
                break;
            }

            if(menuItemNumber == 0) {
                System.out.println();
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
                selectedItemQuantity = scannerInvoiceUserInput.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You did not input a valid integer. The quantity has been set to 1.");
                selectedItemQuantity = 1;
            }
            if (selectedItemQuantity < 0) {
                selectedItemQuantity = 0;
            }
            invoiceItemsArray.add(selectedItem);
            invoiceQuantitiesArray.add(selectedItemQuantity);
        }
        // Set newInvoice Items and Quantities Array
        newInvoice.setInvoiceItemsArray(invoiceItemsArray);
        newInvoice.setInvoiceQuantitiesArray(invoiceQuantitiesArray);

        // Finding invoice driver
        String invoiceCustomerLocation = invoiceCustomer.getCustomerLocation();
        String invoiceRestaurantLocation = invoiceRestaurant.getRestaurantLocation();
        DeliveryDriver invoiceDeliveryDriver = null;
        int minimumLoad = Integer.MAX_VALUE;
        // Loop through driver array to find location match
        for(DeliveryDriver deliveryDriver: deliveryDriversArrayList){
            if(deliveryDriver.getDriverLocation().equals(invoiceRestaurantLocation) && deliveryDriver.getDriverLoad() < minimumLoad && deliveryDriver.getDriverLocation().equals(invoiceCustomerLocation)) {
                invoiceDeliveryDriver = deliveryDriver;
                minimumLoad = deliveryDriver.getDriverLoad();
            }
        }
        //If no matching driver is found driver remains set to null.
        newInvoice.setInvoiceDriver(invoiceDeliveryDriver);

        System.out.println("You have successfully created a new invoice with order number " + newInvoice.getInvoiceNumber());

        // To prevent exterior infinite loop from reading "0" as input in next run of the program
        System.out.println("""
                Options:\s
                 A. Create a new invoice\s
                 B. View Customer List\s
                 C. View Restaurant List\s
                 D. View Driver List\s
                 E. Exit Program\s""");
        System.out.println("Enter A, B, C, D or E:");
        //noinspection unused
        String userChoice = scannerInvoiceUserInput.nextLine().toUpperCase();

        return newInvoice;
    }

    /*restaurantMaker() Method Notes:
    * method returns a restaurant instance to be added manually to restaurantsArrayList
    * 1 parameter String that is the pathname for the text file associated with a restaurant's text file
    * Restaurant text file format is available to view in restaurantTemplate.txt
    * text file is read line by line until there are no more next lines in the text file
    * Lines 1, 2, and 3 are String restaurantName, String restaurantLocation, and String restaurantPhone respectively.
    * Lines 4 onwards are menu items in the following format: String mealName, double mealPrice
    *   For lines 4 onwards, each line is read as a string and then split into an array containing 2 strings at the ','.
    *   The first element in the aforementioned array is the meal name and the second is the meal price as a string
    *   The meal price is parsed from String to type double and the meal name and parsed meal price are passed as fields in a new MenuItem record i.e. MenuItem(String mealName, double mealPrice)
    *   All menu items created are added to an array list which is passed into the new restaurant object as the restaurantMenu
    * Error handling: If a text file cannot be read, an error message is output in the console */
    public static Restaurant restaurantMaker(String pathname) {
        Restaurant generatedRestaurant = new Restaurant();
        try {
            File x = new File(pathname);
            Scanner sc = new Scanner(x);
            generatedRestaurant.setRestaurantName(sc.nextLine());
            generatedRestaurant.setRestaurantLocation(sc.nextLine());
            generatedRestaurant.setRestaurantPhone(sc.nextLine());
            while (sc.hasNext()) {
                String nextLine = sc.nextLine();
                String[] nextLineArray = nextLine.split(",");
                String mealName = nextLineArray[0];
                double mealPrice = Double.parseDouble(nextLineArray[1]);
                generatedRestaurant.addRestaurantMealItem(mealName, mealPrice);
            }
            sc.close();
            return generatedRestaurant;
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return generatedRestaurant;
        }

    }

}




