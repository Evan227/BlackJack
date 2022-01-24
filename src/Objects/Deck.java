package Objects;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck()
	{
		this.deck = createDeck(deck);
	}
	
	public ArrayList<Card> createDeck(ArrayList<Card> deck)
	{
		String[] suits = {"Diamonds","Hearts","Spades","Clubs"};
		
		String[] names = {"Two", "Three","Four","Five","Six", "Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
		int[] vals = {2,3,4,5,6,7,8,9,10,10,10,10,11};
		
		for(int x = 0; x<suits.length;x++)
		{
			for(int y = 0; y<names.length;y++)
			{
				Card hold = new Card(suits[x], vals[y], names[y]);
				deck.add(hold);
			}
		}
		
		return deck;
	}
	
	public void shuffle()
	{
		Collections.shuffle(deck);
	}
	
	public void print()
	{
		for(int x = 0; x<deck.size();x++ )
		{
			System.out.println(deck.get(x).getName() + " of " + deck.get(x).getSuit());
		}
	}
	
	public ArrayList<Card> getArray()
	{
		return deck;
	}

}
