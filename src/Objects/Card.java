package Objects;

public class Card {
	
	private String suit;
	private String name;
	private int value;
	
	
	public Card(String suit, int value, String name)
	{
		this.suit= suit;
		this.value = value;
		this.name = name;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public int getVal()
	{
		return value;
	}

	public String getName()
	{
		return name;
	}
}
