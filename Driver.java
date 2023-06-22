public class Driver {
    private String driverName;
    private String driverLocation;
    private int driverLoad;

    public Driver(String driverName, String driverLocation, int driverLoad) {
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.driverLoad = driverLoad;
    }

    public Driver() {
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
}
