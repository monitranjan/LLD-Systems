import java.util.List;

public class ExpenseManager {
    BalanceSheetManager balanceSheetManager;
    public ExpenseManager(){
        balanceSheetManager = new BalanceSheetManager();
    }
    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateExpenseSplit(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseAmount,paidByUser,description,expenseId,splitType,splitDetails);
        balanceSheetManager.updateUserExpenseBalanceSheet(paidByUser,splitDetails,expenseAmount);
        return expense;
    }
}
