import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    private String groupName;
    private List<User> groupMembers;
    private List<Expense> expenseList;
    private ExpenseManager expenseManager;

    public Group(){
        this.groupMembers = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.expenseManager = new ExpenseManager();
    }

    public void addMember(User user){
        groupMembers.add(user);
    }

    public String getGroupId(){
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser ){
        Expense expense = this.expenseManager.createExpense(expenseId,description,expenseAmount,splitDetails,splitType,paidByUser);
        expenseList.add(expense);
        return expense;
    }
}
