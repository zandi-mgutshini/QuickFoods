import java.util.ArrayList;

public class Restaurant {
    private String restaurantName;
    private String restaurantLocation;
    private String restaurantPhone;
    private final ArrayList <MenuItem> restaurantMenu;

    public Restaurant(String restaurantName, String restaurantLocation, String restaurantPhone, ArrayList<MenuItem> restaurantMenu) {
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantPhone = restaurantPhone;
        this.restaurantMenu = restaurantMenu;
    }

    public Restaurant() {
        this.restaurantName = "Unknown";
        this.restaurantLocation = "Unknown";
        this.restaurantPhone = "000000000";
        this.restaurantMenu = new ArrayList<>();
    }
    // Getters used in Invoice class toString() overidden method
    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public ArrayList<MenuItem> getRestaurantMenu() {
        return restaurantMenu;
    }

    // Setters used in createRestaurant() method in Main
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }
    // Used in Main Method restaurantMaker() to create menu for user generated restaurant
    public void addRestaurantMealItem(String mealName, double mealPrice) {
        MenuItem newMeal = new MenuItem(mealName, mealPrice);
        this.restaurantMenu.add(newMeal);
    }

    // Prints the restaurant menu to console in Main method createInvoice()
    public void printRestaurantMenu() {
        System.out.println("Menu for " + this.restaurantName + ":");
        for (int i = 0; i < this.restaurantMenu.size(); i++) {
            int j = i+1;
            System.out.println( j + ". " + this.restaurantMenu.get(i).getMenuItemString());
        }
    }

    // Prints new restaurant instance's summary in Main method called createRestaurant()
    public void printRestaurantSummary() {
        System.out.println("Restaurant: " + restaurantName + "\n" +
                            "Restaurant Location: " + restaurantLocation + "\n" +
                            "Restaurant Phone Number: " + restaurantPhone);
        System.out.println("Menu: ");
        for (MenuItem item: this.restaurantMenu) {
            System.out.println(item.getMenuItemString());
        }
    }
}
