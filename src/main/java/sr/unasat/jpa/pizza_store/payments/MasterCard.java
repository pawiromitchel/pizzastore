package sr.unasat.jpa.pizza_store.payments;

public class MasterCard extends Payment {
    final double fee = 3;

    public MasterCard() {
    }


    @Override
    void showWelcomeMessage() {
        System.out.println("Thank you for choosing MasterCard");
    }

    @Override
    void showFeeMessage() {
        System.out.println("The fee is " + fee + "%");
    }
}
