package gamestore_project;

public abstract class Game {

	protected String name;
	protected String publisher;
	protected double price;

	public Game(String name, String publisher, double price) {
		this.name = name;
		this.publisher = publisher;
		this.price = price;
	}

	public abstract double priceAfterDiscount();

	public String getName() {
		return name;
	}

	public String getPublisher() {
		return publisher;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Game name: " + name + "\nGame publisher: " + publisher + "\nGame price: " + price + "\nPrice after discount: " + String.format("%.2f",priceAfterDiscount()) + "\n\n";
	}
}
