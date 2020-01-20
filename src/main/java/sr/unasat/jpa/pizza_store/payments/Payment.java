package sr.unasat.jpa.pizza_store.payments;

public abstract class Payment {
    double fee;

    Payment(){}

    public boolean pay(){
        showWelcomeMessage();
        showFeeMessage();
        return false;
    }

    abstract void showWelcomeMessage();
    abstract void showFeeMessage();
}
