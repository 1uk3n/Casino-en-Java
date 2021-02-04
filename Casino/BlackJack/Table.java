import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

@SuppressWarnings("serial")
class Table extends JPanel {
	
	private JPanel topPanel = new JPanel();
	private JPanel dcardPanel = new JPanel();
	private JPanel pcardPanel = new JPanel();
	
	private JButton start = new JButton("Start");
	private JButton hit = new JButton("HIT");
	private JButton stay = new JButton("STAY");
	
	private JLabel dealerlabel = new JLabel();
	private JLabel playerlabel = new JLabel();
	

	private float alignmentX = 0.0f;
	private float alignmentY = 0.0f;
	
	
	Table() {
		topPanel.setBackground(new Color(0, 122, 0));
	    dcardPanel.setBackground(new Color(0, 122, 0));
	    pcardPanel.setBackground(new Color(0, 122, 0));
	  
	    dealerlabel.setText("  Dealer:  ");
	    playerlabel.setText("  Player:  ");
	    
	    topPanel.add(start);
	    
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	   
	    
	    
	    add(dcardPanel);
	    add(pcardPanel);
	    add(topPanel);
	    
	    
	}
	
	void addHitListener(ActionListener HitListener) {
		hit.addActionListener(HitListener);
	}
	
	void addStartListener(ActionListener StartListener) {
		start.addActionListener(StartListener);
	}
	
	void addStayListener(ActionListener StayListener) {
		stay.addActionListener(StayListener);
	}
	
	void display() {
		JFrame myFrame = new JFrame("BlackJack");
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    myFrame.setContentPane(this);
	    myFrame.setPreferredSize(new Dimension(700,550));

	    myFrame.pack();
	    myFrame.setVisible(true);
	}
	
	void addCards(Player p, Dealer d) {
		topPanel.remove(start);
		
		pcardPanel.add(playerlabel);
	    dcardPanel.add(dealerlabel);		
	    
		for (Card c : p.hand) {
			ImageIcon cc = new ImageIcon(c.img);
			JLabel cC = new JLabel(cc);
			
		
			pcardPanel.add(cC);
			
			
		}
		
		for (Card c : d.hand)
			dcardPanel.add(new JLabel(new ImageIcon(c.img))); 

		topPanel.add(new JLabel("Options: "));
		topPanel.add(hit);								
		
		validate();
		repaint();
	}
	
	void newGame() {
		removeAll();
		setBackground(new Color(0, 122, 0));
		
		pcardPanel.removeAll();
		dcardPanel.removeAll();
		topPanel.removeAll();
		topPanel.add(start);
		
		add(dcardPanel);
	    add(pcardPanel);
	    add(topPanel);
	    
	    validate();
		repaint();
		
		
	}
	
	int endGame(boolean isWin) {
		
		int res;
		
		if (isWin == true)
			res = JOptionPane.showConfirmDialog(this, "You won! Would you like to play again?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
		else
			res = JOptionPane.showConfirmDialog(this, "You lost. Would you like to play again?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
		
		validate();
		repaint();
		
		return res;
	}
	
	public void hitPlayer(Player p) {
		JLabel hits = new JLabel(new ImageIcon(p.hand.get(p.hand.size()-1).img));
		pcardPanel.add(hits);
		
		validate();
		repaint();
	}
	
	public void hitDealer(Dealer d) {
		dcardPanel.add(new JLabel(new ImageIcon(d.hand.get(d.hand.size()-1).img)));
		validate();
		repaint();
	}

}