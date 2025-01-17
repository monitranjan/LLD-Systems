public class ATM {
    private BankService bankService;
    private CashDispenser cashDispenser;
    private CardReader cardReader;
    private PinPad pinPad;
    private Display display;

    public ATM() {
        this.bankService = BankService.getInstance();
        this.cardReader = new CardReader();
        this.cashDispenser = CashDispenser.getInstance();
        this.pinPad = new PinPad();
        this.display = new Display();
    }

    public void start() {
        display.showMessage("Welcome to the ATM!");
        String cardNumber = cardReader.readCard();
        if (null == cardNumber) {
            display.showMessage("Card reading failed. please try again");
            return;
        }

        display.showMessage("Please enter your PIN:");
        String pin = pinPad.getPin();

        if (bankService.validateAccounts(cardNumber, pin)) {
            display.showMessage("Authentication successful!");
            performTransaction(cardNumber);
        } else {
            display.showMessage("Wrong credentials");
            return;
        }
        display.showMessage("Thank you for using the ATM.");
    }

    public void performTransaction(String cardNumber) {
        boolean done = false;
        while (!done) {
            display.showMessage("Choose a transaction: 1. Balance Inquiry 2. Withdrawal 3. Deposit 4. Exit");
            int choice = display.getUserInput();

            switch (choice) {
                case 1:
                    new BalanceEnquiry(bankService, cardNumber).execute();
                    break;
                case 2:
                    display.showMessage("Enter amount to withdraw");
                    double amount = display.getUserInput();
                    new WithdrawCash(bankService, cardNumber, amount, cashDispenser).execute();
                    break;
                case 3:
                    display.showMessage("Enter amount to deposit");
                    double depositAmount = display.getUserInput();
                    new DepositCash(depositAmount, bankService, cardNumber).execute();
                    break;
                case 4:
                    done = true;
                    break;
                default:
                    display.showMessage("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        new ATM().start();
    }
}


