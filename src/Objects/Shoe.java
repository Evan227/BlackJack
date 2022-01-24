package Objects;

import java.util.ArrayList;
import java.util.Collections;

public class Shoe {
	
	private ArrayList<Card> shoe = new ArrayList<Card>();
	
	public Shoe(int amount)
	{
		this.shoe = createShoe(amount);
	}
	
	public ArrayList<Card> createShoe(int amount)
	{
		ArrayList<Card> res = new ArrayList<Card>();
		
		for(int x = 0; x<amount;x++)
		{
			Deck deck = new Deck();
			
			res.addAll(deck.getArray());
		}
		
		Collections.shuffle(res);
		
		return res;
	}
	
	public void print()
	{
		for(int x = 0; x<shoe.size();x++ )
		{
			System.out.println(shoe.get(x).getName() + " of " + shoe.get(x).getSuit());
		}
	}
	
	public int size()
	{
		return shoe.size();
	}

	public Card peek()
	{
		return shoe.get(0);
	}
	
	public void pop()
	{
		shoe.remove(0);
	}

}
