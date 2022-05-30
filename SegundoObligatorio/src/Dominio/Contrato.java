package Dominio;

import java.io.Serializable;

    
public class Contrato implements Serializable{
    Empleado empleado;
    Cliente cliente;
    Deposito Deposito ;
    private static int numeroDeContrato=0;
    

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDeposito(Deposito Deposito) {
        this.Deposito = Deposito;
    }

    public static void setNumeroDeContrato(int numeroDeContrato) {
        Contrato.numeroDeContrato = numeroDeContrato;
    }

   

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Deposito getDeposito() {
        return Deposito;
    }

    public int getNumeroDeContrato() {
        return numeroDeContrato;
    }

    public Contrato(Empleado empleado, Cliente cliente, Deposito Deposito) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.Deposito = Deposito;
        setNumeroDeContrato(getNumeroDeContrato()+1);
    }

    @Override
    public String toString() {
        return "Contrato{" + "empleado=" + empleado + ", cliente=" + cliente + ", Deposito=" + Deposito + ", numeroDeContrato=" + numeroDeContrato + '}';
    }
    
    
    
    
}
