package Dominio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sistema implements Serializable {

    private ArrayList<Deposito> depositos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> empleados;
    private ArrayList<Contrato> contratos;
    private ArrayList<Visita> visitas;

    public Sistema() {
        depositos = new ArrayList<Deposito>();
        clientes = new ArrayList<Cliente>();
        empleados = new ArrayList<Empleado>();
        contratos = new ArrayList<Contrato>();
        visitas = new ArrayList<Visita>();
    }

    public ArrayList<Deposito> getDepositos() {
        return depositos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public ArrayList<Visita> getVisitas() {
        return visitas;
    }

    public void agregarDeposito(Deposito d) {
        this.depositos.add(d);
    }

    public void agragarCliente(Cliente c) {
        this.clientes.add(c);
    }

    public void agregarEmpleado(Empleado e) {
        this.empleados.add(e);
    }

    public void agregarContrato(Contrato c) {
        this.contratos.add(c);
    }

    public void agregarVisita(Visita v) {
        this.visitas.add(v);
    }

    public void eliminarContrato(Contrato c) {

        this.getContratos().remove(c);

    }
    
    
    public void actualizarEstadoDeposito(Contrato c){
    c.getDeposito().setOcupado(false);
    
    
    
    }

    public boolean existeCliente(Cliente c) {
        boolean resu = false;
        for (int i = 0; i < this.getClientes().size() && !resu; i++) {
            if (this.getClientes().get(i).getCedula().equals(c.getCedula())) {
                resu = true;
            }
        }
        return resu;

    }

    public boolean existeEmpleado(Empleado e) {
        boolean resu = false;
        for (int i = 0; i < this.getEmpleados().size() && !resu; i++) {
            if (this.getEmpleados().get(i).getCedula().equals(e.getCedula())) {
                resu = true;
            }
        }
        return resu;

    }

    public boolean existeDeposito(Deposito d) {
        boolean resu = false;
        for (int i = 0; i < this.getDepositos().size() && !resu; i++) {
            if (this.getDepositos().get(i).getNumero() == d.numero) {
                resu = true;
            }
        }
        return resu;

    }

    public Sistema cargarSistema() {
        Sistema sistema = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("datosPrueba.ser"));
            sistema = (Sistema) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("NOHAYARCHIVO");
            sistema = new Sistema();
        }
        return sistema;
    }

    public void guardarSistema(Sistema sistema) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("datosPrueba.ser"));
            out.writeObject(sistema);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
