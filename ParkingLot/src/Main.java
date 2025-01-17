public class Main {
    public static void main(String[] args) {
        ParkingSpotManager parkingSpotManager = new ParkingSpotManager(1, 1, 1,3);  // 10 two-wheelers, 5 three-wheelers, 3 four-wheelers

        Entrance entrance = new Entrance(parkingSpotManager);

        Vehicle vehicle1 = new Vehicle(VehicleType.TWO_WHEELER, "Red", "WB1234");
        Vehicle vehicle2 = new Vehicle(VehicleType.TWO_WHEELER, "Blue", "MH5678");
        Vehicle vehicle3 = new Vehicle(VehicleType.TWO_WHEELER,"Yellow", "MH12345");
        Vehicle vehicle4 = new Vehicle(VehicleType.TWO_WHEELER, "Blue", "MH5678");


        ParkingStrategy strategy = new DefaultParkingStrategy();
        CostComputation costComputation = new MinuteBasedStrategy();
        ExitGate exitGate = new ExitGate();

        // Book parking for vehicle 1
        Ticket ticket1 = entrance.bookSpotAndGiveTicket(vehicle1, strategy, costComputation);
        System.out.println("Ticket 1: " + (ticket1 != null ? ticket1.getPrice() : "No ticket"));

        // Book parking for vehicle 2
        Ticket ticket2 = entrance.bookSpotAndGiveTicket(vehicle2, strategy, costComputation);
        System.out.println("Ticket 2: " + (ticket2 != null ? ticket1.getPrice() : "No ticket"));

        Ticket ticket3 = entrance.bookSpotAndGiveTicket(vehicle3, strategy, costComputation);
        System.out.println("Ticket 3: " + (ticket3 != null ? ticket1.getPrice() : "No ticket"));

        Ticket ticket4 = entrance.bookSpotAndGiveTicket(vehicle4, strategy, costComputation);
        System.out.println("Ticket 4: " + (ticket4 != null ? ticket1.getPrice() : "No ticket"));

        try { Thread.sleep(60000); } catch (InterruptedException e) {}

        // Simulate payment at the exit
        exitGate.payPrice(ticket1, costComputation);
        exitGate.payPrice(ticket2, costComputation);
        exitGate.payPrice(ticket3, costComputation);


        // Vacate parking spots
        exitGate.vacateParking(ticket1.getParkingSpot());
        exitGate.vacateParking(ticket2.getParkingSpot());
        exitGate.vacateParking(ticket3.getParkingSpot());

        // Check if the parking spots are empty
        System.out.println("Is Parking Spot 1 Empty: " + ticket1.getParkingSpot().isEmpty());
        System.out.println("Is Parking Spot 2 Empty: " + ticket2.getParkingSpot().isEmpty());
        System.out.println("Is Parking Spot 3 Empty: " + ticket3.getParkingSpot().isEmpty());
    }
}
