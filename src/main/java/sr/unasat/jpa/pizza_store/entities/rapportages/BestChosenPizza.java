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
    private double month;

    public String getType() {
        return type;
    }

    public double getTotal_chosen() {
        return total_chosen;
    }

    public double getYear() {
        return year;
    }

    public double getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "BestChosenPizza{" +
                "type='" + type + '\'' +
                ", total_chosen=" + total_chosen +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}
