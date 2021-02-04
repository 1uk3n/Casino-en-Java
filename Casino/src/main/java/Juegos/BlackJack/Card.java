package Juegos.BlackJack;

import java.awt.image.BufferedImage;

public class Card {
	  private final Suit suit;
	  private final Value cardValue;
	  final BufferedImage img; 			
	 
	  Card (Value cardValue, Suit suit, BufferedImage img){
	    this.cardValue = cardValue;
	    this.suit = suit;
	    this.img = img;
	  }
	 
	  public Suit getSuit(){
	    return suit;
	  }
	 
	  public int getCardValue() 
	  {
	    return cardValue.getValue();
	  }
	  
	}
