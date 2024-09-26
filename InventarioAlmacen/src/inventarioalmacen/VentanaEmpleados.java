/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioalmacen;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
//import javafx.stage.FileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author misa_
 */
public class VentanaEmpleados extends JFrame{
    public JPanel panel;
    public JTextField curp, nombre, apellidoP, apellidoM, telefono, nombreu, contrasena
            ,calle, colonia, ciudad, cp, estado, numeroint, numeroext;
    public Conexion conexion;
    Conexion conec=new Conexion();
    Conexion cn =new Conexion();
    JButton btnCancelar, btnGuardar, btnTelefono, eliminardoc;
    JComboBox docempleado, telefonotipo,listae ;
    String CURP;
    public VentanaEmpleados(){
        setSize(1366,768);
        setTitle("STRELOK EMPLEADOS");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1024,720));
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicio();
        conexion =new Conexion();
        //Conexion conec=new Conexion();
        
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
    
          
    
    //////CAMBIO DE PANELES PARA DIFERENTES INTERFACES
    private void panelC(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 20, 370, 245);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,20, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Registro Empleado");
        panel.add(texto);
    }
    
 
    private void panelDocumento(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 20, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
        ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,30, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Cnsultar Doc. Empleado");
        panel.add(texto);
        
    }
    private void panelModEmp(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,40, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Modificar Empleado");
        panel.add(texto);
    }
   private void panelModEli(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,50, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Eliminar Empleado");
        panel.add(texto);
    }
   ///////////////////////////////////////////////////////////METODO REGISTRAR EMPLEADOS 
    private void componentesRegistrarEmpleado(){
          JLabel tel=new JLabel();
            JLabel telt=new JLabel();
        JLabel doc=new JLabel();  
          JLabel contacto = new JLabel();
            JLabel dc = new JLabel();
            
        JLabel nombree=new JLabel();
        nombree.setText("Nombre");
        nombree.setBounds(210,250,200,50);
        nombree.setFont(new Font("cops",1,26));
        panel.add(nombree);
       nombre=new JTextField();
       nombre.setFont(new Font("cops",1,26));
       TextPrompt prueba =new TextPrompt ("Nombre",nombre);
       nombre.setBounds(50, 290, 370, 50);
       panel.add(nombre);
       nombre.setEditable(false);
       
       JLabel DATOSE=new JLabel();
       DATOSE.setText("Datos personales");
       DATOSE.setBounds(50,130,300,50);
        DATOSE.setFont(new Font("cops",3,26));
        panel.add(DATOSE);
        
       JLabel telE=new JLabel();
       telE.setText("CURP");
        telE.setBounds(460,150,200,50);
        telE.setFont(new Font("cops",1,26));
        panel.add(telE);
       curp=new JTextField();
       curp.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("CURP de empleado",curp);
       curp.setBounds(320, 190, 350, 50);
       panel.add(curp);
       curp.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
           int k=0;
          String qrySelect;
         ResultSet resultado;
         qrySelect="select * from empleado";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
             if(resultado.getString("ID_Empleado").equals(curp.getText())){
                 JOptionPane.showMessageDialog(null,"Empleado ya registrado");
             }
         }
         if(k==0){
                 nombre.setEditable(true);
                 apellidoM.setEditable(true);
                 apellidoP.setEditable(true);
                         
             }
                 
         }catch(SQLException el){
         JOptionPane.showMessageDialog(null, "error"+el.getMessage());
         }
           }
       });
       
       JLabel apellidopat=new JLabel();
       apellidopat.setText("Apellido Paterno");
        apellidopat.setBounds(520,250,200,50);
        apellidopat.setFont(new Font("cops",1,26));
        panel.add(apellidopat);
       apellidoP=new JTextField();
       apellidoP.setFont(new Font("cops",1,26));
       TextPrompt prueba2 =new TextPrompt ("Apellido P.",apellidoP);
       apellidoP.setBounds(450, 290, 350, 50);
       panel.add(apellidoP);
       apellidoP.setEditable(false);
       
       JLabel apellidomat=new JLabel();
       apellidomat.setText("Apellido Materno");
        apellidomat.setBounds(920,250,200,50);
        apellidomat.setFont(new Font("cops",1,26));
        panel.add(apellidomat);
       apellidoM=new JTextField();
       apellidoM.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Apellido M.",apellidoM);
       apellidoM.setBounds(850, 290, 350, 50);
       panel.add(apellidoM);
       apellidoM.setEditable(false);
       
       apellidoM.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           
           String qryInsert;
           // qryInsert="INSERT into empleado SET ID_Empleado="+"'"+curp.getText().toUpperCase()+"'"+",Nombre_E="+"'"+nombre.getText().toUpperCase()+"'"+",Ap_pat="+"'"+
           //     apellidoP.getText().toUpperCase()+"'"+",Ap_mat="+"'"+apellidoM.getText().toUpperCase()+"'";//+",ID_Inventario="+"'100'";
          //  String qryinserts="insert into docempleado SET ID_Empleado="+"'"+curp.getText().toUpperCase()+"'";
            try {
             //    conexion.sentencia.executeUpdate(qryInsert);
               //  conexion.sentencia.executeUpdate(qryinserts);
                  curp.setEditable(false);
                   nombre.setEditable(false);
                   apellidoP.setEditable(false);
                   apellidoM.setEditable(false);
                   //btnCancelar.setVisible(false);
                   
                   calle.setEditable(true);
                   cp.setEditable(true);
                   ciudad.setEditable(true);
                   colonia.setEditable(true);
                   estado.setEditable(true);
                   numeroint.setEditable(true);
                   numeroext.setEditable(true);
       
            } catch (Exception eS) {
                JOptionPane.showMessageDialog(null,"ERROR..."+eS.getMessage());
                
            }
        
           
           }
        });
       
        JLabel Dirrec=new JLabel();
       Dirrec.setText("Direccion");
       Dirrec.setBounds(600,350,300,50);
        Dirrec.setFont(new Font("cops",3,26));
        panel.add(Dirrec);
       
          /////direccion
          JLabel calletxt=new JLabel();
       calletxt.setText("Calle");
        calletxt.setBounds(170,390,200,50);
        calletxt.setFont(new Font("cops",1,26));
        panel.add(calletxt);
          calle=new JTextField();
       calle.setFont(new Font("cops",1,26));
       TextPrompt prueba5 =new TextPrompt ("Calle",calle);
       calle.setBounds(50, 430, 350, 50);
       panel.add(calle);
       calle.setEditable(false);
       
       JLabel coloniatxt=new JLabel();
       coloniatxt.setText("Colonia");
        coloniatxt.setBounds(930,390,200,50);
        coloniatxt.setFont(new Font("cops",3,26));
        panel.add(coloniatxt);
        colonia=new JTextField();
       colonia.setFont(new Font("cops",1,26));
       TextPrompt prueba6 =new TextPrompt ("Colonia",colonia);
       colonia.setBounds(850, 430, 350, 50);
       panel.add(colonia);
       colonia.setEditable(false);
       
       JLabel numerointxt=new JLabel();
       numerointxt.setText("N. interior");
        numerointxt.setBounds(420,390,120,50);
        numerointxt.setFont(new Font("cops",1,26));
        panel.add(numerointxt);
       numeroint=new JTextField();
       numeroint.setFont(new Font("cops",1,26));
       TextPrompt prueba7 =new TextPrompt ("N. interior",numeroint);
       numeroint.setBounds(420, 430, 100, 50);
       panel.add(numeroint);
       numeroint.setEditable(false);
       
       JLabel numeroexttxt=new JLabel();
       numeroexttxt.setText("N. exterior");
        numeroexttxt.setBounds(550,390,120,50);
        numeroexttxt.setFont(new Font("cops",1,26));
        panel.add(numeroexttxt);
       numeroext=new JTextField();
       numeroext.setFont(new Font("cops",1,26));
       TextPrompt prueba73 =new TextPrompt ("N. exterior",numeroext);
       numeroext.setBounds(550, 430, 100, 50);
       panel.add(numeroext);
       numeroext.setEditable(false);
       
       JLabel cptxt=new JLabel();
       cptxt.setText("C. postal");
        cptxt.setBounds(720,390,120,50);
        cptxt.setFont(new Font("cops",1,26));
        panel.add(cptxt);
       cp=new JTextField();
       cp.setFont(new Font("cops",1,26));
       TextPrompt prueba76 =new TextPrompt ("C.P.",cp);
       cp.setBounds(720, 430, 100, 50);
       panel.add(cp);
       cp.setEditable(false);
       
       JLabel ciudadtxt=new JLabel();
       ciudadtxt.setText("Ciudad");
        ciudadtxt.setBounds(350,490,200,50);
        ciudadtxt.setFont(new Font("cops",1,26));
        panel.add(ciudadtxt);
       ciudad=new JTextField();
       ciudad.setFont(new Font("cops",1,26));
       TextPrompt prueba8 =new TextPrompt ("Ciudad",ciudad);
       ciudad.setBounds(270, 530, 280, 50);
       panel.add(ciudad);
       ciudad.setEditable(false);
       
       JLabel estadotxt=new JLabel();
       estadotxt.setText("Estado");
        estadotxt.setBounds(650,490,200,50);
        estadotxt.setFont(new Font("cops",1,26));
        panel.add(estadotxt);
       estado=new JTextField();
       estado.setFont(new Font("cops",1,26));
       TextPrompt prueba63 =new TextPrompt ("Estado",estado);
       estado.setBounds(570, 530, 350, 50);
       panel.add(estado);
       estado.setEditable(false);
       estado.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String qryUpdate;
            qryUpdate="INSERT into empleado SET ID_Empleado="+"'"+curp.getText().toUpperCase()+"'"+",Nombre_E="+"'"+nombre.getText().toUpperCase()+"'"+",Ap_pat="+"'"+
                apellidoP.getText().toUpperCase()+"'"+",Ap_mat="+"'"+apellidoM.getText().toUpperCase()+"'"+",Calle="+"'"+calle.getText()+"'"+",Colonia="+"'"+
                colonia.getText()+"'"+",CP="+"'"+cp.getText()+"'"+",Ciudad="+"'"+ciudad.getText()
                    +"'"+",Estado="+"'"+estado.getText()+"'"+",Numero_ext="+"'"+numeroext.getText()+"'"
                    +",Numero_int="+"'"+numeroint.getText()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryUpdate);
                  telefono.setEditable(true);
                //  btnTelefono.setEnabled(true);
                   
                  calletxt.setVisible(false);
                   calle.setVisible(false);
                   cptxt.setVisible(false);
                   cp.setVisible(false);
                   ciudadtxt.setVisible(false);
                   ciudad.setVisible(false);
                   colonia.setVisible(false);
                   estadotxt.setVisible(false);
                   estado.setVisible(false);
                   numerointxt.setVisible(false);
                   numeroint.setVisible(false);
                   numeroexttxt.setVisible(false);
                   numeroext.setVisible(false);
                   coloniatxt.setVisible(false);
                   Dirrec.setVisible(false);
                   
                   tel.setVisible(true);
                   telefono.setVisible(true);
                   telt.setVisible(true);
                   doc.setVisible(true);
                   docempleado.setVisible(true);
                   telefonotipo.setVisible(true);
                   telefonotipo.setEnabled(true);
                   docempleado.setEnabled(true);
                   btnGuardar.setVisible(true);
                   contacto.setVisible(true);
                   dc.setVisible(true);
                   //btnTelefono.setVisible(true);
       
            } catch (SQLException eS) {
                JOptionPane.showMessageDialog(null,"ERROR..."+eS.getMessage());
                
            }
        
               
           }
       });
       
     
          contacto.setText("Telefonos contacto");
        contacto.setBounds(50,352,200,50);
        contacto.setFont(new Font("cops",3,26));
        panel.add(contacto);
        contacto.setVisible(false);
       
       //JLabel tel=new JLabel();
       tel.setText("Telefono");
        tel.setBounds(200,375,120,50);
        tel.setFont(new Font("cops",1,26));
        panel.add(tel);
        tel.setVisible(false);
       telefono=new JTextField();
       telefono.setFont(new Font("cops",1,26));
       TextPrompt prueba4 =new TextPrompt ("Telefono",telefono);
       telefono.setBounds(200, 415, 200, 50);
       panel.add(telefono);
       telefono.setEditable(false);
       telefono.setVisible(false);
       
       
       //JLabel telt=new JLabel();
       telt.setText("Tipo telefono");
        telt.setBounds(450,375,180,50);
        telt.setFont(new Font("cops",1,26));
        panel.add(telt);
        telt.setVisible(false);
       telefonotipo=new JComboBox<String>();
        telefonotipo.setBounds(450,415,300,50);
        panel.add(telefonotipo);
        telefonotipo.addItem("Casa");
        telefonotipo.addItem("Celular");
        telefonotipo.addItem("Oficina");
       telefonotipo.setBackground(new Color(245, 203, 104));
       telefonotipo.setFont(new Font ("copper",2,28));
       telefonotipo.setForeground(Color.black);
       telefonotipo.setEnabled(false);
       telefonotipo.setSelectedIndex(-1);
       telefonotipo.setVisible(false);
       telefonotipo.addActionListener(AccionRegistrarTel);
       /*
       btnTelefono=new JButton();
        btnTelefono.setBounds(800, 400, 150, 50);
       panel.add(btnTelefono);
       btnTelefono.setText("Anadir");
       btnTelefono.setForeground(Color.black);
       btnTelefono.setFont(new Font ("copper",2,26));
       btnTelefono.setBackground(Color.green);
       btnTelefono.addActionListener(AccionRegistrarTel);
       btnTelefono.setVisible(false);*/
       
       
