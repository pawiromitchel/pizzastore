package sr.unasat.jpa.pizza_store.builder;

import sr.unasat.jpa.pizza_store.entities.Order;
import sr.unasat.jpa.pizza_store.entities.Topping;

import java.util.List;

public class PizzaBuilder implements Builder {
    private String size;
    private String type;
    private String crust;
    private String payment;
    private double price;
    private List<Topping> toppingList;

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCrust(String crust) {
        this.crust = crust;
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
        return new Order(0, size, payment, crust, type, toppingList);
    }
}
