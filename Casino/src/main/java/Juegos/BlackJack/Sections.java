/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos.BlackJack;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Andy
 */
public class Sections extends JPanel {
    
        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawImage(new ImageIcon("C:\\Users\\Andy\\Documents\\NetBeansProjects\\Casino-en-Java\\Casino\\src\\main\\java\\Juegos\\BlackJack\\tablero.jpg").getImage(), 0, 0, null);
            
        }
        
}
