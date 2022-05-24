package Dominio;


public class Empleado extends Persona {
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
    



    public Empleado(String direccion, int añoDeIngreso, String nombre, String cedula, int telefono) {
        super(nombre, cedula, telefono);
        this.direccion = direccion;
        this.añoDeIngreso = añoDeIngreso;
    }
    
    
    
   
}
