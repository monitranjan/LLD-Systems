public class RatingBasedPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        return 40.0 * tripMetaData.getDriverRating().ordinal();
    }
}
