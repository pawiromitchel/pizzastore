package sr.unasat.jpa.pizza_store.app;

import sr.unasat.jpa.pizza_store.builder.PizzaBuilder;
import sr.unasat.jpa.pizza_store.config.JPAConfiguration;
import sr.unasat.jpa.pizza_store.dao.UserDAO;
import sr.unasat.jpa.pizza_store.entities.User;
import sr.unasat.jpa.pizza_store.payments.MasterCard;
import sr.unasat.jpa.pizza_store.payments.PayPal;
import sr.unasat.jpa.pizza_store.payments.Payment;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        String[] sizes = {"Groot", "Medium", "Klein"};

        // AUTH

        // aan de hand van de user role moet ht de menus aangeven

        System.out.println("Welkom bij pimp my pizza");
        System.out.println("Log AUB eerst in om gebruik te maken van de applicatie");

        System.out.println("Vul hier uw gebruikersnaam in");
        Scanner usernameRead = new Scanner(System.in);
        String username = usernameRead.nextLine();
        System.out.println("Vul hier uw wachtwoord in");
        Scanner passwordRead = new Scanner(System.in);
        String password = passwordRead.nextLine();

        System.out.println("Checking the database");
        UserDAO userDAO = new UserDAO(JPAConfiguration.getEntityManager());
        User user = userDAO.authUser(username, password);

        if(user != null){
            System.out.println("Welkom bij het systeem");
            if(user.getRole().getId() == 1){
                System.out.println("Welkom terug Admin");
                // EMPLOYEE

                // RAPPORTAGES

                // verschillende branches

                // inkomsten per branche per kwartaal

                // best selling per branche

                // de 5 combinatie toppings per kwaartaal
            } else {
                System.out.println("Welkom gebruiker " + user.getUsername());
                // GEBRUIKER

                // kies de size van de pizza

                System.out.println("Kies de grootte van de pizza");
                Scanner sizeRead = new Scanner(System.in);
                String size = sizeRead.nextLine();

                // type pizza

                System.out.println("Kies de type van de pizza");
                Scanner typeRead = new Scanner(System.in);
                String type = typeRead.nextLine();

                // soort bodem

                System.out.println("Kies de bodem van de pizza");
                Scanner crustRead = new Scanner(System.in);
                String crust = crustRead.nextLine();

                // toppings > hoe moet ik dit doen?

                // nog een bestelling plaatsen? > hoe moet ik dit doen?

                // TEMPLATE PATTERN
                Payment payment = null;
                System.out.println("Kies de betalingsmethode.\n" +
                        "1 - PayPal\n" +
                        "2 - MasterCard");
                Scanner paymentRead = new Scanner(System.in);
                int choice = paymentRead.nextInt();

                if(choice == 1){
                    payment = new PayPal();
                } else if(choice == 2){
                    payment = new MasterCard();
                }
                payment.pay();

                // BUILDER PATTERN
                PizzaBuilder pizzaBuilder = new PizzaBuilder();
                pizzaBuilder.setCrust(crust);
                pizzaBuilder.setSize(size);
                pizzaBuilder.setType(type);
            }
        } else {
            System.out.println("Gebruikersnaam of Wachtwoord niet juist, probeer opnieuw");
        }
    }
}
