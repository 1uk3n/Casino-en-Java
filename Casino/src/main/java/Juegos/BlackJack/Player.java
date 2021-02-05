package Juegos.BlackJack;

import java.util.ArrayList;

class Player {
	ArrayList<Card> hand = new ArrayList<Card>();
	
	
	int getScore() {
		int sum = 0;
		for (Card c : hand)
			sum += c.getCardValue();
		
		return sum;
	}
	
}
