public class Customer {
    private final String customerName;
    private final String customerEmail;
    private final String customerPhone;
    private final String customerLocation;
    private final String customerAddress;

    public Customer(String customerName, String customerEmail, String customerPhone, String customerLocation, String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerLocation = customerLocation;
        this.customerAddress = customerAddress;
    }

    public Customer() {
        this.customerName = "customerName";
        this.customerEmail = "customerEmail@admin.com";
        this.customerPhone = "customerPhone";
        this.customerLocation = "customerLocation";
        this.customerAddress = "customerAddress";
    }

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


    public void printCustomerSummary() {
          System.out.println("Customer: " + customerName + '\n' +
                "Email: " + customerEmail + '\n' +
                "Phone Number: " + customerPhone + '\n' +
                "Location: " + customerLocation + '\n' +
                "Address: " + customerAddress);
    }
}
