/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author JENG-PC
 */
public class SuperheroeBO {
    private String mensaje = "";
    private SuperheroeDAO sdao = new SuperheroeDAO();
    Connection conn;
    
    public void ListarSuperheroe (JComboBox nom_superheroe)throws SQLException{
         conn = conexion.getConnection();
        try {
            sdao.ListarSuperheroe(conn, nom_superheroe);
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
        }finally{
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    
    } 
    public void ListarArma (JComboBox nom_arma) throws SQLException{
         conn = conexion.getConnection();
         try{
             sdao.ListarArma(conn, nom_arma);
             conn.close();
         }catch(SQLException e){
             conn.rollback();
         }finally{
             try{
                 if(conn!=null){
                     conn.close();                             
                 }
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
         }
   
    }
    
    public void ListarEscudo (JComboBox nom_escudo) throws SQLException{
         conn = conexion.getConnection();
         try{
             sdao.ListarEscudo(conn, nom_escudo);
             conn.close();
         }catch(SQLException e){
             conn.rollback();
         }finally{
             try{
                 if(conn!=null){
                     conn.close();                             
                 }
             }catch(SQLException e){
                 System.err.println(e.getMessage());
             }
         }
   
    }
     public int consultaVidaHeroe (String sel_heroe)throws SQLException{
         int vida = 0;
         conn = conexion.getConnection();
         try {
             vida = sdao.consultaVidaHeroe(conn, sel_heroe);             
             conn.commit();
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
             conn.rollback();         
         }finally{
           try{
               if(conn!= null){
                   conn.close();
               }
           }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e.getMessage());
           }
       }       
        return vida;
     }
        
      public int consultaArmaHeroe(String sel_arma)throws SQLException{
         int da??o = 0;
         conn = conexion.getConnection();
         try {
             da??o = sdao.consultaArmaHeroe(conn, sel_arma);             
             conn.commit();
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
             conn.rollback();         
         }finally{
           try{
               if(conn!= null){
                   conn.close();
               }
           }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e.getMessage());
           }
       }       
        return da??o;
      }
        
  public int consultaEscudoHeroe(String sel_escudo)throws SQLException{
         int proteccion = 0;
         conn = conexion.getConnection();
         try {
             proteccion = sdao.consultaEscudoHeroe(conn, sel_escudo);             
             conn.commit();
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
             conn.rollback();         
         }finally{
           try{
               if(conn!= null){
                   conn.close();
               }
           }catch(SQLException e){
             JOptionPane.showMessageDialog(null, e.getMessage());
           }
       }       
        return proteccion;
 }
   
    
}
