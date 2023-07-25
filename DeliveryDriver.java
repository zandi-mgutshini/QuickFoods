public class DeliveryDriver {
    private String driverName;
    private String driverLocation;
    private int driverLoad;

    DeliveryDriver(String driverName, String driverLocation, int driverLoad) {
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.driverLoad = driverLoad;
    }

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

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public int getDriverLoad() {
        return driverLoad;
    }

    public void setDriverLoad(int driverLoad) {
        this.driverLoad = driverLoad;
    }

    @Override
    public String toString() {
        return "Driver name: " + driverName + ", " +
                "Driver Location: " + driverLocation + ", " +
                "Driver Load: " + driverLoad + '\n';
    }
}
