import java.util.Random;

public class Trip {
    Rider rider;
    Driver driver;
    Location source;
    Location destination;
    TRIPSTATUS tripstatus;
    int tripId;
    double price;
    PricingStrategy pricingStrategy;
    DriverMatchingStrategy driverMatchingStrategy;

    public Trip(Rider rider, Driver driver, Location source, Location destination, double price, PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.rider = rider;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.tripId = new Random().nextInt(1000);
        this.tripstatus = TRIPSTATUS.CREATED;
    }

    public int getTripId() {
        return tripId;
    }

    public void startTrip() {
        this.tripstatus = TRIPSTATUS.INPROGRESS;
        System.out.println("Trip In Progress.");
    }

    public void completeTrip() {
        this.tripstatus = TRIPSTATUS.COMPLETED;
        System.out.println("Trip Completed.");
    }

    @Override
    public String toString() {
        return "Trip{" +
                "rider=" + rider.getName() +
                ", driver=" + driver.getName() +
                ", source=" + source +
                ", destination=" + destination +
                ", tripstatus=" + tripstatus +
                ", tripId=" + tripId +
                ", price=" + price +
                '}';
    }
}
