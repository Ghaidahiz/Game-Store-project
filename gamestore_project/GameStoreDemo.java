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
        int check;

        do {
            System.out.println("ARE YOU A .. \n 1- USER? \n 2-ADMIN?");
            check = sc.nextInt();
            User u1;
            if (check == 1) {

                System.out.println("PLEASE ENTER YOUR NAME :");
                String name = sc.next();
                if (GEA.findUser(name) == null) {
                    System.out.println("WELCOME TO OUR STORE , PLEASE FILL THE NEXT INFORMATION");
                    System.out.println("PLEASE ENTER YOUR WALLET AMOUNT :");
                    double wallet = sc.nextDouble();

                     u1 = new User(name, wallet);
                     GEA.addUser(u1);
                } else if (GEA.findUser(name) != null) {
                     u1 = GEA.findUser(name);
                    System.out.println("WELCOME BACK !");
                }

                System.out.println(" PLEASE SELECT NUMBER OF SERVICE THAT YOU WANT : ");
                System.out.println(
                        "1- BUY A GAME ? \n 2-SEND GIFT TO A FRIEND ? \n 3-UNINSTALL GAME ? \n 4- FIND GAME ?");
                int choice = sc.nextInt();

                while (choice < 0 && choice > 4) {
                    System.out.println("WRONG INPUT , PLEASE TRY AGAIN ?");
                    System.out.println(
                            "1- BUY A GAME ? \n 2-SEND GIFT TO A FRIEND ? \n 3-UNINSTALL GAME ? \n 4- FIND GAME ? \n 5-SHOW ALL GAMES IN LIBRARY ? \n 0-EXIT ?");
                    choice = sc.nextInt();
                }

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
                    (GEA.findUser(name)).findGame(Gname);
                    break;

                case 5:
                (GEA.findUser(name)).toString();
                    break;

                case 0:
                    System.exit(0);
                    break;
                }




            } else if (check == 2) {




            } else


                System.out.println("invalid input , try again..");

        } while (check != 1 && check != 2);
    }}




