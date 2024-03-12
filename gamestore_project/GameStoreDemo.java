package gamestore_project;

import java.util.*;

public class GameStoreDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Admin Almaha = new Admin("Almaha", "123");
        Admin Eman = new Admin("Eman", "321");
        Admin Ghaida = new Admin("Ghaida", "213");

        GameStore GEA = new GameStore("GEA", Almaha, Eman, Ghaida);
        System.out.println("GEA GAME STORE");
        int check = 0;

        do {
            System.out.println("ARE YOU A .. \n 1- USER? \n 2-ADMIN? \n 3-EXIT?");
            try {
                check = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("PLEASE ENTER A DIGIT");
                sc.next();
                check = 0;
            }
            User u1;
            if (check == 1) {

                System.out.println("PLEASE ENTER YOUR NAME :");
                String name = sc.next();
                if (GEA.findUser(name) == null) {
                    System.out.println("\nWELCOME TO OUR STORE , PLEASE FILL OUT THE NEXT INFORMATION");
                    System.out.println("PLEASE ENTER YOUR WALLET AMOUNT :");
                    double wallet = sc.nextDouble();

                    u1 = new User(name, wallet);
                    GEA.addUser(u1);
                } else if (GEA.findUser(name) != null) {
                    u1 = GEA.findUser(name);
                    System.out.println("WELCOME BACK !");
                }
                int choice ;
                do{
                 do {

                    try {
                        System.out.println(" \nPLEASE SELECT NUMBER OF SERVICE THAT YOU WANT : ");
                        System.out.println(
                                "1- BUY A GAME ? \n 2-SEND GIFT TO A FRIEND ? \n 3-UNINSTALL GAME ? \n 4- FIND GAME ? \n 5-SHOW ALL GAMES IN LIBRARY ? \n 6-SHOW GAMES OF GEA STORE ? \n 0-LOG OUT ?");
                        choice = sc.nextInt();
                        sc.nextLine();

                        if (choice < 0 || choice > 6) {
                            System.out.println("INVALID INPUT , PLEASE ENTER A NUMBER BETWEEN 0 AND 6 ");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("PLEASE ENTER A DIGIT");
                        sc.next();
                        choice = -1; // Set choice to -1 to continue loop
                    }
                } while (choice < 0 || choice > 6);
                
                switch (choice) {
                case 1:
                    System.out.println("ENTER THE NAME OF THE GAME ..");
                    String Gname = sc.nextLine();
                    (GEA.findUser(name)).buyGame(GEA.searchForGame(Gname));
                    break;

                case 2:
                    System.out.println(" ENTER THE NAME OF YOUR FRIEND ACCOUNT AND THE NAME OF THE WANTED GAME");
                    String Fname = sc.nextLine();
                    Gname = sc.nextLine();
                    (GEA.findUser(name)).sendGift(GEA.findUser(Fname), GEA.searchForGame(Gname));

                    break;

                case 3:
                    System.out.println("ENTER THE NAME OF THE GAME YOU WANT TO UNINSTALL..");
                    Gname = sc.nextLine();
                    (GEA.findUser(name)).uninstallGame(Gname);
                    break;

                case 4:
                    System.out.println("ENTER THE NAME OF THE GAME YOU WANT TO FIND IN YOUR LIBRARY ..");
                    Gname = sc.nextLine();
                    GEA.findUser(name).findGame(Gname);
                    break;

                case 5:
                    System.out.println("THESE ARE YOUR LIBRARY'S GAMES:");
                    Game[] library = (GEA.findUser(name)).getGameLibrary();
                    for (int i = 0; i < (GEA.findUser(name)).getNumberOfGames(); i++)
                        System.out.println(library[i]);
                    break;

                case 6:
                    GEA.displayGames();
                    break;

                case 0:
                    
                    break;
                }
            }while(choice !=0);

            } else if (check == 2) {
                boolean isAdmin = false;
                String name = "";

                while (isAdmin == false) {

                    System.out.println("PLEASE ENTER YOUR NAME :");
                    name = sc.nextLine();

                    for (int i = 0; i < GEA.getAdminList().length; i++) {

                        if (GEA.getAdminList()[i].getUsername().equalsIgnoreCase(name)) {

                            System.out.println("WELCOME BACK! , PLEASE ENTER YOUR PASSWORD");
                            String password = sc.nextLine();

                            if (GEA.getAdminList()[i].getPassword().equals(password)) {
                                isAdmin = true;
                                break;
                            } else {
                                System.out.println("INCORRECT PASSWORD, PLEASE TRY AGAIN");
                            }

                        } else if (!(GEA.getAdminList()[i].getUsername().equalsIgnoreCase(name))){
                            System.out.println("INCORRECT USERNAME, PLEASE TRY AGAIN");
                        }
                    }
                }
                int choice = 0;
                do {
                System.out.println("HELLO ADMIN " + name + " PLEASE SELECT THE SERVICE THAT YOU WANT ");
                do {

                    try {
                        System.out.println(
                                "1- ADD A GAME TO THE STORE ? \n 2- REMOVE A GAME FROM THE STORE ? \n 3- SEARCH FOR A GAME ? \n 4- DISPLAY GAMES ? \n 5-LOG OUT?");
                        choice = sc.nextInt();
                        sc.nextLine();

                        if (choice < 1 || choice > 5) {
                            System.out.println("INVALID INPUT , PLEASE ENTER A NUMBER BETWEEN 1 AND 6 ");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("PLEASE ENTER A DIGIT");
                        sc.next();
                        choice = -1; // Set choice to -1 to continue loop
                    }
                } while (choice < 0 || choice > 5);

                switch (choice) {
                case 1:
                    int GGenre = 0;
                    System.out.println("ENTER THE GAME'S NAME");
                    String Gname = sc.nextLine();
                    System.out.println("ENTER THE GAME'S PUBLISHER");
                    String Gpub = sc.nextLine();
                    System.out.println("ENTER THE GAME'S PRICE");
                    double Gprice = sc.nextDouble();
                    sc.nextLine();

                    do {
                        try {
                            System.out.println("ENTER THE GAME'S GENRE");
                            System.out.println(
                                    "1- Detective ? \n 2- Horror ? \n 3- RPG ? \n 4- Story-rich ? \n 5- Survival ?");
                            GGenre = sc.nextInt();
                            sc.nextLine();

                            if (GGenre < 1 || GGenre > 5) {
                                System.out.println("INVALID INPUT , PLEASE ENTER A NUMBER BETWEEN 0 AND 5 ");
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("PLEASE ENTER A DIGIT");
                            sc.next();
                            GGenre = -1; // Set GGenre to -1 to continue loop
                        }
                    } while (GGenre < 1 || GGenre > 5);

                    switch (GGenre) {
                    case 1:
                        Game game = new Detective(Gname, Gpub, Gprice);
                        GEA.addGame(game);
                        break;
                    case 2:
                        game = new Horror(Gname, Gpub, Gprice);
                        GEA.addGame(game);
                        break;
                    case 3:
                        game = new RPG(Gname, Gpub, Gprice);
                        GEA.addGame(game);
                        break;
                    case 4:
                        game = new StoryRich(Gname, Gpub, Gprice);
                        GEA.addGame(game);
                        break;
                    case 5:
                        game = new Survival(Gname, Gpub, Gprice);
                        GEA.addGame(game);
                    }
                    break;
                case 2:
                    System.out.println("ENTER THE GAME'S NAME");
                    Gname = sc.nextLine();
                    GEA.removeGame(Gname);

                    break;
                case 3:
                    System.out.println("ENTER THE GAME'S NAME");
                    Gname = sc.nextLine();
                   System.out.println( GEA.searchForGame(Gname));
                    break;
                case 4:
                    GEA.displayGames();
                    break;
                case 5: 
                	break;
                }
              }while(choice!=5);
            } else if(check!=3)

                System.out.println("invalid input , try again..");

        } while (check != 3);

    }
}