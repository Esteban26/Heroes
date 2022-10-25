/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author JENG-PC
 */
public class SuperheroeDAO {
    
    public void ListarSuperheroe (Connection conn, JComboBox nom_superheroe){
        PreparedStatement pst;
        String tabla = "superheroe";        
        String sql = "select nom_super from " +tabla;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            while (result.next()) {             
                
                nom_superheroe.addItem(result.getString("nom_super"));
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println("No se pudo listar el nombre del superheroe");
        }   
    }
    
     public void ListarArma (Connection conn, JComboBox nom_arma){
        PreparedStatement pst;
        String tabla = "arma";        
        String sql = "select nom_arma from " +tabla;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            while (result.next()) {                
                nom_arma.addItem(result.getString("nom_arma"));
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println("No se pudo listar el nombre del superheroe");
        }   
    }
     
     public void ListarEscudo(Connection conn, JComboBox nom_escudo){
        PreparedStatement pst;
        String tabla = "escudo";        
        String sql = "select nom_escudo from " +tabla;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            while (result.next()) {                
                nom_escudo.addItem(result.getString("nom_escudo"));
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println("No se pudo listar el escudo");
        }   
    }
     public int consultaVidaHeroe (Connection conn, String sel_heroe){
         int vida = 0;
         PreparedStatement pst = null;
         String tabla = "superheroe";         
         String sql = "select vida_super from " + tabla + " where nom_super =  ? ";        
         try{
             pst = conn.prepareStatement(sql);             
             pst.setString(1,sel_heroe);             
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                  vida = rs.getInt("vida_super");
             }             
             pst.execute();
             pst.close();
         }catch(SQLException | NullPointerException e){
             System.out.print("Error no hay vida: " + e.getMessage());
         }
           return vida;    
     }
     
      public int consultaArmaHeroe (Connection conn, String sel_arma){
         int daño = 0;
         PreparedStatement pst = null;
         String tabla = "arma";         
         String sql = "select danno_arma from " + tabla + " where nom_arma =  ? ";        
         try{
             pst = conn.prepareStatement(sql);             
             pst.setString(1,sel_arma);             
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                  daño = rs.getInt("danno_arma");
             }             
             pst.execute();
             pst.close();
         }catch(SQLException | NullPointerException e){
             System.out.print("Error no hay arma: " + e.getMessage());
         }
           return daño;    
     }
    
           public int consultaEscudoHeroe (Connection conn, String sel_escudo){
         int proteccion = 0;
         PreparedStatement pst = null;
         String tabla = "escudo";         
         String sql = "select proteccion_escudo from " + tabla + " where nom_escudo =  ? ";        
         try{
             pst = conn.prepareStatement(sql);             
             pst.setString(1,sel_escudo);             
             ResultSet rs = pst.executeQuery();
             while(rs.next()){
                  proteccion = rs.getInt("proteccion_escudo");
             }             
             pst.execute();
             pst.close();
         }catch(SQLException | NullPointerException e){
             System.out.print("Error no hay escudo: " + e.getMessage());
         }
           return proteccion;    
     }
    
}
