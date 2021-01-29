
package Usuario;

public class SilverUser extends BlankUser{
    
    @Override
    int getRango() {
        return 1;
    }
    
    @Override
    void depositarFichas(int fichasGanadas) {
        fichas += fichasGanadas + (int) (fichasGanadas * 0.05);
    }

    @Override
    int retirarFichas(int apuesta) {
        return apostarFichas(apuesta) + (int) (apuesta * 0.05);
    }
}
