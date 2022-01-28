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

public class TraerPalabraIngles {

	public JFrame frame;
	private JTextField txtPalabraEspaniol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraerPalabraIngles window = new TraerPalabraIngles();
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
	public TraerPalabraIngles() {
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
		
		JLabel lblNewLabel = new JLabel("Ingrese palabra en espa\u00F1ol");
		lblNewLabel.setBounds(49, 29, 169, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtPalabraEspaniol = new JTextField();
		
		txtPalabraEspaniol.setBounds(66, 55, 86, 20);
		frame.getContentPane().add(txtPalabraEspaniol);
		txtPalabraEspaniol.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 105, 227, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado Ingl\u00E9s");
		lblNewLabel_1.setBounds(49, 122, 102, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(88, 147, 46, 14);
		frame.getContentPane().add(lblResultado);
		
		txtPalabraEspaniol.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					DiccionarioService diccionarioService = new DiccionarioService();
					Palabra diccionario = new Palabra();
					diccionario.setPalabraEspaniol(txtPalabraEspaniol.getText());
					Palabra palabra = diccionarioService.getPalabraIngles(diccionario);
					if(palabra != null) {
						lblResultado.setText(palabra.getPalabraIngles());
					} else {
						JOptionPane.showMessageDialog(null, "Palabra no existe, agregala!!!!");
					}
					
				}
			}
		});
	}

}
