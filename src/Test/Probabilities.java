package Test;
import java.util.ArrayList;

import Objects.*;

public class Probabilities {
	
	private ArrayList<Card> shoe = new ArrayList<Card>();
	private int amount;
	private int value;
	
	public Probabilities(ArrayList<Card> shoe, int amount, int value)
	{
		this.shoe = shoe;
		this.amount = amount;
		this.value = value;
	}
	
	public int CardCount()
	{
		int val = 0;
		
		for(Card c:shoe)
		{
			if(c.getVal() >= 2 && c.getVal() <= 6)
			{
				val +=1;
			}
			else if(c.getVal() == 10 || c.getName().equals("Ace"))
			{
				val-=1;
			}
			
		}
		
		return val/(amount- (shoe.size()/52));
		
	}
	
	public double percentToAtleast17()
	{
		
		double res = 0;
		
		int previousCards =0;
		
		for(Card c:shoe)
		{
			if(value + c.getVal() >= 17 && value + c.getVal() <= 21)
			{
				previousCards++;
			}
		}
		
		
		
		return res;
	}
	
	public double percentToBlackJack()
	{
		if(value < 10)
		{
			return 0;
		}
		
		double res = 0;
		
		int compliment = 21-value;
		int previousCards =0;
		
		for(Card c:shoe)
		{
			if(c.getVal() == compliment)
			{
				previousCards++;
			}
		}
		
		if(compliment != 11)
		{
			res = (float) (24-previousCards)/(312-shoe.size());
		}
		else
		{
			res = (96-previousCards)/(312-shoe.size());
		}
		
		return res;
	}

}
