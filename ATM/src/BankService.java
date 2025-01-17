import java.util.concurrent.ConcurrentHashMap;

public class BankService {
    private static BankService instance;
    private ConcurrentHashMap<String,Double> accounts;

    public BankService(){
        accounts = new ConcurrentHashMap<>();
        accounts.put("123456789",500.0);
    }

    public static synchronized BankService getInstance() {
        if(instance == null){
            return new BankService();
        }
        return instance;
    }

    public boolean validateAccounts(String cardNumber, String pin){
        return "123456789".equals(cardNumber) && "1234".equals(pin);
    }

    public synchronized double balanceEnquiry(String cardNumber){
        return accounts.getOrDefault(cardNumber,0.0);
    }

    public synchronized boolean withdrawCash(String cardNumber, double withdrawlAmount) {
        double currentBalance = balanceEnquiry(cardNumber);
        if (withdrawlAmount <= currentBalance) {
            currentBalance -= withdrawlAmount;
            accounts.put(cardNumber, currentBalance);
            return true;
        } else {
            System.out.println("Not Enough amount in bank account");
            return false;
        }
    }

    public synchronized boolean depositCash(String cardNumber, double depositAmount) {
        double currentBalance = balanceEnquiry(cardNumber);
        currentBalance += depositAmount;
        accounts.put(cardNumber, currentBalance);
        System.out.println("Deposit succsessful and updated account balance :"+ currentBalance);
        return true;
    }

}
