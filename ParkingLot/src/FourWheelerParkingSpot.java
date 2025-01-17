public class FourWheelerParkingSpot extends AbstractParkingSpot {
    public FourWheelerParkingSpot(int noOfFloor, int price) {
        super(noOfFloor, price);
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (vehicle.getVehicleType() == VehicleType.FOUR_WHEELER) {
            isOccupied = true;
            currentVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type for this spot");
        }
    }
}