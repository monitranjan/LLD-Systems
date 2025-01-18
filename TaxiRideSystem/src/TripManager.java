import java.util.HashMap;
import java.util.Map;

public class TripManager {
    private static TripManager instance;
    private RiderManager riderManager = RiderManager.getInstance();
    private DriverManager driverManager = DriverManager.getInstance();
    private Map<Integer, TripMetaData> tripsMetaDataInfo = new HashMap<>();
    private Map<Integer, Trip> tripsInfo = new HashMap<>();

    public static synchronized TripManager getInstance() {
        if(instance == null){
            instance = new TripManager();
        }
        return instance;
    }

    public Trip createTrip(Rider rider, Location srcLoc, Location dstLoc, double price, PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        Driver driver = driverMatchingStrategy.matchDriver(new TripMetaData(srcLoc, dstLoc, rider.getRating()));
        Trip trip = new Trip(rider, driver, srcLoc, dstLoc, price, pricingStrategy, driverMatchingStrategy);
        tripsInfo.put(trip.getTripId(), trip);
        tripsMetaDataInfo.put(trip.getTripId(), new TripMetaData(srcLoc, dstLoc, rider.getRating()));
        return trip;
    }


    public Map<Integer, Trip> getTripsInfo() {
        return tripsInfo;
    }
}
