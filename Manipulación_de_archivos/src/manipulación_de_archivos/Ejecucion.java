/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manipulación_de_archivos;
import java.io.*;
import java.util.Arrays;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Ejecucion extends  Operaciones {
    @Override
    protected int crearArchivo(String NombreArchivo, String TextoInicial) {
            int i = 0;
            File file = new File(NombreArchivo +".txt");
 
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                }
            }else{i = 1;}
            
            return i;
 
    }

    @Override
    protected void eliminarArchvio(String nombre, long telefono, String archivo) {
        try {
 
            // Get the name of the contact to be updated
            // from the Command line argument
            String newName = nombre;
            System.out.println(archivo);
            String nameNumberString;
            String name;
            long number;
            int index;
 
            // Using file pointer creating the file.
            File file = new File(archivo+".txt");
 
            
            
 
            // Opening file in reading and write mode.
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
            System.out.println(raf);
            // Checking whether the name of contact exists.
            // getFilePointer() give the current offset
            // value from start of the file.
          
            while (raf.getFilePointer() > raf.length()) {
                System.out.println("Hola mundo");
                // reading line from the file.
                nameNumberString = raf.readLine();
   System.out.println("Hola mundo");
                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");
 
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                // if condition to find existence of record.
                if (name == newName) {
                    found = true;
                    break;
                }
            }
 
            // Delete the contact if record exists.
            if (found == true) {
 
                // Creating a temporary file
                // with file pointer as tmpFile.
                File tmpFile = new File("temp.txt");
 
                // Opening this temporary file
                // in ReadWrite Mode
                RandomAccessFile tmpraf
                    = new RandomAccessFile(tmpFile, "rw");
 
                // Set file pointer to start
                raf.seek(0);
 
                // Traversing the friendsContact.txt file
                while (raf.getFilePointer()
                       < raf.length()) {
 
                    // Reading the contact from the file
                    nameNumberString = raf.readLine();
 
                    index = nameNumberString.indexOf('!');
                    name = nameNumberString.substring(
                        0, index);
 
                    // Check if the fetched contact
                    // is the one to be deleted
                    if (name.equals(nombre)) {
 
                        // Skip inserting this contact
                        // into the temporary file
                        continue;
                    }
 
                    // Add this contact in the temporary
                    // file
                    tmpraf.writeBytes(nameNumberString);
 
                    // Add the line separator in the
                    // temporary file
                    tmpraf.writeBytes(
                        System.lineSeparator());
                }
 
                // The contact has been deleted now
                // So copy the updated content from
                // the temporary file to original file.
 
                // Set both files pointers to start
                raf.seek(0);
                tmpraf.seek(0);
 
                // Copy the contents from
                // the temporary file to original file.
                while (tmpraf.getFilePointer()
                       < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
 
                // Set the length of the original file
                // to that of temporary.
                raf.setLength(tmpraf.length());
 
                // Closing the resources.
                tmpraf.close();
                raf.close();
 
                // Deleting the temporary file
                tmpFile.delete();
 
                System.out.println(" Friend deleted. ");
            }
 
            // The contact to be deleted
            // could not be found
            else {
 
                // Closing the resources.
                raf.close();
 
                // Print the message
                System.out.println(" Input name"
                                   + " does not exists. ");
            }
        }
 
        catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    

    @Override
    protected String actualizarArchivo(String NombreArchivo, String TextoInicial) {
            String nameNumberString;
            String name;
            String frase;
            long number;
            int index;
            frase = "";
            File file = new File(NombreArchivo +".txt");
            RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
            boolean found = false;
 
        try {
            // Traversing the file
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {
 
                // reading line from the file.
                nameNumberString = raf.readLine();
 
                // splitting the string to get name and
                // number
                String[] lineSplit
                        = nameNumberString.split("!");
                
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                // Print the contact data
                frase += (
                        "Nombre del amigo: " + name + "\n" + "Contacto del amigo: " + number + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Ejecucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return frase;
          }

    @Override
  
    protected void leerArchivo(String nombre, long telefono, String archivo) {
        try {
            String nuevoNombre = nombre;

            long nuevoNumero = telefono;

            String nombreNumeroString;
            String name;
            long number;
            int indice;

            File file = new File(archivo);

            if (!file.exists()) {
                file.createNewFile();
            }

            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean encontrado = false;

            while (raf.getFilePointer() < raf.length()) {
                nombreNumeroString = raf.readLine();

                String[] partes = nombreNumeroString.split("!");
                name = partes[0];
                number = Long.parseLong(partes[1]);

                if (name.equals(nuevoNombre) || number == nuevoNumero) {
                    encontrado = true;
                    break;
                }
            }

            // Actualizar el contacto si existe
            if (encontrado) {
                // Crear un archivo temporal
                File tmpFile = new File("temp.txt");
                RandomAccessFile rafTemporal = new RandomAccessFile(tmpFile, "rw");

                raf.seek(0);

                // Recorrer el archivo friendsContact.txt
                while (raf.getFilePointer() < raf.length()) {
                    // Leer el contacto del archivo
                    nombreNumeroString = raf.readLine();

                    indice = nombreNumeroString.indexOf('!');
                    name = nombreNumeroString.substring(0, indice);

                    // Verificar si el contacto es el que se va a actualizar
                    if (name.equals(nuevoNombre)) {
                        // Actualizar el número de este contacto
                        nombreNumeroString = name + "!" + String.valueOf(nuevoNumero);
                    }

                    // Agregar este contacto al archivo temporal
                    rafTemporal.writeBytes(nombreNumeroString);

                    // Agregar el separador de línea en el archivo temporal
                    rafTemporal.writeBytes(System.lineSeparator());
                }

                // El contacto ha sido actualizado, copiar el contenido actualizado del archivo temporal al archivo original

                // Establecer los punteros de ambos archivos al inicio
                raf.seek(0);
                rafTemporal.seek(0);

                // Copiar el contenido del archivo temporal al archivo original
                while (rafTemporal.getFilePointer() < rafTemporal.length()) {
                    raf.writeBytes(rafTemporal.readLine());
                    raf.writeBytes(System.lineSeparator());
                }

                // Establecer la longitud del archivo original igual a la del archivo temporal
                raf.setLength(rafTemporal.length());

                // Cerrar los recursos
                rafTemporal.close();
                raf.close();

                // Eliminar el archivo temporal

                System.out.println("Amigo actualizado.");
            } else {
                // El contacto a actualizar no se encontró
                raf.close();
                System.out.println("El nombre ingresado no existe.");
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (NumberFormatException nef) {
            System.out.println(nef);
        }
    }
}

    

