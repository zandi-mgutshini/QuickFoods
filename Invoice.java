import java.util.ArrayList;

public class Invoice {
    private int invoiceNumber;
    private Customer invoiceCustomer;
    private Restaurant invoiceRestaurant;
    private ArrayList <InvoiceItem> invoiceItemArrayList;
//    private Driver invoiceDriver;

    public Invoice(int invoiceNumber, Customer invoiceCustomer, Restaurant invoiceRestaurant, ArrayList<InvoiceItem> invoiceItemArrayList) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceCustomer = invoiceCustomer;
        this.invoiceRestaurant = invoiceRestaurant;
        this.invoiceItemArrayList = invoiceItemArrayList;
    }


}
