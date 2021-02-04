package Juegos.BlackJack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Table extends JPanel {
	
	private JPanel topPanel = new Sections();
	private JPanel dcardPanel = new Sections();
	private JPanel pcardPanel = new Sections();
	
	private JButton hit = new JButton("Pedir");
	private JButton stay = new JButton("Pasar");
	
	private JLabel dealerlabel = new JLabel();
	private JLabel playerlabel = new JLabel();
	

	private float alignmentX = 0.0f;
	private float alignmentY = 0.0f;
	
	
	Table() {
            newGame();
            
	}
	
	void addHitListener(ActionListener HitListener) {
		hit.addActionListener(HitListener);
	}
	
	void addStayListener(ActionListener StayListener) {
		stay.addActionListener(StayListener);
	}
	
	void display() {
	    JFrame myFrame = new JFrame("BlackJack");
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    myFrame.setContentPane(this);
	    myFrame.setSize(new Dimension(600,400));
	    myFrame.pack();
	    myFrame.setVisible(true);
	}
	
	void addCards(Player p, Dealer d) {
     
            pcardPanel.add(playerlabel);
	    dcardPanel.add(dealerlabel);		
	    
		for (Card c : p.hand) {
			ImageIcon cc = new ImageIcon(c.img);
			JLabel cC = new JLabel(cc);
			pcardPanel.add(cC);
				
		}
		
		for (Card c : d.hand)
			dcardPanel.add(new JLabel(new ImageIcon(c.img))); 
                
                JLabel options = new JLabel("Opciones: ");
                options.setForeground(Color.white);
		topPanel.add(options);
		topPanel.add(hit);
                topPanel.add(stay);	
		validate();
		repaint();
	}
	
       
    void newGame() {

        removeAll();
        pcardPanel.removeAll();
        dcardPanel.removeAll();
        topPanel.removeAll();


        dealerlabel.setForeground(Color.white);            
        playerlabel.setForeground(Color.white);
        dealerlabel.setText("  Casa:  ");
        playerlabel.setText("  Jugador:  ");	    


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(600,400));
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
		
		//validate();
		//repaint();
		
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