package gamestore_project;

public class Survival extends Game{

	public Survival(String name, String publisher, double price) {
		super(name, publisher, price);
	}

	public double priceAfterDiscount()
	{
		return super.price*0.40;
	}
}
