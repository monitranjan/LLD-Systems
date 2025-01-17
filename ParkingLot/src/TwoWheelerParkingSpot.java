public class TwoWheelerParkingSpot extends AbstractParkingSpot {
    public TwoWheelerParkingSpot(int noOfFloor, int price) {
        super(noOfFloor, price);
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {
            isOccupied = true;
            currentVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type for this spot");
        }
    }
}