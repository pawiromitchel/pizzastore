package sr.unasat.jpa.pizza_store.app;

import sr.unasat.jpa.pizza_store.builder.PizzaBuilder;
import sr.unasat.jpa.pizza_store.config.JPAConfiguration;
import sr.unasat.jpa.pizza_store.dao.*;
import sr.unasat.jpa.pizza_store.entities.*;
import sr.unasat.jpa.pizza_store.payments.MasterCard;
import sr.unasat.jpa.pizza_store.payments.PayPal;
import sr.unasat.jpa.pizza_store.payments.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        // start the login service
        loginService();

        // testing
//        testing();
    }

    static void loginService() {
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

        if (user != null) {
            System.out.println("Welkom terug " + user.getUsername() + " :)");

            // check voor de role van de ingelogde gebruiker
            switch(user.getRole().getId()){
                case 1:
                    Scanner menuRead = new Scanner(System.in);
                    int choice = menuRead.nextInt();

                    System.out.println("Wat wilt u nu doen?\n" +
                            "1. Bestelling Management\n" +
                            "2. Analytics\n" +
                            "3. Gebruiker Management");

//                    switch (choice){
//                        case 1:
//                            orderManagement();
//                            break;
//                        case 2:
//                            break;
//                        case 3:
//                            break;
//                    }
                    break;
                case 2:
                    break;
                case 3:
                    placeNewOrder(user);
                    break;
            }
        } else {
            System.out.println("Gebruikersnaam of Wachtwoord niet juist, probeer opnieuw");
            // start the logica opnieuw
            loginService();
        }
    }

    static void analytics(User user) {
        System.out.println("Welkom terug Admin");
        // EMPLOYEE

        // RAPPORTAGES

        // verschillende branches

        // inkomsten per branche per kwartaal

        // best selling per branche

        // de 5 combinatie toppings per kwaartaal
    }

    static void placeNewOrder(User user) {

        // prepare the menu
        OrderDAO orderDAO = new OrderDAO(JPAConfiguration.getEntityManager());
        SizeDAO sizeDAO = new SizeDAO(JPAConfiguration.getEntityManager());
        TypeDAO typeDAO = new TypeDAO(JPAConfiguration.getEntityManager());
        ToppingDAO toppingDAO = new ToppingDAO(JPAConfiguration.getEntityManager());

        List<Size> sizeList = sizeDAO.selectAll();
        List<Type> typeList = typeDAO.selectAll();
        List<Topping> toppingList = toppingDAO.selectAll();
        double totalPrice = 0;

        // size pizza
        System.out.println("Kies de grootte van de pizza");
        for(Size size : sizeList){
            System.out.println(size.getId() + ". " + size.getSize() + ", SRD " + size.getPrice());
        }
        Scanner sizeRead = new Scanner(System.in);
        int size = sizeRead.nextInt();
        Size sizeChosen = sizeDAO.selectOne(size);

        // type pizza
        System.out.println("Kies de type van de pizza");
        for(Type type : typeList){
            System.out.println(type.getId() + ". " + type.getType() + ", SRD " + type.getPrice());
        }
        Scanner typeRead = new Scanner(System.in);
        int type = typeRead.nextInt();
        Type typeChosen = typeDAO.selectOne(type);

        // toppings uitkiezen

        boolean ready = false;
        double toppingPrice = 0;
        List<Topping> toppingListChosen = new ArrayList<Topping>();

        while (!ready) {
            System.out.println("Kies een topping voor jouw pizza");
            for(Topping topping : toppingList){
                System.out.println(topping.getId() + ". " + topping.getTopping() + ", SRD " + topping.getPrice());
            }
            Scanner toppingRead = new Scanner(System.in);
            int topping = toppingRead.nextInt();
            Topping toppingChosen = toppingDAO.selectOne(topping);

            toppingListChosen.add(toppingChosen);
            // add the price of the topping to the toppingPrice
            toppingPrice += toppingChosen.getPrice();

            System.out.println("Wilt u nog een topping uitkiezen?\n" +
                    "1. Ja\n" +
                    "2. Nee");
            Scanner readyRead = new Scanner(System.in);
            int readyChosen = readyRead.nextInt();

            if(readyChosen == 2){
                ready = true;
            }
        }

        // calculate the total price
        totalPrice = sizeChosen.getPrice() + typeChosen.getPrice() + toppingPrice;

        // TEMPLATE PATTERN
        Payment payment = null;
        String paymentName = "";
        System.out.println("Kies de betalingsmethode.\n" +
                "1. PayPal\n" +
                "2. MasterCard");
        Scanner paymentRead = new Scanner(System.in);
        int choice = paymentRead.nextInt();

        if (choice == 1) {
            payment = new PayPal();
            paymentName = "PayPal";
        } else if (choice == 2) {
            payment = new MasterCard();
            paymentName = "MasterCard";
        }
        payment.pay();

        System.out.println("--- Summary ---");
        System.out.println("Uitgekozen grootte: " + sizeChosen.getSize());
        System.out.println("Uitgekozen type: " + typeChosen.getType());
        System.out.println("Uitgekozen toppings: ");
        for(Topping topping : toppingListChosen){
            System.out.println("- " + topping.getTopping());
        }
        System.out.println("Totaal bedrag is SRD" + totalPrice);
        System.out.println("Uitgekozen betalingsmethode is " + paymentName);

        // BUILDER PATTERN
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        pizzaBuilder.setType(typeChosen);
        pizzaBuilder.setSize(sizeChosen);
        pizzaBuilder.setToppingList(toppingListChosen);
        pizzaBuilder.setPayment(paymentName);
        pizzaBuilder.setPrice(totalPrice);
        Order order = pizzaBuilder.getResult();
        orderDAO.insert(order);
        System.out.println("Uw order is opgeslagen");
    }

    static void testing(){

        System.out.println("--- Welcome to debug mode ---");

        // prepare the menu
        SizeDAO sizeDAO = new SizeDAO(JPAConfiguration.getEntityManager());

        List<Size> sizeList = sizeDAO.selectAll();

        System.out.println("Kies uw pizza size");
        for(Size size : sizeList){
            System.out.println(size.getId() + ". " + size.getSize() + ", SRD " + size.getPrice());
        }
    }
}
