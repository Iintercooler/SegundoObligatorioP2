package Dominio;

import java.io.Serializable;


public class Persona implements Serializable{
    String nombre,cedula;
    String telefono;   

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public Persona(String nombre, String cedula, String telefono) {
        this.setNombre(nombre);
        this.setCedula(cedula);
        this.setTelefono(telefono);
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono ;
    }
    
    
    
    
    
    
}
