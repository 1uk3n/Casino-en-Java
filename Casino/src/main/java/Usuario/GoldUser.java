
package Usuario;

public class GoldUser extends BlankUser{
    
    public GoldUser(String nombre, String contrasenia, int fichas){
        this.nombre = nombre;
        this.fichas = fichas;
        this.contrasenia = contrasenia;
    }
    
    @Override
    public int getRango() {
        return 2;
    }

    @Override
    public void depositarFichas(int fichasGanadas) {
        fichas += fichasGanadas + (int)Math.ceil(fichasGanadas * 0.10);
    }

    @Override
    public int retirarFichas(int apuesta) throws ExCasino.InvalidBet{
        return apostarFichas(apuesta) + (int)Math.ceil(apuesta * 0.10);
    }

}
