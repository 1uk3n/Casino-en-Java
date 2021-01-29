
package Usuario;

public class GoldUser extends BlankUser{
    
    @Override
    int getRango() {
        return 2;
    }

    @Override
    void depositarFichas(int fichasGanadas) {
        fichas += fichasGanadas + (int) (fichasGanadas * 0.10);
    }

    @Override
    int retirarFichas(int apuesta) {
        return apostarFichas(apuesta) + (int) (apuesta * 0.10);
    }

}
