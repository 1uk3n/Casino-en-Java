
package Test;

public class Test{
    
    public static void wait300(){
        long first = System.currentTimeMillis();
        while(System.currentTimeMillis() - first < 300){}
        
    }
}
