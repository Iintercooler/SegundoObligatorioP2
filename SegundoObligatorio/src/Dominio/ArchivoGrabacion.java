package Dominio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArchivoGrabacion {
    private Formatter out;
    
    
    
    
    
    public ArchivoGrabacion(String unNombre, boolean ext){
        try {
            // SI EXT ES FALSE ES FALSE SE SOBRE ESCRIBE, SI ES TRUE SE EXTIENDE
 
            FileWriter f= new FileWriter(unNombre,ext);
            out = new Formatter(f);
        } catch (IOException ex) {
            System.out.println("Error con el archivo");
        }
    
    }
    
    
    
    public void grabarLinea(String unaLinea){
    out.format("%s%n", unaLinea);
    
    }
    
    public void cerrar(){
    out.close();
    }
    
    
    
    
    
}
