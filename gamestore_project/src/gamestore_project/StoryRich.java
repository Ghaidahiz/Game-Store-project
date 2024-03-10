package gamestore_project;

public class StoryRich extends Game{

	public StoryRich(String name, String publisher, double price) {
		super(name, publisher, price);
	}

	public double priceAfterDiscount()
	{
		return super.price*0.40;
	}
}
