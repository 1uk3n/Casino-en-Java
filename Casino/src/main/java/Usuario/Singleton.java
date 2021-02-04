package Usuario;

public class Singleton {
    private static BlankUser currentUser = null;
    
    private Singleton(){
    }
    
    public static BlankUser getInstance(){
        return currentUser;
    }
    
    public static void createInstance(BlankUser newUser){
        currentUser = newUser;
    }
}
