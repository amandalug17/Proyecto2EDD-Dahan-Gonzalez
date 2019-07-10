/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto02_dahan_gonzalez;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class Juego {
    private Nodo root;
    private ArbolBinario arbol;
    private Nodo nodo ;
    private Nodo nodo1 ;
    
    /**
     * Constructor 
     */

    public Juego() {
        this.root = new Nodo("¿Estas pensando en un animal?");
        this.arbol = new ArbolBinario(root);
        this.nodo = new Nodo("¿Ladra?");
        this.nodo1 =new Nodo("Perro");
        arbol.getRoot().setRight(nodo);
        nodo.setRight(nodo1);
       
    }
    
   /**
    * Método para crear el árbol durante el juego
    * @param arbol: recibe un árbol cargado por el usuario
    */
    
    public void play(ArbolBinario arbol){
        int aux=0;
        Nodo guardado = root;
        do{
        root = arbol.getRoot();
        boolean bucle = true;
        int respuesta = JOptionPane.showConfirmDialog(null, arbol.getRoot().getData());
        if(respuesta==0){
            root = root.getRight();
                
                while(!arbol.Es_hoja(root)){
                    
                    if(root==null){
                        break;
                    }
                    
                    int resp = JOptionPane.showConfirmDialog(null, root.getData());
                    if(resp==0){
                        root = root.getRight();
                    }
                    if(resp==1){
                        guardado = root;
                        root = root.getLeft();
                        
                    }
                    if(resp==2){
                        JOptionPane.showMessageDialog(null, "Te haz salido del juego", "Oh oh...",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    
                }
                
                if(root==null){
                    JOptionPane.showMessageDialog(null, "No he podido adivinar", "Ups...",JOptionPane.INFORMATION_MESSAGE);
                    String nuevoAnimal = JOptionPane.showInputDialog(null, "¿En qué animal estabas pensando?");
                    String infoAnimal = JOptionPane.showInputDialog(null, "¿Que pregunta harías para adivinar este animal?");
                    Nodo nuevo = new Nodo (nuevoAnimal);
                    Nodo existe = new Nodo ("¿"+infoAnimal+"?");
                    root = existe;
                    guardado.setLeft(root);
                    root.setRight(nuevo);
                } else {
                    String animal = root.getData();
                
                    int resp = JOptionPane.showConfirmDialog(null, "¿Es un "+animal+"?");
                    if(resp==0){
                        JPanel panel1 = new JPanel();
                        JOptionPane.showMessageDialog(panel1, "Lo sabía! He ganado.", "Lo he adivinado...",JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(resp==1){

                        JOptionPane.showMessageDialog(null, "No he podido adivinar", "Ups...",JOptionPane.INFORMATION_MESSAGE);
                        String nuevoAnimal = JOptionPane.showInputDialog(null, "¿En qué animal estabas pensando?");
                        String infoAnimal = JOptionPane.showInputDialog(null, "¿Qué diferencia a un "+ animal + " de un "+ nuevoAnimal);
                        int indicador = JOptionPane.showConfirmDialog(null, "¿Si el animal fuera un "+animal+" cuál sería la respuesta a dicha diferencia?");
                        root.setData("¿"+infoAnimal+"?");
                        Nodo nuevo = new Nodo (nuevoAnimal);
                        Nodo nuevo2 = new Nodo (animal);
                        if(indicador==0){
                            root.setRight(nuevo2);
                            root.setLeft(nuevo);
                        }
                        if(indicador==1){
                            root.setRight(nuevo);
                            root.setLeft(nuevo2);
                        }
                        if(indicador==2){
                            JOptionPane.showMessageDialog(null, "Te haz salido del juego", "Oh oh...",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                
                }
                
                aux = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?");
                
            }
        if(respuesta==1){
            JPanel panel1 = new JPanel();
            JOptionPane.showMessageDialog(panel1, "Juega de nuevo!", "Que lastima...",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(respuesta==2){
            JOptionPane.showMessageDialog(null, "Te haz salido del juego", "Oh oh...",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        }while(aux==0);
    }
    /**
     * Método para jugar el juego sin que se reciba un árbol por el usuario, se crea el 
     * arbol inicial por el contructor.
     */
    public void play(){
        int aux=0;
        Nodo guardado = root;
        do{
        root = arbol.getRoot();
        boolean bucle = true;
        int respuesta = JOptionPane.showConfirmDialog(null, arbol.getRoot().getData());
        if(respuesta==0){
            root = root.getRight();
                
                while(!arbol.Es_hoja(root)){
                    
                    if(root==null){
                        break;
                    }
                    
                    int resp = JOptionPane.showConfirmDialog(null, root.getData());
                    if(resp==0){
                        root = root.getRight();
                    }
                    if(resp==1){
                        guardado = root;
                        root = root.getLeft();
                        
                    }
                    if(resp==2){
                        JOptionPane.showMessageDialog(null, "Te haz salido del juego", "Oh oh...",JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    
                }
                
                if(root==null){
                    JOptionPane.showMessageDialog(null, "No he podido adivinar", "Ups...",JOptionPane.INFORMATION_MESSAGE);
                    String nuevoAnimal = JOptionPane.showInputDialog(null, "¿En qué animal estabas pensando?");
                    String infoAnimal = JOptionPane.showInputDialog(null, "¿Que pregunta harías para adivinar este animal?");
                    Nodo nuevo = new Nodo (nuevoAnimal);
                    Nodo existe = new Nodo ("¿"+infoAnimal+"?");
                    root = existe;
                    guardado.setLeft(root);
                    root.setRight(nuevo);
                } else {
                    String animal = root.getData();
                
                    int resp = JOptionPane.showConfirmDialog(null, "¿Es un "+animal+"?");
                    if(resp==0){
                        JPanel panel1 = new JPanel();
                        JOptionPane.showMessageDialog(panel1, "Lo sabía! He ganado.", "Lo he adivinado...",JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(resp==1){

                        JOptionPane.showMessageDialog(null, "No he podido adivinar", "Ups...",JOptionPane.INFORMATION_MESSAGE);
                        String nuevoAnimal = JOptionPane.showInputDialog(null, "¿En qué animal estabas pensando?");
                        String infoAnimal = JOptionPane.showInputDialog(null, "¿Qué diferencia a un "+ animal + " de un "+ nuevoAnimal);
                        int indicador = JOptionPane.showConfirmDialog(null, "¿Si el animal fuera un "+animal+" cuál sería la respuesta a dicha diferencia?");
                        root.setData("¿"+infoAnimal+"?");
                        Nodo nuevo = new Nodo (nuevoAnimal);
                        Nodo nuevo2 = new Nodo (animal);
                        if(indicador==0){
                            root.setRight(nuevo2);
                            root.setLeft(nuevo);
                        }
                        if(indicador==1){
                            root.setRight(nuevo);
                            root.setLeft(nuevo2);
                        }
                        if(indicador==2){
                            JOptionPane.showMessageDialog(null, "Te haz salido del juego", "Oh oh...",JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                
                }
                
                aux = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?");
                
            }
        if(respuesta==1){
            JPanel panel1 = new JPanel();
            JOptionPane.showMessageDialog(panel1, "Juega de nuevo!", "Que lastima...",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(respuesta==2){
            JOptionPane.showMessageDialog(null, "Te haz salido del juego", "Oh oh...",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        }while(aux==0);
    }
    
    /**
    *Setters y Getters
    */

    public ArbolBinario getArbol() {
        return arbol;
    }

    public void setArbol(ArbolBinario arbol) {
        this.arbol = arbol;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public Nodo getRoot() {
        return root;
    }
    
}
