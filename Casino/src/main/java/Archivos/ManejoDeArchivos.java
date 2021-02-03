
package Archivos;

import java.util.List;
import java.util.LinkedList;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;

import Usuario.*;

public class ManejoDeArchivos {
    
    public static boolean initialize(){
        File users = new File("Usuarios.ser");
        
        if(!users.exists()){
            try{
                users.createNewFile();
            }catch(SecurityException e){
                System.out.println("No es posible escribir en este directorio.");
                return false;
            }catch(IOException e){
                System.out.println("Error de entrada y salida.");
                return false;
            }
            System.out.println("Bienvenido, es el primer usuario de este programa.");
        }
        
        return true;
        
    }
    
    public static boolean login(String user, String pwd){
        
        BlankUser current= null;
        ObjectInputStream is = null;
        
        try{
            is = new ObjectInputStream(new FileInputStream("Usuarios.ser"));
        }catch(FileNotFoundException e){
            System.out.println("No se ha creado el archivo de usuarios.");
            return false;
        }catch(IOException e){
            System.out.println("Error de entrada y salida.");
            return false;
        }
        
        try{
            
            while(true){
                current = (BlankUser) is.readObject();
                if(current.getNombre().equals(user))
                    if(current.getContrasenia().equals(pwd)){
                        Singleton.createInstance(current);
                        try{
                            is.close();
                        }catch(IOException e){
                            System.out.println("Error al cerrar el lector");
                        }
                        return true;
                    } 
            }
            
        }catch(NullPointerException e){
            System.out.println("No se inicializó el objeto.");
            return false;
        }catch(ClassNotFoundException e){
            System.out.println("No se pudo encontrar la clase.");
        }catch(IOException e){
            System.out.println("El usuario no se encuentra registrado.");
        }
        
        try{
            is.close();
        }catch(IOException e){
            System.out.println("Error al cerrar el lector.");
        }
        
        return false;
    }
    
    
    public static boolean register(String nombre, String pwd){
        
        ObjectOutputStream os = null;
        
        try{
            os = new ObjectOutputStream(new FileOutputStream("Usuarios.ser", true));
        }catch(FileNotFoundException e){
            System.out.println("No se ha creado el archivo de usuarios.");
            return false;
        }catch(IOException e){
            System.out.println("Error de entrada y salida.");
            return false;
        }
        
        try{
            
            os.writeObject((BlankUser) new SilverUser(nombre,pwd,100));
            
            System.out.println("Ha sido registrado exitosamente, le hemos regalado 100 fichas.");
            try {
                os.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el escritor.");
            }
            return true;
            
        }catch(InvalidClassException e){
            System.out.println("Error con la clase inicial.");
        }catch(NotSerializableException e){
            System.out.println("No es posible serializar el objeto.");
        }catch(IOException e){
            System.out.println("Error de entrada o salida.");
        }catch (NullPointerException e) {
            System.out.println("No se inicializó el objeto.");
            return false;
        }
        
        try {
            os.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el escritor.");
        }
        
        return false;
    }
    
    public static boolean logout(){
        
        if(Singleton.getInstance() == null){
            return false;
        }
        
        List<BlankUser> users = new LinkedList<>();
        BlankUser current = null;
        ObjectInputStream is = null;
        
        try{
            is = new ObjectInputStream(new FileInputStream("Usuarios.ser"));
        }catch(FileNotFoundException e){
            System.out.println("No se ha creado el archivo de usuarios.");
            return false;
        }catch(IOException e){
            System.out.println("Error de entrada y salida.");
            return false;
        }
        
        try{
            
            // Guardamos todos los usuarios en una lista menos el que actualizaremos.
            while(true){
                
                current = (BlankUser) is.readObject();
                
                // Dos usuarios pueden tener el mismo nombre pero es improbable que tengan la misma contraseña
                if(!current.getNombre().equals(Singleton.getInstance().getNombre())){
                    users.add(current);
                }else{
                    if(!current.getContrasenia().equals(Singleton.getInstance().getContrasenia())){
                        users.add(current);
                    } 
                }
            }
            
        // No se pudo realizar el proceso
        }catch(NullPointerException e){
            System.out.println("No se inicializó el objeto.");
            return false;
        }catch(ClassNotFoundException e){
            System.out.println("No se pudo encontrar la clase.");
            return false;
        
        // Se llegó al final del archivo
        }catch(IOException e){
        }
        
    
        // Cerramos el flujo de entrada
        try{
            is.close();
        }catch(IOException e){
            System.out.println("Error al cerrar el lector.");
        }
        
        ObjectOutputStream os = null;
        
        try{
            os = new ObjectOutputStream(new FileOutputStream("Usuarios.ser"));
        }catch(FileNotFoundException e){
            System.out.println("No se ha creado el archivo de usuarios.");
            return false;
        }catch(IOException e){
            System.out.println("Error de entrada y salida.");
            return false;
        }
        
        try{
            
            // Guardamos todos los usuarios en una lista menos el que actualizaremos.
            for(BlankUser user : users){
                os.writeObject(user);
            }
            
            // Guardamos el usuario actualizaco
            os.writeObject(Singleton.getInstance());
            
            Singleton.createInstance(null);
            
            //Cerramos el flujo de salida
            try {
                os.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el escritor.");
            }
            return true;
            
        // No se pudo realizar el proceso
        }catch (InvalidClassException e) {
            System.out.println("Error con la clase inicial.");
        } catch (NotSerializableException e) {
            System.out.println("No es posible serializar el objeto.");
        } catch (IOException e) {
            System.out.println("Error de entrada o salida.");
        } catch (NullPointerException e) {
            System.out.println("No se inicializó el objeto.");
            return false;
        }
        
        //Cerramos el flujo de salida
        try {
            os.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el escritor.");
        }
        
        return false;
    }
}
