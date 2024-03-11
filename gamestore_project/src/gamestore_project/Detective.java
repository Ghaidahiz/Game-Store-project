package gamestore_project;
public class Detective extends Game{
	
	public Detective(String name, String publisher, double price) {
		super(name, publisher, price);
	}
	
	public Detective (Game g) {
		super(g.getName(), g.getPublisher(), g.getPrice());
	}

	public double priceAfterDiscount()
	{
		return price -(price*0.15);
	}

}
