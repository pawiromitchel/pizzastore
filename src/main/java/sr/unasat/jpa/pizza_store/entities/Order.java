package sr.unasat.jpa.pizza_store.entities;

import javax.persistence.*;

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

    public Order(int id, String size, String payment, String crust, String type) {
        this.id = id;
        this.size = size;
        this.payment = payment;
        this.crust = crust;
        this.type = type;
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
