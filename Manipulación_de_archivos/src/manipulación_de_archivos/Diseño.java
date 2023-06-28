
package manipulación_de_archivos;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Diseño  extends JFrame implements ActionListener 
{
    Ejecucion operaciones =  new Ejecucion();
    int respuestaEliminacion ;
    private JButton buttonnAplicar;
    private JTextField nombreArchivo, nombre, telefono ;
    private JLabel labelNombreArchivoCrear, labelNombreArchivoEliminar, labelNombreArchvioActualizar,labelNombreArchivoLeer, label_nombre, label_telefono;
    private JComboBox comboOperacionesConArchivos;
    private Container contenedorGeneral, contenerdorCrearArchivo, contenedorEliminarArchivo, contenedorLeerArchivo, contenedorActualizarArchivo;
    private JCheckBox checkboxTextoIncial;
    private JTextArea textoDocumento;
    private int item;
    Diseño(){
        this.setBackground(Color.gray);
        this.setSize(400, 500);
        this.setLayout(null);
        this.setTitle("Manipulación de archivos.");       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }        
    
    protected void diseñarContenedorGeneral(){
       this.contenedorGeneral = this.getContentPane();
       this.contenedorGeneral.setLayout(null);
       
      this.comboOperacionesConArchivos = new JComboBox();
       this.comboOperacionesConArchivos.addItem("Crear archivo");
       this.comboOperacionesConArchivos.addItem("Leer archivo");
       this.comboOperacionesConArchivos.addItem("Actualizar archivo");
       this.comboOperacionesConArchivos.addItem("Eliminar archivo");
       this.comboOperacionesConArchivos.setBounds(10, 10, 370, 25);
       this.comboOperacionesConArchivos.addActionListener(this);
       
       this.textoDocumento =  new JTextArea();
        this.textoDocumento.setBounds(50, 140, 200, 200);
       
        this.nombreArchivo =  new JTextField();
        this.nombreArchivo.setBounds(20, 75 , 350, 20);

       
       this.buttonnAplicar = new JButton("Aplicar");
       this.buttonnAplicar.setBounds(270, 400, 100 ,20);
       this.buttonnAplicar.addActionListener(this);
       this.textoDocumento.setEditable(false);
       this.contenedorGeneral.add(this.buttonnAplicar);
       this.contenedorGeneral.add(this.comboOperacionesConArchivos);
       this.contenedorGeneral.add(this.nombreArchivo);
       this.contenedorGeneral.add(this.textoDocumento);
       this.contenedorGeneral.setVisible(true);
       
       diseñarContenedorCrearArchivo();
    }
    
    private void diseñarContenedorCrearArchivo(){
        
        this.contenerdorCrearArchivo = this.getContentPane();
        this.contenerdorCrearArchivo.setLayout(null);
        
        this.labelNombreArchivoCrear = new JLabel("Nombre del archivo para crear");
        this.labelNombreArchivoCrear.setBounds(120, 50, 350, 20);
        
        
        this.checkboxTextoIncial =  new JCheckBox("Agregar Amigos");
        this.checkboxTextoIncial.setBounds(270 , 140, 100,25);
        this.checkboxTextoIncial.addActionListener(this);
        
        
   
        
        this.contenerdorCrearArchivo.add(this.labelNombreArchivoCrear);
        this.contenerdorCrearArchivo.add(this.checkboxTextoIncial);
     
   
                    this.contenerdorCrearArchivo.setVisible(true);

        
        
        item= 0;
    }
    
     private void diseñarContenedorLeerArchivo(){

        this.contenedorLeerArchivo = this.getContentPane();
        this.contenedorLeerArchivo.setLayout(null);
        
        this.labelNombreArchivoLeer = new JLabel("Nombre del archivo para leer");
        this.labelNombreArchivoLeer.setBounds(120, 50, 350, 20);
        
               
        
       
        
        this.contenedorLeerArchivo.add(this.labelNombreArchivoLeer);
    
   
        
        this.contenedorLeerArchivo.setVisible(true);
        
        item= 1;
    }
     private void diseñarContenedorActualizararArchivo(){
        
        this.contenedorActualizarArchivo = this.getContentPane();
        this.contenedorActualizarArchivo.setLayout(null);
        
        this.labelNombreArchvioActualizar = new JLabel("Nombre del archivo para actualizar");
        this.labelNombreArchvioActualizar.setBounds(120, 50, 350, 20);
        
        this.label_nombre =  new JLabel("Nombre");
        this.label_nombre.setBounds(300 , 80 , 100 , 200);
        
        this.nombre = new JTextField();
        this.nombre.setBounds(270, 200, 100, 20);
        
        this.label_telefono =  new JLabel("Telefono");
        this.label_telefono.setBounds(300 , 180 , 100 , 200);
        
        this.telefono = new JTextField();
        this.telefono.setBounds(270, 300, 100, 20);
        
        
        
        this.contenedorActualizarArchivo.add(this.label_telefono);
        this.contenedorActualizarArchivo.add(telefono);
        this.contenedorActualizarArchivo.add(nombre);
        this.contenedorActualizarArchivo.add(this.labelNombreArchvioActualizar);
        this.contenedorActualizarArchivo.add(label_nombre);
        this.contenedorActualizarArchivo.setVisible(true);
        
        item= 2;
    }
     private void LimpiezaDiseñoContenedorLeerArchivo(){
         this.labelNombreArchivoLeer.setVisible(false);

        

         this.contenedorLeerArchivo.setVisible(false);
     }

    
     
    private void LimpiezaDiseñoContenedorCrearArchivo(){
        this.checkboxTextoIncial.setVisible(false);
        this.labelNombreArchivoCrear.setVisible(false);
        this.contenerdorCrearArchivo.setVisible(false);
        
        
    }
    
    private void LimpiezaDiseñoEliminar(){
        this.labelNombreArchivoEliminar.setVisible(false);
        this.contenedorEliminarArchivo.setVisible(false);
        this.nombre.setVisible(false);
         this.telefono.setVisible(false);
         this.label_nombre.setVisible(false);
         this.label_telefono.setVisible(false);

    }
    
    private void LimpiezaDiseñoActualizar(){

         this.labelNombreArchvioActualizar.setVisible(false);
       
         this.nombre.setVisible(false);
         this.telefono.setVisible(false);
         this.contenedorActualizarArchivo.setVisible(false);
         this.label_nombre.setVisible(false);
         this.label_telefono.setVisible(false);
    }

    
    private void LimpiezaGeneral(int indice){
        if (indice == 0){
            switch(this.item){
                case 1 -> LimpiezaDiseñoContenedorLeerArchivo();
                
                case 2 -> LimpiezaDiseñoActualizar();
                
                case 3 -> LimpiezaDiseñoEliminar();
            }
            this.diseñarContenedorCrearArchivo();
        }        
        if(indice == 1){
            switch(this.item){
                case 0 ->  LimpiezaDiseñoContenedorCrearArchivo();       
                case 2 -> LimpiezaDiseñoActualizar();
                case 3 -> LimpiezaDiseñoEliminar();
            }
            this.diseñarContenedorLeerArchivo();
        }
        if (indice == 2){
            switch(this.item){
                case 0 ->  LimpiezaDiseñoContenedorCrearArchivo();       
                case 1 -> LimpiezaDiseñoContenedorLeerArchivo();
                case 3 -> LimpiezaDiseñoEliminar();
            }
            this.diseñarContenedorActualizararArchivo();
        }
        if (indice == 3){
            switch(this.item){
                case 0 ->  LimpiezaDiseñoContenedorCrearArchivo();       
                case 1 -> LimpiezaDiseñoContenedorLeerArchivo();
                case 2 -> LimpiezaDiseñoActualizar();
            }
            this.eliminarArchivo();
        } 
        
    }
    private void eliminarArchivo(){
        
        this.contenedorEliminarArchivo = this.getContentPane();
        this.contenedorEliminarArchivo.setLayout(null);
        
         this.label_nombre =  new JLabel("Nombre");
        this.label_nombre.setBounds(300 , 80 , 100 , 200);
        
        this.nombre = new JTextField();
        this.nombre.setBounds(270, 200, 100, 20);
        
        this.label_telefono =  new JLabel("Telefono");
        this.label_telefono.setBounds(300 , 180 , 100 , 200);
        
        this.telefono = new JTextField();
        this.telefono.setBounds(270, 300, 100, 20);
        
        this.labelNombreArchivoEliminar = new JLabel("Nombre del archivo para eliminar");
        this.labelNombreArchivoEliminar.setBounds(120, 50, 350, 20);
        
        this.nombreArchivo =  new JTextField();
        this.nombreArchivo.setBounds(20, 75 , 350, 20);
        
       this.label_nombre =  new JLabel("Nombre");
        this.label_nombre.setBounds(300 , 80 , 100 , 200);
        
        this.nombre = new JTextField();
        this.nombre.setBounds(270, 200, 100, 20);
        
        this.label_telefono =  new JLabel("Telefono");
        this.label_telefono.setBounds(300 , 180 , 100 , 200);
        
        this.telefono = new JTextField();
        this.telefono.setBounds(270, 300, 100, 20);
        
        
        
        this.contenedorEliminarArchivo.add(this.label_telefono);
        this.contenedorEliminarArchivo.add(telefono);
        this.contenedorEliminarArchivo.add(nombre);
         this.contenedorEliminarArchivo.add(this.label_nombre);
        this.contenerdorCrearArchivo.add(this.labelNombreArchivoEliminar);
               
        this.contenedorEliminarArchivo.setVisible(true);
        item =3 ;
    } 
    
  
            
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.comboOperacionesConArchivos && this.comboOperacionesConArchivos.getSelectedIndex() != this.item){
            this.LimpiezaGeneral(this.comboOperacionesConArchivos.getSelectedIndex());
        }
        if(e.getSource() == this.checkboxTextoIncial){
            if(checkboxTextoIncial.isSelected()){
                this.textoDocumento.setEnabled(false);
                String respuestanombre =  JOptionPane.showInputDialog("Ingrese el Nombre del contacto");
                String respuestanumero =JOptionPane.showInputDialog("Ingrese el numero del contacto");
                System.out.println(respuestanombre+ respuestanumero );
            }else{
             
            
            }
        }
        
        if(e.getSource() == this.buttonnAplicar){
       
            
            if(this.item == 0 && this.checkboxTextoIncial.isSelected() == false){
                if(operaciones.crearArchivo(this.nombreArchivo.getText(), "") == 0){
                    JOptionPane.showMessageDialog(rootPane, "Archivo Creado exitosamente");
                    this.textoDocumento.setText(operaciones.actualizarArchivo(this.nombreArchivo.getText(), ""));

                }else{
                    int confirmacion  = JOptionPane.showConfirmDialog(rootPane, "¿Archivo ya existe desea utilizarlo?");
                    if (confirmacion == JOptionPane.YES_OPTION){
                        this.nombreArchivo.setEnabled(true);
                        this.textoDocumento.setText(operaciones.actualizarArchivo(this.nombreArchivo.getText(), ""));

                        
                    }
                    else if(confirmacion == JOptionPane.NO_OPTION){
                        this.nombreArchivo.setEditable(true);
                        this.nombreArchivo.setText("");
                    }
                }
                
            }
            else if(item == 1){
                this.textoDocumento.setText(operaciones.actualizarArchivo(this.nombreArchivo.getText(), ""));
            }
            
            else if(item == 2){
                if(this.nombreArchivo.getText() == ""){
                    JOptionPane.showConfirmDialog(rootPane,"El nombre del archivo esta vacío" );
                    
                }else{
                    operaciones.leerArchivo(this.nombre.getText(), Long.valueOf(this.telefono.getText()), this.nombreArchivo.getText());
                }
            }
            
            else if(item == 3){
                respuestaEliminacion = JOptionPane.showConfirmDialog(rootPane, "¿Seguro desea eliminar el archivo? (Esta acción sera irreversible) ");
                if(respuestaEliminacion == JOptionPane.YES_OPTION){
                    operaciones.eliminarArchvio(this.nombre.getText(), Long.parseLong(this.telefono.getText()), this.nombreArchivo.getText());

                
                }
        }
           
        }
    }
    
}
