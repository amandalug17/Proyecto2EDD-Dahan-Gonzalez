/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto02_dahan_gonzalez;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


/**
 *
 * @author Amanda González y Orly Dahan
 */
public class Nodo {
    private Nodo right;
    private Nodo left;
    private String data;

    public Nodo(String data) {
        this.right = null;
        this.left = null;
        this.data = data;
    }

 
 
    /**
    *Método que nos indica si el nodo tiene ambos hijos
    *@param n
    *@return int
    */
     public int nodosCompletos(Nodo n){
            if (n == null){
                return 0;
            } else {
                if(n.getLeft()!= null && n.getRight()!= null){
                    return nodosCompletos(n.getLeft())+ nodosCompletos(n.getRight())+1;
                }
                return nodosCompletos(n.getLeft())+ nodosCompletos(n.getRight());
            }
     }
     
     /**
     * Setters y Getters
     */

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
