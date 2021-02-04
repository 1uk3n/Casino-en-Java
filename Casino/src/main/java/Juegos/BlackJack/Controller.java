package Juegos.BlackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


import javax.swing.Timer;


public class Controller implements Observer {
	
	BlackJack game;
	Table t;
	
	Controller(BlackJack game, Table t) {
		this.game = game;
		this.t = t;
		
		this.game.addObserver(this);
		this.t.addHitListener(new HitListener());
		this.t.addStayListener(new StayListener());
		
	}
	
	public void go() {
                t.addCards(game.getPlayer(), game.getDealer());
		t.display();
	}
	
	public void update(Observable obj, Object observed) {
		
		t.hitDealer(game.getDealer());
		
	}
	
	void loss() {
		int result = t.endGame(false);
		System.out.println(result);
		
		if (result == 0) {
			game = new BlackJack();	
			game.addObserver(this);
			t.newGame();
                        t.addCards(game.getPlayer(), game.getDealer());
                       
		}
		
		else
			System.exit(0);
	}
        
	void win() {
		int result = t.endGame(true);
		System.out.println(result);
		
		if (result == 0) {
			game = new BlackJack();
			game.addObserver(this);  
			t.newGame();
                        t.addCards(game.getPlayer(), game.getDealer());
                       
		}
		
		else
			System.exit(0);
	}
	
	class HitListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			
			game.hit();
			
			
			
			Timer timer = new Timer(25, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (game.isBust() == true) 
						loss();
				}
			});
			
			
			timer.setRepeats(false);
			timer.start();
			t.hitPlayer(game.getPlayer());
			
		}
	}
	
	class StayListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			game.stay();
			
			Timer timer = new Timer(25, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (game.isWin() == true)
						win(); 
					else
						loss();
				}
			});
			
			timer.setRepeats(false);
			timer.start();
		}
		
	}
	
}
