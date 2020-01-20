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

    @Override
    public String toString() {
        return "Topping{" +
                "id=" + id +
                ", topping='" + topping + '\'' +
                '}';
    }
}
