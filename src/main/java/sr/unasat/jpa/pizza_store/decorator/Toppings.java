package sr.unasat.jpa.pizza_store.decorator;

import sr.unasat.jpa.pizza_store.entities.Order;
import sr.unasat.jpa.pizza_store.entities.Topping;

import java.util.ArrayList;
import java.util.List;

public class Toppings extends ToppingsDecorator {
    protected Topping topping;
    List<Topping> toppingList = new ArrayList<Topping>();
    double totalToppingPrice = 0;

    public Toppings(Order pizzaToDecorate) {
        super(pizzaToDecorate);
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
        toppingList.add(topping);
        System.out.println("Adding topping " + topping.getTopping());
        this.totalToppingPrice += topping.getPrice();
        System.out.println("Total toppingPrice " + this.totalToppingPrice);
    }

    public double getPrice(){
        return this.totalToppingPrice;
    }

    @Override
    public List<Topping> getToppingList() {
        return toppingList;
    }
}
