public interface ParkingSpot {
    boolean isEmpty();
    void occupy(Vehicle vehicle);
    void vacateParkingSpot();
    int getPrice();
    int getNoOfFloor();
}