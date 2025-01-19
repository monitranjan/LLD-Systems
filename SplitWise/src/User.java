public class User {
    String userId;
    String name;
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }
}
