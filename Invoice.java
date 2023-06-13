import java.util.ArrayList;

public class Invoice {
    private int orderNumber;
    private Customer orderCustomer;
    private Restaurant orderRestaurant;
    private ArrayList <OrderItem> orderItemArrayList;

    public Invoice(int orderNumber, Customer orderCustomer, Restaurant orderRestaurant, ArrayList<OrderItem> orderItemArrayList) {
        this.orderNumber = orderNumber;
        this.orderCustomer = orderCustomer;
        this.orderRestaurant = orderRestaurant;
        this.orderItemArrayList = orderItemArrayList;
    }
}
