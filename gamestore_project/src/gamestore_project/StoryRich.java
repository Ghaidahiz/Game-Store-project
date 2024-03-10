package gamestore_project;

public class StoryRich extends Game{

	public StoryRich(String name, String publisher, double price) {
		super(name, publisher, price);
	}
	
	public StoryRich(Game g) {
		super(g.getName(), g.getPublisher(), g.getPrice());
	}

	public double priceAfterDiscount()
	{
		return super.price*0.40;
	}
}
