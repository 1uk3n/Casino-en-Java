/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Juegos.CarreraDeCaballos.Hipodromo;
import javax.swing.JFrame;

/**
 *
 * @author Andy
 */
public class ControladorPrincipal {
    
    public static void main(String[] args) throws InterruptedException {
        
        JFrame f = new JFrame();
        Hipodromo hipo = new Hipodromo();
       
        f.add(hipo);
        f.setSize(hipo.getWidth(),hipo.getHeight());
        f.pack();   
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Hipo");
        f.setVisible(true);
        hipo.initHilos();
        
    }
}
