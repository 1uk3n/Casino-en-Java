
package Usuario;

public class AdminUser extends BlankUser{
    
    public AdminUser(String nombre, String contrasenia, int fichas){
        this.nombre = nombre;
        this.fichas = fichas;
        this.contrasenia = contrasenia;
    }
    
    @Override
    public int getRango() {
        return 4;
    }

    @Override
    public void depositarFichas(int fichasGanadas) {
        fichas += fichasGanadas;
    }

    @Override
    public int retirarFichas(int apuesta) {
        return apostarFichas(apuesta);
    }
}
