
package Usuario;

public class DiamondUser extends BlankUser{
    @Override
    int getRango() {
        return 3;
    }

    @Override
    void depositarFichas(int fichasGanadas) {
        fichas += fichasGanadas + (int) (fichasGanadas * 0.25);
    }

    @Override
    int retirarFichas(int apuesta) {
        return apostarFichas(apuesta) + (int) (apuesta * 0.25);
    }
}