//       JLabel dc = new JLabel();
          dc.setText("Documentos empleado");
        dc.setBounds(50,460,220,50);
        dc.setFont(new Font("cops",3,26));
        panel.add(dc);
        dc.setVisible(false);
       
      
       doc.setText("Documento");
        doc.setBounds(500,480,150,50);
        doc.setFont(new Font("cops",1,26));
        panel.add(doc);
        doc.setVisible(false);
       docempleado=new JComboBox<String>();
        docempleado.setBounds(450,520,300,50);
        panel.add(docempleado);
        docempleado.addItem("CURP");
        docempleado.addItem(" RFC");
        docempleado.addItem(" INE ");
        
       docempleado.setBackground(new Color(245, 203, 104));
       docempleado.setFont(new Font ("copper",2,28));
       docempleado.setForeground(Color.black);
       docempleado.setVisible(false);
       docempleado.setSelectedIndex(-1);
       docempleado.addActionListener(AccionRegistrardoc);
       
       
       
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 650, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Volver");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.addActionListener(Volver);
       btnGuardar.setVisible(false);
       
       btnCancelar= new JButton();
       btnCancelar.setBounds(400, 650, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);
       
       ////////////////////////////////////////////METODO MODIFICAR EMPLEADOS
    }
    private void ComponenteActualizarEmpleado(){
        JLabel telE=new JLabel();
       telE.setText("CURP");
        telE.setBounds(540,130,200,50);
        telE.setFont(new Font("cops",1,26));
        panel.add(telE);
        listae=new JComboBox<String>();
        listae.setBounds(400,170,360,50);
        panel.add(listae);
        listae.setBackground(new Color(245, 203, 104));
        listae.setFont(new Font ("copper",2,30));
        listae.setForeground(Color.black);
                      
       String qrySelect;
         ResultSet resultado;
         qrySelect="select * from empleado";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         listae.addItem(resultado.getString("ID_Empleado"));
         
         }
         
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
        listae.setSelectedIndex(-1);
       listae.addActionListener(AccionListaempleadosPActualizar);
        
        
        
         JLabel tel=new JLabel();
            JLabel telt=new JLabel();
        JLabel doc=new JLabel();     
            
        JLabel nombree=new JLabel();
        nombree.setText("Nombre");
        nombree.setBounds(190,230,200,50);
        nombree.setFont(new Font("cops",1,26));
        panel.add(nombree);
       nombre=new JTextField();
       nombre.setFont(new Font("cops",1,26));
       TextPrompt prueba =new TextPrompt ("Nombre",nombre);
       nombre.setBounds(50, 270, 370, 50);
       panel.add(nombre);
       //nombre.setEditable(false);
       
       
       JLabel apellidopat=new JLabel();
       apellidopat.setText("Apellido Paterno");
        apellidopat.setBounds(520,230,200,50);
        apellidopat.setFont(new Font("cops",1,26));
        panel.add(apellidopat);
       apellidoP=new JTextField();
       apellidoP.setFont(new Font("cops",1,26));
       TextPrompt prueba2 =new TextPrompt ("Apellido P.",apellidoP);
       apellidoP.setBounds(450, 270, 350, 50);
       panel.add(apellidoP);
       //apellidoP.setEditable(false);
       
       JLabel apellidomat=new JLabel();
       apellidomat.setText("Apellido Materno");
        apellidomat.setBounds(920,230,200,50);
        apellidomat.setFont(new Font("cops",1,26));
        panel.add(apellidomat);
       apellidoM=new JTextField();
       apellidoM.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Apellido M.",apellidoM);
       apellidoM.setBounds(850, 270, 350, 50);
       panel.add(apellidoM);
       //apellidoM.setEditable(false);
       
       apellidoM.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           
           String qryInsert;
           // qryInsert="INSERT into empleado SET ID_Empleado="+"'"+curp.getText().toUpperCase()+"'"+",Nombre_E="+"'"+nombre.getText().toUpperCase()+"'"+",Ap_pat="+"'"+
           //     apellidoP.getText().toUpperCase()+"'"+",Ap_mat="+"'"+apellidoM.getText().toUpperCase()+"'";//+",ID_Inventario="+"'100'";
          //  String qryinserts="insert into docempleado SET ID_Empleado="+"'"+curp.getText().toUpperCase()+"'";
            try {
             //    conexion.sentencia.executeUpdate(qryInsert);
               //  conexion.sentencia.executeUpdate(qryinserts);
                  curp.setEditable(false);
                   nombre.setEditable(false);
                   apellidoP.setEditable(false);
                   apellidoM.setEditable(false);
                   //btnCancelar.setVisible(false);
                   
                   calle.setEditable(true);
                   cp.setEditable(true);
                   ciudad.setEditable(true);
                   colonia.setEditable(true);
                   estado.setEditable(true);
                   numeroint.setEditable(true);
                   numeroext.setEditable(true);
       
            } catch (Exception eS) {
                JOptionPane.showMessageDialog(null,"ERROR..."+eS.getMessage());
                
            }
        
           
           }
        });
          /////direccion
          JLabel calletxt=new JLabel();
       calletxt.setText("Calle");
        calletxt.setBounds(130,340,200,50);
        calletxt.setFont(new Font("cops",1,26));
        panel.add(calletxt);
          calle=new JTextField();
       calle.setFont(new Font("cops",1,26));
       TextPrompt prueba5 =new TextPrompt ("Calle",calle);
       calle.setBounds(50, 380, 350, 50);
       panel.add(calle);
       //calle.setEditable(false);
       
       JLabel coloniatxt=new JLabel();
       coloniatxt.setText("Colonia");
        coloniatxt.setBounds(930,340,200,50);
        coloniatxt.setFont(new Font("cops",3,26));
        panel.add(coloniatxt);
        colonia=new JTextField();
       colonia.setFont(new Font("cops",1,26));
       TextPrompt prueba6 =new TextPrompt ("Colonia",colonia);
       colonia.setBounds(850, 380, 350, 50);
       panel.add(colonia);
       //colonia.setEditable(false);
       
       JLabel numerointxt=new JLabel();
       numerointxt.setText("N. interior");
        numerointxt.setBounds(420,340,120,50);
        numerointxt.setFont(new Font("cops",1,26));
        panel.add(numerointxt);
       numeroint=new JTextField();
       numeroint.setFont(new Font("cops",1,26));
       TextPrompt prueba7 =new TextPrompt ("N. interior",numeroint);
       numeroint.setBounds(420, 380, 100, 50);
       panel.add(numeroint);
       //numeroint.setEditable(false);
       
       JLabel numeroexttxt=new JLabel();
       numeroexttxt.setText("N. exterior");
        numeroexttxt.setBounds(550,340,120,50);
        numeroexttxt.setFont(new Font("cops",1,26));
        panel.add(numeroexttxt);
       numeroext=new JTextField();
       numeroext.setFont(new Font("cops",1,26));
       TextPrompt prueba73 =new TextPrompt ("N. exterior",numeroext);
       numeroext.setBounds(550, 380, 100, 50);
       panel.add(numeroext);
       //numeroext.setEditable(false);
       
       JLabel cptxt=new JLabel();
       cptxt.setText("C. postal");
        cptxt.setBounds(720,340,120,50);
        cptxt.setFont(new Font("cops",1,26));
        panel.add(cptxt);
       cp=new JTextField();
       cp.setFont(new Font("cops",1,26));
       TextPrompt prueba76 =new TextPrompt ("C.P.",cp);
       cp.setBounds(720, 380, 100, 50);
       panel.add(cp);
       //cp.setEditable(false);
       
       JLabel ciudadtxt=new JLabel();
       ciudadtxt.setText("Ciudad");
        ciudadtxt.setBounds(280,440,200,50);
        ciudadtxt.setFont(new Font("cops",1,26));
        panel.add(ciudadtxt);
       ciudad=new JTextField();
       ciudad.setFont(new Font("cops",1,26));
       TextPrompt prueba8 =new TextPrompt ("Ciudad",ciudad);
       ciudad.setBounds(200, 480, 280, 50);
       panel.add(ciudad);
       //ciudad.setEditable(false);
       
       JLabel estadotxt=new JLabel();
       estadotxt.setText("Estado");
        estadotxt.setBounds(580,440,200,50);
        estadotxt.setFont(new Font("cops",1,26));
        panel.add(estadotxt);
       estado=new JTextField();
       estado.setFont(new Font("cops",1,26));
       TextPrompt prueba63 =new TextPrompt ("Estado",estado);
       estado.setBounds(500, 480, 350, 50);
       panel.add(estado);
     //  estado.setEditable(false);
       estado.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              
            try {
                
                  telefono.setEditable(true);
                 // btnTelefono.setEnabled(true);
                   
                  calletxt.setVisible(false);
                   calle.setVisible(false);
                   cptxt.setVisible(false);
                   cp.setVisible(false);
                   ciudadtxt.setVisible(false);
                   ciudad.setVisible(false);
                   colonia.setVisible(false);
                   estadotxt.setVisible(false);
                   estado.setVisible(false);
                   numerointxt.setVisible(false);
                   numeroint.setVisible(false);
                   numeroexttxt.setVisible(false);
                   numeroext.setVisible(false);
                   coloniatxt.setVisible(false);
                   listae.setEnabled(false);
                   
                   tel.setVisible(true);
                   telefono.setVisible(true);
                   telt.setVisible(true);
                   doc.setVisible(true);
                   docempleado.setVisible(true);
                   telefonotipo.setVisible(true);
                   telefonotipo.setEnabled(true);
                   docempleado.setEnabled(true);
                   btnGuardar.setVisible(true);
                   //btnTelefono.setVisible(true);
       
            } catch (Exception eS) {
                JOptionPane.showMessageDialog(null,"ERROR..."+eS.getMessage());
                
            }
        
               
           }
       });
       
       
          
       
       //JLabel tel=new JLabel();
       tel.setText("Telefono");
        tel.setBounds(200,360,120,50);
        tel.setFont(new Font("cops",1,26));
        panel.add(tel);
        tel.setVisible(false);
       telefono=new JTextField();
       telefono.setFont(new Font("cops",1,26));
       TextPrompt prueba4 =new TextPrompt ("Telefono",telefono);
       telefono.setBounds(200, 400, 200, 50);
       panel.add(telefono);
       telefono.setEditable(false);
       telefono.setVisible(false);
       
       
       //JLabel telt=new JLabel();
       telt.setText("Tipo telefono");
        telt.setBounds(450,360,180,50);
        telt.setFont(new Font("cops",1,26));
        panel.add(telt);
        telt.setVisible(false);
       telefonotipo=new JComboBox<String>();
        telefonotipo.setBounds(450,400,300,50);
        panel.add(telefonotipo);
        telefonotipo.addItem("Casa");
        telefonotipo.addItem("Celular");
        telefonotipo.addItem("Oficina");
       telefonotipo.setBackground(new Color(245, 203, 104));
       telefonotipo.setFont(new Font ("copper",2,28));
       telefonotipo.setForeground(Color.black);
       telefonotipo.setEnabled(false);
       telefonotipo.setSelectedIndex(-1);
       telefonotipo.setVisible(false);
       telefonotipo.addActionListener(AccionLlenarTelefono);
       
       btnTelefono=new JButton();
        btnTelefono.setBounds(800, 400, 150, 50);
       panel.add(btnTelefono);
       btnTelefono.setText("Actualizar");
       btnTelefono.setForeground(Color.black);
       btnTelefono.setFont(new Font ("copper",2,26));
       btnTelefono.setBackground(Color.blue);
       btnTelefono.addActionListener(AccionActualizarTel);
       btnTelefono.setVisible(false);
       
       
       
       
      
       doc.setText("Documento");
        doc.setBounds(500,460,150,50);
        doc.setFont(new Font("cops",1,26));
        panel.add(doc);
        doc.setVisible(false);
       docempleado=new JComboBox<String>();
        docempleado.setBounds(450,500,300,50);
        panel.add(docempleado);
        docempleado.addItem("CURP");
        docempleado.addItem(" RFC");
        docempleado.addItem(" INE");
        
       docempleado.setBackground(new Color(245, 203, 104));
       docempleado.setFont(new Font ("copper",2,28));
       docempleado.setForeground(Color.black);
       docempleado.setVisible(false);
       docempleado.setSelectedIndex(-1);
       docempleado.addActionListener(AccionActualizarDoc);
       
       
       
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 650, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.addActionListener(AccionActualizarEmpleado);
       btnGuardar.setVisible(false);
       
       btnCancelar= new JButton();
       btnCancelar.setBounds(400, 650, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);
    }
    ///////////////////////////////Metodo eliminar empleado
    private void ComponenteEliminarEmpleado(){
        JLabel telE=new JLabel();
       telE.setText("CURP");
        telE.setBounds(540,130,200,50);
        telE.setFont(new Font("cops",1,26));
        panel.add(telE);
        listae=new JComboBox<String>();
        listae.setBounds(400,170,360,50);
        panel.add(listae);
        listae.setBackground(new Color(245, 203, 104));
        listae.setFont(new Font ("copper",2,30));
        listae.setForeground(Color.black);
                      
       String qrySelect;
         ResultSet resultado;
         qrySelect="select * from empleado";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         listae.addItem(resultado.getString("ID_Empleado"));
         
         }
         
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
        listae.setSelectedIndex(-1);
       listae.addActionListener(AccionListaempleadosPEliminar);
        
        
        
         JLabel tel=new JLabel();
            JLabel telt=new JLabel();
        JLabel doc=new JLabel();     
            
        JLabel nombree=new JLabel();
        nombree.setText("Nombre");
        nombree.setBounds(190,230,200,50);
        nombree.setFont(new Font("cops",1,26));
        panel.add(nombree);
       nombre=new JTextField();
       nombre.setFont(new Font("cops",1,26));
       TextPrompt prueba =new TextPrompt ("Nombre",nombre);
       nombre.setBounds(50, 270, 370, 50);
       panel.add(nombre);
       nombre.setEditable(false);
       
       
       JLabel apellidopat=new JLabel();
       apellidopat.setText("Apellido Paterno");
        apellidopat.setBounds(520,230,200,50);
        apellidopat.setFont(new Font("cops",1,26));
        panel.add(apellidopat);
       apellidoP=new JTextField();
       apellidoP.setFont(new Font("cops",1,26));
       TextPrompt prueba2 =new TextPrompt ("Apellido P.",apellidoP);
       apellidoP.setBounds(450, 270, 350, 50);
       panel.add(apellidoP);
       apellidoP.setEditable(false);
       
       JLabel apellidomat=new JLabel();
       apellidomat.setText("Apellido Materno");
        apellidomat.setBounds(920,230,200,50);
        apellidomat.setFont(new Font("cops",1,26));
        panel.add(apellidomat);
       apellidoM=new JTextField();
       apellidoM.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Apellido M.",apellidoM);
       apellidoM.setBounds(850, 270, 350, 50);
       panel.add(apellidoM);
       apellidoM.setEditable(false);
       
       
       
          
       
       //JLabel tel=new JLabel();
       tel.setText("Telefono");
        tel.setBounds(200,360,120,50);
        tel.setFont(new Font("cops",1,26));
        panel.add(tel);
        //tel.setVisible(false);
       telefono=new JTextField();
       telefono.setFont(new Font("cops",1,26));
       TextPrompt prueba4 =new TextPrompt ("Telefono",telefono);
       telefono.setBounds(200, 400, 200, 50);
       panel.add(telefono);
       telefono.setEnabled(false);

       
       
       //JLabel telt=new JLabel();
       telt.setText("Tipo telefono");
        telt.setBounds(450,360,180,50);
        telt.setFont(new Font("cops",1,26));
        panel.add(telt);
      //  telt.setVisible(false);
       telefonotipo=new JComboBox<String>();
        telefonotipo.setBounds(450,400,300,50);
        panel.add(telefonotipo);
        telefonotipo.addItem("Casa");
        telefonotipo.addItem("Celular");
        telefonotipo.addItem("Oficina");
       telefonotipo.setBackground(new Color(245, 203, 104));
       telefonotipo.setFont(new Font ("copper",2,28));
       telefonotipo.setForeground(Color.black);
       telefonotipo.setEnabled(false);
       telefonotipo.setSelectedIndex(-1);
       telefonotipo.setEnabled(false);
       telefonotipo.addActionListener(AccionLlenarTelefono);
       
       btnTelefono=new JButton();
        btnTelefono.setBounds(800, 400, 150, 50);
       panel.add(btnTelefono);
       btnTelefono.setText("Eliminar");
       btnTelefono.setForeground(Color.black);
       btnTelefono.setFont(new Font ("copper",2,26));
       btnTelefono.setBackground(Color.red);
       btnTelefono.addActionListener(AccionEliminarTel);
       btnTelefono.setEnabled(false);
       
       
       
       
      
       doc.setText("Documento");
        doc.setBounds(500,460,150,50);
        doc.setFont(new Font("cops",1,26));
        panel.add(doc);
        //doc.setVisible(false);
       docempleado=new JComboBox<String>();
        docempleado.setBounds(450,500,300,50);
        panel.add(docempleado);
        docempleado.addItem("CURP");
        docempleado.addItem(" RFC");
        docempleado.addItem(" INE");
        
       docempleado.setBackground(new Color(245, 203, 104));
       docempleado.setFont(new Font ("copper",2,28));
       docempleado.setForeground(Color.black);
       docempleado.setEnabled(false);
       docempleado.setSelectedIndex(-1);
       
       eliminardoc=new JButton();
       eliminardoc.setBounds(800, 500, 150, 50);
        panel.add(eliminardoc);
       eliminardoc.setText("Eliminar");
       eliminardoc.setForeground(Color.black);
       eliminardoc.setFont(new Font ("copper",2,26));
       eliminardoc.setBackground(Color.red);
       eliminardoc.addActionListener(AccionEliminarDoc);
       eliminardoc.setEnabled(false);
      
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 650, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Eliminar");
       btnGuardar.setForeground(Color.white);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.black);
       btnGuardar.addActionListener(AccionEliminarEmpleado2);
       btnGuardar.setVisible(false);
       
       btnCancelar= new JButton();
       btnCancelar.setBounds(400, 650, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     ActionListener AccionListaempleados = new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ae) {
         String qrySelect;
         ResultSet resultado;
         qrySelect="select * from empleado WHERE ID_Empleado="+"'"+listae.getSelectedItem().toString()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
             {
         
         nombre.setText(resultado.getString("Nombre_E"));
         apellidoP.setText(resultado.getString("Ap_pat"));
         apellidoM.setText(resultado.getString("Ap_mat"));
                
         //listae.addItem(resultado.getString("ID_Empleado"));
             }
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }}
                       
      };
    
     private void RegistrarTelActualizar(){
          String qryInsert;
            qryInsert="INSERT into telefono SET Tipo_Tel="+"'"+telefonotipo.getSelectedItem().toString()+"'"+",Numero_Tel="+"'"+telefono.getText()+"'"+",ID_EmpleadoT="+"'"+
                listae.getSelectedItem()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryInsert);
                  
                  telefonotipo.removeItem(telefonotipo.getSelectedItem());
                  telefonotipo.setSelectedIndex(-1);
                  telefono.setText("");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
            }
     }
     
     ActionListener AccionLlenarTelefono = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                   String qrySelect;
         ResultSet resultado;
         qrySelect="select * from telefono WHERE Tipo_Tel="+"'"+telefonotipo.getSelectedItem()+"'"+" and "+
                 "ID_EmpleadoT="+"'"+listae.getSelectedItem()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
             {
         
         telefono.setText(resultado.getString("Numero_Tel"));
        
                
         //listae.addItem(resultado.getString("ID_Empleado"));
             }
         }catch(SQLException ex){
         //JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage()); 
         } 
                    
                }
          }    ;         
     

     ActionListener AccionActualizarTel = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            int c=0;
            String qrySelect;
         ResultSet resultado;
         qrySelect="select * from telefono";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
             if(resultado.getString("ID_EmpleadoT").equals(listae.getSelectedItem()) && 
                     resultado.getString("Tipo_Tel").equals(telefonotipo.getSelectedItem())){ 
                 c=1;
                 break; 
              }     
         }
         if(c==1){
            String qryInsert;
            qryInsert="Update telefono SET Numero_Tel="+"'"+telefono.getText()+"'"+"where ID_EmpleadoT="+"'"+listae.getSelectedItem()+"'"
                  +" and "+"Tipo_Tel="+"'"+telefonotipo.getSelectedItem()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryInsert);
                  telefonotipo.removeItem(telefonotipo.getSelectedItem());
                  telefonotipo.setSelectedIndex(-1);
                  telefono.setText("");
            } catch (SQLException e) {
              
                 JOptionPane.showMessageDialog(null, e.getMessage());
                 
               
            }
         }
         else{
            int i= JOptionPane.showConfirmDialog(null, "Este empleado no tiene este tipo de telefono, \n"
                    + "Quieres agregarlo?");
            if(i==0){RegistrarTelActualizar();}
         }

         }
         catch (SQLException ex){
             JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage());
         
         }
         
         
            }
     };
           
     
     
    ActionListener AccionRegistrarTel = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
          
            String qryInsert;
            qryInsert="INSERT into telefono SET Tipo_Tel="+"'"+telefonotipo.getSelectedItem().toString()+"'"+",Numero_Tel="+"'"+telefono.getText()+"'"+",ID_EmpleadoT="+"'"+
                curp.getText().toUpperCase()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryInsert);
                  
                  telefonotipo.removeItem(telefonotipo.getSelectedItem());
                  telefonotipo.setSelectedIndex(-1);
