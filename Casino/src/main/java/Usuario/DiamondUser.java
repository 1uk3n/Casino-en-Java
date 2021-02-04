
package Usuario;

public class DiamondUser extends BlankUser{
    
    public DiamondUser(String nombre, String contrasenia, int fichas){
        this.nombre = nombre;
        this.fichas = fichas;
        this.contrasenia = contrasenia;
    }
    
    @Override
    public int getRango() {
        return 3;
    }

    @Override
    public void depositarFichas(int fichasGanadas) {
        fichas += fichasGanadas + (int) (fichasGanadas * 0.25);
    }

    @Override
    public int retirarFichas(int apuesta) {
        return apostarFichas(apuesta) + (int) (apuesta * 0.25);
    }
}
