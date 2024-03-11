package gamestore_project;

public class GameStore {
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

   public void addUser(User u) {
      for (int i = 0; i < noUsers; i++) {
         if (userList[i] == u) { // to check if the user is already exist in the array or not , because we dont
                                 // want to add a user twice.
            System.out.println("can  not add user because it's already exist in Game Stors");
            return;
         }
         if (userList[i].getUsername().equals(u.getUsername())) { // to check the uniqness of username.
            System.out.println("can not add user ,the username is used by another user please try another one");
            return;
         }
      }
      if (noUsers < userList.length) {
         userList[noUsers++] = u;
         System.out.println("the user was added successfully :) ");
      } else
         System.out.println("can not add user -the array is full- :( ");
   }

   public void removeUser(String username) {
      boolean exist = false;
      int i;
      for (i = 0; i < noUsers; i++)
         if (userList[i].getUsername().equals(username)) {
            exist = true;
            break;
         }
      if (exist) {
         userList[i] = userList[noUsers - 1];
         userList[noUsers - 1] = null;
         noUsers--;
         System.out.println("the user -" + username + "- was removed successfully");
      } else
         System.out.println(" remove fail -can not find user with this username: " + username + " -");
   }

   public User findUser(String username) {
      for (int i = 0; i < noUsers; i++)
         if (userList[i].getUsername().equals(username))
            return userList[i];
      System.out.println("there is no user with this username: " + username);
      return null;
   }

   private boolean checkGame(String name) {
      for (int i = 0; i < noGames; i++)
         if (gameList[i].getName().equals(name))
            return false;
      return true;

   }

   public void addGame(Game g) {
      if (checkGame(name)) {
         if (noGames < gameList.length) {
            if (g instanceof Detective)
               gameList[noGames++] = new Detective(g);
            else if (g instanceof RPG)
               gameList[noGames++] = new RPG(g);
            else if (g instanceof StoryRich)
               gameList[noGames++] = new StoryRich(g);
            else if (g instanceof Horror)
               gameList[noGames++] = new Horror(g);
            else if (g instanceof Survival)
               gameList[noGames++] = new Survival(g);
            System.out.println("the Game was added successfully :) ");
         }

         else
            System.out.println("can not add Game -the array is full- :( ");
      }
   }

   public boolean removeGame(String name) {
      boolean exist = false;
      int i;
      for (i = 0; i < noGames; i++)
         if (gameList[i].getName().equals(name)) {
            exist = true;
            break;
         }
      if (exist) {
         gameList[i] = gameList[noGames--];
         gameList[noGames] = null;
         System.out.println("the Game -" + name + "- was removed successfully");
         return true;
      } else
         System.out.println(" remove fail -can not find Game with this name: " + name + " -");
      return false;
   }

public Game searchForGame(String name) {
	
	for(int i =0 ; i< noGames ;i++)
	if(gameList[i].getName().equals(name) )
		return gameList[i];
	
   System.out.println("cant not find game with the received name :(");
	  return null;
        
}
    
public Game[] getGameList() { return gameList ;}

public int getNoUsers() {return noUsers;}


public Game[] getRPG(){
int count=0, x=0;
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof RPG)
      count++;
Game[] RPGgame= new Game[count];
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof RPG)
      RPGgame[x++]=gameList[i];
return RPGgame;}

   public Game[] getStoryRich() {
      int count = 0, x = 0;
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof StoryRich)
            count++;
      Game[] SRgame = new Game[count];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof StoryRich)
            SRgame[x++] = gameList[i];
      return SRgame;
   }

   public Game[] getHorror() {
      int count = 0, x = 0;
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Horror)
            count++;
      Game[] Hgame = new Game[count];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Horror)
            Hgame[x++] = gameList[i];
      return Hgame;
   }

   public Game[] getDetective() {
      int count = 0, x = 0;
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Detective)
            count++;
      Game[] Dgame = new Game[count];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Detective)
            Dgame[x++] = gameList[i];
      return Dgame;
   }

   public Game[] getSurvival() {
      int count = 0, x = 0;
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Survival)
            count++;
      Game[] Sgame = new Game[count];
      for (int i = 0; i < noGames; i++)
         if (gameList[i] instanceof Survival)
            Sgame[x++] = gameList[i];
      return Sgame;
   }
   public Admin[] getAdminList() {
       return adminList;
   }

   public void displayGames(int selection) {
      
      switch(selection) {
      case 1:
         System.out.println("this is all games in GEA STORE:\n--------------");
          for (int i=0; i<noGames; i++)
            System.out.println(gameList[i]);
           break;
              
       case 2:	
          System.out.println("this is all games of type RPG in GEA STORE:\n--------------");
          Game[] RPGGame= getRPG();
          for (int i=0; i<RPGGame.length; i++)
            System.out.println(RPGGame[i]);
           break;
           
       case 3:
          System.out.println("these are all games of type Detective in GEA STORE:\n--------------");
          Game[] DetectiveGame= getDetective();
          for (int i=0; i<DetectiveGame.length; i++)
          System.out.println(DetectiveGame[i]);
           break;
           
       case 4: 
          System.out.println("this is all games of type Horror in GEA STORE:\n--------------");
          Game[] HorrorGame= getHorror();
          for (int i=0; i<HorrorGame.length; i++)
          System.out.println(HorrorGame[i]);
           break;
           
       case 5: 
          System.out.println("this is all games of type Story Rich in GEA STORE:\n--------------");
          Game[] SRGame= getStoryRich();
          for (int i=0; i<SRGame.length; i++)
          System.out.println(SRGame[i]);
           break;
          
       case 6:
          System.out.println("this is all games of type Survival in GEA STORE:\n--------------");
          Game[] SurvivalGame= getSurvival();
          for (int i=0; i<SurvivalGame.length; i++)
          System.out.println(SurvivalGame[i]);
           break; }    
   }

}
