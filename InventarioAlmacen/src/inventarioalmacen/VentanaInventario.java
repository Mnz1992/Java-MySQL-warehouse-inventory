/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventarioalmacen;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
public class VentanaInventario extends JFrame {
    public JDateChooser calendar, calendar2;
    
    public JPanel panel;
   // public UtilDateModel fecha;
    JComboBox listaproveedores, listaproducto, listaempleado;
    public Conexion conexion;
    JTextField folio,precio,cantidad, producto, nombrep, nombreemp;
    JButton btnCancelar, btnGuardar;
    String foliosalida, folioperdida, foliodevolucion;

    public VentanaInventario(){
        setSize(1366,768);
        setTitle("STRELOK S.I.A.");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1024,720));
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicio();
        conexion =new Conexion();
}
    
    
    private void inicio(){
            panel();
            //botonesInterfaz();
            panelC();

    }
    private void panel(){
        panel =new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
         panel.setBackground(new Color(217, 217, 217));

    }
    private void panelPrincipal(){
        JLabel Background=new JLabel();
        Background.setBounds(910, 0, 370, 245);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(430,50, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("INVENTARIO");
        panel.add(texto);
    }
   private void panelC(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(230,10, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Registro Factura");
        panel.add(texto);
    }
    private void panelSalida(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(100,70, 800, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Registro Salida Producto");
        panel.add(texto);
    }
    private void panelPerdida(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(200,70, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Registro Perdida");
        panel.add(texto);
    }
    private void panelDevolucion(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(200,60, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Registro Devolucion");
        panel.add(texto);
    }
    private void panelStock(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 0, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(200,70, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Registro Stock");
        panel.add(texto);
    }
          private void panelReportes(){
        JLabel Background=new JLabel();
        Background.setBounds(880, 20, 480, 300);
          //Background=new JLabel(new ImageIcon(getClass().getResource("IMG/.png")));
          ImageIcon c = new ImageIcon("logo.png");
        Background.setIcon(new ImageIcon(c.getImage().getScaledInstance(Background.getWidth(), Background.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(Background);
        
        JLabel texto=new JLabel();
        texto.setBounds(250,120, 700, 100);
        texto.setFont(new Font ("copper",3,60));
        texto.setText("Reporte Ineventario");
        panel.add(texto);
    }
    
    private void componenteMenuP(){
         JButton RegistrarF= new JButton();
       RegistrarF.setBounds(180, 200, 400, 100);
       panel.add(RegistrarF);
       RegistrarF.setText("Registrar Factura");
       RegistrarF.setForeground(Color.black);
       RegistrarF.setFont(new Font ("copper",2,38));
       RegistrarF.setBackground(Color.white);
      RegistrarF.addActionListener(BotonFactura);
       
       JButton RegistrarSalida= new JButton();
       RegistrarSalida.setBounds(720, 200, 400, 100);
       panel.add(RegistrarSalida);
       RegistrarSalida.setText("Registrar Salida");
       RegistrarSalida.setForeground(Color.black);
       RegistrarSalida.setFont(new Font ("copper",2,38));
       RegistrarSalida.setBackground(Color.white);
      RegistrarSalida.addActionListener(BotonSalida);
      
        JButton RegistrarDevolucion= new JButton();
       RegistrarDevolucion.setBounds(180, 340, 400, 100);
       panel.add(RegistrarDevolucion);
       RegistrarDevolucion.setText("Registrar Devolucion");
       RegistrarDevolucion.setForeground(Color.black);
       RegistrarDevolucion.setFont(new Font ("copper",2,38));
       RegistrarDevolucion.setBackground(Color.white);
       RegistrarDevolucion.addActionListener(BotonDevolucion);
       
       JButton RegistrarPerdida= new JButton();
       RegistrarPerdida.setBounds(720, 340, 400, 100);
       panel.add(RegistrarPerdida);
       RegistrarPerdida.setText("Registrar Perdida");
       RegistrarPerdida.setForeground(Color.black);
       RegistrarPerdida.setFont(new Font ("copper",2,38));
       RegistrarPerdida.setBackground(Color.white);
       RegistrarPerdida.addActionListener(BotonPerdida);
      
      JButton RegistrarStockI= new JButton();
       RegistrarStockI.setBounds(440, 480, 400, 100);
       panel.add(RegistrarStockI);
       RegistrarStockI.setText("Registrar Stock I");
       RegistrarStockI.setForeground(Color.black);
       RegistrarStockI.setFont(new Font ("copper",2,38));
       RegistrarStockI.setBackground(Color.white);
       RegistrarStockI.addActionListener(BotonStockIn);
       
       btnGuardar= new JButton();
       btnGuardar.setBounds(550, 625, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Volver");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
      btnGuardar.addActionListener(BotonVolverMenuP);
    }
       //Acciones botones menu inventario
       ActionListener BotonFactura = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            menuInventario(1);
        }
           
       };
        ActionListener BotonSalida = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            menuInventario(2);
        }
        };
         ActionListener BotonPerdida = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            menuInventario(3);
        }
           
       };
         
         ActionListener BotonDevolucion = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            menuInventario(4);
        }
           
       };
         
         ActionListener BotonStockIn = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            menuInventario(5);
        }
           
       };
    ActionListener BotonVolverMenuP = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
           
       };
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void componenteRF(){
        
         JLabel datosfactura=new JLabel();
        datosfactura.setText("Datos factura");
        datosfactura.setBounds(50,105,200,50);
        datosfactura.setFont(new Font("cops",3,26));
        panel.add(datosfactura);
        
        
        
        JLabel foliotxt=new JLabel();
        foliotxt.setText("Folio");
        foliotxt.setBounds(260,130,200,50);
        foliotxt.setFont(new Font("cops",1,26));
        panel.add(foliotxt);
        folio=new JTextField();
       folio.setFont(new Font("cops",1,26));
       TextPrompt prueba1 =new TextPrompt ("Folio",folio);
       folio.setBounds(120, 170, 350, 50);
       panel.add(folio);
        
       JLabel calendariotxt=new JLabel();
        calendariotxt.setText("Fecha");
        calendariotxt.setBounds(520,130,200,50);
        calendariotxt.setFont(new Font("cops",1,26));
        panel.add(calendariotxt);
        calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        // Ubicar y agregar al panel
        calendar.setBounds(520,170,180,50);
        calendar.setFont(new Font ("copper",2,27));
        panel.add(calendar);
        
        //lista de proveedores
        JLabel provedortxt=new JLabel();
        provedortxt.setText("Proveedor RFC");
        provedortxt.setBounds(100,250,250,50);
        provedortxt.setFont(new Font("cops",1,26));
        panel.add(provedortxt);
        listaproveedores=new JComboBox<String>();
        listaproveedores.setBounds(50,290,300,50);
        
        //listaproveedores.addItem("RFC Proveedor");
       listaproveedores.setBackground(Color.black);
       listaproveedores.setFont(new Font ("copper",2,28));
       listaproveedores.setForeground(Color.white);
       panel.add(listaproveedores);
            
            String qrySelect;
             ResultSet resultado;
             qrySelect="select * from proveedor";
             try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while(resultado.next()){
             listaproveedores.addItem(resultado.getString("ID_Proveedor"));
             listaproveedores.setSelectedIndex(-1);
             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
             
       nombrep=new JTextField();
       nombrep.setFont(new Font("cops",1,26));
       TextPrompt prueba142 =new TextPrompt ("N. Proveedor",nombrep);
       nombrep.setBounds(380, 290, 260, 50);
       panel.add(nombrep);
       nombrep.setEditable(false);
        listaproveedores.addActionListener(AccionListaproveedor);

       
      //lista de proveedores
      JLabel empleadotxt=new JLabel();
        empleadotxt.setText("CURP empleado");
        empleadotxt.setBounds(720,250,250,50);
        empleadotxt.setFont(new Font("cops",1,26));
        panel.add(empleadotxt);
        listaempleado=new JComboBox<String>();
        listaempleado.setBounds(670,290,300,50);
        //listaempleado.addItem("RFC Proveedor");
       listaempleado.setBackground(new Color(245, 203, 104));
       listaempleado.setFont(new Font ("copper",2,28));
       listaempleado.setForeground(Color.black);
       panel.add(listaempleado);
     
            
            String qrySelect2;
             ResultSet resultado2;
             qrySelect2="select * from empleado";
             try{
             resultado2=conexion.sentencia.executeQuery(qrySelect2);
             while(resultado2.next()){
             listaempleado.addItem(resultado2.getString("ID_Empleado"));
             listaempleado.setSelectedIndex(-1);
             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
        
             
        nombreemp=new JTextField();
       nombreemp.setFont(new Font("cops",1,26));
       TextPrompt prueba112 =new TextPrompt ("N. Empleado",nombreemp);
       nombreemp.setBounds(1000, 290, 350, 50);
       panel.add(nombreemp);
       nombreemp.setEditable(false);
        listaempleado.addActionListener(AccionListaempleadoFACTURA);
       
        
        JLabel datosfacturacuerpo=new JLabel();
        datosfacturacuerpo.setText("Productos factura");
        datosfacturacuerpo.setBounds(50,370,250,50);
        datosfacturacuerpo.setFont(new Font("cops",3,26));
        panel.add(datosfacturacuerpo);
             //productos
       JLabel productotxt=new JLabel();
        productotxt.setText("Codigo Producto");
        productotxt.setBounds(100,405,250,50);
        productotxt.setFont(new Font("cops",1,26));
        panel.add(productotxt);      
       listaproducto=new JComboBox<String>();
       listaproducto.setBounds(50,445,300,50);
       listaproducto.setBackground(new Color(245, 203, 104));
       listaproducto.setFont(new Font ("copper",2,28));
       listaproducto.setForeground(Color.BLACK);
       panel.add(listaproducto);
            
            String qrySelects;
             ResultSet resultados;
             qrySelects="select * from producto";
             try{
             resultados=conexion.sentencia.executeQuery(qrySelects);
             while(resultados.next()){
             listaproducto.addItem(resultados.getString("Cod_barras_p"));
             listaproducto.setSelectedIndex(-1);
             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
              listaproducto.addActionListener(AccionListaproductos);
             
        producto=new JTextField();
        producto.setFont(new Font("cops",1,26));
        TextPrompt prueba12 =new TextPrompt ("Producto",producto);
        producto.setBounds(380, 445, 390, 50);
        panel.add(producto);
        producto.setEditable(false);
        
        JLabel cantidadtxt=new JLabel();
        cantidadtxt.setText("Cantidad");
        cantidadtxt.setBounds(800,405,200,50);
        cantidadtxt.setFont(new Font("cops",1,26));
        panel.add(cantidadtxt);
        cantidad=new JTextField();
        cantidad.setFont(new Font("cops",1,26));
        TextPrompt prueba123 =new TextPrompt ("Cantidad",cantidad);
        cantidad.setBounds(800, 445, 120, 50);
        panel.add(cantidad);
        
                  cantidad.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {

                  RegistrarProductoFactura();
                   }
                });
        
        JLabel preciotxt=new JLabel();
        preciotxt.setText("Precio U.");
        preciotxt.setBounds(950,405,200,50);
        preciotxt.setFont(new Font("cops",1,26));
        panel.add(preciotxt);
        precio=new JTextField();
        precio.setFont(new Font("cops",1,26));
        TextPrompt prueba124 =new TextPrompt ("Pecio U.",precio);
        precio.setBounds(950, 445, 120, 50);
        panel.add(precio);
        
        JButton anadir= new JButton();
       anadir.setBounds(1100, 430, 150, 50);
       panel.add(anadir);
       anadir.setText("Anadir");
       anadir.setForeground(Color.white);
       anadir.setFont(new Font ("copper",2,26));
       anadir.setBackground(Color.green);
       anadir.addActionListener(AccionRegistrarProductoFactura);
       anadir.setVisible(false);
     
       /*
       productostabla =new JTable();
       modelot=new DefaultTableModel();
       modelot.setColumnIdentifiers(columnas);
       productostabla.setFont(new Font ("copper",2,18));
       productostabla.setForeground(Color.white);
       productostabla.setBackground(Color.black);
       productostabla.setEnabled(false);
       productostabla.setModel(modelot);
       panel.add(productostabla);
       
       JScrollPane scrollPane = new JScrollPane(productostabla);
       scrollPane.setBounds(100, 390, 1000, 250); 
       panel.add(scrollPane);
       */
       
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 665, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.setVisible(false);
      btnGuardar.addActionListener(Volver);
       
        btnCancelar= new JButton();
       btnCancelar.setBounds(400, 665, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);


  
    }
             private void RegistrarProductoFactura(){
                 String qryInsert="INSERT into factura_entrada_cuerpo SET Folio="+"'"+folio.getText()+"'"+",Stock_Entrada="+
               "'"+cantidad.getText()+"'"+",Cod_barras_p="+"'"+listaproducto.getSelectedItem()+"'"+",precio_entrada="+"'"+precio.getText()+"'";
                producto.setText("");
                precio.setText("");
                cantidad.setText("");
               // listaproducto.setSelectedIndex(-1);
                
                
            try {
                conexion.sentencia.executeUpdate(qryInsert);
                btnGuardar.setVisible(true);
            } catch (SQLException eS) {
                JOptionPane.showMessageDialog(null, "Error"+eS.getMessage());
            }
             }
    
    
    
    
    //agregar productos a la tabla
        ActionListener AccionAgregarproductos = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
         /*   try {
                 if(listaproducto.getSelectedItem() != "Producto"){
         modelot.addRow(new Object[]{listaproducto.getSelectedItem().toString(),producto.getText(),cantidad.getText()
         ,Integer.parseInt(cantidad.getText())*Double.parseDouble(precio.getText())});
          //  System.out.println(modelot.getValueAt(1, 3));
          listaproducto.setSelectedItem(0);
          producto.setText("");
          cantidad.setText("");
          precio.setText("");
            }else{
                JOptionPane.showMessageDialog(null,"Verifique los campos del producto");
            }
                
            } catch (HeadlessException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Verifique los campos del producto");

            }*/
               try {
                
            } catch (Exception ef) {
            }
 
           
        }
            
        };

     ActionListener AccionListaproductos = new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ae) {
         String qrySelect;
         ResultSet resultado;
         qrySelect="select * from producto WHERE Cod_barras_p="+"'"+listaproducto.getSelectedItem().toString()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
                 
             {
         
         producto.setText(resultado.getString("Nombre_prod"));
         precio.setText(resultado.getString("Precio"));
      
             }
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }}
                       
      };
     
     
      ActionListener AccionListaproveedor = new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ae) {
         String qrySelect;
         ResultSet resultado;
         qrySelect="select * from proveedor WHERE ID_Proveedor="+"'"+listaproveedores.getSelectedItem().toString()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
                 
             {
         
         nombrep.setText(resultado.getString("Empresa_prov"));
       
             }
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }}
                       
      };
      
      ActionListener AccionListaempleadoFACTURA = new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ae) {
         String formato = calendar.getDateFormatString();
                 java.util.Date date = calendar.getDate();
         SimpleDateFormat sdf = new SimpleDateFormat(formato);        
                 
         String qrySelect,qryInsert;
         ResultSet resultado;
         qrySelect="select * from empleado WHERE ID_Empleado="+"'"+listaempleado.getSelectedItem().toString()+"'";
       qryInsert="INSERT into factura_entrada SET Folio="+"'"+folio.getText()+"'"+",Fecha_Entrada="+
               "'"+sdf.format(date)+"'"+",ID_Proveedor="+"'"+
                listaproveedores.getSelectedItem()+"'"+",ID_Empleado="+"'"+listaempleado.getSelectedItem()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
                 
             {   
             String nombre=(resultado.getString("Nombre_E")+" ");
             String ap=(resultado.getString("Ap_pat"));
             nombreemp.setText(nombre+ap);
         
       
             }
            
             
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
         try { 
             conexion.sentencia.executeUpdate(qryInsert);
             listaempleado.setEnabled(false);
             folio.setEnabled(false);
             listaproveedores.setEnabled(false);
             calendar.setEnabled(false);
             btnCancelar.setVisible(false);

         } catch (SQLException e) {
                  JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage());    
                     
                 }
}
                       
      };
      
      ActionListener AccionListaempleadoSalida = new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ae) {
         String formato = calendar.getDateFormatString();
                 java.util.Date date = calendar.getDate();
         SimpleDateFormat sdf = new SimpleDateFormat(formato);        
                 
         DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/ddhh:mm:ss");
         foliosalida="ALM"+dtf5.format(LocalDateTime.now());
         
         String qrySelect,qryInsert;
         ResultSet resultado;
         qrySelect="select * from empleado WHERE ID_Empleado="+"'"+listaempleado.getSelectedItem().toString()+"'";
       qryInsert="INSERT into vale_salida SET ID_Salida="+"'"+foliosalida+"'"+",Fecha_Salida="+
               "'"+sdf.format(date)+"'"+",ID_Empleado="+"'"+listaempleado.getSelectedItem()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
                 
             {
         
         String nombre=(resultado.getString("Nombre_E")+" ");
         String ap=(resultado.getString("Ap_pat"));
         nombreemp.setText(nombre+ap);
         
       
             }
            
             
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }
          try {
              conexion.sentencia.executeUpdate(qryInsert);
             listaempleado.setEnabled(false);
             calendar.setEnabled(false);
             //btnCancelar.setVisible(false);
         } catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
                 }
             }
                       
      };
        ActionListener AccionRegistroProductosEntradainicial = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
       String formato = calendar.getDateFormatString();
                 java.util.Date date = calendar.getDate();
         SimpleDateFormat sdf = new SimpleDateFormat(formato);        
                 
         DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/ddhh:mm:ss");
         foliosalida="SAL"+dtf5.format(LocalDateTime.now());
         
         String qryInsert;
       
       qryInsert="INSERT into inventario SET Cod_barras_p="+"'"+listaproducto.getSelectedItem()+"'"+",Stock_ini="+"'"+cantidad.getText()+
               "'"+",FolioI="+"'"+"INVI"+listaproducto.getSelectedItem()+"'"
               +",ID_Empleado="+"'"+listaempleado.getSelectedItem()+"'";
            try {
                conexion.sentencia.executeUpdate(qryInsert);
                menuInventario(8);
            } catch (SQLException es) {
                JOptionPane.showInputDialog(null,"Inventario Inicial ya registrado  "+ es.getMessage());
            }
        }
            
        };
        
        ActionListener AccionRegistroProductosPerdida = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
       String formato = calendar.getDateFormatString();
                 java.util.Date date = calendar.getDate();
         SimpleDateFormat sdf = new SimpleDateFormat(formato);        
                 
         DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/ddhh:mm:ss");
         foliosalida="PER"+dtf5.format(LocalDateTime.now());
         
         String qryInsert;
       
       qryInsert="INSERT into perdida SET Cod_barras_p="+"'"+listaproducto.getSelectedItem()+"'"+",Fecha_Perdida="+
               "'"+sdf.format(date)+"'"+",Cantidad_Perdida="+"'"+cantidad.getText()+
               "'"+",Folio_Perdida="+"'"+foliosalida+"'"
               +",ID_Empleado="+"'"+listaempleado.getSelectedItem()+"'";
            try {
                conexion.sentencia.executeUpdate(qryInsert);
                menuInventario(8);
            } catch (SQLException es) {
                JOptionPane.showInputDialog(null,"Error"+ es.getMessage());
            }
        }
            
        };
        
        ActionListener AccionRegistroProductosDevolucion = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
       String formato = calendar.getDateFormatString();
                 java.util.Date date = calendar.getDate();
         SimpleDateFormat sdf = new SimpleDateFormat(formato);        
                 
         DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy/MM/ddhh:mm:ss");
         foliosalida="DEV"+dtf5.format(LocalDateTime.now());
         
         String qryInsert;
       
       qryInsert="INSERT into devolucion SET Cod_barras_p="+"'"+listaproducto.getSelectedItem()+"'"+",Fecha_Devolucion="+
               "'"+sdf.format(date)+"'"+",Cantidad_Devuelta="+"'"+cantidad.getText()+
               "'"+",Folio_Devolucion="+"'"+foliosalida+"'"
               +",ID_Empleado="+"'"+listaempleado.getSelectedItem()+"'";
            try {
                conexion.sentencia.executeUpdate(qryInsert);
                menuInventario(8);
            } catch (SQLException es) {
                JOptionPane.showInputDialog(null,"Error"+ es.getMessage());
            }
        }
            
        };

      
      ActionListener AccionListaempleadosencillo = new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ae) {
         String qrySelect;
         ResultSet resultado;
         qrySelect="select * from empleado WHERE ID_Empleado="+"'"+listaempleado.getSelectedItem().toString()+"'";
         try{
             resultado=conexion.sentencia.executeQuery(qrySelect);
             while (resultado.next())
                 
             {
         
         String nombre=(resultado.getString("Nombre_E")+" ");
         String ap=(resultado.getString("Ap_pat"));
         nombreemp.setText(nombre+ap);
         
       
             }
     
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
         }}
                       
      };
    
      
      
    ActionListener AccionRegistrarProductoFactura = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String qryInsert="INSERT into factura_entrada_cuerpo SET Folio="+"'"+folio.getText()+"'"+",Stock_Entrada="+
               "'"+cantidad.getText()+"'"+",Cod_barras_p="+"'"+listaproducto.getSelectedItem()+"'";
                producto.setText("");
                precio.setText("");
                cantidad.setText("");
               // listaproducto.setSelectedIndex(-1);
                
                
            try {
                conexion.sentencia.executeUpdate(qryInsert);
                btnGuardar.setVisible(true);
            } catch (SQLException eS) {
                JOptionPane.showMessageDialog(null, "Error"+eS.getMessage());
            }
        }
        
    };
    
    ActionListener AccionRegistrarProductoSalida = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String qryInsert="INSERT into vale_cuerpo_salida SET ID_salida="+"'"+foliosalida+"'"+",Stock_Salida="+
               "'"+cantidad.getText()+"'"+",Cod_barras_p="+"'"+listaproducto.getSelectedItem()+"'";
                producto.setText("");
                precio.setText("");
                cantidad.setText("");
               // listaproducto.setSelectedIndex(-1);1111111
                
                
            try {
                conexion.sentencia.executeUpdate(qryInsert);
                btnGuardar.setVisible(true);
            } catch (SQLException eS) {
                JOptionPane.showMessageDialog(null, "Error"+eS.getMessage());
            }
        }
        
    };
    
    
    
    
    
    
    private void componenteVale(){
         JLabel dtv=new JLabel();
        dtv.setText("Datos del vale");
        dtv.setBounds(50,225,220,50);
        dtv.setFont(new Font("cops",3,26));
        panel.add(dtv);
        
        JLabel fechatxt=new JLabel();
        fechatxt.setText("Fecha");
        fechatxt.setBounds(250,250,200,50);
        fechatxt.setFont(new Font("cops",1,26));
        panel.add(fechatxt);
        calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        // Ubicar y agregar al panel
        calendar.setBounds(250,290,180,50);
        calendar.setFont(new Font ("copper",2,27));
        panel.add(calendar);

       
      //lista de proveedores
      JLabel empleadotxt=new JLabel();
        empleadotxt.setText("CURP Empleado");
        empleadotxt.setBounds(480,250,220,50);
        empleadotxt.setFont(new Font("cops",1,26));
        panel.add(empleadotxt);
        listaempleado=new JComboBox<String>();
        listaempleado.setBounds(480,290,300,50);
        panel.add(listaempleado);
        //listaempleado.addItem("RFC Proveedor");
       // listaempleado.setSelectedIndex(-1);
    //    listaempleado.setRenderer(new MyComboBoxRenderer("CURP Empleado"));
       listaempleado.setBackground(Color.black);
       listaempleado.setFont(new Font ("copper",2,28));
       listaempleado.setForeground(Color.white);
     
            
            String qrySelect2;
             ResultSet resultado2;
             qrySelect2="select * from empleado";
             try{
             resultado2=conexion.sentencia.executeQuery(qrySelect2);
             while(resultado2.next()){
             listaempleado.addItem(resultado2.getString("ID_Empleado"));
             listaempleado.setSelectedIndex(-1);
             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
             
        nombreemp=new JTextField();
       nombreemp.setFont(new Font("cops",1,26));
       TextPrompt prueba112 =new TextPrompt ("N. Empleado",nombreemp);
       nombreemp.setBounds(820, 290, 350, 50);
       panel.add(nombreemp);
       nombreemp.setEditable(false);
        listaempleado.addActionListener(AccionListaempleadoSalida);
       
             //productos
         
             JLabel dtvV=new JLabel();
        dtvV.setText("Productos del vale");
        dtvV.setBounds(50,358,250,50);
        dtvV.setFont(new Font("cops",3,26));
        panel.add(dtvV);
             
        JLabel productotxt=new JLabel();
        productotxt.setText("Codigo Producto");
        productotxt.setBounds(140,390,260,50);
        productotxt.setFont(new Font("cops",1,26));
        panel.add(productotxt);     
       listaproducto=new JComboBox<String>();
       listaproducto.setBounds(90,430,300,50);
       panel.add(listaproducto);
    //   listaproducto.addItem("Producto");
       listaproducto.setBackground(Color.black);
       listaproducto.setFont(new Font ("copper",2,28));
       listaproducto.setForeground(Color.white);
       
            
            String qrySelects;
             ResultSet resultados;
             qrySelects="select * from producto";
             try{
             resultados=conexion.sentencia.executeQuery(qrySelects);
             while(resultados.next()){
             listaproducto.addItem(resultados.getString("Cod_barras_p"));
             listaproducto.setSelectedIndex(-1);
             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
             listaproducto.addActionListener(AccionListaproductos);
        producto=new JTextField();
        producto.setFont(new Font("cops",1,26));
        TextPrompt prueba12 =new TextPrompt ("Producto",producto);
        producto.setBounds(420, 430, 390, 50);
        panel.add(producto);
        producto.setEditable(false);
        
        JLabel cantidads=new JLabel();
        cantidads.setText("Cantidad");
        cantidads.setBounds(990,390,200,50);
        cantidads.setFont(new Font("cops",1,26));
        panel.add(cantidads);
        cantidad=new JTextField();
        cantidad.setFont(new Font("cops",1,26));
        TextPrompt prueba123 =new TextPrompt ("Cantidad",cantidad);
        cantidad.setBounds(990, 430, 120, 50);
        panel.add(cantidad);
         cantidad.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {

                 RegistrarProductoValeSalida();
                   }
                });
        
        JLabel preciotxt=new JLabel();
        preciotxt.setText("Precio");
        preciotxt.setBounds(840,390,200,50);
        preciotxt.setFont(new Font("cops",1,26));
        panel.add(preciotxt);
        precio=new JTextField();
        precio.setFont(new Font("cops",1,26));
        TextPrompt prueba124 =new TextPrompt ("Pecio U.",precio);
        precio.setBounds(840, 430, 120, 50);
        panel.add(precio);
        
        JButton anadir= new JButton(); ///se intercambio por la accion de cantidad producto
       anadir.setBounds(1100, 430, 150, 50);
       panel.add(anadir);
       anadir.setText("Anadir");
       anadir.setForeground(Color.white);
       anadir.setFont(new Font ("copper",2,26));
       anadir.setBackground(Color.green);
       anadir.addActionListener(AccionRegistrarProductoSalida);
       anadir.setVisible(false);
     
       /*
       productostabla =new JTable();
       modelot=new DefaultTableModel();
       modelot.setColumnIdentifiers(columnas);
       productostabla.setFont(new Font ("copper",2,18));
       productostabla.setForeground(Color.white);
       productostabla.setBackground(Color.black);
       productostabla.setEnabled(false);
       productostabla.setModel(modelot);
       panel.add(productostabla);
       
       JScrollPane scrollPane = new JScrollPane(productostabla);
       scrollPane.setBounds(100, 390, 1000, 250); 
       panel.add(scrollPane);
       */
       
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 665, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.setVisible(false);
       btnGuardar.addActionListener(Volver);
       
        btnCancelar= new JButton();
       btnCancelar.setBounds(400, 665, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);

  
    }
    
    private void RegistrarProductoValeSalida(){
        String qryInsert="INSERT into vale_cuerpo_salida SET ID_salida="+"'"+foliosalida+"'"+",Stock_Salida="+
               "'"+cantidad.getText()+"'"+",Cod_barras_p="+"'"+listaproducto.getSelectedItem()+"'";
                producto.setText("");
                precio.setText("");
                cantidad.setText("");
               // listaproducto.setSelectedIndex(-1);1111111
                
                
            try {
                conexion.sentencia.executeUpdate(qryInsert);
                btnGuardar.setVisible(true);
            } catch (SQLException eS) {
                JOptionPane.showMessageDialog(null, "Error"+eS.getMessage());
            }
        
    }
    
    
    private void componentePerdida(){
        JLabel dtv=new JLabel();
          dtv.setText("Datos de perdida");
        dtv.setBounds(50,225,220,50);
        dtv.setFont(new Font("cops",3,26));
        panel.add(dtv);
        
    JLabel calendartxt=new JLabel();
        calendartxt.setText("Feecha");
        calendartxt.setBounds(250,250,260,50);
        calendartxt.setFont(new Font("cops",1,26));
        panel.add(calendartxt);       
    calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        // Ubicar y agregar al panel
        calendar.setBounds(250,290,180,50);
        calendar.setFont(new Font ("copper",2,27));
        panel.add(calendar);

       
      //lista de proveedores
      JLabel empleadotxt=new JLabel();
      empleadotxt.setText("CURP Empleado");
        empleadotxt.setBounds(480,250,220,50);
        empleadotxt.setFont(new Font("cops",1,26));
        panel.add(empleadotxt);
        listaempleado=new JComboBox<String>();
        listaempleado.setBounds(480,290,300,50);
        panel.add(listaempleado);
        //listaempleado.addItem("RFC Proveedor");
       // listaempleado.setSelectedIndex(-1);
        listaempleado.setRenderer(new MyComboBoxRenderer("CURP Empleado"));
       listaempleado.setBackground(Color.black);
       listaempleado.setFont(new Font ("copper",2,28));
       listaempleado.setForeground(Color.white);
     
            
            String qrySelect2;
             ResultSet resultado2;
             qrySelect2="select * from empleado";
             try{
             resultado2=conexion.sentencia.executeQuery(qrySelect2);
             while(resultado2.next()){
             listaempleado.addItem(resultado2.getString("ID_Empleado"));
             listaempleado.setSelectedIndex(-1);
             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
              listaempleado.addActionListener(AccionListaempleadosencillo);
        nombreemp=new JTextField();
       nombreemp.setFont(new Font("cops",1,26));
       TextPrompt prueba112 =new TextPrompt ("N. Empleado",nombreemp);
       nombreemp.setBounds(820, 290, 350, 50);
       panel.add(nombreemp);
       nombreemp.setEditable(false);
       
       
        JLabel dtvV=new JLabel();
        dtvV.setText("Producto perdido ");
        dtvV.setBounds(50,358,250,50);
        dtvV.setFont(new Font("cops",3,26));
        panel.add(dtvV);
       
             //productos
       JLabel productotxt=new JLabel();
        productotxt.setText("Codigo Producto");
        productotxt.setBounds(160,405,260,50);
        productotxt.setFont(new Font("cops",1,26));
        panel.add(productotxt);
       listaproducto=new JComboBox<String>();
       listaproducto.setBounds(110,445,300,50);
       panel.add(listaproducto);
       listaproducto.addItem("Producto");
       listaproducto.setBackground(Color.black);
       listaproducto.setFont(new Font ("copper",2,28));
       listaproducto.setForeground(Color.white);
       listaproducto.addActionListener(AccionListaproductos);
            
            String qrySelects;
             ResultSet resultados;
             qrySelects="select * from producto";
             try{
             resultados=conexion.sentencia.executeQuery(qrySelects);
             while(resultados.next()){
             listaproducto.addItem(resultados.getString("Cod_barras_p"));

             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
             
        producto=new JTextField();
        producto.setFont(new Font("cops",1,26));
        TextPrompt prueba12 =new TextPrompt ("Producto",producto);
        producto.setBounds(420, 445, 390, 50);
        panel.add(producto);
        producto.setEditable(false);
        
        JLabel Cantidad=new JLabel();
        Cantidad.setText("Cantidad");
        Cantidad.setBounds(990,405,260,50);
        Cantidad.setFont(new Font("cops",1,26));
        panel.add(Cantidad);
        cantidad=new JTextField();
        cantidad.setFont(new Font("cops",1,26));
        TextPrompt prueba123 =new TextPrompt ("Cantidad",cantidad);
        cantidad.setBounds(990, 445, 120, 50);
        panel.add(cantidad);
        
         JLabel preciotxt=new JLabel();
        preciotxt.setText("Precio");
        preciotxt.setBounds(840,405,260,50);
        preciotxt.setFont(new Font("cops",1,26));
        panel.add(preciotxt); 
        precio=new JTextField();
        precio.setFont(new Font("cops",1,26));
        TextPrompt prueba124 =new TextPrompt ("Pecio U.",precio);
        precio.setBounds(840, 445, 120, 50);
        panel.add(precio);
        
     
     
       /*
       productostabla =new JTable();
       modelot=new DefaultTableModel();
       modelot.setColumnIdentifiers(columnas);
       productostabla.setFont(new Font ("copper",2,18));
       productostabla.setForeground(Color.white);
       productostabla.setBackground(Color.black);
       productostabla.setEnabled(false);
       productostabla.setModel(modelot);
       panel.add(productostabla);
       
       JScrollPane scrollPane = new JScrollPane(productostabla);
       scrollPane.setBounds(100, 390, 1000, 250); 
       panel.add(scrollPane);
       */
       
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 665, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.addActionListener(AccionRegistroProductosPerdida);
       
        btnCancelar= new JButton();
       btnCancelar.setBounds(400, 665, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);

        
    }
    
    private void componenteDevolucion(){
        JLabel dtv=new JLabel();
        dtv.setText("Datos de devolucion");
        dtv.setBounds(50,225,250,50);
        dtv.setFont(new Font("cops",3,26));
        panel.add(dtv);
        
        JLabel calendartxt=new JLabel();
        calendartxt.setText("Fecha");
        calendartxt.setBounds(250,250,260,50);
        calendartxt.setFont(new Font("cops",1,26));
        panel.add(calendartxt);  
       calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        // Ubicar y agregar al panel
        calendar.setBounds(250,290,180,50);
        calendar.setFont(new Font ("copper",2,27));
        panel.add(calendar);

       
      //lista de proveedores
      JLabel empleadotxt=new JLabel();
      empleadotxt.setText("CURP Empleado");
        empleadotxt.setBounds(480,250,220,50);
        empleadotxt.setFont(new Font("cops",1,26));
        panel.add(empleadotxt);
        listaempleado=new JComboBox<String>();
        listaempleado.setBounds(480,290,300,50);
        panel.add(listaempleado);
        //listaempleado.addItem("RFC Proveedor");
       // listaempleado.setSelectedIndex(-1);
        listaempleado.setRenderer(new MyComboBoxRenderer("CURP Empleado"));
       listaempleado.setBackground(Color.black);
       listaempleado.setFont(new Font ("copper",2,28));
       listaempleado.setForeground(Color.white);
     
            
            String qrySelect2;
             ResultSet resultado2;
             qrySelect2="select * from empleado";
             try{
             resultado2=conexion.sentencia.executeQuery(qrySelect2);
             while(resultado2.next()){
             listaempleado.addItem(resultado2.getString("ID_Empleado"));
             listaempleado.setSelectedIndex(-1);
             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
              listaempleado.addActionListener(AccionListaempleadosencillo);
        nombreemp=new JTextField();
       nombreemp.setFont(new Font("cops",1,26));
       TextPrompt prueba112 =new TextPrompt ("N. Empleado",nombreemp);
       nombreemp.setBounds(820, 290, 350, 50);
       panel.add(nombreemp);
       nombreemp.setEditable(false);
        
        JLabel dtvV=new JLabel();
        dtvV.setText("Producto a devolver");
        dtvV.setBounds(50,358,250,50);
        dtvV.setFont(new Font("cops",3,26));
        panel.add(dtvV);
             
             //productos
       JLabel productotxt=new JLabel();
        productotxt.setText("Codigo Producto");
        productotxt.setBounds(160,405,260,50);
        productotxt.setFont(new Font("cops",1,26));
        panel.add(productotxt); 
       listaproducto=new JComboBox<String>();
       listaproducto.setBounds(110,445,300,50);
       panel.add(listaproducto);
       listaproducto.addItem("Producto");
       listaproducto.setBackground(Color.black);
       listaproducto.setFont(new Font ("copper",2,28));
       listaproducto.setForeground(Color.white);
       listaproducto.addActionListener(AccionListaproductos);
            
            String qrySelects;
             ResultSet resultados;
             qrySelects="select * from producto";
             try{
             resultados=conexion.sentencia.executeQuery(qrySelects);
             while(resultados.next()){
             listaproducto.addItem(resultados.getString("Cod_barras_p"));

             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
        
             
        producto=new JTextField();
        producto.setFont(new Font("cops",1,26));
        TextPrompt prueba12 =new TextPrompt ("Producto",producto);
        producto.setBounds(420, 445, 390, 50);
        panel.add(producto);
        producto.setEditable(false);
        
        JLabel Cantidad=new JLabel();
        Cantidad.setText("Cantidad");
        Cantidad.setBounds(990,405,260,50);
        Cantidad.setFont(new Font("cops",1,26));
        panel.add(Cantidad);
        cantidad=new JTextField();
        cantidad.setFont(new Font("cops",1,26));
        TextPrompt prueba123 =new TextPrompt ("Cantidad",cantidad);
        cantidad.setBounds(990, 445, 120, 50);
        panel.add(cantidad);
        
         JLabel preciotxt=new JLabel();
        preciotxt.setText("Precio");
        preciotxt.setBounds(840,405,260,50);
        preciotxt.setFont(new Font("cops",1,26));
        panel.add(preciotxt); 
        precio=new JTextField();
        precio.setFont(new Font("cops",1,26));
        TextPrompt prueba124 =new TextPrompt ("Pecio U.",precio);
        precio.setBounds(840, 445, 120, 50);
        panel.add(precio);

     
       /*
       productostabla =new JTable();
       modelot=new DefaultTableModel();
       modelot.setColumnIdentifiers(columnas);
       productostabla.setFont(new Font ("copper",2,18));
       productostabla.setForeground(Color.white);
       productostabla.setBackground(Color.black);
       productostabla.setEnabled(false);
       productostabla.setModel(modelot);
       panel.add(productostabla);
       
       JScrollPane scrollPane = new JScrollPane(productostabla);
       scrollPane.setBounds(100, 390, 1000, 250); 
       panel.add(scrollPane);
       */
       
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 665, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
       btnGuardar.addActionListener(AccionRegistroProductosDevolucion);
       
        btnCancelar= new JButton();
       btnCancelar.setBounds(400, 665, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);

    }
    
    private void componenteStockI(){
        
        JLabel dtv=new JLabel();
        dtv.setText("Datos Stock I.");
        dtv.setBounds(50,225,220,50);
        dtv.setFont(new Font("cops",3,26));
        panel.add(dtv);
        
        JLabel calendartxt=new JLabel();
        calendartxt.setText("Feecha");
        calendartxt.setBounds(250,250,260,50);
        calendartxt.setFont(new Font("cops",1,26));
        panel.add(calendartxt);     
       calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        // Ubicar y agregar al panel
        calendar.setBounds(250,290,180,50);
        calendar.setFont(new Font ("copper",2,27));
        panel.add(calendar);

       
      //lista de empleados
      JLabel empleadotxt=new JLabel();
      empleadotxt.setText("CURP Empleado");
        empleadotxt.setBounds(480,250,220,50);
        empleadotxt.setFont(new Font("cops",1,26));
        panel.add(empleadotxt);
        listaempleado=new JComboBox<String>();
        listaempleado.setBounds(480,290,300,50);
        panel.add(listaempleado);
        //listaempleado.addItem("RFC Proveedor");
       // listaempleado.setSelectedIndex(-1);
        listaempleado.setRenderer(new MyComboBoxRenderer("CURP Empleado"));
       listaempleado.setBackground(Color.black);
       listaempleado.setFont(new Font ("copper",2,28));
       listaempleado.setForeground(Color.white);
     
            
            String qrySelect2;
             ResultSet resultado2;
             qrySelect2="select * from empleado";
             try{
             resultado2=conexion.sentencia.executeQuery(qrySelect2);
             while(resultado2.next()){
             listaempleado.addItem(resultado2.getString("ID_Empleado"));
             listaempleado.setSelectedIndex(-1);
             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
             listaempleado.addActionListener(AccionListaempleadosencillo);
        nombreemp=new JTextField();
       nombreemp.setFont(new Font("cops",1,26));
       TextPrompt prueba112 =new TextPrompt ("N. Empleado",nombreemp);
       nombreemp.setBounds(820, 290, 350, 50);
       panel.add(nombreemp);
       nombreemp.setEditable(false);
      
       
       JLabel dtvV=new JLabel();
        dtvV.setText("Producto Registro Stock");
        dtvV.setBounds(50,358,290,50);
        dtvV.setFont(new Font("cops",3,26));
        panel.add(dtvV);
       
             //productos
        JLabel productotxt=new JLabel();
        productotxt.setText("Codigo Producto");
        productotxt.setBounds(160,405,260,50);
        productotxt.setFont(new Font("cops",1,26));
        panel.add(productotxt); 
       listaproducto=new JComboBox<String>();
       listaproducto.setBounds(110,445,300,50);
       panel.add(listaproducto);
       listaproducto.addItem("Producto");
       listaproducto.setBackground(Color.black);
       listaproducto.setFont(new Font ("copper",2,28));
       listaproducto.setForeground(Color.white);
       listaproducto.addActionListener(AccionListaproductos);
            
            String qrySelects;
             ResultSet resultados;
             qrySelects="select * from producto";
             try{
             resultados=conexion.sentencia.executeQuery(qrySelects);
             while(resultados.next()){
             listaproducto.addItem(resultados.getString("Cod_barras_p"));

             }

             }catch(SQLException e){
             JOptionPane.showMessageDialog(null,"ERROR..."+e.getMessage()); 
             }
             
        producto=new JTextField();
        producto.setFont(new Font("cops",1,26));
        TextPrompt prueba12 =new TextPrompt ("Producto",producto);
        producto.setBounds(420, 445, 390, 50);
        panel.add(producto);
        producto.setEditable(false);
        
        
        
        JLabel Cantidad=new JLabel();
        Cantidad.setText("Cantidad");
        Cantidad.setBounds(990,405,260,50);
        Cantidad.setFont(new Font("cops",1,26));
        panel.add(Cantidad); 
        cantidad=new JTextField();
        cantidad.setFont(new Font("cops",1,26));
        TextPrompt prueba123 =new TextPrompt ("Cantidad",cantidad);
        cantidad.setBounds(990, 445, 120, 50);
        panel.add(cantidad);
        
        JLabel preciotxt=new JLabel();
        preciotxt.setText("Precio");
        preciotxt.setBounds(840,405,260,50);
        preciotxt.setFont(new Font("cops",1,26));
        panel.add(preciotxt); 
        precio=new JTextField();
        precio.setFont(new Font("cops",1,26));
        TextPrompt prueba124 =new TextPrompt ("Pecio U.",precio);
        precio.setBounds(840, 445, 120, 50);
        panel.add(precio);

     
       /*
       productostabla =new JTable();
       modelot=new DefaultTableModel();
       modelot.setColumnIdentifiers(columnas);
       productostabla.setFont(new Font ("copper",2,18));
       productostabla.setForeground(Color.white);
       productostabla.setBackground(Color.black);
       productostabla.setEnabled(false);
       productostabla.setModel(modelot);
       panel.add(productostabla);
       
       JScrollPane scrollPane = new JScrollPane(productostabla);
       scrollPane.setBounds(100, 390, 1000, 250); 
       panel.add(scrollPane);
       */
       
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 665, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Guardar");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
      btnGuardar.addActionListener(AccionRegistroProductosEntradainicial);
       
        btnCancelar= new JButton();
       btnCancelar.setBounds(400, 665, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(Volver);

    }
    /*
    
    public void botonesInterfaz(){
        
        JTextField k=new JTextField();
        k.setBounds(400, 0, 80, 20);
        
        
        
          
        //BOTON REGISTRAR EMPLEADO
       JButton btnFactura= new JButton();
        btnFactura.setBounds(500, 120, 350, 350);
       panel.add(btnFactura);
        ImageIcon b = new ImageIcon("facturai.png");
        btnFactura.setIcon(new ImageIcon(b.getImage().getScaledInstance(btnFactura.getWidth(), btnFactura.getHeight(), Image.SCALE_SMOOTH)));
        btnFactura.addActionListener(AccionRF);
        btnFactura.setVisible(true);
      
        
      //BOTON MODIFICAR O ELIMINAR EMPLEADO
        JButton btnVale= new JButton();
        btnVale.setBounds(40, 560, 350, 350);
       panel.add(btnVale);
        ImageIcon c = new ImageIcon("valesalida.png");
        btnVale.setIcon(new ImageIcon(c.getImage().getScaledInstance(btnVale.getWidth(), btnVale.getHeight(), Image.SCALE_SMOOTH)));
        btnVale.addActionListener(Accionmodificare);
        
        
        // BOTON AGREGAR O ELIMINAR USUARIO
        JButton btnInventarioA= new JButton();
        btnInventarioA.setBounds(500, 560, 350, 350); 
        ImageIcon icon = new ImageIcon("a.png");
        btnInventarioA.setIcon(new ImageIcon(icon.getImage().getScaledInstance(btnInventarioA.getWidth(), btnInventarioA.getHeight(), Image.SCALE_SMOOTH)));
        btnInventarioA.setBackground(new Color(217,217,217));
        btnInventarioA.addActionListener(Accionusuario);
       panel.add(btnInventarioA);
        
       
        //BOTON REGISTRAR O ELIMINAR DOCUMENTOS DE LOS EMPLEADOS
        JButton btnPerdida= new JButton();
        btnPerdida.setBounds(960, 560, 350, 350);
        ImageIcon d = new ImageIcon("perdida.png");
        btnPerdida.setIcon(new ImageIcon(d.getImage().getScaledInstance(btnPerdida.getWidth(), btnPerdida.getHeight(), Image.SCALE_SMOOTH)));
        btnPerdida.addActionListener(AccionDocumentosR);
        panel.add(btnPerdida);
      
        //BOTON PARA CONSULTAR LOS DOCUMENTOS DE LOS EMPLEADOS 
        JButton btnDevolucion= new JButton();
        btnDevolucion.setBounds(1420, 560, 350, 350);
        ImageIcon de = new ImageIcon("devolucion.png");
        btnDevolucion.setIcon(new ImageIcon(de.getImage().getScaledInstance(btnDevolucion.getWidth(), btnDevolucion.getHeight(), Image.SCALE_SMOOTH)));
        btnDevolucion.addActionListener(AccionDocumentosC);
        panel.add(btnDevolucion);
        
        JButton btnReportes= new JButton();
        btnReportes.setBounds(1420, 560, 350, 350);
        ImageIcon de2 = new ImageIcon("reportes.png");
        btnDevolucion.setIcon(new ImageIcon(de.getImage().getScaledInstance(btnReportes.getWidth(), btnReportes.getHeight(), Image.SCALE_SMOOTH)));
        btnDevolucion.addActionListener(AccionDocumentosC);
        panel.add(btnReportes);
      
        
        
    }*/
   
    private void ComponenteReporteDiario(){
        JLabel calendartxt=new JLabel();
        calendartxt.setText("Feecha");
        calendartxt.setBounds(450,300,260,50);
        calendartxt.setFont(new Font("cops",1,26));
        panel.add(calendartxt);     
       calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        // Ubicar y agregar al panel
        calendar.setBounds(450,340,180,50);
        calendar.setFont(new Font ("copper",2,27));
        panel.add(calendar);

       
      
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 620, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Imprimir");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
      btnGuardar.addActionListener(AccionReporteDiario);
       
        btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(BotonVolverMenuP);

    }
    
    
    private void ComponenteReporteFecha(){
        JLabel calendartxt=new JLabel();
        calendartxt.setText("Feecha Inicial");
        calendartxt.setBounds(380,300,260,50);
        calendartxt.setFont(new Font("cops",1,26));
        panel.add(calendartxt);     
       calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        // Ubicar y agregar al panel
        calendar.setBounds(380,340,180,50);
        calendar.setFont(new Font ("copper",2,27));
        panel.add(calendar);
        
        
        JLabel calendartxt2=new JLabel();
        calendartxt2.setText("Feecha Final");
        calendartxt2.setBounds(640,300,260,50);
        calendartxt2.setFont(new Font("cops",1,26));
        panel.add(calendartxt2);     
       calendar2 = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        // Ubicar y agregar al panel
        calendar2.setBounds(640,340,180,50);
        calendar2.setFont(new Font ("copper",2,27));
        panel.add(calendar2);

       
      
       btnGuardar= new JButton();
       btnGuardar.setBounds(700, 620, 150, 50);
       panel.add(btnGuardar);
       btnGuardar.setText("Imprimir");
       btnGuardar.setForeground(Color.black);
       btnGuardar.setFont(new Font ("copper",2,26));
       btnGuardar.setBackground(Color.green);
      btnGuardar.addActionListener(AccionReporteFechas);
       
        btnCancelar= new JButton();
       btnCancelar.setBounds(400, 620, 150, 50);
       panel.add(btnCancelar);
       btnCancelar.setText("Cancelar");
       btnCancelar.setForeground(Color.black);
       btnCancelar.setFont(new Font ("copper",2,26));
       btnCancelar.setBackground(Color.red);
       btnCancelar.addActionListener(BotonVolverMenuP);

    }
   
   
        ActionListener AccionReporteDiario = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            String formato = calendar.getDateFormatString();
                 java.util.Date date = calendar.getDate();
         SimpleDateFormat sdf = new SimpleDateFormat(formato); 
           
            try {
                 Conexion cn = new Conexion();
                JasperReport reporteem=null;
                String path="src\\inventarioalmacen\\ReporteINV.jasper";
                
                Map param = new HashMap();
                param.put("fecha1",sdf.format(date));
                param.put("fecha2",sdf.format(date));
                
                reporteem = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jprint = JasperFillManager.fillReport(reporteem, param, cn.conectar);
                JasperViewer view=new JasperViewer(jprint, false);
                view.setVisible(true);
                
                setVisible(false);
                
                
            } catch (JRException ex) {
                Logger.getLogger(VentanaEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
                
            };
    
    ActionListener AccionReporteFechas = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            String formato = calendar.getDateFormatString();
                 java.util.Date date = calendar.getDate();
         SimpleDateFormat sdf = new SimpleDateFormat(formato);
         
         String formato2 = calendar2.getDateFormatString();
                 java.util.Date date2 = calendar2.getDate();
         SimpleDateFormat sdfx = new SimpleDateFormat(formato2); 
           
            try {
                 Conexion cn = new Conexion();
                JasperReport reporteem=null;
                String path="src\\inventarioalmacen\\ReporteINV.jasper";
                
                Map param = new HashMap();
                param.put("fecha1",sdf.format(date));
                param.put("fecha2",sdfx.format(date2));
                
                reporteem = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jprint = JasperFillManager.fillReport(reporteem, param, cn.conectar);
                JasperViewer view=new JasperViewer(jprint, false);
                view.setVisible(true);
                
                setVisible(false);
                
                
            } catch (JRException ex) {
                Logger.getLogger(VentanaEmpleados.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
                
            };
    
    
   
   ActionListener Volver = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            menuInventario(8);
        }
       
   };
   
   public void menuInventario(int i){
         if(i==1){
           panel.removeAll();
           panel.repaint();
           componenteRF();
           panelC();
       }
       if(i==2){
           panel.removeAll();
           panel.repaint();
           componenteVale();
           panelSalida();
          // compoenentesusuario();
          // panelUsuario();
        }  
        if(i==3){
            panel.removeAll();
            panel.repaint();
            componentePerdida();
            panelPerdida();
        }
        if(i==4){
            panel.removeAll();
            panel.repaint();
            componenteDevolucion();
            panelDevolucion();
            
        }
        if(i==5){
            panel.removeAll();
            panel.repaint();
            componenteStockI();
            panelStock();
            
        }
        if(i==6){
            panel.removeAll();
            panel.repaint();
            ComponenteReporteDiario();
            panelReportes();
            
        }
         if(i==7){
            panel.removeAll();
            panel.repaint();
            ComponenteReporteFecha();
            panelReportes();
            
        }
         if(i==8){
            panel.removeAll();
            panel.repaint();
            componenteMenuP();
            panelPrincipal();
         }
           
   }
 
}
