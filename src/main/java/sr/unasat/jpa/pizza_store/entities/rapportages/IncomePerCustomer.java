package sr.unasat.jpa.pizza_store.entities.rapportages;

import javax.persistence.*;

@Entity
public class IncomePerCustomer {

    @Id
    private int id;

    @Column
    private String username;

    @Column
    private String total_income;

    @Column
    private double year;

    @Column
    private double quarter;

    @Override
    public String toString() {
        return "IncomePerCustomer{" +
                "username='" + username + '\'' +
                ", total_income='" + total_income + '\'' +
                ", year=" + year +
                ", quarter=" + quarter +
                '}';
    }
}
