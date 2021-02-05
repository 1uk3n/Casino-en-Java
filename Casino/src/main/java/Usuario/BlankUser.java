package Usuario;

import java.io.Serializable;

public abstract class BlankUser implements Serializable{
    String nombre;
    String contrasenia;
    int fichas;

    public int getFichas(){
        return fichas;
    }
    
    public BlankUser upgradeRank(){
        switch(getRango()){
            case 1:
                return new GoldUser(this.nombre, this.contrasenia, this.fichas);
            case 2:
                return new DiamondUser(this.nombre, this.contrasenia, this.fichas);
        }
        return this;
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }
    
    public boolean hasTokens(){
        if(fichas <= 0){
            return false;
        }else{
            return true;
        }
    }

    public void setFichas(int fichas){
        this.fichas = fichas;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int apostarFichas(int fichas) throws ExCasino.InvalidBet{
        if(fichas > this.fichas){
            throw new ExCasino.InvalidBet();
        }else{
            this.fichas -= fichas;
            return fichas;
        }
     
    }
    
    public boolean pagarServicio(int fichas){
        if(this.fichas < fichas){
            return false;
        }else{
            this.fichas -= fichas;
            return true;
        }
    }
    
    public abstract int getRango();

    public abstract void depositarFichas(int fichasGanadas);
   
    public abstract int retirarFichas(int apuesta)throws ExCasino.InvalidBet;
}
