import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
// Note to self: Add functionality to ensure user input is not an empty string especially for createRestaurant & createCustomer name location, phone and address
class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customersArrayList = new ArrayList<>();
        ArrayList<Restaurant> restaurantsArrayList = new ArrayList<>();
        ArrayList<DeliveryDriver> deliveryDriversArrayList = new ArrayList<>();
        ArrayList<Invoice> invoicesArrayList = new ArrayList<>();
        // Generating restaurants from 12 text files bennys.txt, braairepublic.txt, coalgrill.txt, fishermanscatch.txt, hudsons.txt, jerrys.txt, lapizzeria.txt, mamaskitchen.txt, potchefstroomdelights.txt, spiceofindia.txt, springboksteakhouse.txt, sushidelight.txt
        Restaurant restaurant1 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/bennys.txt");
        Restaurant restaurant2 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/braairepublic.txt");
        Restaurant restaurant3 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/coalgrill.txt");
        Restaurant restaurant4 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/fishermanscatch.txt");
        Restaurant restaurant5 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/hudsons.txt");
        Restaurant restaurant6 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/jerrys.txt");
        Restaurant restaurant7 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/lapizzeria.txt");
        Restaurant restaurant8 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/mamaskitchen.txt");
        Restaurant restaurant9 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/potchefstroomdelights.txt");
        Restaurant restaurant10 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/spiceofindia.txt");
        Restaurant restaurant11 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/springboksteakhouse.txt");
        Restaurant restaurant12 = restaurantMaker("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/restaurants/sushidelight.txt");
        // Populating restaurantsArrayList with restaurants 1-12
        restaurantsArrayList.add(restaurant1);
        restaurantsArrayList.add(restaurant2);
        restaurantsArrayList.add(restaurant3);
        restaurantsArrayList.add(restaurant4);
        restaurantsArrayList.add(restaurant5);
        restaurantsArrayList.add(restaurant6);
        restaurantsArrayList.add(restaurant7);
        restaurantsArrayList.add(restaurant8);
        restaurantsArrayList.add(restaurant9);
        restaurantsArrayList.add(restaurant10);
        restaurantsArrayList.add(restaurant11);
        restaurantsArrayList.add(restaurant12);

        // Populating the customersArrayList with Customer instances from file customers.txt
        int i = 0;
        try {
            File customersText = new File("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/customers.txt");
            Scanner customerScanner = new Scanner(customersText);
            while (customerScanner.hasNext()) {
//                System.out.println("Customer " + i+1);
                String nextLine = customerScanner.nextLine();
//                System.out.println(nextLine);
                String[] nextLineArray = nextLine.split(", ");
//                nextLineArray.add();
                Customer generatedCustomer= new Customer(nextLineArray[0],nextLineArray[1],nextLineArray[2],nextLineArray[3], nextLineArray[4]);
                // Populating customersArrayList
                customersArrayList.add(generatedCustomer);
//                generatedCustomer.printCustomerSummary();
                i++;
            }
            customerScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Populating the driversArrayList with DeliveryDriver instances from file drivers.txt
        int k = 0;
        try {
            File deliveryDriversText = new File("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/drivers.txt");
            Scanner driverScanner = new Scanner(deliveryDriversText);
            while (driverScanner.hasNext()) {
//                System.out.println("Driver " + k+1);
                String nextLine = driverScanner.nextLine();
                DeliveryDriver generatedDriver= new DeliveryDriver(nextLine);
                // Populating customersArrayList
                deliveryDriversArrayList.add(generatedDriver);
//                System.out.println(generatedDriver);
                k++;
            }
            driverScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Scanner userInputScanner = new Scanner(System.in);

//        Restaurant testingRestaurant = createRestaurant(userInputScanner);
//        restaurantsArrayList.add(testingRestaurant);
//        Customer testingCustomer = createCustomer(userInputScanner);
//        customersArrayList.add(testingCustomer);
        Invoice newInvoice = createInvoice(userInputScanner, customersArrayList, restaurantsArrayList);
        invoicesArrayList.add(newInvoice);
        System.out.println();
        System.out.println(newInvoice);





        userInputScanner.close();

//        Scanner scannerUserInput = new Scanner(System.in);
//        // Enquire with user about making a new restaurant
//        boolean isMakingNewRestaurant;
//        System.out.println("Would you like to make a new restaurant? Enter 'yes' or 'no' ");
//        String isMakingARestaurantInput = scannerUserInput.nextLine();
//        isMakingARestaurantInput = isMakingARestaurantInput.toLowerCase();

//        switch (isMakingARestaurantInput) {
//            case "yes", "y" -> isMakingNewRestaurant = true;
//            case "no", "n" -> isMakingNewRestaurant = false;
//            default -> {
//                isMakingNewRestaurant = false;
//                System.out.println("Your response could not be identified. Exiting...");
//            }
//        }
//        System.out.println();
//        while (isMakingNewRestaurant) {
//                Restaurant newRestaurant = createRestaurant();
//                restaurantsList.add(newRestaurant);
//                System.out.println("Would you like to make a new restaurant? Enter 'yes' or 'no' ");
//                isMakingARestaurantInput = scannerUserInput.nextLine();
//                isMakingARestaurantInput = isMakingARestaurantInput.toLowerCase();
//                System.out.println("You have created" + restaurantsList.size() + " restaurant(s). Would you like to make another restaurant? Enter 'yes' or 'no' ");
//                switch (isMakingARestaurantInput) {
//                    case "yes", "y" -> System.out.println(" ");
//                    case "no", "n" -> isMakingNewRestaurant = false;
//                    default -> {
//                        isMakingNewRestaurant = false;
//                        System.out.println("Your response could not be recognised. You are not creating a new restaurant.");
//                    }
//                }
//        }
        // User decision to create an order. If isOrdering is false, subsequent while loop block is not executed
//        boolean isOrdering;
//        System.out.println("Would you like to create a new order? Enter 'yes' or 'no' ");
//        String isOrderingInput= scannerUserInput.nextLine().toLowerCase();
//        switch (isOrderingInput) {
//            case "yes", "y" -> isOrdering = true;
//            case "no", "n" -> isOrdering = false;
//            default -> {
//                isOrdering = false;
//                System.out.println("Your response could not be recognised. You are not creating a new order.");
//            }
//        }

        /* While loop to create an Invoice to be stored in Invoice ArrayList
        * From the customer array list, the user selects the customer that is ordering.
        * From the restaurants array list, the user selects the restaurant they would like to order from
        * Using the aforementioned restaurant's menu, the user inputs the menu item and the quantity they would like to order
        * The order items are added to an order item array list. The order number, customer instance, restaurant instance and order item array list
        * are used as parameters to create an Invoice instance. This invoice instance is then added to the invoice array list.
        * The value of isOrdering is updated at the end of the loop allowing the user to create another order or exit the ordering process */
//        while (isOrdering) {
//            System.out.println("Which customer would you like to create an order for?");
//            printCustomersList(customersList);
//            System.out.println("Enter the customer number for the customer you would like to create an order for: ");
//            String customerNumberInput = scannerUserInput.nextLine();
//            int customerNumber;
//            try {
//                customerNumber = Integer.parseInt(customerNumberInput);
//                if (customerNumber <= 0 || customerNumber > customersList.size()) {
//                    System.out.println("The customer number you entered is not valid. The customer number has been set to the most recent customer on record.");
//                    customerNumber = customersList.size();
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("You did not enter a valid integer customer number. The customer number has been set to the most recent customer on record.");
//                customerNumber = customersList.size();
//            }
//            // Converting customer number to customer index by subtracting 1.
//            int customerIndex = customerNumber - 1;
//            Customer invoiceCustomer = customersList.get(customerIndex);
//            System.out.println("You have selected " + invoiceCustomer.getCustomerName() + " as the customer for this order.");
//
//            // Selecting the restaurant to order from
//            int restaurantNumber;
//            System.out.println();
//            System.out.println("Which restaurant would you like to order from? ");
//            printRestaurantsList(restaurantsList);
//            System.out.println("Enter the restaurant number for the restaurant you would like to order from: ");
//            String restaurantNumberInput = scannerUserInput.nextLine();
//            try {
//                restaurantNumber = Integer.parseInt(restaurantNumberInput);
//                if (restaurantNumber <= 0 || restaurantNumber > restaurantsList.size()) {
//                    System.out.println("The customer number you entered is not valid. The restaurant number has been set to the most recent restaurant on record.");
//                    restaurantNumber = restaurantsList.size();
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("You did not enter a valid integer restaurant number. The restaurant number has been set to the most recent restaurant on record.");
//                restaurantNumber = restaurantsList.size();
//            }
//            // Converting restaurant number to restaurant index
//            int restaurantIndex = restaurantNumber - 1;
//            Restaurant invoiceRestaurant = restaurantsList.get(restaurantIndex);
//
//            System.out.println("You have selected " + invoiceRestaurant.getRestaurantName() + ".");
//            invoiceRestaurant.printRestaurantMenu();
//
//            // Collecting Customer Order information
//            ArrayList<InvoiceItem> invoiceItemArrayList = new ArrayList<>();
//            while(true) {
//                invoiceRestaurant.printRestaurantMenu();
//                System.out.println("Enter the menu item number for the item you would like to order (Enter 0 to Exit):");
//                int menuItemNumber;
//                try {
//                    menuItemNumber = scannerUserInput.nextInt();
//                } catch (NumberFormatException e) {
//                    System.out.println("You did not input a valid integer.");
//                    break;
//                }
//
//                if(menuItemNumber == 0) {
//                    break;
//                }
//                if(menuItemNumber < 1 || menuItemNumber > invoiceRestaurant.getRestaurantMenu().size()) {
//                    System.out.println("You entered an invalid menu item number. Please try again.");
//                    continue;
//                }
//                MenuItem selectedItem = invoiceRestaurant.getRestaurantMenu().get(menuItemNumber - 1);
//                System.out.print("Enter the quantity: ");
//                int selectedItemQuantity;
//                 try {
//                     selectedItemQuantity = scannerUserInput.nextInt();
//                } catch (NumberFormatException e) {
//                    System.out.println("You did not input a valid integer. The quantity has been set to 1.");
//                     selectedItemQuantity = 1;
//                }
//                 if (selectedItemQuantity < 0) {
//                     selectedItemQuantity = 0;
//                 }
//                 InvoiceItem selectedInvoiceItem = new InvoiceItem(selectedItemQuantity, selectedItem);
//                 invoiceItemArrayList.add(selectedInvoiceItem);
//
//            }
//
//
//        }

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
        // User input to create a customer instance
        System.out.println("Enter Customer Name and Surname: ");
        String customerName = scannerCustomerUserInput.nextLine();
        //System.out.println("Hello, " + customerName + "!");
        //System.out.println("Name: " + customerName);

        System.out.println("Enter email address: ");
        String customerEmail = scannerCustomerUserInput.nextLine();
        //System.out.println("Email address: " + customerEmail );

        System.out.println("Enter phone number: ");
        String customerPhone = scannerCustomerUserInput.nextLine();
        //System.out.println("Phone number: " + customerPhone);

        System.out.println("Enter city: ");
        String customerLocation = scannerCustomerUserInput.nextLine();
        //System.out.println("Location: " + customerLocation );

        System.out.println("Enter street address: ");
        String customerAddress = scannerCustomerUserInput.nextLine();
        //System.out.println("Street address: " + customerAddress);

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
     * A driver is selected from deliveryDriversArrayList
     * a new invoice item is populated with customer, restaurant, order number, and driver*/
    public static Invoice createInvoice(Scanner scannerInvoiceUserInput, ArrayList<Customer> customersArrayList, ArrayList<Restaurant> restaurantArrayList) {
        Invoice newInvoice = new Invoice();

        System.out.println("Which customer would you like to create an order for?");
        printCustomersList(customersArrayList);
        System.out.println("Enter the customer number for the customer you would like to create an order for: ");
        String customerNumberInput = scannerInvoiceUserInput.nextLine();
        int customerNumber;
        try {
            customerNumber = Integer.parseInt(customerNumberInput);
            if (customerNumber <= 0 || customerNumber > customersArrayList.size()) {
                System.out.println("The customer number you entered is not valid. The customer number has been set to the most recent customer on record.");
                customerNumber = customersArrayList.size();
            }
            } catch (NumberFormatException e) {
                System.out.println("You did not enter a valid integer customer number. The customer number has been set to the most recent customer on record.");
                customerNumber = customersArrayList.size();
            }

        //Converting customer number to customer index by subtracting 1.
        int customerIndex = customerNumber - 1;

        //Setting customer for newInvoice
        Customer invoiceCustomer = customersArrayList.get(customerIndex);
        newInvoice.setInvoiceCustomer(invoiceCustomer);
        System.out.println("Ordering for " + invoiceCustomer.getCustomerName() + "... ");

        //Selecting newInvoice restaurant for newInvoice
        int restaurantNumber;
        System.out.println();
        System.out.println("Which restaurant would you like to order from? ");
        printRestaurantsList(restaurantArrayList);
        System.out.println("Enter the restaurant number for the restaurant you would like to order from: ");
        String restaurantNumberInput = scannerInvoiceUserInput.nextLine();
        try {
            restaurantNumber = Integer.parseInt(restaurantNumberInput);
            if (restaurantNumber <= 0 || restaurantNumber > restaurantArrayList.size()) {
                System.out.println("The restaurant number you entered is not valid. The restaurant number has been set to the most recent restaurant on record.");
                restaurantNumber = restaurantArrayList.size();
            }
        } catch (NumberFormatException e) {
            System.out.println("You did not enter a valid integer restaurant number. The restaurant number has been set to the most recent restaurant on record.");
            restaurantNumber = restaurantArrayList.size();
        }
        // Set newInvoice restaurant
        int restaurantIndex = restaurantNumber - 1;
        Restaurant invoiceRestaurant = restaurantArrayList.get(restaurantIndex);
        newInvoice.setInvoiceRestaurant(invoiceRestaurant);
        newInvoice.setInvoiceRestaurantMenuArray(invoiceRestaurant.getRestaurantMenu());

        System.out.println("Ordering from " + invoiceRestaurant.getRestaurantName() + "...");

        ArrayList<MenuItem> invoiceItemsArray = new ArrayList<>();
        ArrayList<Integer> invoiceQuantitiesArray = new ArrayList<>();
        System.out.println("Enter order notes: ");
        String invoiceSpecialInstructions = scannerInvoiceUserInput.nextLine();
        if(invoiceSpecialInstructions==""){
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
            } catch (NumberFormatException e) {
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

        System.out.println("You have successfully created a new invoice with order number " + newInvoice.getInvoiceNumber());

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
    * Error handling: If a text file cannot be read, an error message is output in the console
    * Issues: relative path names are not functioning in Intelli J and eclipse IDEs so all path names in this document are absolute pathnames */
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
//            generatedRestaurant.printRestaurantSummary();
//            System.out.println();
            return generatedRestaurant;
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return generatedRestaurant;
        }

    }

}




