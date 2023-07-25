import java.util.ArrayList;
import java.util.UUID;

public class Invoice {
    private String invoiceNumber;
    private Customer invoiceCustomer;
    private Restaurant invoiceRestaurant;
    private ArrayList <MenuItem> invoiceRestaurantMenuArray;
    private ArrayList <MenuItem> invoiceItemsArray;
    private ArrayList<Integer> invoiceQuantitiesArray;
    private DeliveryDriver invoiceDriver;
    private String invoiceSpecialInstructions;

    public Invoice() {
        this.invoiceNumber = (UUID.randomUUID()).toString();
        this.invoiceCustomer = new Customer();
        this.invoiceRestaurant = new Restaurant();
        this.invoiceRestaurantMenuArray = new ArrayList<>();
        this.invoiceItemsArray = new ArrayList<>();
        this.invoiceQuantitiesArray = new ArrayList<>();
        this.invoiceDriver = new DeliveryDriver();
        this.invoiceSpecialInstructions = "N/A";
    }
    public Invoice(Customer invoiceCustomer, Restaurant invoiceRestaurant) {
        this.invoiceNumber = (UUID.randomUUID()).toString();
        this.invoiceCustomer = invoiceCustomer;
        this.invoiceRestaurant = invoiceRestaurant;
        this.invoiceRestaurantMenuArray = invoiceRestaurant.getRestaurantMenu();
        this.invoiceItemsArray = new ArrayList<>();
        this.invoiceQuantitiesArray = new ArrayList<>();
        this.invoiceDriver = new DeliveryDriver();
        this.invoiceSpecialInstructions = "N/A";
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Customer getInvoiceCustomer() {
        return invoiceCustomer;
    }

    public void setInvoiceCustomer(Customer invoiceCustomer) {
        this.invoiceCustomer = invoiceCustomer;
    }

    public Restaurant getInvoiceRestaurant() {
        return invoiceRestaurant;
    }

    public void setInvoiceRestaurant(Restaurant invoiceRestaurant) {
        this.invoiceRestaurant = invoiceRestaurant;
    }

    public ArrayList<MenuItem> getInvoiceRestaurantMenuArray() {
        return invoiceRestaurantMenuArray;
    }

    public void setInvoiceRestaurantMenuArray(ArrayList<MenuItem> invoiceRestaurantMenuArray) {
        this.invoiceRestaurantMenuArray = invoiceRestaurantMenuArray;
    }

    public ArrayList<MenuItem> getInvoiceItemsArray() {
        return invoiceItemsArray;
    }

    public void setInvoiceItemsArray(ArrayList<MenuItem> invoiceItemsArray) {
        this.invoiceItemsArray = invoiceItemsArray;
    }

    public ArrayList<Integer> getInvoiceQuantitiesArray() {
        return invoiceQuantitiesArray;
    }

    public void setInvoiceQuantitiesArray(ArrayList<Integer> invoiceQuantitiesArray) {
        this.invoiceQuantitiesArray = invoiceQuantitiesArray;
    }

    public DeliveryDriver getInvoiceDriver() {
        return invoiceDriver;
    }

    public void setInvoiceDriver(DeliveryDriver invoiceDriver) {
        this.invoiceDriver = invoiceDriver;
    }

    public String getInvoiceSpecialInstructions() {
        return invoiceSpecialInstructions;
    }

    public void setInvoiceSpecialInstructions(String invoiceSpecialInstructions) {
        this.invoiceSpecialInstructions = invoiceSpecialInstructions;
    }

    public double getInvoiceTotal() {
        double invoiceTotal = 0d;
        for(int i =0; i<invoiceQuantitiesArray.size(); i++) {
            invoiceTotal += (invoiceItemsArray.get(i).mealPrice()) * (invoiceQuantitiesArray.get(i)) ;
        }
        return invoiceTotal;
    }

    public String getInvoiceDriver(ArrayList<DeliveryDriver> deliveryDriverArrayList) {
        return "";
    }
    public String invoiceItemQuantityPriceString() {
        String invoiceItemQuantityPriceString = "";
        for (int i = 0; i < this.invoiceItemsArray.size(); i++) {
            invoiceItemQuantityPriceString += this.invoiceQuantitiesArray.get(i) + " x " + invoiceItemsArray.get(i).getMenuItemString() + '\n';
        }

        return invoiceItemQuantityPriceString;
    }

    @Override
    public String toString() {
        return "Order No:" + this.invoiceNumber + "\n" +
                "Customer: " + this.invoiceCustomer.getCustomerName() + "\n" +
                "Email: " + this.invoiceCustomer.getCustomerEmail() + "\n" +
                "Cell: " + this.invoiceCustomer.getCustomerPhone() + "\n" +
                "Location: " + this.invoiceCustomer.getCustomerLocation() + "\n" +
                "You have ordered the following from " + this.invoiceRestaurant.getRestaurantName() + " in " + invoiceRestaurant.getRestaurantLocation() + ": \n" +
                this.invoiceItemQuantityPriceString() +
                "Special instructions: " + this.invoiceSpecialInstructions + '\n' +
                "Total: R" + String.format("%.2f", this.getInvoiceTotal())  + '\n' +
                "Driver driver" + " is the nearest to the restaurant and so they will be delivering your order to you at:  \n " + this.invoiceCustomer.getCustomerAddress() + "\n" +
                "If you need to contact the restaurant, their number is " + this.invoiceRestaurant.getRestaurantPhone() + ". "
                ;
    }
}
