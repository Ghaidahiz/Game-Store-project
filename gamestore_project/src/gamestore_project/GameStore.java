package gamestore_project;

public class GameStore {
private String name;
private User[] userList=new User[50];
private Game[] gameList=new Game [50];
private Admin[] adminList =new Admin[3];

private int noUsers;
private int noGames;

public GameStore(String name,Admin a1, Admin a2, Admin a3){
this.name=name;
adminList[0]=a1;
adminList[1]= a2; 
adminList[2]= a3;
noUsers =0;
noGames =0;
}


public void addUser(User u){
for(int i=0; i<noUsers ;i++){   
   if (userList[i] == u){            // to check if the user is already exist in the array or not , because we dont want to add a user twice.                                                               
      System.out.println("can  not add user because it's already exist in Game Stors");
      return ;}
   if (userList[i].getUsername().equals(u.getUsername()) ) {    //to check the uniqness of username.
       System.out.println("can not add user ,the username is used by another user please try another one");
       return;}}
if(noUsers < userList.length ){
  userList[noUsers++] = u ;
  System.out.println("the user was added successfully :) ");}
else System.out.println("can not add user -the array is full- :( ");
}


public void removeUser(String username){
boolean exist= false; int i;
for(i=0; i<noUsers; i++)
   if(userList[i].getUsername().equals(username) ){
     exist =true;
     break;}
if(exist){
  userList[i]=userList[noUsers-1] ;
  userList[noUsers-1]=null;
  noUsers--;
  System.out.println("the user -"+username+"- was removed successfully");}
else System.out.println (" remove fail -can not find user with this username: "+username+" -");}    
   
public User findUser(String username ){
 for (int i=0; i<noUsers; i++)
     if(userList[i].getUsername().equals(username) )
       return userList[i];
  System.out.println("there is no user with this username: "+username);
  return null ;}
  

private boolean checkGame(String name) 
{  
   for(int i=0; i<noGames ;i++)
      if (gameList[i].getName().equals(name))
      return false;
       return true;
		
}

public void addGame(Game g) { 
    if(checkGame(name)){
   if(noGames<gameList.length){
      if(g instanceof Detective)
    	  gameList[noGames++] = new Detective(g);
      else if(g instanceof RPG)
    	  gameList[noGames++] = new RPG(g);
      else if(g instanceof StoryRich)
    	  gameList[noGames++] = new StoryRich(g);
      else if(g instanceof Horror)
    	  gameList[noGames++] = new Horror(g);
      else if(g instanceof Survival)
    	  gameList[noGames++] = new Survival(g);
      System.out.println("the Game was added successfully :) ");}
   
   else System.out.println("can not add Game -the array is full- :( ");}	
}


public boolean removeGame(String name) {
	boolean exist= false; int i;
	for(i=0; i<noGames; i++)
	   if(gameList[i].getName().equals(name) ){
	     exist =true;
	     break;}
	if(exist){
	  gameList[i]=gameList[noGames--] ;
	  gameList[noGames]=null;
	  System.out.println("the Game -"+name+"- was removed successfully");
   return true;}
	else System.out.println (" remove fail -can not find Game with this name: "+name+" -");
return false;}    
	   


public Game searchForGame(String name) {
	
	for(int i =0 ; i< noGames ;i++)
	if(gameList[i].getName().equals(name) )
		return gameList[i];
	
   System.out.println("cant not find game with the received name :(");
	  return null;
        
}
    
     
 
public Game[] searchForGamepub ( String publisher ){
 int counter=0, x=0;
for (int i=0; i < noGames; i++)
     if( gameList[i].getPublisher().equalsIgnoreCase(publisher) ) 
        counter++;
Game [] game = new Game[counter];
for (int i=0; i < noGames; i++)
    if( gameList[i].getPublisher().equalsIgnoreCase(publisher) ) 
       game[x++]= gameList[i];
return game; }


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


public Game[] getStoryRich(){
int count=0, x=0;
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof StoryRich)
      count++;
Game[] SRgame= new Game[count];
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof StoryRich)
      SRgame[x++]=gameList[i];
return SRgame;}


public Game[] getHorror(){
int count=0, x=0;
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof Horror)
      count++;
Game[] Hgame= new Game[count];
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof Horror)
      Hgame[x++]=gameList[i];
return Hgame;}


public Game[] getDetective(){
int count=0, x=0;
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof Detective)
      count++;
Game[] Dgame= new Game[count];
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof Detective)
      Dgame[x++]=gameList[i];
return Dgame;}


public Game[] getSurvival(){
int count=0, x=0;
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof Survival)
      count++;
Game[] Sgame= new Game[count];
for(int i=0; i<noGames ; i++)
   if( gameList[i] instanceof Survival)
      Sgame[x++]=gameList[i];
return Sgame;}




}
