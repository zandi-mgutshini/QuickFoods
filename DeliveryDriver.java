public class DeliveryDriver {
    private final String driverName;
    private final String driverLocation;
    private  int driverLoad;

    DeliveryDriver(String commaSeparatedNameLocationLoadString) {
        String[] nameLocationLoadArray = commaSeparatedNameLocationLoadString.split(", ");
        this.driverName = nameLocationLoadArray[0];
        this.driverLocation = nameLocationLoadArray[1];
        try {
        this.driverLoad = Integer.parseInt(nameLocationLoadArray[2]);}
        catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            this.driverLoad = 0;
            System.out.println("Driver load has been set to 0 for " + this.driverName + " in " + this.driverLocation);
        }
    }

    DeliveryDriver() {
        this.driverName = "Generic Driver";
        this.driverLocation = "Unknown";
        this.driverLoad = 0;
    }
    public String getDriverName() {
        return driverName;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public int getDriverLoad() {
        return driverLoad;
    }

    @Override
    public String toString() {
        return " " + driverName + ", " +
                driverLocation + ", " +
                driverLoad ;
    }
}
