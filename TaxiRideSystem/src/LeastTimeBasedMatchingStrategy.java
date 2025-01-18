import java.util.Map;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
    private DriverManager driverManager = DriverManager.getInstance();

    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        Map<String, Driver> drivers = driverManager.driverMap;
        for (Driver driver : drivers.values()) {
            if (driver.isAvailable()) {
                driver.setAvailable(false); // Mark driver as unavailable
                return driver;
            }
        }
        throw new RuntimeException("No available drivers found");
    }
}