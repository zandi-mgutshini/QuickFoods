public record OrderItem(int orderCount, MenuItem orderItem ) {

    public String printOrderItem() {
        return "" + orderCount + " x " + orderItem.mealName() + " (R" + orderItem.mealPrice() + ")";
    }
}
