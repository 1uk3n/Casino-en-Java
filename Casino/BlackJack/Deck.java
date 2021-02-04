import java.util.*;
import java.awt.image.BufferedImage;

class Deck {
	  ArrayList<Card> deck;
	 
	  public Deck(){
		  
		  try {
		  LoadImages im = new LoadImages();
		  
		  
		  BufferedImage[] crdimg = im.cards;
		  
				  this.deck = new ArrayList<>();
				  for (int a=0; a<13; a++){

					 
					  Value value = Value.values()[a];
	 
					  for (int b=0; b<4; b++){
					  
						  Card card = new Card(value, Suit.values()[b], crdimg[(a*4)+b]);
						  this.deck.add(card);
					  }
				  }
				  Collections.shuffle(deck);
		  } catch(Exception e) {
		  	System.out.println(e.getMessage());
		  }	
		    
	  }
}