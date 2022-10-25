/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JENG-PC
 */
public class Superheroe {
       private String nombre;
       private int salud;     
       private int daño;
       private int proteccion;
    public Superheroe(String nombre, int salud,int daño, int proteccion) {
        this.nombre = nombre;
        this.salud = salud;        
        this.daño = daño;
        this.proteccion = proteccion;
    }

    public Superheroe() {
    }
    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getProteccion() {
        return proteccion;
    }

    public void setProteccion(int proteccion) {
        this.proteccion = proteccion;
    }

    
}
