import java.util.List;

public class NearToEntranceParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) {
        // Assuming spots near the entrance are at the beginning of the list
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isEmpty()) {
                return spot;
            }
        }
        return null;
    }
}