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
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class VentanaProducto extends JFrame {
            public JPanel panel;
            public JTextField codigoP, nombreP, categoria, precio, unidades;
            public Conexion conexion;
            private JComboBox categorialista, tipounidad, codP;
            
    public VentanaProducto(){
        setSize(1366,768);
        setTitle("STRELOK PRODUCTOS");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1024,720));
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicio();
        conexion =new Conexion();
    }
    
    private void inicio(){
        panel();
        panelC();
       
        
        
    }
 private void panelsesion(){
        panel =new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(217, 217, 217));
      
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
        texto.setBounds(230,60, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Registro Producto");
        panel.add(texto);
        
    }
    
    
   private void panelActualizarP(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
        ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(250,50, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Actualizar Producto");
        panel.add(texto);
        
    }
   
    private void panelEliminarP(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
        ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,50, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Eliminar Producto");
        panel.add(texto);
        
    }
    
    private void componentesRegistrarp(){
       JLabel codigo=new JLabel();
        codigo.setText("Codigo");
        codigo.setBounds(560,160,200,50);
        codigo.setFont(new Font("cops",1,26));
        panel.add(codigo);
        codigoP=new JTextField();
       codigoP.setFont(new Font("cops",1,26));
       TextPrompt prueba =new TextPrompt ("Codigo de producto",codigoP);
       codigoP.setBounds(420, 210, 350, 50);
       panel.add(codigoP);
       
       JLabel nombreprod=new JLabel();
        nombreprod.setText("Nombre");
        nombreprod.setBounds(240,270,200,50);
        nombreprod.setFont(new Font("cops",1,26));
        panel.add(nombreprod);
       nombreP=new JTextField();
       nombreP.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("Nombre P.",nombreP);
       nombreP.setBounds(100, 320, 350, 50);
       panel.add(nombreP);
       
       JLabel categoriap=new JLabel();
        categoriap.setText("Categoria");
        categoriap.setBounds(610,280,200,50);
        categoriap.setFont(new Font("cops",1,26));
        panel.add(categoriap);
       categorialista=new JComboBox<>();
        categorialista.setBounds(500,320,350,50);
        panel.add(categorialista);
        categorialista.addItem("Despensa");
        categorialista.addItem("Lateos");
        categorialista.addItem("Bebidas y jugos");
        categorialista.addItem("Carnes");
        categorialista.addItem("Salchichoneria");
        categorialista.addItem("Cuidado personal");
        categorialista.addItem("Aseo y lavanderia");
        categorialista.addItem("Articulos oficina");
        categorialista.addItem("Mascotas");
        categorialista.addItem("Desechables");
        categorialista.addItem("Panaderia y tortilleria");
        categorialista.addItem("Articulos del hogar");
        categorialista.addItem("Faracia");
        categorialista.addItem("Licores");
        categorialista.addItem("Otros");
       categorialista.setBackground(new Color(245, 203, 104));
       categorialista.setFont(new Font ("copper",2,28));
       categorialista.setForeground(Color.black);
       categorialista.setSelectedIndex(-1);
       

       JLabel preciop=new JLabel();
        preciop.setText("Precio");
        preciop.setBounds(910,280,200,50);
        preciop.setFont(new Font("cops",1,26));
        panel.add(preciop);
       precio=new JTextField();
       precio.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Precio U.",precio);
       precio.setBounds(900, 320, 200, 50);
       panel.add(precio);
       
       JLabel unidadesp=new JLabel();
        unidadesp.setText("Unidades");
        unidadesp.setBounds(350,405,200,50);
        unidadesp.setFont(new Font("cops",1,26));
        panel.add(unidadesp);
        unidades=new JTextField();
       unidades.setFont(new Font("cops",1,26));
       TextPrompt prueba33 =new TextPrompt ("Unidades(cantidad)",unidades);
       unidades.setBounds(350, 445, 150, 50);
       panel.add(unidades);
       
       JLabel tipou=new JLabel();
        tipou.setText("Tipo de unidades");
        tipou.setBounds(610,405,250,50);
        tipou.setFont(new Font("cops",1,26));
        panel.add(tipou);
       tipounidad=new JComboBox<>();
        tipounidad.setBounds(610,445,350,50);
        panel.add(tipounidad);
        tipounidad.addItem("kg");
        tipounidad.addItem("gr");
        tipounidad.addItem("L");
        tipounidad.addItem("ml");
        tipounidad.addItem("Caja");
        tipounidad.addItem("Unidad");
        tipounidad.addItem("Pieza");
        tipounidad.addItem("otro");
       tipounidad.setBackground(new Color(245, 203, 104));
       tipounidad.setFont(new Font ("copper",2,28));
       tipounidad.setForeground(Color.black);
       tipounidad.setSelectedIndex(-1);
       
       JButton btnGuardar= new JButton();
       btnGuardar.setBounds(700, 620, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.addActionListener(AccionmRegistrarP);
       
       JButton btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(AccionVolver);
       
    }
       ActionListener AccionmRegistrarP = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String qryInsert;
                    qryInsert="INSERT into producto SET Cod_barras_p="+"'"+codigoP.getText()+"'"+",Nombre_prod="+"'"+nombreP.getText()+"'"+",Categoria="+"'"+
                        categorialista.getSelectedItem()+"'"+",Precio="+"'"+precio.getText()+"'"+",Unidades="+"'"+unidades.getText()+"'"
                            +",Tipo_Unidad="+"'"+tipounidad.getSelectedItem()+"'";
                    try {
                         conexion.sentencia.executeUpdate(qryInsert);
                          codigoP.setText("");
                          nombreP.setText("");
                          precio.setText("");
                          categorialista.setSelectedIndex(-1);
                          unidades.setText("");
                          tipounidad.setSelectedIndex(-1);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
                    }
                }
           
       };
       
       
        private void componenteActualizarProducto(){
       JLabel codigo=new JLabel();
        codigo.setText("Codigo");
        codigo.setBounds(530,130,200,50);
        codigo.setFont(new Font("cops",1,26));
        panel.add(codigo);       
       codP=new JComboBox<>();
        codP.setBounds(400,170,350,50);
        panel.add(codP);
       codP.setBackground(new Color(245, 203, 104));
       codP.setFont(new Font ("copper",2,28));
       codP.setForeground(Color.black);
       
       String qrySelect;
         String registros;
         ResultSet resultado;
         qrySelect="select * from producto";
         registros="";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         codP.addItem(resultado.getString("Cod_barras_p"));
         
         }
         
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
       codP.setSelectedIndex(-1);
       codP.addActionListener(AccionLlenarProducto);
       
       JLabel nombreprod=new JLabel();
        nombreprod.setText("Nombre");
        nombreprod.setBounds(190,260,200,50);
        nombreprod.setFont(new Font("cops",1,26));
        panel.add(nombreprod);
       nombreP=new JTextField();
       nombreP.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("Nombre P.",nombreP);
       nombreP.setBounds(50, 300, 350, 50);
       panel.add(nombreP);
       
       JLabel categoriap=new JLabel();
        categoriap.setText("Categoria");
        categoriap.setBounds(560,260,200,50);
        categoriap.setFont(new Font("cops",1,26));
        panel.add(categoriap);
       categorialista=new JComboBox<>();
        categorialista.setBounds(450,300,350,50);
        panel.add(categorialista);
        categorialista.addItem("Despensa");
        categorialista.addItem("Lateos");
        categorialista.addItem("Bebidas y jugos");
        categorialista.addItem("Carnes");
        categorialista.addItem("Salchichoneria");
        categorialista.addItem("Cuidado personal");
        categorialista.addItem("Aseo y lavanderia");
        categorialista.addItem("Articulos oficina");
        categorialista.addItem("Mascotas");
        categorialista.addItem("Desechables");
        categorialista.addItem("Panaderia y tortilleria");
        categorialista.addItem("Articulos del hogar");
        categorialista.addItem("Faracia");
        categorialista.addItem("Licores");
        categorialista.addItem("Otros");
       categorialista.setBackground(new Color(245, 203, 104));
       categorialista.setFont(new Font ("copper",2,28));
       categorialista.setForeground(Color.black);
       categorialista.setSelectedIndex(-1);
       

       JLabel preciop=new JLabel();
        preciop.setText("Precio");
        preciop.setBounds(860,260,200,50);
        preciop.setFont(new Font("cops",1,26));
        panel.add(preciop);
       precio=new JTextField();
       precio.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Precio U.",precio);
       precio.setBounds(850, 300, 200, 50);
       panel.add(precio);
       
       JLabel unidadesp=new JLabel();
        unidadesp.setText("Unidades");
        unidadesp.setBounds(320,390,200,50);
        unidadesp.setFont(new Font("cops",1,26));
        panel.add(unidadesp);
        unidades=new JTextField();
       unidades.setFont(new Font("cops",1,26));
       TextPrompt prueba33 =new TextPrompt ("Unidades(cantidad)",unidades);
       unidades.setBounds(320, 430, 150, 50);
       panel.add(unidades);
       
       JLabel tipou=new JLabel();
        tipou.setText("Tipo de unidades");
        tipou.setBounds(580,390,250,50);
        tipou.setFont(new Font("cops",1,26));
        panel.add(tipou);
       tipounidad=new JComboBox<>();
        tipounidad.setBounds(520,430,350,50);
        panel.add(tipounidad);
        tipounidad.addItem("kg");
        tipounidad.addItem("gr");
        tipounidad.addItem("L");
        tipounidad.addItem("ml");
        tipounidad.addItem("Caja");
        tipounidad.addItem("Unidad");
        tipounidad.addItem("Pieza");
        tipounidad.addItem("otro");
       tipounidad.setBackground(new Color(245, 203, 104));
       tipounidad.setFont(new Font ("copper",2,28));
       tipounidad.setForeground(Color.black);
       tipounidad.setSelectedIndex(-1);
       
       JButton btnGuardar= new JButton();
       btnGuardar.setBounds(700, 620, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.addActionListener(AccionActualizarProducto);
       
       JButton btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(AccionVolver);
       
    }
        
        
        private void componenteEliminarProducto(){
       JLabel codigo=new JLabel();
        codigo.setText("Codigo");
        codigo.setBounds(530,130,200,50);
        codigo.setFont(new Font("cops",1,26));
        panel.add(codigo);       
       codP=new JComboBox<>();
        codP.setBounds(400,170,350,50);
        panel.add(codP);
       codP.setBackground(new Color(245, 203, 104));
       codP.setFont(new Font ("copper",2,28));
       codP.setForeground(Color.black);
       
       String qrySelect;
         String registros;
         ResultSet resultado;
         qrySelect="select * from producto";
         registros="";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         codP.addItem(resultado.getString("Cod_barras_p"));
         
         }
         
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
       codP.setSelectedIndex(-1);
       codP.addActionListener(AccionLlenarProducto);
       
       JLabel nombreprod=new JLabel();
        nombreprod.setText("Nombre");
        nombreprod.setBounds(190,260,200,50);
        nombreprod.setFont(new Font("cops",1,26));
        panel.add(nombreprod);
       nombreP=new JTextField();
       nombreP.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("Nombre P.",nombreP);
       nombreP.setBounds(50, 300, 350, 50);
       panel.add(nombreP);
       
       JLabel categoriap=new JLabel();
        categoriap.setText("Categoria");
        categoriap.setBounds(560,260,200,50);
        categoriap.setFont(new Font("cops",1,26));
        panel.add(categoriap);
       categorialista=new JComboBox<>();
        categorialista.setBounds(450,300,350,50);
        panel.add(categorialista);
        categorialista.addItem("Despensa");
        categorialista.addItem("Lateos");
        categorialista.addItem("Bebidas y jugos");
        categorialista.addItem("Carnes");
        categorialista.addItem("Salchichoneria");
        categorialista.addItem("Cuidado personal");
        categorialista.addItem("Aseo y lavanderia");
        categorialista.addItem("Articulos oficina");
        categorialista.addItem("Mascotas");
        categorialista.addItem("Desechables");
        categorialista.addItem("Panaderia y tortilleria");
        categorialista.addItem("Articulos del hogar");
        categorialista.addItem("Faracia");
        categorialista.addItem("Licores");
        categorialista.addItem("Otros");
       categorialista.setBackground(new Color(245, 203, 104));
       categorialista.setFont(new Font ("copper",2,28));
       categorialista.setForeground(Color.black);
       categorialista.setSelectedIndex(-1);
       

       JLabel preciop=new JLabel();
        preciop.setText("Precio");
        preciop.setBounds(860,260,200,50);
        preciop.setFont(new Font("cops",1,26));
        panel.add(preciop);
       precio=new JTextField();
       precio.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Precio U.",precio);
       precio.setBounds(850, 300, 200, 50);
       panel.add(precio);
       
       JLabel unidadesp=new JLabel();
        unidadesp.setText("Unidades");
        unidadesp.setBounds(320,390,200,50);
        unidadesp.setFont(new Font("cops",1,26));
        panel.add(unidadesp);
        unidades=new JTextField();
       unidades.setFont(new Font("cops",1,26));
       TextPrompt prueba33 =new TextPrompt ("Unidades(cantidad)",unidades);
       unidades.setBounds(320, 430, 150, 50);
       panel.add(unidades);
       
       JLabel tipou=new JLabel();
        tipou.setText("Tipo de unidades");
        tipou.setBounds(580,390,250,50);
        tipou.setFont(new Font("cops",1,26));
        panel.add(tipou);
       tipounidad=new JComboBox<>();
        tipounidad.setBounds(520,430,350,50);
        panel.add(tipounidad);
        tipounidad.addItem("kg");
        tipounidad.addItem("gr");
        tipounidad.addItem("L");
        tipounidad.addItem("ml");
        tipounidad.addItem("Caja");
        tipounidad.addItem("Unidad");
        tipounidad.addItem("Pieza");
        tipounidad.addItem("otro");
       tipounidad.setBackground(new Color(245, 203, 104));
       tipounidad.setFont(new Font ("copper",2,28));
       tipounidad.setForeground(Color.black);
       tipounidad.setSelectedIndex(-1);
       
       JButton btnGuardar= new JButton();
       btnGuardar.setBounds(700, 620, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Eliminar");
       btnGuardar.setForeground(Color.white);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.black);
       btnGuardar.addActionListener(AccionmEliminarPro);
       
       JButton btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(AccionVolver);
       
    }
        
        
    
     
     
     
            ActionListener AccionmEliminarPro = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String qryDelete;
                    qryDelete="delete from producto where Cod_barras_p="+"'"+codP.getSelectedItem()+"'";
                    try {
                         conexion.sentencia.executeUpdate(qryDelete);
                          
                          setVisible(false);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
                    }
                }
                
            };
           
    ActionListener AccionLlenarProducto = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                   String qrySelect;
         ResultSet resultado;
         qrySelect="select * from producto WHERE Cod_barras_p="+"'"+codP.getSelectedItem()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
             {
         
         nombreP.setText(resultado.getString("Nombre_prod"));
         precio.setText(resultado.getString("Precio"));
         categorialista.setSelectedItem(resultado.getString("Categoria"));
         tipounidad.setSelectedItem(resultado.getString("Tipo_unidad"));
         unidades.setText(resultado.getString("Unidades"));
                
         //listae.addItem(resultado.getString("ID_Empleado"));
             }
         }catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage()); 
         } 
                    
                }
          }    ;            
            
            
            
                
    ActionListener AccionActualizarProducto = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    String qryUpdate;
                    qryUpdate="UPDATE producto SET Nombre_prod="+"'"+nombreP.getText()+"'"+",Categoria="+"'"+
                        categorialista.getSelectedItem()+"'"+",Unidades="+"'"+unidades.getText()+"'"
                            +",Tipo_Unidad="+"'"+tipounidad.getSelectedItem()+"'"+",Precio="+"'"+precio.getText()+"'"+"WHERE Cod_barras_p="+"'"+codP.getSelectedItem()+"'";
                    try {
                         conexion.sentencia.executeUpdate(qryUpdate);
                          codP.setSelectedIndex(-1);
                          tipounidad.setSelectedIndex(-1);
                          categorialista.setSelectedIndex(-1);
                          unidades.setText("");
                          nombreP.setText("");
                          precio.setText("");
                    } catch (SQLException ea) {
                        JOptionPane.showMessageDialog(null,"ERROR..."+ea.getMessage());
                    }
                    
                }
        
    }    ;    
            
            
            
   
   ActionListener AccionVolver = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           setVisible(false);
        }
       
   };
   
   
   public void menuproducto(int i){
       if(i==1){//registrar producto
           panel.removeAll();
           panel.repaint();
           componentesRegistrarp();
           panelC();
       }
       if(i==2){//actualizar producto
           panel.removeAll();
           panel.repaint();
            componenteActualizarProducto();
           panelActualizarP();
       }
       if(i==3){//actualizar producto
           panel.removeAll();
           panel.repaint();
            componenteEliminarProducto();
           panelEliminarP();
       }
    
}
    
}
