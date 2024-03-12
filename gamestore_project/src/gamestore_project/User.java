package gamestore_project;

public class User {
	private String username;
	private int numberOfGames;
	private double wallet;
	private Game[] gameLibrary = new Game[50];

	public User(String n, double wallet) {
		username = n;
		numberOfGames = 0;
		this.wallet = wallet;

	}

	public void buyGame(Game g) {
		if (g == null) {
			System.out.println("the game that you want to purchase doesn't exist in this gamestore");
		}
		else if (g.priceAfterDiscount() <= wallet) {
			gameLibrary[numberOfGames++] = g;
			wallet = wallet - g.priceAfterDiscount();
		} else {
			System.out.println("You don't have enough funds in your wallet, can't complete purchase");
		}

	}

	public void sendGift(User friend, Game g) {
		if (g == null || friend == null)
			return;
		if (friend.numberOfGames < friend.gameLibrary.length) {
			if (g.priceAfterDiscount() <= wallet) {
				friend.gameLibrary[friend.numberOfGames++] = g;
				this.wallet = this.wallet - g.priceAfterDiscount();
			} else {
				System.out.println("You don't have enough funds in your wallet, can't complete purchase");
			}
		} else {
			System.out.println("the recipient's library is full");

		}
	}

	public void uninstallGame(String name) {
		for (int i = 0; i < numberOfGames; i++) {
			if (gameLibrary[i].getName().equalsIgnoreCase(name)) {
				gameLibrary[i] = gameLibrary[numberOfGames - 1];
				gameLibrary[--numberOfGames] = null;
				System.out.println(name + " was removed successfully");
				return;
			}

		}
		System.out.println(name + " doesn't exist in your library");
		return;

	}

	public Game findGame(String name) {
		for (int i = 0; i < numberOfGames; i++) {
			if (gameLibrary[i].getName().equalsIgnoreCase(name)) {
				System.out.println(name + " exists in your library");
				return gameLibrary[i];
			}

		}
		System.out.println(name + " doesn't exist in your library");
		return null; // if game is not found

	}

	public String getUsername() {
		return username;
	}

	public Game[] getGameLibrary() {
		return gameLibrary;
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}
	
	public String toString() {
		String gamesInLibrary="";
		for(int i=0;i<numberOfGames;i++)
			gamesInLibrary+=gameLibrary[i].toString();
		return "\nUsername: "+username+"\nThe amount of fund in your wallet: "+wallet+"\n Number of games in your library: "+numberOfGames+"Games in your library:\n"+gamesInLibraray;
	}
}
