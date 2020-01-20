package sr.unasat.jpa.pizza_store.builder;

import sr.unasat.jpa.pizza_store.entities.Order;
import sr.unasat.jpa.pizza_store.entities.Size;
import sr.unasat.jpa.pizza_store.entities.Topping;
import sr.unasat.jpa.pizza_store.entities.Type;

import java.util.List;

public class PizzaBuilder {
    private Size size;
    private Type type;
    private String payment;
    private double price;
    private List<Topping> toppingList;

    public void setSize(Size size) {
        this.size = size;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }

    public Order getResult(){
        return new Order(0, size, payment, type, toppingList, price);
    }
}
