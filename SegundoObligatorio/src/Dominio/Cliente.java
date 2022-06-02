package Dominio;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{
    String mail;

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public Cliente(String mail, String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        setMail(mail);
    }

    @Override
    public String toString() {
        return "Cliente: " + "mail=" + mail +", "+ super.toString();
    }

  

    
    
    
    
}
