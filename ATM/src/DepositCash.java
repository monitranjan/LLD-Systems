public class DepositCash extends Transaction {
    double amount;

    public DepositCash(Double amount, BankService bankService, String accountNumber) {
        super(accountNumber, bankService);
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (bankService.depositCash(accountNumber, amount)) {
            System.out.println("Deposit Successful");
        } else {
            System.out.println("Deposit failed");
        }
    }
}
