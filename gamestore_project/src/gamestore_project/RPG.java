package gamestore_project;

public class RPG extends Game{

	public RPG(String name, String publisher, double price) {
		super(name, publisher, price);
	}

	public double priceAfterDiscount()
	{
		return super.price*0.50;
	}
}
