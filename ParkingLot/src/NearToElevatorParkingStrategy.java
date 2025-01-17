import java.util.List;

public class NearToElevatorParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) {
        // Assuming spots near the elevator are in the middle of the list
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isEmpty()) {
                return spot;
            }
        }
        return null;
    }
}