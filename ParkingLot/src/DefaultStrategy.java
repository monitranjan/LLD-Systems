public class DefaultStrategy implements CostComputation {
    @Override
    public int calculateCostForTicket(Ticket ticket) {
        return ticket.getPrice();
    }
}