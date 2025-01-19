import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    private Map<String, Balance> userBalanace;
    private double totalExpense;
    private double totalYourExpense;
    private double totalYouOwe;
    private double totalYouGetBack;

    public UserExpenseBalanceSheet() {
        userBalanace = new HashMap<>();
        totalExpense = 0;
        totalYouGetBack = 0;
        totalYouOwe = 0;
        totalYourExpense = 0;
    }

    public Map<String, Balance> getUserBalanace() {
        return userBalanace;
    }

    public void setUserBalanace(Map<String, Balance> userBalanace) {
        this.userBalanace = userBalanace;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }
}
