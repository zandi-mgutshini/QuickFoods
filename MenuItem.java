public record MenuItem(String mealName, double mealPrice) {
    public String getMenuItemString() {
        return this.mealName + " (R" + String.format( "%.2f", this.mealPrice) + ")";
    }
}
