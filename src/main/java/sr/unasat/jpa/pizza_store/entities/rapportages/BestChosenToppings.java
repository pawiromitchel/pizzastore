package sr.unasat.jpa.pizza_store.entities.rapportages;

import javax.persistence.*;

@Entity
public class BestChosenToppings {
    @Id
    private int id;

    @Column
    private String toppings;

    @Column
    private int aantal;

    @Column
    private int year;

    @Column
    private int quarter;

    @Override
    public String toString() {
        return "BestChosenToppings{" +
                "id=" + id +
                ", toppings='" + toppings + '\'' +
                ", aantal=" + aantal +
                ", year=" + year +
                ", quarter=" + quarter +
                '}';
    }
}
