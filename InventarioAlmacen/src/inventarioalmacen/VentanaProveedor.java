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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author misa_
 */
public class VentanaProveedor extends JFrame{
        public JPanel panel;
        public JTextField RFCP, nombreP, empresa, telefono;
        public Conexion conexion;
        public Connection con;
        JComboBox proveedores;
        
    
    public VentanaProveedor(){
        setSize(1366,768);
        setTitle("STRELOK S.I.A.");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1024,720));
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
       inicio();
       conexion =new Conexion();
      
    }
    
    
    private void inicio(){
            panel();
            panelC();

    }
    private void panel(){
        panel =new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(217, 217, 217));

    }
    private void panelC(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,70, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Registro Proveedor");
        panel.add(texto);
    }
    private void panelModP(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,50, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Actualizar Proveedor");
        panel.add(texto);
    }
    private void panelElP(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,60, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Eliminar Proveedor");
        panel.add(texto);
    }
  
 
    ///////////////////////////////Metodo componenetes Registrar Proveedor
    private void componentesRP(){
        JLabel RFC=new JLabel();
        RFC.setText("RFC");
        RFC.setBounds(520,200,200,50);
        RFC.setFont(new Font("cops",1,26));
        panel.add(RFC);
         RFCP=new JTextField();
       RFCP.setFont(new Font("cops",1,26));
       TextPrompt prueba =new TextPrompt ("RFC del proveedor",RFCP);
       RFCP.setBounds(380, 240, 350, 50);
       panel.add(RFCP);
       
       JLabel nombre=new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(190,350,200,50);
        nombre.setFont(new Font("cops",1,26));
        panel.add(nombre);
       nombreP=new JTextField();
       nombreP.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("Nombre proveedor",nombreP);
       nombreP.setBounds(50, 390, 350, 50);
       panel.add(nombreP);
       
       JLabel empresat=new JLabel();
        empresat.setText("Empresa");
        empresat.setBounds(580,350,200,50);
        empresat.setFont(new Font("cops",1,26));
        panel.add(empresat);
       empresa=new JTextField();
       empresa.setFont(new Font("cops",1,26));
       TextPrompt prueba2 =new TextPrompt ("Nombre empresa",empresa);
       empresa.setBounds(450, 390, 350, 50);
       panel.add(empresa);
       
       JLabel telE=new JLabel();
       telE.setText("Telefono");
        telE.setBounds(970,350,200,50);
        telE.setFont(new Font("cops",1,26));
        panel.add(telE);
       telefono=new JTextField();
       telefono.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Numero de telefono",telefono);
       telefono.setBounds(850, 390, 350, 50);
       panel.add(telefono);
       
       
        JButton btnGuardar= new JButton();
       btnGuardar.setBounds(700, 620, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.addActionListener(AccionRP);
       
       JButton btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(AccionVolver);
        
    }
    
         ActionListener AccionRP = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               /*String qryInsert="insert into proveedor "
         + "(ID_Proveedor, Nombre_prov, Empresa_prov, Telefono) values "
         + "('"+RFCP.getText().toUpperCase()+"','"+nombreP.getText().toUpperCase()
         + "','"+empresa.getText()+"','"+telefono.getText()+"')"; */
               String qryInsert="call registrarproveedor('"+RFCP.getText().toUpperCase()
                       +"','"+empresa.getText()+"','"+nombreP.getText().toUpperCase()+"','"+telefono.getText()+"')"; 
         try{
             
             
   
        conexion.sentencia.executeUpdate(qryInsert);
             //con=conexion.conectar;
             //ps=con.prepareStatement(string);
         RFCP.setText("");
         nombreP.setText("");
         empresa.setText("");
         telefono.setText("");
         
         }
         catch(SQLException f){
         JOptionPane.showMessageDialog(null,"ERROR..."+f.getMessage());
         }
            }
             
             
         };
         
         
     private void componentesActualizarProveedor(){
        JLabel RFC=new JLabel();
        RFC.setText("RFC");
        RFC.setBounds(540,200,200,50);
        RFC.setFont(new Font("cops",1,26));
        panel.add(RFC);
        
       proveedores=new JComboBox<String>();
        proveedores.setBounds(400,240,350,50);
        panel.add(proveedores);
        proveedores.setBackground(new Color(245, 203, 104));
        proveedores.setFont(new Font ("copper",2,30));
        proveedores.setForeground(Color.black);
        
       String qrySelect;
         String registros;
         ResultSet resultado;
         qrySelect="select * from proveedor";
         registros="";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         proveedores.addItem(resultado.getString("ID_Proveedor"));
         
         }
         
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
        proveedores.setSelectedIndex(-1);
        proveedores.addActionListener(Accionllenarproveedor);
        
        
       JLabel nombre=new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(190,350,200,50);
        nombre.setFont(new Font("cops",1,26));
        panel.add(nombre);
       nombreP=new JTextField();
       nombreP.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("Nombre proveedor",nombreP);
       nombreP.setBounds(50, 390, 350, 50);
       panel.add(nombreP);
       
       JLabel empresat=new JLabel();
        empresat.setText("Empresa");
        empresat.setBounds(580,350,200,50);
        empresat.setFont(new Font("cops",1,26));
        panel.add(empresat);
       empresa=new JTextField();
       empresa.setFont(new Font("cops",1,26));
       TextPrompt prueba2 =new TextPrompt ("Nombre empresa",empresa);
       empresa.setBounds(450, 390, 350, 50);
       panel.add(empresa);
       
       JLabel telE=new JLabel();
       telE.setText("Telefono");
        telE.setBounds(970,350,200,50);
        telE.setFont(new Font("cops",1,26));
        panel.add(telE);
       telefono=new JTextField();
       telefono.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Numero de telefono",telefono);
       telefono.setBounds(850, 390, 350, 50);
       panel.add(telefono);
       
       
        JButton btnGuardar= new JButton();
       btnGuardar.setBounds(700, 620, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.addActionListener(AccionActualizarP);
       
       JButton btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(AccionVolver);
        
    }    

    private void componentesEliminarProveedor(){
       
        JLabel RFC=new JLabel();
        RFC.setText("RFC");
        RFC.setBounds(540,200,200,50);
        RFC.setFont(new Font("cops",1,26));
        panel.add(RFC);
        
       proveedores=new JComboBox<String>();
        proveedores.setBounds(400,240,350,50);
        panel.add(proveedores);
        proveedores.setBackground(new Color(245, 203, 104));
        proveedores.setFont(new Font ("copper",2,30));
        proveedores.setForeground(Color.black);
        
       String qrySelect;
         String registros;
         ResultSet resultado;
         qrySelect="select * from proveedor";
         registros="";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         proveedores.addItem(resultado.getString("ID_Proveedor"));
         
         }
         
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
        proveedores.setSelectedIndex(-1);
        proveedores.addActionListener(Accionllenarproveedor);
        
        
       JLabel nombre=new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(190,350,200,50);
        nombre.setFont(new Font("cops",1,26));
        panel.add(nombre);
       nombreP=new JTextField();
       nombreP.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("Nombre proveedor",nombreP);
       nombreP.setBounds(50, 390, 350, 50);
       panel.add(nombreP);
       
       JLabel empresat=new JLabel();
        empresat.setText("Empresa");
        empresat.setBounds(580,350,200,50);
        empresat.setFont(new Font("cops",1,26));
        panel.add(empresat);
       empresa=new JTextField();
       empresa.setFont(new Font("cops",1,26));
       TextPrompt prueba2 =new TextPrompt ("Nombre empresa",empresa);
       empresa.setBounds(450, 390, 350, 50);
       panel.add(empresa);
       
       JLabel telE=new JLabel();
       telE.setText("Telefono");
        telE.setBounds(970,350,200,50);
        telE.setFont(new Font("cops",1,26));
        panel.add(telE);
       telefono=new JTextField();
       telefono.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Numero de telefono",telefono);
       telefono.setBounds(850, 390, 350, 50);
       panel.add(telefono);
       
       
        JButton btnGuardar= new JButton();
       btnGuardar.setBounds(700, 620, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Elimina");
       btnGuardar.setForeground(Color.white);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.black);
       btnGuardar.addActionListener(AccionEliminarP);
       
       JButton btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(AccionVolver);
        
       
    }
    
     ActionListener AccionEliminarP = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
            String qryDelete;
            qryDelete="delete from proveedor where ID_Proveedor="+"'"+proveedores.getSelectedItem()+"'";
                try {
                  conexion.sentencia.executeUpdate(qryDelete);
                    setVisible(false);
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
                }
                    
            }
         
     };
     
     
     ActionListener Accionllenarproveedor = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String qrySelect;
         ResultSet resultado;
         qrySelect="select * from proveedor WHERE ID_Proveedor="+"'"+proveedores.getSelectedItem()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
             {
         
         nombreP.setText(resultado.getString("Nombre_prov"));
         empresa.setText(resultado.getString("Empresa_prov"));
         telefono.setText(resultado.getString("Telefono"));
                
         //listae.addItem(resultado.getString("ID_Empleado"));
             }
         }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage()); 
         }
                
                
            }
         
     };
     
     
     
     ActionListener AccionActualizarP = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String qryUpdate;
                qryUpdate="UPDATE proveedor SET Nombre_prov='"+nombreP.getText()+"',Empresa_prov='"+empresa.getText()+"',Telefono='"+
                        telefono.getText()+"'WHERE ID_Proveedor="+"'"+proveedores.getSelectedItem()+"'";
                        
                        /*"UPDATE from proveedor where ID_Proveedor="+"'"+RFCP.getText()+"'"
                        +"(ID_Proveedor, Nombre_prov, Empresa_prov, Telefono) values "
                        + "('"+nombreP.getText()
                        + "','"+empresa.getText()+"','"+telefono.getText()+"')";*/
                
                try {
                  conexion.sentencia.executeUpdate(qryUpdate);
                    setVisible(false);
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
                }
            }
         
     };
 

  
   ActionListener Accionregistrarp = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           panel.removeAll();
           panel.repaint();
           componentesRP();
           //panelAP();
           
        }
       
   };
   

   
   ActionListener AccionVolver = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           setVisible(false);
        }
       
   };

     public void menuProveedor(int i){
          if(i==1){//registrar proveedor
           panel.removeAll();
           panel.repaint();
           componentesRP();
           panelC();
       }
       if(i==2){//actualizar proveedor
           panel.removeAll();
           panel.repaint();
          componentesActualizarProveedor();
          panelModP();
     }      
       
       if(i==3){//eliminar proveedor
           panel.removeAll();
           panel.repaint();
          componentesEliminarProveedor();
          panelElP();
     }      

         
    }
}
