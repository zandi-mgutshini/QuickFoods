import java.util.ArrayList;

public class Restaurant {
    private String restaurantName;
    private String restaurantLocation;
    private String restaurantPhone;
    private ArrayList <MenuItem> restaurantMenu;

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
    // Getters
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

    // Setters
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public void setRestaurantMenu(ArrayList<MenuItem> restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public void addRestaurantMealItem(String mealName, double mealPrice) {
        MenuItem newMeal = new MenuItem(mealName, mealPrice);
        this.restaurantMenu.add(newMeal);
    }
    public void addRestaurantMenuItem(MenuItem newMeal) {
        this.restaurantMenu.add(newMeal);
    }

    public void printRestaurantMenu() {
        for (MenuItem item: this.restaurantMenu) {
            System.out.println(item.mealName() + ", R" + item.mealPrice());
        }
    }

    public void printRestaurantSummary() {
        System.out.println("Restaurant: " + restaurantName + "\n" +
                            "Restaurant Location: " + restaurantLocation + "\n" +
                            "Restaurant Phone Number: " + restaurantPhone + "\n");

        System.out.println("Menu for " + restaurantName + " in " + restaurantLocation + ":");
        for (MenuItem item: this.restaurantMenu) {
            System.out.println(item.mealName() + ", R" + item.mealPrice());
        }
    }
}
