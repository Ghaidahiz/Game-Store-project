package gamestore_project;

public class Survival extends Game{

	public Survival(String name, String publisher, double price) {
		super(name, publisher, price);
	}
	
	public Survival(Game g) {
		super(g.getName(), g.getPublisher(), g.getPrice());
	}

	public double priceAfterDiscount() 
	{
		return super.price*0.40;
	}
}
