
package Archivos;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class AppendObjectOutputStream extends ObjectOutputStream{
    
    public AppendObjectOutputStream() throws IOException{
        super();
    }
    
    public AppendObjectOutputStream(OutputStream stream) throws IOException{
        super(stream);
    }
    
    @Override
    protected void writeStreamHeader() throws IOException{
        //No escribir header.
    }
    
}