telefono.setText("");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
            }}
           
        
        
    };
    
    
        ActionListener AccionRegistrardoc = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            CURP=curp.getText();
            RegistrarDocEmpleado();
              docempleado.setSelectedIndex(-1);
          
            
        }
            
        };
        
        
        ActionListener AccionActualizarDoc = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            CURP=listae.getSelectedItem().toString();
         
            ActualizarDocEmpleado();
            docempleado.setSelectedIndex(-1);
            
        }
            
        };
        
        
 ActionListener AccionListaempleadosPActualizar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String qrySelect;
         ResultSet resultado;
         qrySelect="select * from empleado WHERE ID_Empleado="+"'"+listae.getSelectedItem().toString()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
             {
         
         nombre.setText(resultado.getString("Nombre_E"));
         apellidoP.setText(resultado.getString("Ap_pat"));
         apellidoM.setText(resultado.getString("Ap_mat"));
         calle.setText(resultado.getString("Calle"));
         colonia.setText(resultado.getString("Colonia"));
         ciudad.setText(resultado.getString("Ciudad"));
         estado.setText(resultado.getString("Estado"));
         cp.setText(resultado.getString("CP"));
         numeroint.setText(resultado.getString("Numero_int"));
         numeroext.setText(resultado.getString("Numero_ext"));
         btnGuardar.setVisible(true);
                
         //listae.addItem(resultado.getString("ID_Empleado"));
             }
         }catch(SQLException ea){
         JOptionPane.showMessageDialog(null,"ERROR..."+ea.getMessage()); 
         }
        }
     
 };
 ActionListener AccionListaempleadosPEliminar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String qrySelect;
         ResultSet resultado;
         qrySelect="select * from empleado WHERE ID_Empleado="+"'"+listae.getSelectedItem().toString()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
             {
         
         nombre.setText(resultado.getString("Nombre_E"));
         apellidoP.setText(resultado.getString("Ap_pat"));
         apellidoM.setText(resultado.getString("Ap_mat"));
         telefono.setEnabled(true);
         eliminardoc.setEnabled(true);
         docempleado.setEnabled(true);
         telefonotipo.setEnabled(true);
         btnTelefono.setEnabled(true);
         btnGuardar.setVisible(true);
                
         //listae.addItem(resultado.getString("ID_Empleado"));
             }
         }catch(SQLException ea){
         JOptionPane.showMessageDialog(null,"ERROR..."+ea.getMessage()); 
         }
        }
     
 };
                  
    
    ActionListener AccionActualizarEmpleado = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            String qryUpdate;
            qryUpdate="UPDATE empleado SET Nombre_E="+"'"+nombre.getText()+"'"+",Ap_pat="+"'"+
                apellidoP.getText()+"'"+",Ap_mat="+"'"+apellidoM.getText()+"'"+",Calle="+"'"+calle.getText()+
                    "'"+",Colonia="+"'"+colonia.getText()+"'"+",CP="+"'"+cp.getText()+"'"+",Ciudad="+"'"+ciudad.getText()
                    +"'"+",Estado="+"'"+estado.getText()
                    +"'"+",Numero_int="+"'"+numeroint.getText()
                    +"'"+",Numero_ext="+"'"+numeroext.getText()
                    +"'"+"WHERE ID_Empleado="+"'"+listae.getSelectedItem()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryUpdate);;
                setVisible(false);
                  // listae.setSelectedIndex(-1);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
            }
        }
        
    };
      

    
    
    

    
    /*
   //accion para registrar un usuario nuevo
        ActionListener AccionRegistrarUuario = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            String qryInsert;
            qryInsert="INSERT into usuario SET ID_Empleado="+"'"+listae.getSelectedItem().toString()+"'"+",Nombre_usuario="+"'"+
                nombreu.getText()+"'"+",Contraseña="+"'"+contrasena.getText()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryInsert);
                  JOptionPane.showMessageDialog(null, "Registro exitoso");
                  listae.setSelectedIndex(0);
                  nombreu.setText("");
                  contrasena.setText("");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR...Usuario ya existente o datos muy largos"+e.getMessage());
            }
            
            
        }
            
        };
    */

    /*
    private void componentesRD(){
       curp=new JTextField();
       curp.setFont(new Font("cops",1,30));
       TextPrompt prueba1 =new TextPrompt ("CURP del empleado",curp);
       curp.setBounds(500, 300, 410, 60);
       panel.add(curp);
       
       
       JButton btnRFC= new JButton();
       btnRFC.setBounds(100, 430, 350, 350);
       panel.add(btnRFC);
       ImageIcon b = new ImageIcon("RFC.png");
       btnRFC.setIcon(new ImageIcon(b.getImage().getScaledInstance(btnRFC.getWidth(), btnRFC.getHeight(), Image.SCALE_SMOOTH)));
       btnRFC.addActionListener(AccionRegistrarRFC);
       
       JButton btnINE= new JButton();
        btnINE.setBounds(600, 430, 350, 350);
       panel.add(btnINE);
        ImageIcon b1 = new ImageIcon("INE.png");
        btnINE.setIcon(new ImageIcon(b1.getImage().getScaledInstance(btnINE.getWidth(), btnINE.getHeight(), Image.SCALE_SMOOTH)));
        btnINE.addActionListener(AccionRegistrarINE);
        
        JButton btnCURP= new JButton();
        btnCURP.setBounds(1100, 430, 350, 350);
       panel.add(btnCURP);
        ImageIcon b2 = new ImageIcon("CURP.png");
        btnCURP.setIcon(new ImageIcon(b2.getImage().getScaledInstance(btnCURP.getWidth(), btnCURP.getHeight(), Image.SCALE_SMOOTH)));
        btnCURP.addActionListener(AccionRegistrarCURP);
        
         JButton btnCancelar= new JButton();
       btnCancelar.setBounds(1150, 900, 190, 55);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,30));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);
       
       
       JButton btnEliminar= new JButton();
       btnEliminar.setBounds(200, 900, 350, 55);
       panel.add(btnEliminar);
       btnEliminar.setText("Eliminar Documentos");
       btnEliminar.setForeground(Color.white);
       btnEliminar.setFont(new Font ("copper",2,30));
       btnEliminar.setBackground(Color.black);
    }*/
      
      
      
      
      private void RegistrarDocEmpleado(){
            JFileChooser escoger= new JFileChooser();
      
            escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            int estado = escoger.showOpenDialog(null);
            
            if (estado==JFileChooser.APPROVE_OPTION){
                File archivo=escoger.getSelectedFile();

                
                try {
                    FileInputStream flujo=new FileInputStream(archivo);
                    long longitud=archivo.length();
                    //PreparedStatment ps= conexion.sentencia()
                   // String insertcurp ="insert into docempleado CURP'"+archivo+"'WHERE ID_Doc_Empleado"+"'"+curp.getText()+"'";
                    //conexion.sentencia.executeUpdate(insertcurp);
                  PreparedStatement ps = cn.conectar.prepareStatement("INSERT INTO docempleado set DOC="+"?"+""+",ID_Empleado="+"'"+curp.getText().toUpperCase()+"'"
                  +",Tipo_Doc="+"'"+docempleado.getSelectedItem()+"'");//("insert into docempleado (ID_Doc_Empleado,CURP) values ("+"'"+curp.getText()+"',?)");// where ID_Doc_Empleado="+"'"+curp.getText()+"'");
                  
                  ps.setBlob(1,flujo,longitud);
                  
                  ps.executeUpdate();
                    
                docempleado.removeItem(docempleado.getSelectedItem());
                } catch (FileNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage());
                }
                    
            }  
            
        };
     private void RegistrarDocEmpleadoAlActualizar(){
            JFileChooser escoger= new JFileChooser();
      
            escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            int estado = escoger.showOpenDialog(null);
            
            if (estado==JFileChooser.APPROVE_OPTION){
                File archivo=escoger.getSelectedFile();

                
                try {
                    FileInputStream flujo=new FileInputStream(archivo);
                    long longitud=archivo.length();
                    //PreparedStatment ps= conexion.sentencia()
                   // String insertcurp ="insert into docempleado CURP'"+archivo+"'WHERE ID_Doc_Empleado"+"'"+curp.getText()+"'";
                    //conexion.sentencia.executeUpdate(insertcurp);
                  PreparedStatement ps = cn.conectar.prepareStatement("INSERT INTO docempleado set DOC="+"?"+""+",ID_Empleado="+"'"+listae.getSelectedItem()+"'"
                  +",Tipo_Doc="+"'"+docempleado.getSelectedItem()+"'");//("insert into docempleado (ID_Doc_Empleado,CURP) values ("+"'"+curp.getText()+"',?)");// where ID_Doc_Empleado="+"'"+curp.getText()+"'");
                  
                  ps.setBlob(1,flujo,longitud);
                  
                  ps.executeUpdate();
                    
                docempleado.removeItem(docempleado.getSelectedItem());
                } catch (FileNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage());
                }
                    
            }  
            
        };
    
    
        
        private void ActualizarDocEmpleado(){
            int c=0;
            String qrySelect;
         ResultSet resultado;
         qrySelect="select * from docempleado";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
             if(resultado.getString("ID_Empleado").equals(listae.getSelectedItem()) && 
                     resultado.getString("Tipo_Doc").equals(docempleado.getSelectedItem())){ 
                 c=1;
                 break; 
              }     
         }
         if(c==1){
            JFileChooser escoger= new JFileChooser();
      
            escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            int estado = escoger.showOpenDialog(null);
            
            if (estado==JFileChooser.APPROVE_OPTION){
                File archivo=escoger.getSelectedFile();

                
                try {
                    FileInputStream flujo=new FileInputStream(archivo);
                    long longitud=archivo.length();
                    //PreparedStatment ps= conexion.sentencia()
                   // String insertcurp ="insert into docempleado CURP'"+archivo+"'WHERE ID_Doc_Empleado"+"'"+curp.getText()+"'";
                    //conexion.sentencia.executeUpdate(insertcurp);
                  PreparedStatement ps = cn.conectar.prepareStatement("UPDATE docempleado set DOC="+"?"+""+"where ID_Empleado="+"'"+listae.getSelectedItem()+"'"
                  +" and "+"Tipo_Doc="+"'"+docempleado.getSelectedItem()+"'");//("insert into docempleado (ID_Doc_Empleado,CURP) values ("+"'"+curp.getText()+"',?)");// where ID_Doc_Empleado="+"'"+curp.getText()+"'");
                  
                  ps.setBlob(1,flujo,longitud);
                  
                  ps.executeUpdate();
                    
                docempleado.removeItem(docempleado.getSelectedItem());
                } catch (FileNotFoundException| SQLException ex) {
                    JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage());
                }}
         }
         else{
            int i= JOptionPane.showConfirmDialog(null, "Este empleado no tiene este documento, \n"
                    + "Quieres agregarlo?");
            if(i==0){RegistrarDocEmpleadoAlActualizar();}
         }
            
            
            
                    
            
         }
         catch (SQLException ex){
             JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage());
         
         }
         
        };
    
    
      

    /*
    private void componentesCD(){
        listae=new JComboBox<String>();
        listae.setBounds(350,200,360,50);
        panel.add(listae);
        listae.addItem("CURP Empleado");
        listae.setBackground(Color.black);
        listae.setFont(new Font ("copper",2,30));
        listae.setForeground(Color.white);
        
       
       
       String qrySelect;
         String registros;
         ResultSet resultado;
         qrySelect="select * from empleado";
         registros="";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         listae.addItem(resultado.getString("ID_Empleado"));
         
         }
         
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
       
       
       JButton btnRFC= new JButton();
       btnRFC.setBounds(100, 430, 350, 350);
       panel.add(btnRFC);
       ImageIcon b = new ImageIcon("RFC.png");
       btnRFC.setIcon(new ImageIcon(b.getImage().getScaledInstance(btnRFC.getWidth(), btnRFC.getHeight(), Image.SCALE_SMOOTH)));
//       btnRFC.addActionListener(AccionConsultarRFC);
       
       JButton btnINE= new JButton();
        btnINE.setBounds(600, 430, 350, 350);
       panel.add(btnINE);
        ImageIcon b1 = new ImageIcon("INE.png");
        btnINE.setIcon(new ImageIcon(b1.getImage().getScaledInstance(btnINE.getWidth(), btnINE.getHeight(), Image.SCALE_SMOOTH)));
      //  btnINE.addActionListener(AccionConsultarINE);
        
        JButton btnCURP= new JButton();
        btnCURP.setBounds(1100, 430, 350, 350);
       panel.add(btnCURP);
        ImageIcon b2 = new ImageIcon("CURP.png");
        btnCURP.setIcon(new ImageIcon(b2.getImage().getScaledInstance(btnCURP.getWidth(), btnCURP.getHeight(), Image.SCALE_SMOOTH)));
//        btnCURP.addActionListener(AccionConsultarCURP);
        
         JButton btnCancelar= new JButton();
       btnCancelar.setBounds(950, 900, 190, 55);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,30));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);
     
    }
    */
    private void componenteReporteEmpleado(){
        
          JLabel doctxt=new JLabel();
       doctxt.setText("CURP EMPLEADO");
        doctxt.setBounds(245,210,250,50);
        doctxt.setFont(new Font("cops",1,26));
        panel.add(doctxt);
         listae=new JComboBox<String>();
        listae.setBounds(350,250,360,50);
        panel.add(listae);
        listae.setBackground(new Color(245, 203, 104));
        listae.setFont(new Font ("copper",2,30));
        listae.setForeground(Color.black);
                      
       String qrySelect;
         String registros;
         ResultSet resultado;
         qrySelect="select * from empleado";
         registros="";
         try{
         resultado=conexion.sentencia.executeQuery(qrySelect);
         while(resultado.next()){
         listae.addItem(resultado.getString("ID_Empleado"));
         
         }
         
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
        listae.setSelectedIndex(-1);
        listae.addActionListener(AccionListaempleados);
         
         
     nombre=new JTextField();
       nombre.setFont(new Font("cops",1,26));
       TextPrompt prueba =new TextPrompt ("Nombre",nombre);
       nombre.setBounds(50, 330, 350, 50);
       panel.add(nombre);
       
       
       apellidoP=new JTextField();
       apellidoP.setFont(new Font("cops",1,26));
       TextPrompt prueba2 =new TextPrompt ("Apellido P.",apellidoP);
       apellidoP.setBounds(450, 330, 350, 50);
       panel.add(apellidoP);
       
       apellidoM=new JTextField();
       apellidoM.setFont(new Font("cops",1,26));
       TextPrompt prueba3 =new TextPrompt ("Apellido M.",apellidoM);
       apellidoM.setBounds(850, 330, 350, 50);
       panel.add(apellidoM);
      
       JLabel doc=new JLabel();
       doc.setText("Tipo Documento");
        doc.setBounds(400,430,250,50);
        doc.setFont(new Font("cops",1,26));
        panel.add(doc);
       docempleado=new JComboBox<String>();
        docempleado.setBounds(400,470,200,50);
        panel.add(docempleado);
        docempleado.addItem("CURP");
        docempleado.addItem(" RFC");
        docempleado.addItem(" INE");
       docempleado.setBackground(new Color(245, 203, 104));
       docempleado.setFont(new Font ("copper",2,28));
       docempleado.setForeground(Color.black);
       docempleado.setSelectedIndex(-1);
       docempleado.addActionListener(AccionConsultarDOC);
       
         
         JButton btnCancelar= new JButton();
       btnCancelar.setBounds(400, 640, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);
    };
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
            ActionListener AccionConsultarDOC = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
         
                consutaReporteDoc();
 
        }
                
            };
            
    private void consutaReporteDoc(){
        try {
                 cn = new Conexion();
                JasperReport reporteem=null;
                String path="src\\inventarioalmacen\\ReporteE.jasper";
                
                Map param = new HashMap();
                param.put("curp",listae.getSelectedItem());
                param.put("tipo_doc",docempleado.getSelectedItem());
                
                reporteem = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jprint = JasperFillManager.fillReport(reporteem, param, cn.conectar);
                JasperViewer view=new JasperViewer(jprint, false);
                view.setVisible(true);
                
                setVisible(false);
                
                
            } catch (JRException ex) {
                //Logger.getLogger(VentanaEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        
    }    
ActionListener AccionEliminarDoc = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
          
            String qryInsert;
            qryInsert="Delete from docempleado where ID_Empleado="+"'"+listae.getSelectedItem()+"'"
                  +" and "+"Tipo_Doc="+"'"+docempleado.getSelectedItem()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryInsert);
                  docempleado.removeItem(telefonotipo.getSelectedItem());
                  docempleado.setSelectedIndex(-1);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"error"+e.getMessage());
            }}
     };
