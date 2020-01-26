package sr.unasat.jpa.pizza_store.entities;

import javax.persistence.*;

@Entity
@Table(name = "toppings")
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "topping", nullable = false)
    private String topping;

    @Column(name = "price", nullable = false)
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "id=" + id +
                ", topping='" + topping + '\'' +
                ", price=" + price +
                '}';
    }
}
