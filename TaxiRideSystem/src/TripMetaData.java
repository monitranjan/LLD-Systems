public class TripMetaData {
    RATING riderRating;
    RATING driverRating;
    Location source;
    Location destination;

    public TripMetaData(Location srcLoc, Location dstLoc, RATING riderRating) {
        this.source = srcLoc;
        this.destination = dstLoc;
        this.riderRating = riderRating;
    }

    public RATING getRiderRating() {
        return riderRating;
    }

    public RATING getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(RATING driverRating) {
        this.driverRating = driverRating;
    }
}
