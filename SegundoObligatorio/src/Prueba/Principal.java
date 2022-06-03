package Prueba;

import Dominio.ArchivoGrabacion;
import Dominio.ArchivoLectura;
import Dominio.Deposito;
import Dominio.Empleado;
import Dominio.Sistema;
import Interfaz.Inicial;
import Interfaz.Menu;
import Interfaz.registrarDeposito;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class Principal {
    
    public static void main(String[] args) {
        
        
        Inicial v=new Inicial();
        v.setVisible(true);
        
        ////////////////////////////////////////////////////////
        ArchivoLectura arch =new ArchivoLectura("archivo.txt");
        while(arch.hayMasLineas()){
            String []linea=arch.linea().split("#");
            for (int i = 0; i < linea.length; i++) {
             
                System.out.println(linea[i]);
                
            }
           
        }
        arch.cerrar(); 
        ///////////////////////////////////////////////////////////////////
        ArchivoGrabacion arch2 = new ArchivoGrabacion("grabacion.txt",false);
        arch2.grabarLinea("esta es la primera linea  asdsadsad");
        arch2.cerrar();
        /////////////////////////////////////////////////////////////////
    }
    
   

    

}
