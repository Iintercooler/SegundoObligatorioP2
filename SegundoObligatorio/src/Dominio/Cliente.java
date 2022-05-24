package Dominio;

public class Cliente extends Persona {
    String mail;

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public Cliente(String mail, String nombre, String cedula, int telefono) {
        super(nombre, cedula, telefono);
        setMail(mail);
    }

}
