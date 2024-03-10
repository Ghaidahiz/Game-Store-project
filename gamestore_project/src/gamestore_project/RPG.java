package gamestore_project;

public class RPG extends Game{

	public RPG(String name, String publisher, double price) {
		super(name, publisher, price);
	}
	public RPG(Game g) {
		super(g.getName(), g.getPublisher(), g.getPrice());
	}
	public double priceAfterDiscount()
	{
		return super.price*0.50;
	}
}
