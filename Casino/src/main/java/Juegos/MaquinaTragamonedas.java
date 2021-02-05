package Juegos;


import java.util.Random;

public class MaquinaTragamonedas extends Game{

    public static int casillaElegida = 0;  
    public static int casillaSeleccionada = 0;  
    
    @Override
    public void iniciarJuego(){
        fichasSobreLaMesa = 0;
        casillaElegida = 0;
        casillaSeleccionada = 0;
        juegoIniciado = true;
    } 
    
    public int juego(){
        juegoIniciado = false;
        Random rng = new Random();
        
        switch(rng.nextInt(21)){
            
            case 0,1,2,3,4,5:
                if(casillaElegida == 1){
                    casillaSeleccionada = 1;
                    return resultado(1.2);
                }
                break;
                
            case 6,7,8,9,10:
                if(casillaElegida == 2){
                    casillaSeleccionada = 2;
                    return resultado(1.4);
                }
                break;
                
            case 11,12,13,14:
                if(casillaElegida == 3){
                    casillaSeleccionada = 3;
                    return resultado(1.6);
                }
                break;
            
            case 15,16,17:
                if (casillaElegida == 4) {
                    casillaSeleccionada = 4;
                    return resultado(1.8);
                }
                break;
            
            case 18,19:
                if (casillaElegida == 5) {
                    casillaSeleccionada = 5;
                    return resultado(2);
                }
                break;
            
            case 20:
                if (casillaElegida == 6) {
                    casillaSeleccionada = 6;
                    return resultado(3);
                }
                break;
        }
        
        return resultado(0);
    }
    
    
}
