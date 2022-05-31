package Dominio;

import java.io.Serializable;


public class Empleado extends Persona implements Serializable{
    String direccion;
    int añoDeIngreso;

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setAñoDeIngreso(int añoDeIngreso) {
        this.añoDeIngreso = añoDeIngreso;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getAñoDeIngreso() {
        return añoDeIngreso;
    }
    



    public Empleado(String direccion, int añoDeIngreso, String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.direccion = direccion;
        this.añoDeIngreso = añoDeIngreso;
    }

    @Override
    public String toString() {
        return "Empleado{" + "direccion=" + direccion + ", a\u00f1oDeIngreso=" + añoDeIngreso + '}'+super.toString();
    }
    
    
    
    
    
    
   
}
