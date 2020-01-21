package sr.unasat.jpa.pizza_store.dao;

import sr.unasat.jpa.pizza_store.entities.rapportages.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RapportageDAO {
    private EntityManager entityManager;

    public RapportageDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void incomePerYear(){
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("call income_per_year()", IncomePerYear.class);
        List<IncomePerYear> list =  q.getResultList();
        entityManager.getTransaction().commit();

        for(IncomePerYear e : list){
            System.out.println(e);
        }
    }

    public void incomePerYearPerMonth(){
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("call income_per_year_per_month()", IncomePerYearPerMonth.class);
        List<IncomePerYearPerMonth> list =  q.getResultList();
        entityManager.getTransaction().commit();

        for(IncomePerYearPerMonth e : list){
            System.out.println(e);
        }
    }

    public void bestChosenPizzaType(){
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("call best_chosen_pizza_type()", BestChosenPizza.class);
        List<BestChosenPizza> list =  q.getResultList();
        entityManager.getTransaction().commit();

        for(BestChosenPizza e : list){
            System.out.println(e);
        }
    }

    public void bestChosenPizzaTopping(){
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("call best_chosen_toppings()", BestChosenToppings.class);
        List<BestChosenToppings> list =  q.getResultList();
        entityManager.getTransaction().commit();

        for(BestChosenToppings e : list){
            System.out.println(e);
        }
    }

    public void incomePerCustomer(){
        entityManager.getTransaction().begin();
        Query q = entityManager.createNativeQuery("call income_per_customer_per_year_per_month()", IncomePerCustomer.class);
        List<IncomePerCustomer> list =  q.getResultList();
        entityManager.getTransaction().commit();

        for(IncomePerCustomer e : list){
            System.out.println(e);
        }
    }
}
