package com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	public JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 450, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMenu.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Diccionario");
		menuBar.add(mnNewMenu);
		JMenuItem mitIngresarPalabra = new JMenuItem("Ingresar Palabra");
		mitIngresarPalabra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Diccionario diccionario = new Diccionario();
				diccionario.frmDiccionario.setVisible(true);
			}
		});
		mnNewMenu.add(mitIngresarPalabra);
		
		JMenuItem mitTraducirEspIng = new JMenuItem("Traducir espa\u00F1ol ingles");
		mitTraducirEspIng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraerPalabraIngles ingles = new TraerPalabraIngles();
				ingles.frame.setVisible(true);
			}
		});
		mnNewMenu.add(mitTraducirEspIng);
		
		JMenuItem mitTraducirIngEng = new JMenuItem("Traducir ingl\u00E9s espa\u00F1ol");
		mitTraducirIngEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TraerPalabraEspaniol espaniol = new TraerPalabraEspaniol();
				espaniol.frame.setVisible(true);
			}
		});
		mnNewMenu.add(mitTraducirIngEng);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mitSalir = new JMenuItem("Salir");
		mitSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mitSalir);
		
		JMenu mnNewMenu_1 = new JMenu("Calculos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Calcular IVA");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculoIva calculoIva = new CalculoIva();
				calculoIva.frame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Suma");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suma suma = new Suma();
				suma.frmSuma.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
	}

}
