package Dominio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JTextField;

public class Sistema {

    ArrayList<Deposito> Depositos = new ArrayList<Deposito>();
    ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    ArrayList<Empleado> Empleados = new ArrayList<Empleado>();
    ArrayList<Contrato> Contratos = new ArrayList<Contrato>();
    ArrayList<Visita> Visitas = new ArrayList<Visita>();

    public ArrayList<Deposito> getDepositos() {
        return Depositos;
    }

    
    
    
    
    
    
    
    
    
    
    public void agregarDeposito (Deposito d){
        this.Depositos.add(d);
    }
    
    public void agragarCliente(Cliente c){
    this.Clientes.add(c);
    }
    
    public void agregarEmpleado(Empleado e){
    this.Empleados.add(e);
    }
    
    public void agregarContrato(Contrato c){
    this.Contratos.add(c);
    }
    
    public void agregarVisita(Visita v){
    this.Visitas.add(v);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean existeDeposito(Deposito d) {
        boolean resu = false;
        for (int i = 0; i < this.Depositos.size() && !resu; i++) {
            if (this.Depositos.get(i).getNumero() == d.numero) {
                resu = true;
            }
        }
        return resu;

    }

}
