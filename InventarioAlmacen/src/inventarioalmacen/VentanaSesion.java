/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioalmacen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author misa_
 */
public class VentanaSesion extends JFrame{
    public JPanel panel;
    public JTextField usuario, contrasena;
    public Conexion conexion;

    
    public VentanaSesion(){
        setSize(1366,768);
        setTitle("STRELOK S.I.A Inicio Sesion.");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1024,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       inicio();
       conexion =new Conexion();
       //this.setResizable(false);
    }
    
    private void inicio(){
        panel();
        botonesInterfaz();
        txt();
        panelC();
       
        
        
    }
    private void panel(){
        panel =new JPanel();
        panel.setLayout(null);
      this.getContentPane().add(panel);
      
    }
    
    
    private void panelC(){
        JLabel Background;
          Background=new JLabel(new ImageIcon(getClass().getResource("IMG/sesion.png")));
          Background.setBounds(0, 0, 1366, 768);
         panel.add(Background);
         
         
    }
    public void txt(){
       usuario=new JTextField();
       usuario.setFont(new Font("cops",1,28));
       TextPrompt prueba =new TextPrompt ("Usuario",usuario);
       usuario.setBounds(570, 420, 330, 60);
       panel.add(usuario);
       
       
       contrasena=new JTextField();
       contrasena.setFont(new Font("cops",1,28));
       TextPrompt prueba2 =new TextPrompt ("Contrasena",contrasena);
       contrasena.setBounds(570, 510, 330, 60);
       panel.add(contrasena);
       
       
       //usuario.UseSystemPasswordChar=true;
    }
    
    public void botonesInterfaz(){
        //BOTON inciar sesion
       JButton btniniciar= new JButton();
        btniniciar.setBounds(720, 580, 130, 40);
       panel.add(btniniciar);
       btniniciar.setText("Acceder");
       btniniciar.setForeground(Color.white);
       btniniciar.setFont(new Font ("copper",2,24));
       btniniciar.setBackground(Color.black);
       
        //ImageIcon b = new ImageIcon("acceder.png");
        //btniniciar.setIcon(new ImageIcon(b.getImage().getScaledInstance(btniniciar.getWidth(), btniniciar.getHeight(), Image.SCALE_SMOOTH)));
        btniniciar.addActionListener(Accionsesion);
        
        
           

        
      
    }
    //prueba para llamar diferente pane desde otra clase
     ActionListener Accionsesion1 = new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae) {
               VentanaEmpleados B= new VentanaEmpleados();
               B.setVisible(true);
               B.prueba(2);
               
               
           }
                
            };
    public void cerrar(){
        this.setVisible(false);
    }
    public void advertencia(){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Usuario o Contrasena incorreecto");
    }
    ActionListener Accionsesion = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            int k=0;
          String qrySelect;
         ResultSet resultado;
         qrySelect="select * from usuario";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         
         while(resultado.next()){
             if(resultado.getString("Nombre_usuario").equals(usuario.getText())&& resultado.getString("Contraseña").equals(contrasena.getText())){
               Ventana B= new Ventana(); 
               B.setVisible(true);
               cerrar();
                k=1;
             }
         }
         if(k==0){
                 JOptionPane.showMessageDialog(null,"Usuario o contrasena incorrectos, intentelo nuevamente");
                 usuario.setText("");
                 contrasena.setText("");
             }
         //JOptionPane.showMessageDialog(null, registros);
         
                 
         }catch(SQLException e){
         mensaje("ERROR..."+e.getMessage());  
         
         }
            
            
            
            
            
            
            
            
            
            
            /*
           String qrySelect;
         String registros;
         ResultSet resultado;
         qrySelect="select * from empleado";
         registros="";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         registros=registros
         +resultado.getString("ID_Empleado")
         +" "+resultado.getString("Nombre_E")
         +" "+resultado.getString("AP_pat")+"\n";
         }
         JOptionPane.showMessageDialog(null, registros);
         }catch(SQLException e){
         mensaje("ERROR..."+e.getMessage());  
         
         } */
            
            
            
            
            
            
            
            
            //Ventana B= new Ventana(); 
              //  B.setVisible(true);
            //cerrar();
        }

        private void mensaje(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
       
   };
    
  
}
