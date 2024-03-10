package gamestore_project;
public absract class Game {
	
	protected String name;
	protected String publisher;
	protected double price;
	
	public Game(String name , String publisher , double price)
	{
		this.name=name;
		this.publisher=publisher;
		this.price=price;
	}
	
	public abstract double priceAfterDiscount(double p);

	public String getName()
	{
		return name;
	}
}
