/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juegos.CarreraDeCaballos;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Andy
 */
public class Hipodromo extends JPanel implements Runnable {
    
    private Thread animator;
    ArrayList<Caballo> caballos = new ArrayList<>();
    ArrayList<Thread> hilos = new ArrayList<>();
    
    
    @Override
    public void addNotify(){
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    
    }
    
    public Hipodromo() throws InterruptedException{
        
        setPreferredSize(new Dimension(800, 700));
        
        
        addCaballos();
        for (Caballo caballo : caballos) {
            System.out.println("CAballo " + caballo.getName() + " agregado a hilo");
            hilos.add(new Thread(caballo));  
        }
    }
     
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("C:\\Users\\Andy\\Documents\\NetBeansProjects\\Casino-en-Java\\Casino\\src\\main\\java\\Juegos\\CarreraDeCaballos\\road.png").getImage(), 0, 0, this);
         for (Caballo caballo : caballos) {
             int x = caballo.getPosition() * 70;
             int y = caballo.getNumber() * 65;
             g.drawImage(caballo.getImg(), x, y, this);
         }
    }
       
     
    public void initHilos() throws InterruptedException{
        for (Thread hilo : hilos) {
            System.out.println("Hilo " + hilo.getName() + "iniciado");
            hilo.start();
           
        }
         for (Thread hilo : hilos) {
            System.out.println("Hilo " + hilo.getName() + "iniciado");
            hilo.join();
           
        }
    }
 
    @Override
    public void run() {
            Score sc = new Score();
            synchronized(sc){
                while(sc.winner == false){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hipodromo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    repaint();
                    
                }
                
            }
    }
    
    public void addCaballos(){
    
        for (int i = 0; i < 7; i++) {
            caballos.add(new Caballo("Juanito " + i, i+1));
        }
    }
    

}
