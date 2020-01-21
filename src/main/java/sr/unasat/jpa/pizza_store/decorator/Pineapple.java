package sr.unasat.jpa.pizza_store.decorator;

public class Pineapple extends OrderDecorator {
    final double price = 5;

    public Pineapple(BasicOrder newOrder){
        super(newOrder);
        System.out.println("Adding Pineapple");
    }

    @Override
    public double getCosts() {
        return tempOrder.getCosts() + price;
    }
}
