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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    

  
    public Contrato(Empleado empleado, Cliente cliente, Deposito Deposito,String detalles,int numero) {
        this.numero=numero;
        this.empleado = empleado;
        this.cliente = cliente;
        this.Deposito = Deposito;
        this.detalles=detalles;
        
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
