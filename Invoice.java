import java.util.ArrayList;
import java.util.UUID;

public class Invoice {
    private final String invoiceNumber;
    private Customer invoiceCustomer;
    private Restaurant invoiceRestaurant;
    private ArrayList <MenuItem> invoiceItemsArray;
    private ArrayList<Integer> invoiceQuantitiesArray;
    private DeliveryDriver invoiceDriver;
    private String invoiceSpecialInstructions;

    // Constructor used in createInvoice() method in Main
    public Invoice() {
        this.invoiceNumber = (UUID.randomUUID()).toString();
        this.invoiceCustomer = new Customer();
        this.invoiceRestaurant = new Restaurant();
        this.invoiceItemsArray = new ArrayList<>();
        this.invoiceQuantitiesArray = new ArrayList<>();
        this.invoiceDriver = new DeliveryDriver();
        this.invoiceSpecialInstructions = "N/A";
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
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

    public void setInvoiceItemsArray(ArrayList<MenuItem> invoiceItemsArray) {
        this.invoiceItemsArray = invoiceItemsArray;
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

    public void setInvoiceSpecialInstructions(String invoiceSpecialInstructions) {
        this.invoiceSpecialInstructions = invoiceSpecialInstructions;
    }

    // Getting the invoice total for toString() method
    private double getInvoiceTotal() {
        double invoiceTotal = 0d;
        for(int i =0; i<invoiceQuantitiesArray.size(); i++) {
            invoiceTotal += (invoiceItemsArray.get(i).mealPrice()) * (invoiceQuantitiesArray.get(i)) ;
        }
        return invoiceTotal;
    }

    // Creating invoice items list for toString() Method
    private String invoiceItemQuantityPriceString() {
        StringBuilder invoiceItemQuantityPriceString = new StringBuilder();
        for (int i = 0; i < this.invoiceItemsArray.size(); i++) {
            invoiceItemQuantityPriceString.append(this.invoiceQuantitiesArray.get(i)).append(" x ").append(invoiceItemsArray.get(i).getMenuItemString()).append('\n');
        }
        return invoiceItemQuantityPriceString.toString();
    }

    @Override
    // Method to create the invoice string for invoice.txt file
    public String toString() {
        return "Order No: " + this.invoiceNumber + "\n" +
                "Customer: " + this.invoiceCustomer.getCustomerName() + "\n" +
                "Email: " + this.invoiceCustomer.getCustomerEmail() + "\n" +
                "Cell: " + this.invoiceCustomer.getCustomerPhone() + "\n" +
                "Location: " + this.invoiceCustomer.getCustomerLocation() + "\n" +
                "You have ordered the following from " + this.invoiceRestaurant.getRestaurantName() + " in " + invoiceRestaurant.getRestaurantLocation() + ": \n" +
                this.invoiceItemQuantityPriceString() +
                "Special instructions: " + this.invoiceSpecialInstructions + '\n' +
                "Total: R" + String.format("%.2f", this.getInvoiceTotal())  + '\n' +
                this.invoiceDriver.getDriverName() + " is the nearest to the restaurant, so they will be delivering your order to you at:  \n " + this.invoiceCustomer.getCustomerAddress() + "\n" +
                "If you need to contact the restaurant, their number is " + this.invoiceRestaurant.getRestaurantPhone() + ". "
                ;
    }

}
