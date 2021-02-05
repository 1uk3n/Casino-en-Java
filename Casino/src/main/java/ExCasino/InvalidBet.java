
package ExCasino;

public class InvalidBet extends Exception{
    public InvalidBet(){
        super("Realizaste una apuesta inválida");
    }
}
