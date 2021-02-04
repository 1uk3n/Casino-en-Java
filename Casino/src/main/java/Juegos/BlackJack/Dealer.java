package Juegos.BlackJack;

import java.util.ArrayList;

public class Dealer {
	ArrayList<Card> hand = new ArrayList<>();
	
	int getScore() {
		int sum = 0;
		for (Card c : hand)
			sum += c.getCardValue();
		
		return sum;
	}
	
}
