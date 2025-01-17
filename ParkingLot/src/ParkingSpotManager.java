import java.util.*;

public class ParkingSpotManager {
    private Map<Integer, List<ParkingSpot>> floorWiseParkingSpots;  // Map to store spots by floor
    private int twoWheelerSpotsPerFloor;
    private int threeWheelerSpotsPerFloor;
    private int fourWheelerSpotsPerFloor;

    // Constructor with specified number of spots per floor for each vehicle type
    public ParkingSpotManager(int twoWheelerSpotsPerFloor, int threeWheelerSpotsPerFloor, int fourWheelerSpotsPerFloor, int totalFloors) {
        this.floorWiseParkingSpots = new HashMap<>();
        this.twoWheelerSpotsPerFloor = twoWheelerSpotsPerFloor;
        this.threeWheelerSpotsPerFloor = threeWheelerSpotsPerFloor;
        this.fourWheelerSpotsPerFloor = fourWheelerSpotsPerFloor;

        // Initialize the parking spots for each floor
        for (int floor = 1; floor <= totalFloors; floor++) {
            List<ParkingSpot> spotsForFloor = new ArrayList<>();
            for (int i = 0; i < twoWheelerSpotsPerFloor; i++) {
                spotsForFloor.add(new TwoWheelerParkingSpot(floor, 20));  // Assuming price is 20
            }
            for (int i = 0; i < threeWheelerSpotsPerFloor; i++) {
                spotsForFloor.add(new ThreeWheelerParkingSpot(floor, 30));  // Assuming price is 30
            }
            for (int i = 0; i < fourWheelerSpotsPerFloor; i++) {
                spotsForFloor.add(new FourWheelerParkingSpot(floor, 40));  // Assuming price is 40
            }
            floorWiseParkingSpots.put(floor, spotsForFloor);
        }
    }

    // Method to find a parking spot based on vehicle type and strategy
    public ParkingSpot findParkingSpot(Vehicle vehicle, ParkingStrategy strategy) {
        if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {
            return findSpotByType(TwoWheelerParkingSpot.class);
        } else if (vehicle.getVehicleType() == VehicleType.THREE_WHEELER) {
            return findSpotByType(ThreeWheelerParkingSpot.class);
        } else if (vehicle.getVehicleType() == VehicleType.FOUR_WHEELER) {
            return findSpotByType(FourWheelerParkingSpot.class);
        }
        return null;
    }

    // Helper method to find a spot for a specific vehicle type
    private ParkingSpot findSpotByType(Class<?> type) {
        // Search floors for available spots
        for (Map.Entry<Integer, List<ParkingSpot>> entry : floorWiseParkingSpots.entrySet()) {
            for (ParkingSpot spot : entry.getValue()) {
                if (spot.isEmpty() && type.isInstance(spot)) {
                    return spot;
                }
            }
        }
        // If no spot is found for the specific type, throw an exception
        throw new NoParkingSpotAvailableException("No available parking spot for this vehicle type.");
    }
}
