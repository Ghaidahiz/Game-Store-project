package gamestore_project;

import java.util.Scanner;

public class User {
	private String username;
	private int numberOfGames;
	private double wallet;
	private Game[] gameLibrary = new Game[50];
	Scanner sc = new Scanner(System.in);

	public User(String n, double wallet) {
		username = n;
		numberOfGames = 0;
		this.wallet = wallet;

	}

	public void buyGame(Game g) {
		boolean existsInLibrary = false;
		if (g == null) {
			System.out.println("THE GAME THAT YOU WANT TO PURCHASE DOESN'T EXIST IN THIS GAMESTORE");
			return; // to avoid using g if it's null
		}

		else {
			for (int i = 0; i < numberOfGames; i++) {
				if (gameLibrary[i].getName().equalsIgnoreCase(g.getName())) {
					existsInLibrary = true;
					System.out.println(" \n SORRY, BUT THIS GAME ALREADY EXISTS IN YOUR LIBRARY :/ ");
				}
			}
		}

		if (existsInLibrary == false) {
			if (numberOfGames < gameLibrary.length) {
				if (g.priceAfterDiscount() <= wallet) {
					gameLibrary[numberOfGames++] = g;
					wallet = wallet - g.priceAfterDiscount();
					System.out.println("\n THANK YOU FOR PURCHASING " + g.getName() + "!!");

				} else {
					System.out.println("\n YOU DON'T HAVE ENOUGH FUNDS IN YOUR WALLET, CAN'T COMPLETE PURCHASE :( ");
				}
			} else
				System.out.println("\nSORRY, YOUR LIBRARY IS FULL");
		}

	}

	public void sendGift(User friend, Game g) {
		boolean existsInLibrary = false;
		if (g == null || friend == null) {
			return;
		}

		else {
			for (int i = 0; i < friend.numberOfGames; i++) {
				if (friend.gameLibrary[i].getName().equalsIgnoreCase(g.getName())) {
					existsInLibrary = true;
					System.out.println(
							" \n SORRY, BUT THIS GAME ALREADY EXISTS IN " + friend.getUsername() + " LIBRARY :/ ");
				}
			}
		}

		if (existsInLibrary == false) {
			if (friend.numberOfGames < friend.gameLibrary.length) {
				if (g.priceAfterDiscount() <= wallet) {
					friend.gameLibrary[friend.numberOfGames++] = g;
					wallet = wallet - g.priceAfterDiscount();
					System.out.println("\n YOUR GIFT ( " + g.getName() + " ) WAS SENT SUCCESSFULLY TO "
							+ friend.getUsername() + " !!");

				} else {
					System.out.println("\n YOU DON'T HAVE ENOUGH FUNDS IN YOUR WALLET, CAN'T COMPLETE PURCHASE :( ");
				}
			} else
				System.out.println("\nTHE RECIPIENT'S LIBRARY IS FULL");
		}
	}

	/*
	 * if (friend.numberOfGames < friend.gameLibrary.length) { if
	 * (g.priceAfterDiscount() <= wallet) {
	 * friend.gameLibrary[friend.numberOfGames++] = g; this.wallet = this.wallet -
	 * g.priceAfterDiscount(); } else { System.out.
	 * println("You don't have enough funds in your wallet, can't complete purchase"
	 * ); } } else { System.out.println("the recipient's library is full");
	 * 
	 * 
	 * } }
	 */
	public void removeGameFromLibrary(String name) {
		System.out.println(
				"\n the game is not refundable, once you remove a game you will lose access to it unless you buy it again..\n");
		System.out.println("\n do you want to proceed?...\n enter: \n \"y\"- yes, \"n\"- no \n");
		String proceed = sc.nextLine();
		if (proceed.equalsIgnoreCase("y")) {

			for (int i = 0; i < numberOfGames; i++) {
				if (gameLibrary[i].getName().equalsIgnoreCase(name)) {
					gameLibrary[i] = gameLibrary[numberOfGames - 1];
					gameLibrary[--numberOfGames] = null;
					System.out.println(name + " WAS REMOVED SUCCESSFULLY");
					return;
				}

			}
			System.out.println(name + " DOESN'T EXIST IN YOUR LIBRARY");
			return;

		}
		return;
	}

	public Game findGame(String name) {
		for (int i = 0; i < numberOfGames; i++) {
			if (gameLibrary[i].getName().equalsIgnoreCase(name)) {
				System.out.println(name + " HAS BEEN FOUND IN YOUR LIBRARY \n");
				System.out.println(gameLibrary[i].toString());
				return gameLibrary[i];
			}

		}
		System.out.println(name + " DOESN'T EXIST IN YOUR LIBRARY");
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
		String gamesInLibrary = "";
		String sWallet = wallet + "";
		for (int i = 0; i < numberOfGames; i++)
			gamesInLibrary += gameLibrary[i].toString();
		return "\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n USERNAME: " + username + "\n THE AMOUNT OF FUNDS IN WALLET: "
				+ sWallet.substring(0, (sWallet.indexOf('.') + 2)) + "\n THE NUMBER OF GAMES IN LIBRARY IS: ( "
				+ numberOfGames + " ) \n \n THE GAMES IN LIBRARY ARE: : \n" + gamesInLibrary
				+ " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
	}
}