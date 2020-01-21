package sr.unasat.jpa.pizza_store.app;

import sr.unasat.jpa.pizza_store.builder.PizzaBuilder;
import sr.unasat.jpa.pizza_store.config.JPAConfiguration;
import sr.unasat.jpa.pizza_store.dao.*;
import sr.unasat.jpa.pizza_store.decorator.BasicOrder;
import sr.unasat.jpa.pizza_store.decorator.ExtraCheese;
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
        List<User> userList = userDAO.selectAll();

        if (user != null) {
            System.out.println("Welkom terug " + user.getUsername());
            // check voor de role van de ingelogde gebruiker
            switch(user.getRole().getId()){
                case 1:
                case 2:
                    adminMenu();
                    break;
                case 3:
                    System.out.println("--- MENU ---");
                    System.out.println("Wat wilt u nu doen?\n" +
                            "1. Bestelling Management\n" +
                            "2. Profiel bewerken");
                    System.out.println("--- MENU ---");
                    Scanner optionRead = new Scanner(System.in);
                    int optionChosen = optionRead.nextInt();
                    if(optionChosen == 1){
                        bestellingManagement(user);
                    } else if (optionChosen == 2){

                        boolean done = false;
                        while(!done){
                            System.out.println("Wat wilt u wijzigen?\n" +
                                    "1. Gebruikersnaam\n" +
                                    "2. Wachtwoord");
                            Scanner optionRead1 = new Scanner(System.in);
                            int optionChosen1 = optionRead1.nextInt();
                            if(optionChosen1 == 1) {
                                System.out.println("Nieuwe gebruikersnaam");
                                Scanner newUsernameRead = new Scanner(System.in);
                                String newUsername = newUsernameRead.nextLine();
                                user.setUsername(newUsername);
                            } else if(optionChosen1 == 2) {
                                System.out.println("Nieuwe wachtwoord");
                                Scanner newPasswordRead = new Scanner(System.in);
                                String newPassword = newPasswordRead.nextLine();
                                System.out.println("Nieuwe wachtwoord herhalen");
                                Scanner newPasswordRepeatedRead = new Scanner(System.in);
                                String newPasswordRepeated = newPasswordRepeatedRead.nextLine();

                                if(newPassword.equals(newPasswordRepeated)){
                                    user.setPassword(newPassword);
                                }
                            }

                            System.out.println("Uw gebruiker wordt geupdated");
                            userDAO.update(user);
                        }
                    } else {
                        System.out.println("Ongeldige optie gekozen");
                    }
                    break;
            }
        } else {
            System.out.println("Gebruikersnaam of Wachtwoord niet juist, probeer opnieuw");
            // start the logica opnieuw
            loginService();
        }
    }

    static void adminMenu(){
        UserDAO userDAO = new UserDAO(JPAConfiguration.getEntityManager());
        List<User> userList = userDAO.selectAll();
        System.out.println("--- MENU ---");
        System.out.println("Wat wilt u nu doen?\n" +
                "1. Bestelling Management\n" +
                "2. Analytics\n" +
                "3. Gebruiker Management (Coming soon ...)\n" +
                "4. Topping Mangement");
        System.out.println("--- MENU ---");
        Scanner menuRead = new Scanner(System.in);
        int choice = menuRead.nextInt();

        switch (choice){
            case 1:
                System.out.println("Kies de gebruikers ID uit de onderstaande lijst om verder te gaan");
                for(User user1 : userList){
                    System.out.println(user1.getId() + " " + user1.getUsername());
                }
                Scanner userRead = new Scanner(System.in);
                int userChosen = userRead.nextInt();
                User user1 = userDAO.selectOne(userChosen);
                bestellingManagement(user1);
                break;
            case 2:
                analytics();
                break;
            case 3:
                userManagement();
                break;
            case 4:
                toppingsMangement();
        }
    }

    static void toppingsMangement(){
        ToppingDAO toppingDAO = new ToppingDAO(JPAConfiguration.getEntityManager());

        System.out.println("Wat wilt u doen?\n" +
                "1. Nieuwe topping toevoegen?\n" +
                "2. Topping verwijderen");
        Scanner optionRead2 = new Scanner(System.in);
        int option2 = optionRead2.nextInt();
        switch(option2){
            case 1:
                Topping topping = new Topping();
                System.out.println("Naam van de topping");
                Scanner optionRead3 = new Scanner(System.in);
                String option3 = optionRead3.nextLine();
                topping.setTopping(option3);

                System.out.println("Prijs van de topping");
                Scanner optionRead4 = new Scanner(System.in);
                double option4 = optionRead4.nextDouble();
                topping.setPrice(option4);

                toppingDAO.insert(topping);
                break;
            case 2:
                System.out.println("Kies de topping om verwijderd te worden");
                Scanner optionRead5 = new Scanner(System.in);
                int option5 = optionRead5.nextInt();
                Topping topping1 = toppingDAO.selectOne(option5);
                toppingDAO.delete(topping1);
                break;
        }

        // back to the admin menu
        adminMenu();
    }

    static void userManagement(){
        System.out.println("Coming soon ...");
    }

    static void analytics() {
        RapportageDAO rapportageDAO = new RapportageDAO(JPAConfiguration.getEntityManager());

        boolean done = false;
        while(!done){

            System.out.println("Wat wilt u bezichtigen?\n" +
                    "1. Inkomsten per jaar\n" +
                    "2. Inkomsten per jaar per maand\n" +
                    "3. Inkomsten per klant per jaar per maand\n" +
                    "4. Beste uitgekozen pizza per jaar per maand\n" +
                    "5. Best uitgekozen toppings");
            Scanner optionRead = new Scanner(System.in);
            int option = optionRead.nextInt();
            switch(option){
                case 1:
                    rapportageDAO.incomePerYear();
                    break;
                case 2:
                    rapportageDAO.incomePerYearPerMonth();
                    break;
                case 3:
                    rapportageDAO.incomePerCustomer();
                    break;
                case 4:
                    rapportageDAO.bestChosenPizzaType();
                    break;
                case 5:
                    rapportageDAO.bestChosenPizzaTopping();
                    break;
                default:
                    break;
            }

            System.out.println("Wat nu?\n" +
                    "1. Een ander rapportage bekijken\n" +
                    "2. Terug naar hoofdmenu");
            Scanner optionRead2 = new Scanner(System.in);
            int option2 = optionRead2.nextInt();
            if(option2 == 2){
                adminMenu();
            }
        }


    }

    static void bestellingManagement(User user){
        boolean done = false;
        while(!done){
            OrderDAO orderDAO = new OrderDAO(JPAConfiguration.getEntityManager());
            System.out.println("--- MENU ---");
            System.out.println("Wat wilt u doen?\n" +
                    "1. Een nieuwe bestelling plaatsen?\n" +
                    "2. Alle bestellingen bezichtigen?\n" +
                    "3. Een specifieke bestelling opzoeken?");
            System.out.println("--- MENU ---");
            Scanner optionRead = new Scanner(System.in);
            int optionChosen = optionRead.nextInt();

            switch(optionChosen){
                case 1:
                    placeNewOrder(user);
                    break;
                case 2:
                    List<Order> orderList = orderDAO.selectAllByUser(user);
                    for(Order order : orderList){
                        System.out.println("Order # " + order.getId() + "\n" +
                                "Bestelling geplaatst op " + order.getDateCreated() + "\n" +
                                "Totaal gekost SRD" + order.getPrice());
                    }
                    break;
                case 3:
                    System.out.println("Kies de order nummer uit doe u wilt zoeken");
                    Scanner orderNumberRead = new Scanner(System.in);
                    int orderNumberChosen = orderNumberRead.nextInt();
                    Order order = orderDAO.selectOne(orderNumberChosen);
                    System.out.println("Order # " + order.getId() + "\n" +
                            "Bestelling geplaatst op " + order.getDateCreated() + "\n" +
                            "Totaal gekost SRD" + order.getPrice());
                    break;
            }

            System.out.println("--- MENU ---");
            System.out.println("Wat nu?\n" +
                    "1. Applicatie afsluiten\n" +
                    "*. Terug naar de menu");
            System.out.println("--- MENU ---");
            Scanner doneRead = new Scanner(System.in);
            int doneChosen = doneRead.nextInt();
            if(doneChosen == 1) {
                System.out.println("Bye :)");
                done = true;
            }
        }
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

//            // DECORATOR PATTERN
//            sr.unasat.jpa.pizza_store.decorator.Order basicOrder = new ExtraCheese(new BasicOrder());

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
        pizzaBuilder.setUser(user);
        Order order = pizzaBuilder.getResult();
        Order insertedOrder = orderDAO.insert(order);
        System.out.println("Uw order nummer is " + insertedOrder.getId());
    }
}
