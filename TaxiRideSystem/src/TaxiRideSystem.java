public class TaxiRideSystem {
    public static void main(String[] args) {
        RiderManager riderMgr = RiderManager.getInstance();
        DriverManager driverMgr = DriverManager.getInstance();
        TripManager tripMgr = TripManager.getInstance();
        StrategyManager strategyMgr = StrategyManager.getInstance();

        // Add Riders and Drivers
        riderMgr.addRider(new Rider("Alice", RATING.FOUR));
        driverMgr.addDriver(new Driver("Bob", RATING.FIVE));

        Rider rider = riderMgr.getRider("Alice");
        Location srcLoc = new Location("123 Main St");
        Location dstLoc = new Location("456 Elm St");

        PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(new TripMetaData(srcLoc, dstLoc, rider.getRating()));
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineMatchingStrategy(new TripMetaData(srcLoc, dstLoc, rider.getRating()));

        Trip trip = tripMgr.createTrip(rider, srcLoc, dstLoc, pricingStrategy.calculatePrice(new TripMetaData(srcLoc, dstLoc, rider.getRating())), pricingStrategy, driverMatchingStrategy);
        System.out.println(trip.toString());
        if(trip!= null){
            trip.startTrip();
        }
        System.out.println(trip.toString());

        try {
            Thread.sleep(1000);
            trip.completeTrip();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(trip.toString());
    }
}