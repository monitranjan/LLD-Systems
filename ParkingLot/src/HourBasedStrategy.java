public class HourBasedStrategy implements CostComputation {
    @Override
    public int calculateCostForTicket(Ticket ticket) {
        long duration = System.currentTimeMillis() - ticket.getTime();
        int hours = (int) (duration / (1000 * 60 * 60));
        return hours * ticket.getPrice();
    }
}