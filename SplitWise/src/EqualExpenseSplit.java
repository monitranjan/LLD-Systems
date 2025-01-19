import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {
    @Override
    public void validateExpenseSplit(List<Split> splitList, double totalAmount) {
        double equalAmount = totalAmount / splitList.size();
        splitList.stream()
                .forEach(split -> {
                    if (Math.abs(split.getAmount() - equalAmount) > 0.01) {
                        throw new IllegalArgumentException("Split amount is not equal to the expected equal amount.");
                    }
                });
    }

}
