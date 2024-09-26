/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioalmacen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javafx.scene.layout.Background;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author misa_
 */
public class Ventana extends JFrame{
    public JPanel panel, panele;
    private JComboBox entradas, modificaciones, reportes, salidas;
     public JTextField codigoP, nombreP, categoria, precio, unidades;
     
        
    public Ventana(){
        setSize(1366,768);
        setTitle("STRELOK S.I.A.");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1024,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
      // this.setExtendedState(MAXIMIZED_BOTH);
        
        //panel.add(Background);
     //this.setResizable(rootPaneCheckingEnabled);
        setUndecorated(true);
        inicio();
        
        
        
    }
    
    
    private void inicio(){
        panel();
       botonesInterfaz();
        panelC();
       
        
        
    }
    private void panel(){
        panel =new JPanel();
       // panel.setSize(1600,900);
      this.getContentPane().add(panel);
      panel.setLayout(null);
      panel.setBackground(new Color(217, 217, 217));
      
    }
    
      
    private void panelsesion(){
        panel =new JPanel();
       // panel.setSize(1600,900);
      this.getContentPane().add(panel);
      panel.setLayout(null);
      panel.setBackground(new Color(217, 217, 217));
      
    }
    
     private void panelCsesion(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(300,60, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("MENU PRINCIPAL");
        panel.add(texto);
        
        JLabel SCI=new JLabel();
        SCI=new JLabel(new ImageIcon(getClass().getResource("IMG/a.png")));
        SCI.setBounds(0, 430, 300, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
        panel.add(SCI);
    }
    
    
    private void panelC(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(300,60, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("MENU PRINCIPAL");
        panel.add(texto);
        
        JLabel SCI=new JLabel();
        SCI=new JLabel(new ImageIcon(getClass().getResource("IMG/a.png")));
        SCI.setBounds(0, 430, 300, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
        panel.add(SCI);
    }
    
    ActionListener Accionsalir = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    };
    
     public void botonesInterfazsesion(){
          JLabel codigo=new JLabel();
        codigo.setText("Usuario");
        codigo.setBounds(560,160,200,50);
        codigo.setFont(new Font("cops",1,26));
        panel.add(codigo);
        codigoP=new JTextField();
       codigoP.setFont(new Font("cops",1,26));
       TextPrompt prueba =new TextPrompt ("Codigo de producto",codigoP);
       codigoP.setBounds(420, 210, 350, 50);
       panel.add(codigoP);
       
       JLabel nombreprod=new JLabel();
        nombreprod.setText("Contraseña");
        nombreprod.setBounds(240,270,200,50);
        nombreprod.setFont(new Font("cops",1,26));
        panel.add(nombreprod);
       nombreP=new JTextField();
       nombreP.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("Nombre P.",nombreP);
       nombreP.setBounds(100, 320, 350, 50);
       panel.add(nombreP);
         
         JButton btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Iniciar Sesion");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.green);
      // btnCancelar.addActionListener(Iniciarsesion);
     }

        
    
     
     
     
     
     
     
    
    public void botonesInterfaz(){
        JButton salida=new JButton();
         salida.setBounds(0, 0, 100, 30);
       panel.add(salida);
       salida.setText("SALIR");
       salida.setForeground(Color.white);
       salida.setFont(new Font ("copper",2,15));
       salida.setBackground(Color.red);
       salida.addActionListener(Accionsalir);
    
        entradas=new JComboBox<String>();
        entradas.setBounds(100,170,300,60);
        panel.add(entradas);
        entradas.addItem(" Inventario");
        entradas.addItem(" Producto");
        entradas.addItem(" Empleado");
        entradas.addItem(" Proveedor");
        entradas.setSelectedIndex(-1);
        entradas.setRenderer(new MyComboBoxRenderer("ALTAS"));
       entradas.addActionListener(AccionENTRADAS);
       entradas.setBackground(new Color(245, 203, 104));
       entradas.setFont(new Font ("copper",2,40));
       entradas.setForeground(Color.black);
       //entradas.setLocation(point);
       
       
       
       modificaciones=new JComboBox<String>();
        modificaciones.setBounds(680,330,380,60);
        panel.add(modificaciones);
       // modificaciones.addItem("MODIFICAR");
        modificaciones.addItem(" Producto");
        modificaciones.addItem(" Proveedor");
        modificaciones.addItem(" Empleado");
        modificaciones.setSelectedIndex(-1);
        modificaciones.setRenderer(new MyComboBoxRenderer("MODIFICACIONES"));
       modificaciones.addActionListener(AccionMODIFICACIONES);
       modificaciones.setBackground(new Color(245, 203, 104));
       modificaciones.setFont(new Font ("copper",2,40));
       modificaciones.setForeground(Color.black);
       
       salidas=new JComboBox<String>();
       salidas.setBounds(380,250,300,60);
 
        panel.add(salidas);
     //   salidas.addItem("ELIMINAR");
        salidas.addItem(" Producto");
        salidas.addItem(" Proveedor");
        salidas.addItem(" Empleado");
      //  salidas.addItem(" Usuario");
        salidas.setSelectedIndex(-1);
        salidas.setRenderer(new MyComboBoxRenderer("BAJAS"));
       salidas.addActionListener(AccionSalidas);
       salidas.setBackground(new Color(245, 203, 104));
       salidas.setFont(new Font ("copper",2,40));
       salidas.setForeground(Color.black);
       
       
       reportes=new JComboBox<String>();
        reportes.setBounds(980,410,380,60);
        panel.add(reportes);
       // reportes.addItem("REPORTES");
        reportes.addItem(" Doc. Empleado");
        reportes.addItem(" Inventario Dia");
        reportes.addItem(" Inventario Quincenal");
        reportes.addItem(" Inventario Semestral");
        reportes.addItem(" Inventario Anual");
        reportes.setSelectedIndex(-1);
        reportes.setRenderer(new MyComboBoxRenderer("REPORTES"));
       // entradas.addItemListener(this);
       reportes.addActionListener(AccionReportes);
       reportes.setBackground(new Color(245, 203, 104));
       reportes.setFont(new Font ("copper",2,40));
       reportes.setForeground(Color.black);
      
       
        
        
        
    }
   
    
    ActionListener AccionENTRADAS = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           
            if(entradas.getSelectedItem()==" Inventario"){
                VentanaInventario ghs=new VentanaInventario();
                ghs.setVisible(true);
                ghs.menuInventario(8);
            }
            if(entradas.getSelectedItem()==" Producto"){
                VentanaProducto i=new VentanaProducto();
                i.setVisible(true);
                i.menuproducto(1);
            }
            if(entradas.getSelectedItem()==" Empleado"){
               VentanaEmpleados B= new VentanaEmpleados();
               B.setVisible(true);
               B.prueba(1);
            }
            if(entradas.getSelectedItem()==" Proveedor"){
                
                VentanaProveedor ki=new VentanaProveedor();
                ki.setVisible(true);
                ki.menuProveedor(1);
            }
            
            
            entradas.setSelectedIndex(-1);
        }
        
    };
    
     ActionListener AccionMODIFICACIONES = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(modificaciones.getSelectedItem()==" Producto"){
                VentanaProducto k=new VentanaProducto();
                k.menuproducto(2);
                k.setVisible(true);
            }
            if(modificaciones.getSelectedItem()==" Proveedor"){
                VentanaProveedor j=new VentanaProveedor();
                j.menuProveedor(2);
                j.setVisible(true);
            }
            if(modificaciones.getSelectedItem()==" Empleado"){
                VentanaEmpleados B= new VentanaEmpleados();
               B.setVisible(true);
               B.prueba(3);
            }
            
            modificaciones.setSelectedIndex(-1);
        }
         
     };
     
     
     
    ActionListener AccionSalidas = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {
            if(salidas.getSelectedItem()==" Producto"){
                VentanaProducto k=new VentanaProducto();
                k.menuproducto(3);
                k.setVisible(true);
            }
            if(salidas.getSelectedItem()==" Proveedor"){
                VentanaProveedor k=new VentanaProveedor();
                k.menuProveedor(3);
                k.setVisible(true);
            }
            if(salidas.getSelectedItem()==" Empleado"){
                VentanaEmpleados k=new VentanaEmpleados();
                k.prueba(4);
                k.setVisible(true);
            }
           
            salidas.setSelectedIndex(-1);
        }

    };


   ActionListener AccionReportes = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent ae) {

            if(reportes.getSelectedItem()==" Doc. Empleado"){
                VentanaEmpleados ko=new VentanaEmpleados();
                ko.prueba(10);
                ko.setVisible(true);
            }
            if(reportes.getSelectedItem()==" Inventario Dia"){
                VentanaInventario chucho=new VentanaInventario();
                chucho.menuInventario(6);
                chucho.setVisible(true);
            }
            if(reportes.getSelectedItem()==" Inventario Quincenal"){
                VentanaInventario chucho=new VentanaInventario();
                chucho.menuInventario(7);
                chucho.setVisible(true);
            }
             if(reportes.getSelectedItem()==" Inventario Semestral"){
                VentanaInventario chucho=new VentanaInventario();
                chucho.menuInventario(7);
                chucho.setVisible(true);
            }
              if(reportes.getSelectedItem()==" Inventario Anual"){
                VentanaInventario chucho=new VentanaInventario();
                chucho.menuInventario(7);
                chucho.setVisible(true);
            }
            reportes.setSelectedIndex(-1);
        }

   };

   
   
}
    


