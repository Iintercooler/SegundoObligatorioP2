/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practico_ejercicio8;

import java.util.ArrayList;


public class Sistema {
     private ArrayList<Pelicula> Peliculas = new ArrayList<Pelicula>();

    public ArrayList<Pelicula> getPeliculas() {
        return Peliculas;
    }

    public void agregarPelicula (Pelicula p){
        this.Peliculas.add(p);
    }
    
}




