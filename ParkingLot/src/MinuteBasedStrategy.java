public class MinuteBasedStrategy implements CostComputation {
    @Override
    public int calculateCostForTicket(Ticket ticket) {
        long duration = System.currentTimeMillis() - ticket.getTime();
        int minutes = (int) (duration / (1000 * 60));
        return minutes * ticket.getPrice();
    }
}