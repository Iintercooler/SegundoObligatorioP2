package Prueba;

import Dominio.Deposito;
import Dominio.Empleado;
import Dominio.Sistema;
import Interfaz.Menu;
import Interfaz.registrarDeposito;

public class Principal {
    
    public static void main(String[] args) {
        
        Sistema sistema = new Sistema();
        sistema.cargarSistema();
        
        
        
        Menu menu = new Menu(sistema);
        menu.setVisible(true);
        
       
        
        
        
    }
}
