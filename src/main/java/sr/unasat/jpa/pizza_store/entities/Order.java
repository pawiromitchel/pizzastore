package sr.unasat.jpa.pizza_store.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "payment", nullable = false)
    private String payment;

    @Column(name = "crust", nullable = false)
    private String crust;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @Column
    @JoinTable(
            name = "order_topping",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "topping_id") }
    )
    private List<Topping> toppingList;

    public Order(int id, String size, String payment, String crust, String type, List<Topping> toppingList) {
        this.id = id;
        this.size = size;
        this.payment = payment;
        this.crust = crust;
        this.type = type;
        this.toppingList = toppingList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", payment='" + payment + '\'' +
                ", crust='" + crust + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
