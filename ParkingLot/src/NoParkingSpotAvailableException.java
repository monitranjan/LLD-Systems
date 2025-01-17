// Custom exception for no available parking spots
public class NoParkingSpotAvailableException extends RuntimeException {
    public NoParkingSpotAvailableException(String message) {
        super(message);
    }
}
