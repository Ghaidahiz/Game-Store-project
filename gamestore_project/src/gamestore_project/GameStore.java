package gamestore_project;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GameStore {
   Scanner sc = new Scanner(System.in);
   private String name;
   private User[] userList = new User[50];
   private Game[] gameList = new Game[50];
   private Admin[] adminList = new Admin[3];

   private int noUsers;
   private int noGames;

   public GameStore(String name, Admin a1, Admin a2, Admin a3) {
      this.name = name;
      adminList[0] = a1;
      adminList[1] = a2;
      adminList[2] = a3;
      noUsers = 0;
      noGames = 0;
   }

   public boolean userExists(User u) {
      for (int i = 0; i < noUsers; i++) {

         if (userList[i].getUsername().equalsIgnoreCase(u.getUsername())) { // to check the uniqness of username.
            System.out.println("the username already exists");
            return true;
         }
      }
      return false;
   }
   public boolean userExists(String user) {
      for (int i = 0; i < noUsers; i++) {

         if (userList[i].getUsername().equalsIgnoreCase(user)) { // to check the uniqness of username.
            System.out.println("the username already exists");
            return true;
         }
      }
      return false;
   }

   public boolean addUser(User u) {
      if (!userExists(u)) {
         if (noUsers < userList.length) {
            userList[noUsers++] = u;
            return true;
         } else
            System.out.println("can not add user -the store is busy- :( ");
         return false;
      } else {
         System.out.println("the username already exists");
         return false;
      }
   }

   public void removeUser(String username) {
      boolean exist = false;
      int i;
      for (i = 0; i < noUsers; i++)
         if (userList[i].getUsername().equalsIgnoreCase(username)) {
            exist = true;
            break;
         }
      if (exist) {
         userList[i] = userList[noUsers - 1];
         userList[noUsers - 1] = null;
         noUsers--;
         System.out.println("the user -" + username + "- was removed successfully");
      } else
         System.out.println(" remove failed -can not find user with this username: " + username + " -");
   }

   public User findUser(String username) {
      for (int i = 0; i < noUsers; i++)
         if (userList[i].getUsername().equalsIgnoreCase(username))
            return userList[i];
      System.out.println("Sorry.. couldn't find user \"" + username + "\"");
      return null;
   }

   public void AdminExists()
   {


   }

   public boolean gameExists(String name) {
      for (int i = 0; i < noGames; i++){
         if (gameList[i].getName().equalsIgnoreCase(name))
            return true;}
      return false;

   }

   public boolean addGame(Game g) {
         if (noGames < gameList.length) {
            if (g instanceof Detective) {
               gameList[noGames++] = new Detective(g);
               return true;
            }

            else if (g instanceof RPG) {
               gameList[noGames++] = new RPG(g);
               return true;
            }

            else if (g instanceof StoryRich) {
               gameList[noGames++] = new StoryRich(g);
               return true;
            }

            else if (g instanceof Horror) {
               gameList[noGames++] = new Horror(g);
               return true;
            }

            else if (g instanceof Survival) {
               gameList[noGames++] = new Survival(g);
               return true;
            }
            else{
               return false; //not one of the genres "impossible, but we have to cover all cases"
            }
         }
         else{
            System.out.println("can not add Game -the store is full- :( ");
            return false;
         }
     
      
   }
 
   public void removeGame(String name) {
      boolean exist = false;
      int i;
      for (i = 0; i < noGames; i++)
         if (gameList[i].getName().equalsIgnoreCase(name)) {
            exist = true;
            break;
         }
      if (exist) {
         gameList[i] = gameList[noGames- 1];
         gameList[noGames - 1] = null;
         noGames--;
         System.out.println("the Game -" + name + "- was removed successfully");
      
      } else
         System.out.println(" remove fail -can not find Game with this name: " + name + " -");
   }

   public Game searchForGame(String name) {

      for (int i = 0; i < noGames; i++)
         if (gameList[i].getName().equalsIgnoreCase(name))
            return gameList[i];

      System.out.println("cant not find game with the received name :(");
      return null;

   }

   public Game[] getGameList() {
      return gameList;
   }

   public int getNoGames() {
      return noGames;
   }

   public int getNoUsers() {
      return noUsers;
   }

   public Game[] getRPG() {
      int RPGcount = 0, index = 0;
      for (int i = 0; i < noGames; i++) {
         if (gameList[i] instanceof RPG)
            RPGcount++;
      }
      if (RPGcount == 0) {
         System.out.println("there is no games of this genre in the store :(");
      }
      Game[] RPGgame = new Game[RPGcount];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof RPG)
            RPGgame[index++] = gameList[i];
      return RPGgame;
   }

   public Game[] getStoryRich() {
      int SRcount = 0, index = 0;
      for (int i = 0; i < noGames; i++) {
         if (gameList[i] instanceof StoryRich)
            SRcount++;
      }
      if (SRcount == 0) {
         System.out.println("there is no games of this genre in the store :(");
      }
      Game[] SRgame = new Game[SRcount];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof StoryRich)
            SRgame[index++] = gameList[i];
      return SRgame;
   }

   public Game[] getHorror() {
      int HRRcount = 0, index = 0;
      for (int i = 0; i < noGames; i++) {
         if (gameList[i] instanceof Horror)
            HRRcount++;
      }
      if (HRRcount == 0) {
         System.out.println("there is no games of this genre in the store :(");
      }
      Game[] HRRgame = new Game[HRRcount];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Horror)
            HRRgame[index++] = gameList[i];
      return HRRgame;
   }

   public Game[] getDetective() {
      int DETcount = 0, index = 0;
      for (int i = 0; i < noGames; i++) {
         if (gameList[i] instanceof Detective)
            DETcount++;
      }
      if (DETcount == 0) {
         System.out.println("there is no games of this genre in the store :(");
      }
      Game[] DETgame = new Game[DETcount];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Detective)
            DETgame[index++] = gameList[i];
      return DETgame;
   }

   public Game[] getSurvival() {
      int SURcount = 0, index = 0;
      for (int i = 0; i < noGames; i++) {
         if (gameList[i] instanceof Survival)
            SURcount++;
      }
      if (SURcount == 0) {
         System.out.println("there is no games of this genre in the store :(");
      }
      Game[] SURgame = new Game[SURcount];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Survival)
            SURgame[index++] = gameList[i];
      return SURgame;
   }

   public Admin[] getAdminList() {
      return adminList;
   }

   public void displayGames() {
      System.out.println("CHOOSE WHAT DO YOU WANT TO DISPLAY?");
      int selection = 0;
      do {
         try {
            System.out.println(
                  " ~~~~~~~~~~~~~~~~~~~~~~ \n 1-ALL GAMES. \n 2-RPG GAMES. \n 3-DETECTIVE GAMES. \n 4-HORROR GAMES. \n 5-STORY RICH GAMES. \n 6-SURVIVAL GAMES. ");
            selection = sc.nextInt();

            if (selection < 1 || selection > 6) {
               System.out.println("INVALID INPUT , PLEASE ENTER A NUMBER BETWEEN 0 AND 6 ");
            }
         } catch (InputMismatchException e) {
            System.out.println("PLEASE ENTER A DIGIT");
            sc.next();
            selection = -1; // Set selection to -1 to continue loop
         }
      } while (selection < 1 || selection > 6);

      switch (selection) {
      case 1:
         System.out.println("these are all the games in " + name + " store:\n-------------- \n");
         for (int i = 0; i < noGames; i++)
            System.out.println(gameList[i]);
         break;

      case 2:
         System.out.println("these are all the games of type RPG in " + name + " store:\n-------------- \n");
         Game[] RPGGame = getRPG();
         for (int i = 0; i < RPGGame.length; i++)
            System.out.println(RPGGame[i]);
         break;

      case 3:
         System.out.println("these are all the games of type Detective in " + name + " store:\n-------------- \n");
         Game[] DetectiveGame = getDetective();
         for (int i = 0; i < DetectiveGame.length; i++)
            System.out.println(DetectiveGame[i]);
         break;

      case 4:
         System.out.println("these are all the games of type Horror in " + name + " store:\n-------------- \n");
         Game[] HorrorGame = getHorror();
         for (int i = 0; i < HorrorGame.length; i++)
            System.out.println(HorrorGame[i]);
         break;

      case 5:
         System.out.println("these are all the games of type Story-rich in " + name + " store:\n-------------- \n");
         Game[] SRGame = getStoryRich();
         for (int i = 0; i < SRGame.length; i++)
            System.out.println(SRGame[i]);
         break;

      case 6:
         System.out.println("these are all the games of type Survival in " + name + " store:\n-------------- \n");
         Game[] SurvivalGame = getSurvival();
         for (int i = 0; i < SurvivalGame.length; i++)
            System.out.println(SurvivalGame[i]);
         break;
      }
   }
  
   public void displayAllUsers(){
		for(int i=0; i<noUsers;i++){
         System.out.println("\n " + userList[i].toString());

      }

	}
}
