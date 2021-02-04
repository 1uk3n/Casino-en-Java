package Usuario;

import java.io.Serializable;

public abstract class BlankUser implements Serializable{
    String nombre;
    String contrasenia;
    int fichas;

    public int getFichas(){
        return fichas;
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }

    public void setFichas(int fichas){
        this.fichas = fichas;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int apostarFichas(int fichas){
        this.fichas -= fichas;
        return fichas;
    }

    public abstract int getRango();

    public abstract void depositarFichas(int fichasGanadas);
   
    public abstract int retirarFichas(int apuesta);
}
