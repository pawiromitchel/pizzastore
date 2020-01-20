package sr.unasat.jpa.pizza_store.builder;

import sr.unasat.jpa.pizza_store.entities.Order;

public class PizzaBuilder implements Builder {
    private String size;
    private String type;
    private String crust;
    private String payment;
    private double price;

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

    public Order getResult(){
        return new Order(0, size, payment, crust, type);
    }
}
