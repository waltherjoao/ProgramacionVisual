package com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.lemas.entidad.Palabra;
import com.lemas.vista.DiccionarioService;

import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TraerPalabraEspaniol {

	public JFrame frame;
	private JTextField txtPalabraIngles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraerPalabraEspaniol window = new TraerPalabraEspaniol();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TraerPalabraEspaniol() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 274, 219);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese palabra en Ingl\u00E9s");
		lblNewLabel.setBounds(49, 29, 169, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtPalabraIngles = new JTextField();
		
		txtPalabraIngles.setBounds(66, 55, 86, 20);
		frame.getContentPane().add(txtPalabraIngles);
		txtPalabraIngles.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 105, 227, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado espa\u00F1ol");
		lblNewLabel_1.setBounds(49, 122, 102, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(88, 147, 46, 14);
		frame.getContentPane().add(lblResultado);
		
		txtPalabraIngles.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					DiccionarioService diccionarioService = new DiccionarioService();
					Palabra diccionario = new Palabra();
					diccionario.setPalabraIngles(txtPalabraIngles.getText());
					Palabra palabra = diccionarioService.getPalabraEspaniol(diccionario);
					if(palabra != null) {
						lblResultado.setText(palabra.getPalabraEspaniol());
					} else {
						JOptionPane.showMessageDialog(null, "Palabra no existe, agregala!!!!");
					}
					
				}
			}
		});
	}

}
