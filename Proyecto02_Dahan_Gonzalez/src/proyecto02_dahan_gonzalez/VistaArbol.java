/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto02_dahan_gonzalez;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author USUARIO
 */
public class VistaArbol extends JFrame{
        private JPanel contentPane;
        public ArbolBinario tree;
	public Lienzo drawer;
         
	
	/**
	 * Creamos el frame donde se visualizará el Árbol
        * @param tree
	 */
	public VistaArbol (ArbolBinario tree) {
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		drawer = new Lienzo(tree);
                drawer.setSize(drawer.getMaximumSize());
                contentPane.add(drawer);
                JScrollPane scrollPane = new JScrollPane(contentPane);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setBounds(100, 100, 3000, 1500);
                scrollPane.setVisible(true);
                scrollPane.setEnabled(true);
                contentPane.setPreferredSize(new Dimension(1500, 500));
                this.setLayout(new BorderLayout());
                this.setBackground(Color.WHITE);
                this.setContentPane(scrollPane);
                this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setBounds(100, 100, 3000, 1500);
                this.setResizable(true);
		this.tree =tree;
	}
        
        /**
         * Método que inicia el visualizador del árbol
         */
        public void iniciar(){
            drawer.setObjArbol(tree);
        }
}
