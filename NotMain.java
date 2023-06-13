import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NotMain {
    public static void main(String[] args) {
        // Generating restaurants from text files
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

        // Reading the customer file to create customers
        int i = 0;
        ArrayList<Customer> customerArrayList= new ArrayList<>();
        try {
            File customersText = new File("/Users/zmgutshini/IdeaProjects/CapstoneProject/src/customers.txt");
            Scanner customerScanner = new Scanner(customersText);
            while (customerScanner.hasNext()) {
                System.out.println("Customer " + i);
                String nextLine = customerScanner.nextLine();
//                System.out.println(nextLine);
                String[] nextLineArray = nextLine.split(",");
//                nextLineArray.add();
                Customer generatedCustomer= new Customer(nextLineArray[0],nextLineArray[1],nextLineArray[2],nextLineArray[3], nextLineArray[4]);
                customerArrayList.add(generatedCustomer);
                generatedCustomer.printCustomerSummary();
                i++;
            }
            customerScanner.close();
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        System.out.println(customerArrayList.get(0).customerSummaryString());

        // Testing customer methods
        Customer testCustomer = new Customer("John Doe", "johndoe@gmail.com", "012 345 6789", "Cape Town", "12 Cherry Road \nGardens");
        System.out.println(testCustomer.customerSummaryString());
        System.out.println(testCustomer.getCustomerAddress());
        // Testing Menu Item and Order item
        MenuItem testMenuItem = new MenuItem("Chicken Schnitzel", 95.99);
        OrderItem testOrderItem = new OrderItem(2, testMenuItem);
        System.out.println(testOrderItem.printOrderItem());
        System.out.println("____________");
        // Testing Restaurant
        Restaurant testRestaurant = new Restaurant();
        testRestaurant.setRestaurantName("Aeosop's Eatery");
        testRestaurant.setRestaurantLocation("Gardens");
        testRestaurant.setRestaurantPhone("021 123 4567");
        testRestaurant.addRestaurantMealItem("Cheese Burger", 34.99);
        testRestaurant.addRestaurantMealItem("Chicken Strips", 80.00);
        testRestaurant.addRestaurantMealItem("Pepperoni Pizza", 120.00);
        testRestaurant.addRestaurantMealItem("Greek Salad", 95.00);
        testRestaurant.addRestaurantMealItem("Hawaiian Pizza", 110.00);
        testRestaurant.addRestaurantMealItem("Small Fries", 39.99);
        testRestaurant.addRestaurantMenuItem(testMenuItem);

        testRestaurant.printRestaurantMenu();

        testRestaurant.printRestaurantSummary();
    }
    public static Restaurant restaurantMaker(String pathname) {
        Restaurant generatedRestaurant = new Restaurant();
        // Reading poem.txt line by line and appending it to myString
        // Note to users: ensure poem.txt file path is correct on your system
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
            generatedRestaurant.printRestaurantSummary();
            System.out.println();
            return generatedRestaurant;
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            return generatedRestaurant;
        }

    }

//        try {
//            File x = new File(pathname);
//            Scanner sc = new Scanner(x);
//            generatedRestaurant.setRestaurantName(sc.nextLine());
//            generatedRestaurant.setRestaurantLocation(sc.nextLine());
//            generatedRestaurant.setRestaurantPhone(sc.nextLine());
//            while (sc.hasNext()) {
//                String nextLine = sc.nextLine();
//                String[] nextLineArray = nextLine.split(",");
//                String mealName = nextLineArray[0];
//                double mealPrice = Double.parseDouble(nextLineArray[1]);
//                generatedRestaurant.addRestaurantMealItem(mealName, mealPrice);
//            }
//            sc.close();
//            generatedRestaurant.printRestaurantSummary();
//            System.out.println();
//            return generatedRestaurant;
//        } catch (FileNotFoundException e) {
//            System.out.println("Error");
//            return generatedRestaurant;
//        }


}




