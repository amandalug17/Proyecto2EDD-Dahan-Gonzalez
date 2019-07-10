/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto02_dahan_gonzalez;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 *
 * @author Amanda González y Orly Dahan
 */
public class Lienzo extends JPanel {
    private ArbolBinario objArbol;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public Lienzo(ArbolBinario objArbol) {
        this.objArbol = objArbol;
    }
    

    /**
     * Setter de la clase Arbol 
     * @param objArbol 
     */

    public void setObjArbol(ArbolBinario objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        pintar(g, getWidth() / 2, 20, objArbol.getRoot());
    }
    /**
     * Método para pintar el arbol binario
     * @param g: objeto de la clase graphics
     * @param x: coordenada en x
     * @param y: cooordenada en y 
     * @param n: nodo del árbol
     */
    private void pintar(Graphics g, int x, int y, Nodo n) {
        if (n == null){ //Si es null no se pinta nada
        }
        else {
            g.setFont(new Font("Arial", Font.BOLD, 10));
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
            g.setColor(Color.LIGHT_GRAY);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);//dibujamos un círculo para representar el nodo
            g.setColor(Color.black);
            g.drawString(n.getData().toUpperCase(), x + 12, y + 18);//dibujamos el valor del nodo
            if (n.getLeft()!= null){//Creamos las lineas que conectan los nodos del árbol
                g.setColor(Color.black);
                g.drawLine(x+ RADIO, y+ RADIO, x- ANCHO-EXTRA+RADIO, y+ANCHO+RADIO);
                g.setColor(Color.BLUE);
                g.drawString("no",((x+ RADIO)+( x- ANCHO-EXTRA+RADIO))/2, ((y+ RADIO) +(y+ANCHO+RADIO))/2);
                g.setColor(Color.black);
                
            }
            if (n.getRight()!= null){
                g.setColor(Color.black);
                g.drawLine(x+ RADIO, y+ RADIO, x+ ANCHO+EXTRA+RADIO, y+ANCHO+RADIO);
                g.setColor(Color.BLUE);
                g.drawString("si", ((x+ RADIO)+(x+ ANCHO+EXTRA+RADIO))/2, ((y+ RADIO)+(y+ANCHO+RADIO))/2);
                g.setColor(Color.black);
            }
            pintar(g, x-ANCHO-EXTRA, y+ ANCHO, n.getLeft());
            pintar(g, x+ANCHO+EXTRA, y+ANCHO, n.getRight());
         }
          
    }
}
