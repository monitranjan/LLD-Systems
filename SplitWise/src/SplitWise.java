import java.util.ArrayList;
import java.util.List;

public class SplitWise {
    UserManager userManager;
    GroupManager groupManager;
    BalanceSheetManager balanceSheetManager;
    
    public SplitWise(){
        userManager = new UserManager();
        groupManager = new GroupManager();
        balanceSheetManager = new BalanceSheetManager();
    }
    
    public void demo(){
        setUserAndGroup();
        Group group = groupManager.getGroup("Group1");
        group.addMember(userManager.getUser("U1002"));
        group.addMember(userManager.getUser("U1003"));

        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(userManager.getUser("U1001"),1000);
        Split split2 = new Split(userManager.getUser("U1002"),1000);
        Split split3 = new Split(userManager.getUser("U1003"),1000);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);

        group.createExpense("EXP1001","Breakfast",3000,splits, ExpenseSplitType.EQUAL,userManager.getUser("U1001"));

        List<Split> splits2 = new ArrayList<>();
        Split split4 = new Split(userManager.getUser("U1001"),2000);
        Split split5 = new Split(userManager.getUser("U1002"),1000);
        splits.add(split4);
        splits.add(split5);
        group.createExpense("EXP1001","Lunch",3000,splits,ExpenseSplitType.UNEQUAL,userManager.getUser("U1002"));

        for (User user: userManager.getUserList()){
            balanceSheetManager.showBalanceSheetOfUser(user);
        }

    }

    private void setUserAndGroup() {
        addUsersToSplitWise();
        User user = userManager.getUser("U1001");
        groupManager.createGroup("Group1","Trip to Goa", user);
    }

    private void addUsersToSplitWise() {
        User user1 = new User("U1001","Monit");
        User user2 = new User("U1002","Ranjan");
        User user3 = new User("U1003","Kumar");

        userManager.addUser(user1);
        userManager.addUser(user2);
        userManager.addUser(user3);
    }
}
