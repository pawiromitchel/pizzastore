package sr.unasat.jpa.pizza_store.decorator;

import sr.unasat.jpa.pizza_store.entities.Order;

public class ToppingsDecorator extends Order {
    protected Order pizza;

    public ToppingsDecorator(Order pizzaToDecorate) {
        this.pizza = pizzaToDecorate;
    }

    public double getCosts() {
        return pizza.getPrice() + this.getPrice();
    }
}
