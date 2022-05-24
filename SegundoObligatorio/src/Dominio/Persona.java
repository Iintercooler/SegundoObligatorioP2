package Dominio;


public abstract class Persona {
    String nombre,cedula;
    int telefono;   

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public Persona(String nombre, String cedula, int telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }
    
    
    
    
    
    
}
