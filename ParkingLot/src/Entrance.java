public class Entrance {
    private ParkingSpotManager parkingSpotManager;

    public Entrance(ParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }

    public Ticket bookSpotAndGiveTicket(Vehicle vehicle, ParkingStrategy strategy, CostComputation costComputation) {
        try {
            ParkingSpot spot = parkingSpotManager.findParkingSpot(vehicle, strategy);
            if (spot == null) {
                throw new IllegalStateException("No available parking spot");
            }
            spot.occupy(vehicle);
            long currentTime = System.currentTimeMillis();
            int price = spot.getPrice();

            return new Ticket(spot.getNoOfFloor(), price, vehicle.getVehicleNumber(), currentTime, vehicle.getVehicleType(), spot);
        } catch (NoParkingSpotAvailableException e) {
            // Handle the exception and notify the user
            System.out.println(e.getMessage());  // For now, just print the message
            return null;
        }
    }
}
