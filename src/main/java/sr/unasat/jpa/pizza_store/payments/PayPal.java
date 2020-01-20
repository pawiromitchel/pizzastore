package sr.unasat.jpa.pizza_store.payments;

public class PayPal extends Payment{
    final double fee = 5;

    public PayPal() {
    }

    @Override
    void showWelcomeMessage() {
        System.out.println("Thank you for choosing PayPal");
    }

    @Override
    void showFeeMessage() {
        System.out.println("The fee is " + fee + "%");

    }
}
