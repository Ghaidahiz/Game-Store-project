package gamestore_project;

public class User {
private String username;
private int nOfg; //number of games
private double wallet;
private Game[] gameLibrary = new Game[50];


public User(String n, double wallet){
	username =n;
	nOfg=0;
	this.wallet=wallet;
	
}

public boolean buyGame(Game g) {
	if(g==null)
		return false;
	if (g.priceAfterDiscount() <= wallet) {
		gameLibrary[nOfg++]=g;
		wallet = wallet - g.priceAfterDiscount();
		return true;
	}

	else return false;
	
}



public boolean sendGift(User friend , Game g) {
	if (g==null || friend==null)
		return false;
	
	if (g.priceAfterDiscount() <= wallet && friend.nOfg < friend.gameLibrary.length) {
		friend.gameLibrary[friend.nOfg++]=g;
		this.wallet = this.wallet - g.priceAfterDiscount();
		return true;
	}
	else return false;
	

}

public boolean uninstallGame(String name) {
	for(int i = 0; i<nOfg;i++) {
		if(gameLibrary[i].getName().equalsIgnoreCase(name)) {
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
