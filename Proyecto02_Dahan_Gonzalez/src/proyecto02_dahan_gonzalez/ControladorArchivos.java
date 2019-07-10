
package proyecto02_dahan_gonzalez;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Amanda González
 */
public class ControladorArchivos {

    public ControladorArchivos() {
    }
    /**
     * Método para guardad el árbol en un archivo de texto
     * @param datos: recibe la lista de datos de los nodos del arbol ppara guardarlos en un txt
     */
    public void guardarArbol(ArrayList<String> datos){
        List<String> data = new ArrayList<>();
        data = datos;
        File archivo;
        PrintWriter escribir;
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo txt a guardar");
        archivo = new File(nombre+".txt");
        if(!archivo.exists()){//Si no existe el archivo creamos uno 
        try{
            if(archivo.createNewFile()){
                JOptionPane.showMessageDialog(null, "Se ha creado el archivo con éxito", "ARCHIVO CREADO EXITOSAMENTE", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "El archivo se ha guardado en la carpeta"
                        + " del proyecto", "UBICIÓN DEL ARCHIVO ", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (IOException e){
             JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo", "ERROR!", JOptionPane.ERROR_MESSAGE);
           
        }
    
        }
        
        //Si existe el archivo lo comenzamos a llenar 
            try {
                escribir  = new PrintWriter(archivo, "utf-8");
                for (int i = 0; i < data.size(); i++) {
                    escribir.println(data.get(i));//Cada elemento de la lista será una linea del txt
                }
                escribir.close();
                JOptionPane.showMessageDialog(null, "El archivo se ha guardado en la carpeta"
                        + " del proyecto", "UBICIÓN DEL ARCHIVO ", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se ha podido crear el archivo", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
    }
    /**
     * Método que abre un archivo de texto para llenar el árbol
     * @param archivo: recibe un objeto File que será el archivo con los elementos del árbol
     * @return String []: retorna un vector con los elementos que se van a cargar en el árbol
     */
    public String[] Abrir(File archivo){
        
        String [] elementosArb= null;
        try{
            BufferedReader reader = new BufferedReader (new FileReader(archivo));//Abrir el archivo mediante un FileReader
            String linea;
            //Convertimos el reader en un ArrayList
            List<String> arlist = new ArrayList<>();
            while((linea= reader.readLine())!= null){ //Mientras haya lineas en el txt
                arlist.add(linea);//seguarda cada linea en la lista
                
            }
            //Convertimos la lista en un Array con los elementos
            elementosArb = arlist.toArray(new String [arlist.size()]);
            reader.close();//cerramos el BufferedReader
            
        } catch (Exception e){
            System.err.println("No se encontró el archivo..");
        }
        return elementosArb;
    }
    
    
    
    
    
}
