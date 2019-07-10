/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto02_dahan_gonzalez;
import java.util.*;

/**
 *
 * @author USUARIO
 */
public class ArbolBinario {
    private Nodo root;
    
    
    //Constructor
    public ArbolBinario(Nodo root) {
        this.root = root;
        
    }
     

   /*
    Método para guardar los datos de un árbol en una lista de Strings
   */
   public ArrayList Guardar(Nodo raiz){
       ArrayList<String> datos = new ArrayList<>();
       if(raiz==null){
           return datos;
       } else{
           datos.add(raiz.getData());
           if(raiz.getLeft()==null){
               datos.add(".");
           }else{
               datos.add(raiz.getLeft().getData());
           }
           if(raiz.getRight()==null){
               datos.add(".");
           }else{
               datos.add(raiz.getRight().getData());
           }
           datos.addAll(Guardar(raiz.getLeft()));
           datos.addAll(Guardar(raiz.getRight()));
       }
       
       return datos;
       
   }
   
   /**
    * Primitivas de los árboles binarios
    * 
    */
   
  
   
   /*
    *Método para saber si el nodo está vacío
    *@param: Nodo
    *@return: boolean
    */
    
    public boolean isVacio(Nodo n){
            return n==null;
        }
   
    
    /*
    *Método para saber si el arbol está vacío
    *@param: Nodo
    *@return: boolean
    */
    
    public boolean isVacio(){
            return root==null;
        }
    
    /*
    Método para saber si un Nodo es hoja
    */
    public boolean Es_hoja(Nodo n){
        boolean esHoja = false;
        if(n==null){
            return false;
        }
        esHoja = n.getRight()== null && n.getLeft()==null;
        return esHoja;
    }
    /*
    *Método para insertar un nodo a la derecha 
    *@param: string valor, int padre
    *
    */
   public void insertarD(Nodo e) {
               String valor= e.getData();
		Nodo n = buscar(root, valor);
		Nodo hijoDerecho = e;
		n.setRight(hijoDerecho);
   }
   /*
    *Método para insertar un nodo a la izquierda
    *@param: string valor, int padre
    *
    */
   public void insertarI(String valor) {
		Nodo n = buscar(root, valor);
		Nodo hijoI = new Nodo(valor);
		n.setLeft(hijoI);
   }
   /*
    *Método para insertar la raiz
    *@param: string valor
    *
    */

    public void insertarRoot(String data) {
            root = new Nodo(data);
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }
    /**
    *Método de búsqueda
     * @param n
     * @param valor
     * @return Nodo 
    */
    
    public Nodo buscar(Nodo n, String valor) {
            Nodo resultado = null;
            if (n == null){
                    return null;
            } if (n.getData().equals(valor)){
                    return n;
            }if (n.getLeft() != null){
                    resultado = buscar(n.getLeft(), valor);
            }if (resultado == null){
                    resultado = buscar(n.getRight(), valor);
            }
             return resultado;
    }
    /*
    * Método insertar un nodo en el árbol
    *@param dato (la información que está dentro del nodo)
    *@param ABB (Nodo a insertar)
    *@param resp (es un int que nos indica si se coloca a la izquierda o a la derecha, si es 0 
    el usuario colocó un si y se coloca a la derecha, si es 1 se coloca a la izquierda)
    *@return: boolean
    */
    public boolean insertar(String dato, Nodo ABB, int resp){
        //Si el nodo ABB es vacio creamos un nuevo nodo 
            if(isVacio(ABB)){
                ABB=new Nodo(dato);
                return true;
            } else{//Si ABB no es vacío
                 if(resp==1){
                        if(this.isVacio(ABB.getLeft())){//Si no tiene hijo izquierdo
                            ABB.setLeft(new Nodo(dato));
                            return true;
                        }else{
                            return insertar(dato, ABB.getLeft(), resp);
                      }  
                    }else{
                        if(this.isVacio(ABB.getRight())){//Si no tiene hijo derecho
                            ABB.setRight(new Nodo(dato));
                            return true;
                        }else{
                            return insertar(dato, ABB.getRight(), resp);
                      }  
                    }
                    
                }
            }
        
    /**
    *Métodoque nos da la altura del árbole búsqueda
     * @param root
     * @return int 
    */
    public int getAltura(Nodo root) {
            if (root == null){
                return 0;
            }
            return Math.max(getAltura(root.getLeft()), getAltura(root.getRight())) + 1;
    }

    /**
     *Método para recorrer el árbol en preOrden
     * @param n
     *
    */
    public void PreOrder(Nodo n ){

            if (n == null){
                return;
            }
            System.out.println(n.getData());
            PreOrder(n.getLeft());
            PreOrder(n.getRight());
    }
    /**
     *Método para recorrer el árbol en InOrden
     * @param n
     *
    */

    public void InOrder(Nodo n ){

            if (n == null){
                return;
            }
            InOrder(n.getLeft());
            System.out.println(n.getData());
            InOrder(n.getRight());
    }
    /**
     *Método para recorrer el árbol en PostOrden
     * @param n
    */

    public void PostOrder(Nodo n ){

            if (n == null){
                return;
            }
            PostOrder(n.getLeft());
            PostOrder(n.getRight());
            System.out.println(n.getData());
    }
   
}
