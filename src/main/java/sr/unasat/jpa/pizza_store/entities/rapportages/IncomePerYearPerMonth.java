package sr.unasat.jpa.pizza_store.entities.rapportages;

import javax.persistence.*;

@Entity
public class IncomePerYearPerMonth {
    @Id
    private int id;

    @Column
    private String year;

    @Column
    private String quarter;

    @Column
    private double gross_income;

    @Override
    public String toString() {
        return "IncomePerYear{" +
                "year='" + year + '\'' +
                ", quarter='" + quarter + '\'' +
                ", gross_income=" + gross_income +
                '}';
    }
}
