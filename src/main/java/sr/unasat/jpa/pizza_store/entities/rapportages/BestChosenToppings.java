package sr.unasat.jpa.pizza_store.entities.rapportages;

import javax.persistence.*;

@Entity
public class BestChosenToppings {
    @Id
    private int id;

    @Column
    private String topping;

    @Column
    private int aantal_keren_uitgekozen;

    public String getTopping() {
        return topping;
    }

    public int getAantal_keren_uitgekozen() {
        return aantal_keren_uitgekozen;
    }

    @Override
    public String toString() {
        return "BestChosenToppings{" +
                "topping='" + topping + '\'' +
                ", aantal_keren_uitgekozen=" + aantal_keren_uitgekozen +
                '}';
    }
}
