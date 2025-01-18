public class StrategyManager {
    private static StrategyManager instance;

    public static synchronized StrategyManager getInstance() {
        if(instance == null){
            instance = new StrategyManager();
        }
        return instance;
    }

    public PricingStrategy determinePricingStrategy(TripMetaData metaData) {
        return new DefaultPricingStrategy();
    }

    public DriverMatchingStrategy determineMatchingStrategy(TripMetaData metaData) {
        return new LeastTimeBasedMatchingStrategy();
    }
}
