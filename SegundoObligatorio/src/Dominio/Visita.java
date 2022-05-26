
package Dominio;

import java.util.Date;


public class Visita {
    Deposito deposito;
    Cliente cliente;
    Empleado empleado;
    Date fecha;

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public Visita(Deposito deposito, Cliente cliente, Empleado empleado, Date fecha) {
        this.deposito = deposito;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha = fecha;
    }
    
    
    
    
    
}
