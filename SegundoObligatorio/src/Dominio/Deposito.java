package Dominio;

public class Deposito {
    int numero;
    int tamaño;
    boolean estantes;
    boolean refrigerado;
    boolean ocupado;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void setEstantes(boolean estantes) {
        this.estantes = estantes;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean isEstantes() {
        return estantes;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public Deposito(int numero, int tamaño, boolean estantes, boolean refrigerado) {
        this.numero = numero;
        this.tamaño = tamaño;
        this.estantes = estantes;
        this.refrigerado = refrigerado;
        this.ocupado = false;
    }

   
    
}
