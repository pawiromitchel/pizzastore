package sr.unasat.jpa.pizza_store.decorator;

public class Mushrooms extends OrderDecorator {
    final double price = 2;

    public Mushrooms(BasicOrder newOrder){
        super(newOrder);
        System.out.println("Adding Mushrooms");
    }

    @Override
    public double getCosts() {
        return tempOrder.getCosts() + price;
    }
}
