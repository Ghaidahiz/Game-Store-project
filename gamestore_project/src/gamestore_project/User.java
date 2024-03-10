package gamestore_project;

public class User {
private String username;
private int nOfg; //number of games
private double wallet;
private Game[] gameLibrary;


public User(String n,int size, double wallet){
	username =n;
	nOfg=0;
	this.wallet=wallet;
	gameLibrary= new Game[size];//idk about dat
	
}

public boolean buyGame(Game g) { //*** I may need too cast g and make cases for each child of games but this is the basic idea***
	if (g.priceAfterDiscount() <= wallet) {//also I need to check if game exists in library**
		gameLibrary[nOfg++]=g;
		wallet = wallet - g.priceAfterDiscount();
		return true;
	}

	else return false;
	
}



public boolean sendGift(User friend , Game g) {
	if (g.priceAfterDiscount() <= wallet ) {
		friend.gameLibrary[friend.nOfg++]=g;
		this.wallet = this.wallet - g.priceAfterDiscount();
		return true;
	}
	else return false;
	

}

public boolean uninstallGame(String name) {
	for(int i = 0; i<nOfg;i++) {
		if(gameLibrary[i].name.equalsIgnoreCase(name)) {
			gameLibrary[i]=gameLibrary[nOfg-1];
			gameLibrary[--nOfg]=null;
			return true;
		}
		
	}
	return false;
	
}



public Game findGame(String name) {
	for(int i=0;i<nOfg;i++) {
		if(gameLibrary[i].name.equalsIgnoreCase(name)) {
			return gameLibrary[i];
		}

	}
	return null; //if game is not found
	
}

public String getUsername() {
	return username;
}



}
