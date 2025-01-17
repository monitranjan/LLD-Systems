public class Ticket {
    private int floorNo;
    private int price;
    private String name;
    private long time;
    private VehicleType vehicleType;
    private ParkingSpot parkingSpot;

    public Ticket(int floorNo, int price, String name, long time, VehicleType vehicleType, ParkingSpot parkingSpot) {
        this.floorNo = floorNo;
        this.price = price;
        this.name = name;
        this.time = time;
        this.vehicleType = vehicleType;
        this.parkingSpot = parkingSpot;
    }

    public int getPrice() {
        return price;
    }

    public long getTime() {
        return time;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}