ActionListener AccionEliminarTel = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
          
            String qryInsert;
            qryInsert="delete from telefono where ID_EmpleadoT="+"'"+listae.getSelectedItem()+"'"
                  +" and "+"Tipo_Tel="+"'"+telefonotipo.getSelectedItem()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryInsert);
                  telefonotipo.removeItem(telefonotipo.getSelectedItem());
                  telefonotipo.setSelectedIndex(-1);
                  telefono.setText("");
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null,"error"+e.getMessage());
            }}
     };
ActionListener AccionEliminarEmpleado2 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
          
            String qryDelete;
            qryDelete="Delete from empleado where ID_Empleado="+"'"+listae.getSelectedItem()+"'";
            try {
                 conexion.sentencia.executeUpdate(qryDelete);
                  setVisible(false);
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null,"error"+e.getMessage());
                }
            }
     };
              
    /*        
            
            
            
    public  void descargar(Conexion cn){
        String nombre=listae.getSelectedItem().toString();
        cn = new Conexion();
            try {
             Statement st=   cn.conectar.createStatement();
             ResultSet rs=st.executeQuery("select CURP from docempleado where ID_Doc_Empleado="+"'"+listae.getSelectedItem().toString()+"'");
            while(rs.next()){
                Blob blob = rs.getBlob("CURP");
                InputStream is = blob.getBinaryStream();
                GuardarDocumento(is, "CURP "+listae.getSelectedItem().toString());
            }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
            }
            
        
    }        
    
       public  void descargarine(Conexion cn){
        String nombre=listae.getSelectedItem().toString();
        cn = new Conexion();
            try {
             Statement st=   cn.conectar.createStatement();
             ResultSet rs=st.executeQuery("select INE from docempleado where ID_Doc_Empleado="+"'"+listae.getSelectedItem().toString()+"'");
            while(rs.next()){
                Blob blob = rs.getBlob("INE");
                InputStream is = blob.getBinaryStream();
                GuardarDocumento(is, "INE "+listae.getSelectedItem().toString());
            }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
            }
            
        
    }     
       
       
       public  void descargargarfc(Conexion cn){
        String nombre=listae.getSelectedItem().toString();
        cn = new Conexion();
            try {
             Statement st=   cn.conectar.createStatement();
             ResultSet rs=st.executeQuery("select RFC from docempleado where ID_Doc_Empleado="+"'"+listae.getSelectedItem().toString()+"'");
            while(rs.next()){
                Blob blob = rs.getBlob("RFC");
                InputStream is = blob.getBinaryStream();
                GuardarDocumento(is, "RFC "+listae.getSelectedItem().toString());
            }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());
            }
            
        
    }     
            
    public static void GuardarDocumento(InputStream x, String nombre ){
        File fichero= new File("D:/"+nombre+".jpg");
        BufferedInputStream in = new BufferedInputStream(x);
        try {
            BufferedOutputStream out= new BufferedOutputStream(new FileOutputStream(fichero));
            
            byte[] bytes =new byte [8096];
            
            int len=0;
            
            while((len=in.read(bytes))>0){
                out.write(bytes,0,len);
                
            }
            out.flush();
            out.close();
            in.close();
            JOptionPane.showMessageDialog(null,"Documento Exportado Correctamente");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"ERROR..."+ex.getMessage());
        }
        
    }

    
    
    */
    
    
   /* public void botonesInterfaz(){
        //BOTON REGISTRAR EMPLEADO
       JButton btnRegistrar= new JButton();
        btnRegistrar.setBounds(500, 120, 350, 350);
       panel.add(btnRegistrar);
        ImageIcon b = new ImageIcon("nuevoe.png");
        btnRegistrar.setIcon(new ImageIcon(b.getImage().getScaledInstance(btnRegistrar.getWidth(), btnRegistrar.getHeight(), Image.SCALE_SMOOTH)));
        btnRegistrar.addActionListener(RegistrarEmpleado);
        btnRegistrar.setVisible(true);
      
        
      //BOTON MODIFICAR O ELIMINAR EMPLEADO
        JButton btnModificar= new JButton();
        btnModificar.setBounds(40, 560, 350, 350);
       panel.add(btnModificar);
        ImageIcon c = new ImageIcon("modificar.png");
        btnModificar.setIcon(new ImageIcon(c.getImage().getScaledInstance(btnModificar.getWidth(), btnModificar.getHeight(), Image.SCALE_SMOOTH)));
        btnModificar.addActionListener(Accionmodificare);
        
        
        // BOTON AGREGAR O ELIMINAR USUARIO
        JButton btnUsuario= new JButton();
        btnUsuario.setBounds(500, 560, 350, 350); 
        ImageIcon icon = new ImageIcon("usuario.png");
        btnUsuario.setIcon(new ImageIcon(icon.getImage().getScaledInstance(btnUsuario.getWidth(), btnUsuario.getHeight(), Image.SCALE_SMOOTH)));
        btnUsuario.setBackground(new Color(217,217,217));
        btnUsuario.addActionListener(Accionusuario);
       panel.add(btnUsuario);
        
       
        //BOTON REGISTRAR O ELIMINAR DOCUMENTOS DE LOS EMPLEADOS
        JButton btnRegistrardoc= new JButton();
        btnRegistrardoc.setBounds(960, 560, 350, 350);
        ImageIcon d = new ImageIcon("nuevodoc.png");
        btnRegistrardoc.setIcon(new ImageIcon(d.getImage().getScaledInstance(btnRegistrardoc.getWidth(), btnRegistrardoc.getHeight(), Image.SCALE_SMOOTH)));
        btnRegistrardoc.addActionListener(AccionDocumentosR);
        panel.add(btnRegistrardoc);
      
        //BOTON PARA CONSULTAR LOS DOCUMENTOS DE LOS EMPLEADOS 
        JButton btnConsultardoc= new JButton();
        btnConsultardoc.setBounds(1420, 560, 350, 350);
        ImageIcon de = new ImageIcon("consultar.png");
        btnConsultardoc.setIcon(new ImageIcon(de.getImage().getScaledInstance(btnConsultardoc.getWidth(), btnConsultardoc.getHeight(), Image.SCALE_SMOOTH)));
        btnConsultardoc.addActionListener(AccionDocumentosC);
        panel.add(btnConsultardoc);
      
        
        
    } */
   

   
   ActionListener Volver = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
           setVisible(false);
        }
       
   };
   
   public void prueba(int i){
       if(i==1){//registrar empleado
           panel.removeAll();
           panel.repaint();
           componentesRegistrarEmpleado();
           panelC();
       }
       
       if(i==3){//modificar empleado
           panel.removeAll();
           panel.repaint();
           ComponenteActualizarEmpleado();
           panelModEmp();
       }
       if(i==4){//eliminar empleado
           panel.removeAll();
           panel.repaint();
           ComponenteEliminarEmpleado();
           panelModEli();
       }
       if(i==10){//Reporte
           panel.removeAll();
           panel.repaint();
           componenteReporteEmpleado();
           panelDocumento();
       }
   }
   
}
