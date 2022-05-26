package Prueba;

import Dominio.Deposito;
import Dominio.Empleado;
import Dominio.Sistema;
import Interfaz.registrarDeposito;

public class Principal {
    
    public static void main(String[] args) {
        
        Sistema sistema = new Sistema();
        
        
        
        registrarDeposito ventana = new registrarDeposito(sistema);
        ventana.setVisible(true);
        
        
        
    }
}
