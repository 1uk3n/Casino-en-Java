
package Juegos;

public class Game {
    
    public static int fichasSobreLaMesa;
    public static boolean juegoIniciado;
    
    // Inicializar variables
    public void iniciarJuego(){
        juegoIniciado = true;
        fichasSobreLaMesa = 0;
    } 
    
    // Asegurar que usuario tenga fichas
    public void apostar(int fichasUsuario){
        fichasSobreLaMesa += fichasUsuario;
    } 
    
    // Regresar fichas ganadas
    public int resultado(double multiplicador){
        return (int)Math.ceil((fichasSobreLaMesa * multiplicador));
    }
    
    // Regresar apuesta en caso de salir sin jugar
    public int terminarJuego(){
        if(juegoIniciado){
            return fichasSobreLaMesa;
        }else{
            return 0;
        }
    } 
    
}
