package Juegos.CarreraDeCaballos;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Caballo implements Runnable {
    
    private String name;
    private int win_streak;
    private int position;
    private Score score;
    private int number;
    private Image img;

    private Random rand = new Random();
    
    public Caballo(String name, int number) {
        this.position = 0;
        this.name = name;
        this.score = new Score();
        this.win_streak = rand.nextInt(3);
        this.number = number;
        this.img = new ImageIcon("C:\\Users\\Andy\\Documents\\NetBeansProjects\\Casino-en-Java\\Casino\\src\\main\\java\\Juegos\\CarreraDeCaballos\\horse.png").getImage();
    }

    public Image getImg() {
        return img;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }
    
    @Override
    public void run() {
        
        synchronized(score){
        try{
            while(score.winner == false){
                System.out.println(name + " Posición " + position);
                int sleepTime = rand.nextInt(2000) - rand.nextInt(10)*win_streak;
                
                Thread.currentThread().sleep(Math.abs(sleepTime));  
            
                if(score.winner == true){
                   
                    Thread.currentThread().interrupt();
                    break;     
                    
                }
                
                position++;            
                if(position == 10){
                         
                        score.winner = true;
                        score.winnerName = name;
                     
                }               
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
     
    }    
   }


}
    