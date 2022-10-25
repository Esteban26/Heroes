/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Vista.Vista_batalla;
import Modelo.Superheroe;
import Modelo.SuperheroeBO;
import Modelo.SuperheroeDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
        
/**
 *
 * @author JENG-PC
 */
public class controlador implements ActionListener{
    
    private Vista_batalla vista;
    private Superheroe modelo;  
    SuperheroeBO subo = new SuperheroeBO();

    public controlador(Vista_batalla vista, Superheroe modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.btn_atacar.addActionListener(this);
        ListarSuperheroe();
        ListarArma();
        ListarEscudo();
    }
    public void iniciar_vista(){
        vista.setTitle("Batalla de heroes!!!!!!!!!!!!!");
        vista.setLocationRelativeTo(null);  
        vista.setLocation(200, 100);
    }
    public void ListarSuperheroe(){
        try {
           subo.ListarSuperheroe(vista.lst_heroe_ataca);
           subo.ListarSuperheroe(vista.lst_heroe_recibe);
        } catch (SQLException e) {
           System.out.print("No hay heroes registrados"); 
        }
    }
    public void ListarArma(){
        try{
            subo.ListarArma(vista.lst_arma);
        }catch(SQLException e){
            System.out.print("No hay armas registradas");
        }
    }
    public void ListarEscudo(){
        try {
        subo.ListarEscudo(vista.lst_escudo);
        
        } catch (SQLException e) {
            System.out.print("No hay escudos registrados");
        }
   }
    public int consultaVidaHeroe(String nom_heroe){
        int vida = 0;
        try {
            vida = subo.consultaVidaHeroe(nom_heroe);
           
        } catch (SQLException e) {
           System.out.print("No hay registro de vidas del heroe");

        }
        return vida;
    }
    public int consultaArmaHeroe(String nom_arma){
       int daño = 0;
        try {
            daño = subo.consultaArmaHeroe(nom_arma);
            
        } catch (SQLException e) {
            System.out.print("N0 hay registo daño de arma");
        }
       return daño;
    }   
    
    public int consultaEscudoHeroe(String nom_escudo){
       int proteccion = 0;
        try {
            proteccion = subo.consultaEscudoHeroe(nom_escudo);
        } catch (SQLException e) {
            System.out.print("N0 hay registo proteccion de escudo");
        }
       return proteccion;
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        //Nombre,salud y arma   
        int salud_victima = consultaVidaHeroe((String)vista.lst_heroe_recibe.getSelectedItem()); 
        int salud_ataca = consultaVidaHeroe((String)vista.lst_heroe_ataca.getSelectedItem());
        int arma_atacante = consultaArmaHeroe((String)vista.lst_arma.getSelectedItem());
        int proteccion_victima = 
        int salud = 0;
        int daño = 0;
        if(e.getSource() == vista.btn_atacar){
            String nom_atacante = String.valueOf(vista.lst_heroe_ataca.getSelectedItem());
            String arma_atacante = String.valueOf(vista.lst_arma.getSelectedItem());
            String nom_victima = String.valueOf(vista.lst_heroe_recibe.getSelectedItem());              
            String escudo_victima = String.valueOf(vista.lst_escudo.getSelectedItem());
            
            Superheroe victima = new Superheroe(nom_victima,salud_victima,arma_atacante,escudo_victima);            
            Superheroe atacante = new Superheroe(nom_atacante,salud_ataca,arma_atacante,escudo_victima);
            vista.lbl_resultado.setText("El resultado es: "+atacante.atacar(victima));  
            
//            
        
        }
        
    }
    
    
    
}
