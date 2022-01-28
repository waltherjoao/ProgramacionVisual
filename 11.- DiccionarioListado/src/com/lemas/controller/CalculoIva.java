package com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalculoIva {

	public JFrame frame;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoIva window = new CalculoIva();
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
	public CalculoIva() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 493, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el valor y pulse ENTER");
		lblNewLabel.setBounds(87, 11, 171, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 89, 251, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(62, 117, 365, 14);
		frame.getContentPane().add(lblResultado);
		
		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					double valor = Double.parseDouble(txtValor.getText());
					double calculo = valor * 0.12;
					double resultado = valor+calculo;
					lblResultado.setText("El IVA es "+calculo+"\n El valor a cancelar es  "+resultado);
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		            e.consume();  // if it's not a number, ignore the event
		        }
			}
		});
		txtValor.setBounds(115, 36, 86, 20);
		frame.getContentPane().add(txtValor);
		txtValor.setColumns(10);
	}
}
