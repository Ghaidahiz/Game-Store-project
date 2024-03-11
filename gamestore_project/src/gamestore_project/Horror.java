package gamestore_project;

public class Horror extends Game{
	
	public Horror(String name, String publisher, double price) {
		super(name, publisher, price);
	}
	
	public Horror(Game g) {
		super(g.getName(), g.getPublisher(), g.getPrice());
	}
	public double priceAfterDiscount()
	{
		return price-(price*0.30);
	}


}
