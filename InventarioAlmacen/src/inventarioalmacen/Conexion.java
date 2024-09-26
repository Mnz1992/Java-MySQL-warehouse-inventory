/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioalmacen;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author misa_
 */
public class Conexion {
    String url;
     String user;
     String pass;
     Connection conectar;
     Statement sentencia;

 
 
    public Conexion() {
       // initComponents();
         url="jdbc:mysql://127.0.0.1:3306/strelok";
         user="root";
         pass="AMOmimadre123"; 
         laconec();
    }
    public void laconec(){
         //mensaje("Conectando...");
         try{
         conectar=(Connection) DriverManager.getConnection(url, user, pass);
         //mensaje("Conección exitosa");
         sentencia=(Statement) conectar.createStatement();
         }
         catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
    }
}
}
