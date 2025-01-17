public class CashDispenser {
    private static CashDispenser instance;
    private double availableCash = 100000;

    public synchronized static CashDispenser getInstance() {
        if(instance == null){
            return new CashDispenser();
        }
        return instance;
    }

    public synchronized boolean checkCashAvailability(double amount) {
        return availableCash >= amount;
    }

    public void dispenseCash(double withdrawalAmount){
        if(checkCashAvailability(withdrawalAmount)){
            availableCash -= withdrawalAmount;
            System.out.println("Please take your cash: " + withdrawalAmount);
        } else {
            System.out.println("Insufficient cash available.");
        }
    }
}
