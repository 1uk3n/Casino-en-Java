package Usuario;

public abstract class BlankUser {
    String nombre;
    int fichas;

    public void BlankUser(String nombre, int fichas){
        this.nombre = nombre;
        this.fichas = fichas;
    }

    int getFichas(){
        return fichas;
    }

    String getNombre(){
        return nombre;
    }

    void setFichas(int fichas){
        this.fichas = fichas;
    }

    void setNombre(String nombre){
        this.nombre = nombre;
    }

    int apostarFichas(int fichas){
        this.fichas -= fichas;
        return fichas;
    }

    abstract int getRango();

    abstract void depositarFichas(int fichasGanadas);
   
    abstract int retirarFichas(int apuesta);
}
