package sr.unasat.jpa.pizza_store.entities;

import sr.unasat.jpa.pizza_store.builder.PizzaBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "size")
    private Size size;

    @Column(name = "payment", nullable = false)
    private String payment;

    @ManyToOne
    @JoinColumn(name = "type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @Column
    @JoinTable(
            name = "order_topping",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "topping_id") }
    )
    private List<Topping> toppingList;


    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "date_created", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dateCreated;

    public Order() {
    }

    public Order(int id, Size size, String payment, Type type, User user, List<Topping> toppingList, double price) {
        this.id = id;
        this.size = size;
        this.payment = payment;
        this.type = type;
        this.user = user;
        this.toppingList = toppingList;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }

    public void addToToppingList(Topping topping){
        this.toppingList.add(topping);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
