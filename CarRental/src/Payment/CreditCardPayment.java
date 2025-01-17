package Payment;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+"using credit card");
    }
}
