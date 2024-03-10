package gamestore_project;

public class Horror extends Game{
	
	public Horror(String name, String publisher, double price) {
		super(name, publisher, price);
	}

	public double priceAfterDiscount()
	{
		return super.price*0.30;
	}


}
