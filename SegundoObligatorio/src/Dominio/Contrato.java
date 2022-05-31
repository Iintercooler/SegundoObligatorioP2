package Dominio;

import java.io.Serializable;

    
public class Contrato implements Serializable{
    Empleado empleado;
    Cliente cliente;
    Deposito Deposito ;
     private int numero;
    private static int ProximoNumero;
    

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDeposito(Deposito Deposito) {
        this.Deposito = Deposito;
    }

  
    
    
     public Cliente getCliente() {
        return this.cliente ;
    }
    
    
    
    
    
     public int getNumero() {
        return numero;
    }

    public void setNumero(int unNumero) {
        numero = unNumero;
    }

    public static int getProximoNumero() {
        return ProximoNumero;
    }

    public static void setProximoNumero(int unProximoNumero) {
        ProximoNumero = unProximoNumero;
    }

    public Contrato(Empleado empleado, Cliente cliente, Deposito Deposito) {
       Contrato.setProximoNumero(Contrato.getProximoNumero() + 1);
        this.empleado = empleado;
        this.cliente = cliente;
        this.Deposito = Deposito;
        
    }

    @Override
    public String toString() {
        return "Contrato{" + "empleado=" + empleado + ", cliente=" + cliente + ", Deposito=" + Deposito + ", numero=" + numero + '}';
    }
    
    
    
    
    
    
   
    

   

    public Empleado getEmpleado() {
        return empleado;
    }

   

    public Deposito getDeposito() {
        return Deposito;
    }

    

   

  
    
    
    
    
}
