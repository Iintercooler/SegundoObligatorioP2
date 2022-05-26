package Dominio;


public class Contrato {
    Empleado empleado;
    Cliente cliente;
    Deposito Deposito ;
    int numeroDeContrato=0;

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDeposito(Deposito Deposito) {
        this.Deposito = Deposito;
    }

    public void setNumeroDeContrato(int numeroDeContrato) {
        this.numeroDeContrato = numeroDeContrato;
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
        this.numeroDeContrato = getNumeroDeContrato()+1;
    }
    
    
    
    
}
