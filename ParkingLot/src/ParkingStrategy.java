import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots);
}