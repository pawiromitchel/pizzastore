package sr.unasat.jpa.pizza_store.decorator;

public class OrderDecorator implements Order {
    protected Order tempOrder;

    public OrderDecorator(Order newOrder) {
        this.tempOrder = newOrder;
    }

    public double getCosts() {
        return tempOrder.getCosts();
    }
}
