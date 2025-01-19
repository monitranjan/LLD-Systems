import java.util.ArrayList;
import java.util.List;

public class Expense {
    private String expenseID;
    private String description;
    private User paidByUser;
    private double expenseAmount;
    ExpenseSplitType splitType;
    List<Split> splitList = new ArrayList<>();

    public Expense(double expenseAmount, User paidByUser, String description, String expenseID, ExpenseSplitType expenseSplitType, List<Split> splitDetails) {
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.description = description;
        this.expenseID = expenseID;
        this.splitType = expenseSplitType;
        this.splitList.addAll(splitDetails);
    }
}
