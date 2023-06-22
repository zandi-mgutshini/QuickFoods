public record InvoiceItem(int orderQuantity, MenuItem orderItem ) {

    public String getInvoiceItemString() {
        return "" + orderQuantity + " x " + orderItem.mealName() + " (R" + orderItem.mealPrice() + ")";
    }
}
