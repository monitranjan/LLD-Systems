public class WithdrawCash extends Transaction {
    private double amount;
    private CashDispenser cashDispenser;
    public WithdrawCash(BankService bankService, String accountNumber, double amount, CashDispenser cashDispenser){
        super(accountNumber,bankService);
        this.amount = amount;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        if(cashDispenser.checkCashAvailability(amount) && bankService.withdrawCash(accountNumber,amount)){
            cashDispenser.dispenseCash(amount);
            System.out.println("Please collect cash");
        } else{
            System.out.println("withdrawal failed");
        }
    }
}
