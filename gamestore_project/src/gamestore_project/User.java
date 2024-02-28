package gamestore_project;

public class User {
private String username;
private int nOfg; //number of games
private double wallet;
private Game[] gameLibrary;


public User(String n, int no, double wallet){}
public boolean buyGame(Game g) {}

public boolean sendGift(String username , Game g) {}

public boolean uninstallGame(String name) {}

public Game findGame(String name) {}

public String getUsername() {
	return username;
}



}
