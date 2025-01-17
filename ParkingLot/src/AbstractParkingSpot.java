abstract class AbstractParkingSpot implements ParkingSpot {
    protected boolean isOccupied;
    protected int noOfFloor;
    protected int price;
    protected Vehicle currentVehicle;

    public AbstractParkingSpot(int noOfFloor, int price) {
        this.noOfFloor = noOfFloor;
        this.price = price;
        this.isOccupied = false;
    }

    @Override
    public boolean isEmpty() {
        return !isOccupied;
    }

    @Override
    public void vacateParkingSpot() {
        isOccupied = false;
        currentVehicle = null;
    }
    public int getPrice() {
        return price;
    }

    public int getNoOfFloor() {
        return noOfFloor;
    }
}