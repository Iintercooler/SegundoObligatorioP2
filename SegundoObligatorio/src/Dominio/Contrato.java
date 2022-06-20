package Dominio;

import java.io.Serializable;

    
public class Contrato implements Serializable{
    Empleado empleado;
    Cliente cliente;
    Deposito Deposito ;
    int numero;
    String detalles;

    public Contrato() {
    
    }
    
    

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setCliente(Cliente clientss) {
        this.cliente = clientss;
    }

    public void setDeposito(Deposito Deposito) {
        this.Deposito = Deposito;
    }

  
    
    
     public Cliente getCliente() {
        return this.cliente ;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    
    
    
    
     public int getNumero() {
        return numero;
    }

    public void setNumero(int unNumero) {
        numero = unNumero;
    }

    

  
    public Contrato(Empleado empleado, Cliente clientss, Deposito Deposito,String detalles,int numero) {
        this.setNumero(numero);
        this.setEmpleado(empleado);
        this.setCliente(clientss);
        this.setDeposito(Deposito);
        this.setDetalles(detalles);
        
    }

    @Override
    public String toString() {
        return "Contrato Numero " + numero+ ", Detalles: " + detalles;
    }
    
    
    
    
    
    
   
    

   

    public Empleado getEmpleado() {
        return empleado;
    }

   

    public Deposito getDeposito() {
        return Deposito;
    }

    

   

  
    
    
    
    
}
