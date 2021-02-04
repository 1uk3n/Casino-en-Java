package Juegos;


import java.util.Random;

public class MaquinaTragamonedas extends Game{

    public static int casillaElegida = 0;  
    public static String[] opciones = {"Realizar apuesta", "Iniciar Juego", "Salir"};
    public static String[] apuestas = {"Limón", "Uva", "Manzana", "Sandía", "Estrella", "Jackpot"};
    
    @Override
    public void iniciarJuego(){
        fichasSobreLaMesa = 0;
        casillaElegida = 0;
        juegoIniciado = true;
    } 
    
    public int juego(){
        juegoIniciado = false;
        Random rng = new Random();
        int casillaGanadora = rng.nextInt(21);
        
        switch(casillaGanadora){
            
            case 0,1,2,3,4,5:
                if(casillaElegida == 1){
                    return resultado(1.2);
                }
                break;
                
            case 6,7,8,9,10:
                if(casillaElegida == 2){
                    return resultado(1.4);
                }
                break;
                
            case 11,12,13,14:
                if(casillaElegida == 3){
                    return resultado(1.6);
                }
                break;
            
            case 15,16,17:
                if (casillaElegida == 4) {
                    return resultado(1.8);
                }
                break;
            
            case 18,19:
                if (casillaElegida == 5) {
                    return resultado(2);
                }
                break;
            
            case 20:
                if (casillaElegida == 6) {
                    return resultado(3);
                }
                break;
        }
        
        return resultado(0);
    }
    
    
}
