
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
        if(fichasUsuario < 0 && fichasSobreLaMesa == 0){
            fichasSobreLaMesa += fichasUsuario;
        }else{
            System.out.println("No es posible realizar esta apuesta");
        }
    } 
    
    // Regresar fichas ganadas
    public int resultado(double multiplicador){
        return (int)(fichasSobreLaMesa * multiplicador);
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
