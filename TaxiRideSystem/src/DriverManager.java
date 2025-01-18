import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static DriverManager instance;
    Map<String, Driver> driverMap = new HashMap<>();

    public static synchronized DriverManager getInstance() {
        if(instance==null){
            instance = new DriverManager();
        }
        return instance;
    }

    public void addDriver(Driver driver){
        driverMap.put(driver.getName(),driver);
    }

    public Driver getDriver(String name){
        return driverMap.getOrDefault(name,null);
    }

}
