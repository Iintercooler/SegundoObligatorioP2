
package Dominio;

import java.io.Serializable;


public class Visita implements Serializable{
    Contrato contrato;
    Deposito deposito;
    Cliente cliente;
    Empleado empleado;
    int dia;
    int mes;
    

    public Deposito getDeposito() {
        return deposito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Visita(Contrato contrato, Deposito deposito, Cliente cliente, Empleado empleado, int dia, int mes) {
        this.contrato = contrato;
        this.deposito = deposito;
        this.cliente = cliente;
        this.empleado = empleado;
        this.dia = dia;
        this.mes = mes;
    }

  

    @Override
    public String toString() {
        return "empleado=" + empleado.getNombre() + ", dia=" + dia + ", mes=" + mes;
    }

   
    
    
    
    
    
}
