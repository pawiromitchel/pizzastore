package sr.unasat.jpa.pizza_store.decorator;

public class ExtraCheese extends OrderDecorator {
    final double price = 5;

    public ExtraCheese(Order newOrder){
        super(newOrder);
        System.out.println("Adding Extra Cheese");
    }

    @Override
    public double getCosts() {
        return tempOrder.getCosts() + price;
    }
}
