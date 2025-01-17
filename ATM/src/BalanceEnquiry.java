public class BalanceEnquiry extends Transaction {

    public BalanceEnquiry(BankService bankService, String accountNumber) {
        super(accountNumber, bankService);
    }

    @Override
    public void execute() {
        double balance = bankService.balanceEnquiry(accountNumber);
        System.out.println("Available balance is:" + balance);
    }
}
