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
    private double month;

    public String getUsername() {
        return username;
    }

    public String getTotal_income() {
        return total_income;
    }

    public double getYear() {
        return year;
    }

    public double getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "IncomePerCustomer{" +
                "username='" + username + '\'' +
                ", total_income='" + total_income + '\'' +
                ", year=" + year +
                ", month=" + month +
                '}';
    }
}
