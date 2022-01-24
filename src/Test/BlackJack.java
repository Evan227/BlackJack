package Test;
import Objects.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
	
	public static void main(String[] args)
	{
		ArrayList<Card> pastCards = new ArrayList<Card>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many decks do you want in the shoe?");
		
		int amount = sc.nextInt();
		Shoe shoe = new Shoe(amount);
		
		int playerValue = 0;
		int botValue = 0;
		String input = "";
		
		while(!input.equals("q"))
		{
			Card playerCard1 = shoe.peek();
			shoe.pop();
			Card botCard1 = shoe.peek();
			shoe.pop();
			Card playerCard2 = shoe.peek();
			shoe.pop();
			Card botCard2 = shoe.peek();
			shoe.pop();
			
			playerValue = playerCard1.getVal() + playerCard2.getVal();
			botValue = botCard1.getVal() + botCard2.getVal();
			
			System.out.println("My revealed card: "+botCard1.getCard());
			
			System.out.println("Your cards: "+playerCard1.getCard());
			System.out.println("Your cards: "+playerCard2.getCard());
			System.out.println("You have a value of: " + playerValue);
			
			pastCards.add(botCard1);
			pastCards.add(playerCard1);
			pastCards.add(playerCard2);
			
			if(playerValue == 21)
			{
				System.out.println("BLACKJACK");

				continue;
			}
			
			System.out.println("h to hit, s to stand, p for probabilities, q to quit");
			
			
			while(!input.equals("s") && playerValue < 22)
			{
				input = sc.next();
				
				if(input.equals("h"))
				{
					Card c = shoe.peek();
					shoe.pop();
					
					System.out.println(c.getCard());
					playerValue+=c.getVal();
					pastCards.add(c);
					System.out.println("You have a value of: " + playerValue);
				}
				else if(input.equals("q"))
				{
					return;
				}
				else if(input.equals("s"))
				{
					continue;
				}
				else if(input.equals("p"))
				{
					Probabilities p = new Probabilities(pastCards, amount, playerValue);
					
					System.out.println();
					System.out.println("True Count is: " + p.CardCount());
					System.out.println("Probability of you getting BlackJack on next card (assuming 6 deck shoe): " + p.percentToBlackJack());
					System.out.println();
				}
				else
				{
					System.out.println("invalid input");
				}
			}
			
			if(playerValue > 21)
			{
				System.out.println("busted! I win!");
				playerValue = 0;
				
				System.out.println();
				continue;
				
			}
			
			System.out.println("My Turn!");
			System.out.println("My other card is: " + botCard2.getCard());
			System.out.println("So I have a value of: " + botValue);
			
			pastCards.add(botCard2);
			
			botValue = botBlackJackPlay(shoe, botValue, pastCards);
			
			if(playerValue > botValue)
			{
				System.out.println("You win!");
			}
			else if(playerValue < botValue)
			{
				System.out.println("I win!");
			}
			else
			{
				System.out.println("You push!");
			}
			
			System.out.println();
			System.out.println("NEW ROUND!!!");
			
			input = "";
			playerValue = 0;
			botValue = 0;
			
			
		}
		
	}
	
	public static int botBlackJackPlay(Shoe shoe, int value, ArrayList<Card> pastCards)
	{
		int val = value;
		if(val >= 17)
		{
			System.out.println("I stand");
			return val;
		}
		else
		{
			boolean hitting = true;
			
			while(hitting)
			{
				Card c = shoe.peek();
				shoe.pop();
			
				val += c.getVal();
				
				System.out.println("The card I got is: " + c.getCard());
				System.out.println("My new value is: " + val);
				
				pastCards.add(c);
				
				if(val == 21)
				{
					System.out.println("I got Blackjack");
					hitting = false;
				}
				else if(val > 21)
				{
					System.out.println("I busted");
					return 0;
					
				}
				else if(val >= 17)
				{
					hitting = false;
					System.out.println("I stand");
				}
			}
			
		}
		
		return val;
	}
	
	public static void continueGameplay(String input, Scanner sc)
	{
		System.out.println();
		System.out.println("continue? y/n");
		
		input = sc.next();
		if(input.equals("n"))
		{
			System.exit(0);
		}
		System.out.println();
	}
	
	/*public int aceVal(int value)
	{
		
	}*/
	
	

}
