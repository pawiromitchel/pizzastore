package sr.unasat.jpa.pizza_store.decorator;

public class Olives extends OrderDecorator {
    final double price = 5;

    public Olives(BasicOrder newOrder){
        super(newOrder);
        System.out.println("Adding Olives");
    }

    @Override
    public double getCosts() {
        return tempOrder.getCosts() + price;
    }
}
