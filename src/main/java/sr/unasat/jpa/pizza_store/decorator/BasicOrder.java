package sr.unasat.jpa.pizza_store.decorator;

public class BasicOrder implements Order{
    final double price = 0;

    public double getCosts() {
        System.out.println("Starting price at " + price);
        return price;
    }
}
