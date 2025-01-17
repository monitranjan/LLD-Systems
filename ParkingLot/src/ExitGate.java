public class ExitGate {
    public void payPrice(Ticket ticket, CostComputation costComputation) {
        int totalCost = costComputation.calculateCostForTicket(ticket);
        System.out.println("Total cost to pay: " + totalCost);
    }

    public void vacateParking(ParkingSpot spot) {
        spot.vacateParkingSpot();
    }
}