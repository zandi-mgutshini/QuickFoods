public class Customer {
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerLocation;
    private String customerAddress;

    public Customer(String customerName, String customerEmail, String customerPhone, String customerLocation, String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerLocation = customerLocation;
        this.customerAddress = customerAddress;
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

    // Used to generate the customer details invoice header
    public String customerSummaryString() {
        return  "Customer: " + customerName + '\n' +
                "Email: " + customerEmail + '\n' +
                "Phone Number: " + customerPhone + '\n' +
                "Location: " + customerLocation + '\n' ;
    }

    public void printCustomerSummary() {
          System.out.println("Customer: " + customerName + '\n' +
                "Email: " + customerEmail + '\n' +
                "Phone Number: " + customerPhone + '\n' +
                "Location: " + customerLocation + '\n' +
                "Address: " + customerAddress + '\n');
    }
}
