public class Customer {
    private final String customerName;
    private final String customerEmail;
    private final String customerPhone;
    private final String customerLocation;
    private final String customerAddress;

    // Used in createCustomer() method in main and to create customers from customers.txt
    public Customer(String customerName, String customerEmail, String customerPhone, String customerLocation, String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerLocation = customerLocation;
        this.customerAddress = customerAddress;
    }

    // Default customer constructor used in Invoice class's empty constructor.
    public Customer() {
        this.customerName = "customerName";
        this.customerEmail = "customerEmail@admin.com";
        this.customerPhone = "customerPhone";
        this.customerLocation = "customerLocation";
        this.customerAddress = "customerAddress";
    }
    // Getters used in Invoice class toString() overridden method and in createInvoice() method in main.
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }
    // Used to show new customer details in customer creation
    public void printCustomerSummary() {
          System.out.println("Customer: " + customerName + '\n' +
                "Email: " + customerEmail + '\n' +
                "Phone Number: " + customerPhone + '\n' +
                "Location: " + customerLocation + '\n' +
                "Address: " + customerAddress);
    }
}
