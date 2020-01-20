package sr.unasat.jpa.pizza_store.builder;

public interface Builder {
    void setSize(String size);
    void setType(String type);
    void setCrust(String crust);
    void setPayment(String payment);
    void setPrice(double price);
}
