package sr.unasat.jpa.pizza_store.entities.rapportages;

import javax.persistence.*;

@Entity
public class BestChosenPizza {

    @Id
    private int id;

    @Column
    private String type;

    @Column
    private double total_chosen;

    @Column
    private double year;

    @Column
    private double quarter;

    @Override
    public String toString() {
        return "BestChosenPizza{" +
                "type='" + type + '\'' +
                ", total_chosen=" + total_chosen +
                ", year=" + year +
                ", quarter=" + quarter +
                '}';
    }
}
