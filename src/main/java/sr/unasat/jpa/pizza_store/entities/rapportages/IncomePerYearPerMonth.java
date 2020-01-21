package sr.unasat.jpa.pizza_store.entities.rapportages;

import javax.persistence.*;

@Entity
public class IncomePerYearPerMonth {
    @Id
    private int id;

    @Column
    private String year;

    @Column
    private String month;

    @Column
    private double gross_income;

    public String getYear() {
        return year;
    }

    public double getGross_income() {
        return gross_income;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "IncomePerYear{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", gross_income=" + gross_income +
                '}';
    }
}
