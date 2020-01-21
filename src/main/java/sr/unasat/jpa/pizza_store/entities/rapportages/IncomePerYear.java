package sr.unasat.jpa.pizza_store.entities.rapportages;

import javax.persistence.*;

@Entity
public class IncomePerYear {

    @Id
    private int id;

    @Column
    private String year;

    @Column
    private double gross_income;

    public String getYear() {
        return year;
    }

    public double getGross_income() {
        return gross_income;
    }

    @Override
    public String toString() {
        return "IncomePerYear{" +
                "year='" + year + '\'' +
                ", gross_income=" + gross_income +
                '}';
    }
}
