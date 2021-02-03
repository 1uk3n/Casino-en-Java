
package Usuario;

public class SilverUser extends BlankUser{
    
    public SilverUser(String nombre, String contrasenia, int fichas){
        this.nombre = nombre;
        this.fichas = fichas;
        this.contrasenia = contrasenia;
    }
    
    @Override
    public int getRango() {
        return 1;
    }
    
    @Override
    public void depositarFichas(int fichasGanadas) {
        fichas += fichasGanadas + (int) (fichasGanadas * 0.05);
    }

    @Override
    public int retirarFichas(int apuesta) {
        return apostarFichas(apuesta) + (int) (apuesta * 0.05);
    }
}
