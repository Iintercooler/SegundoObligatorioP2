package Dominio;

import java.io.Serializable;
import java.util.Comparator;

public class Deposito implements Serializable, Comparable<Deposito>{
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
    
    
    
    
    public Deposito() {
        this.numero = 0;
        this.tamaño = 0;
        this.estantes = false;
        this.refrigerado = false;
        this.ocupado = false;
   
    }
    
    
    
    
    
    

    public Deposito(int numero, int tamaño, boolean estantes, boolean refrigerado) {
        this.numero = numero;
        this.tamaño = tamaño;
        this.estantes = estantes;
        this.refrigerado = refrigerado;
        this.ocupado = false;
    }

    @Override
    public String toString() {
        String estatesStr;
        String refrigeradoStr;
        if (estantes){
            estatesStr=" Con estantes ";
        
        }else{
        estatesStr=" Sin estantes ";
        }
        
        if (refrigerado){
        refrigeradoStr="Con refrigeracion";
        
        }else{
        refrigeradoStr="Sin refrigeracion";
        }
        
        
        return "Deposito: "+"Num: " + numero + ", (" + tamaño +" m2)," +estatesStr+"," +refrigeradoStr;
    }

   @Override
    public int compareTo(Deposito o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static class Comparators {
        public static Comparator<Deposito> NUMERO = new Comparator<Deposito>() {
            @Override
            public int compare(Deposito o1, Deposito o2) {
                return o1.numero - o2.numero;
            }
        };
    }
    
}
