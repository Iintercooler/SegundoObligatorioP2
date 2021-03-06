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
import java.util.stream.Stream;
import java.util.Observable;
import java.util.Observer;


public class Sistema extends Observable implements Serializable{

    private ArrayList<Deposito> depositos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> empleados;
    private ArrayList<Contrato> contratos;
    private ArrayList<Visita> visitas;
    private int cantidadContratos=1;

    private ArrayList<Observer> observer;
    
    public int getCantidadContratos() {
        return cantidadContratos;
    }

    
    public Sistema() {
        observer = new ArrayList<Observer>();
        depositos = new ArrayList<Deposito>();
        clientes = new ArrayList<Cliente>();
        empleados = new ArrayList<Empleado>();
        contratos = new ArrayList<Contrato>();
        visitas = new ArrayList<Visita>();
    }

    public ArrayList<Deposito> getDepositos() {
        return depositos;
    }
    
    
    
    private ArrayList<Deposito> getDepositosRefri(boolean refrigerado,ArrayList<Deposito> d) {
        
        ArrayList<Deposito> refrigerados=new  ArrayList<>();
        
        for (int i = 0; i < d.size(); i++) {
            if((d.get(i).isRefrigerado()==refrigerado)&&( d.get(i).isOcupado() == false)){
            refrigerados.add(d.get(i));
            
            
            }
            
        }
        
        
        return refrigerados;
    }
    
    
      private ArrayList<Deposito> getDepositosEstantes(boolean estantes,ArrayList<Deposito> d) {
        
        ArrayList<Deposito> conestantes=new  ArrayList<>();
        
        for (int i = 0; i < getDepositos().size(); i++) {
            if((d.get(i).isEstantes()==estantes)&&( d.get(i).isOcupado() == false)){
            conestantes.add(d.get(i));
            
            
            }
            
        }
        
        
        return conestantes;
    }
      
      
       public ArrayList<Deposito> getDepositosCondiciones(boolean estantes,boolean refrigerado,boolean indiferente) {
           
           
            ArrayList<Deposito> cumplen=new  ArrayList<>();
             ArrayList<Deposito> aux=new  ArrayList<>();
            ArrayList<Deposito> resu=new  ArrayList<>();
           
            
            if (indiferente){
            
           
            
            resu= (ArrayList<Deposito>) getDepositos().stream().filter(Deposito -> !Deposito.isOcupado());
                    }else{
            
                
                
                cumplen=getDepositosEstantes(estantes,getDepositos());
                aux=cumplen;
                resu=getDepositosRefri(refrigerado,aux);
                
                
                
            
            
            
            }
            
            
            return resu;
           
            
            
            
            
            
           
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
        notifyObservers();
    }

    public void agragarCliente(Cliente c) {
        this.clientes.add(c);
        notifyObservers();
    }

    public void agregarEmpleado(Empleado e) {
        this.empleados.add(e);
        notifyObservers();
    }

    public void agregarContrato(Contrato c) {
        this.cantidadContratos++;
        this.contratos.add(c);
        notifyObservers();
    }

    public void agregarVisita(Visita v) {
        this.visitas.add(v);
        notifyObservers();
    }
    
    
    public void eliminarVisita(Visita v){
    this.visitas.remove(v);
    }

    public void eliminarContrato(Contrato c) {
        this.getContratos().remove(c);
        notifyObservers();

    }
    
    
    public void actualizarEstadoDeposito(Contrato c){
    c.getDeposito().setOcupado(false);
    
    
    
    }



    
    public boolean existePersona(String cedula){
         boolean resu = false;
        
         for (int i = 0; i < this.getEmpleados().size() && !resu; i++) {
            
             if (Integer.parseInt(this.getEmpleados().get(i).getCedula())==Integer.parseInt(cedula)) {
                resu = true;
               
            }
        }
        
         for (int i = 0; i < this.getClientes().size() && !resu; i++) {
            if (Integer.parseInt(this.getClientes().get(i).getCedula())==Integer.parseInt(cedula)) {
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

    
    
    @Override
    public void addObserver(Observer observer){
    this.observer.add(observer);
    
    }
    
    public void notifyObservers(){
    if (observer!= null){
        for (int i = 0; i < observer.size(); i++) {
            observer.get(i).update(this, this);
        }
   
    
    
    }
    }
    
    
}
