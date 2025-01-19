import java.util.List;
import java.util.Map;

public class BalanceSheetManager {
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpense) {
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalExpense(paidByUserExpenseSheet.getTotalExpense() + totalExpense);

        for (Split split : splits) {
            User user = split.getUser();
            UserExpenseBalanceSheet userExpenseSheet = user.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmount();
            if (expensePaidBy.userId.equals(user.userId)) {
                paidByUserExpenseSheet.setTotalExpense(paidByUserExpenseSheet.getTotalYourExpense() + oweAmount);
            } else {
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + oweAmount);
                Balance userOweBalance;
                if(paidByUserExpenseSheet.getUserBalanace().containsKey(user.userId)){
                    userOweBalance = paidByUserExpenseSheet.getUserBalanace().get(user.userId);
                }else{
                    userOweBalance = new Balance();
                    paidByUserExpenseSheet.getUserBalanace().put(user.userId,userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack()+oweAmount);

                userExpenseSheet.setTotalYouOwe(userExpenseSheet.getTotalYouOwe() + oweAmount);
                userExpenseSheet.setTotalYourExpense(userExpenseSheet.getTotalYourExpense()+oweAmount);

                Balance userPaidBalance;
                if(userExpenseSheet.getUserBalanace().containsKey(expensePaidBy.userId)){
                    userPaidBalance = userExpenseSheet.getUserBalanace().get(expensePaidBy.userId);
                }else{
                    userPaidBalance = new Balance();
                    userExpenseSheet.getUserBalanace().put(expensePaidBy.userId,userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe()+oweAmount);
            }
        }

    }

    public void showBalanceSheetOfUser(User user){

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet =  user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalExpense());
        for(Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserBalanace().entrySet()){

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }


}
