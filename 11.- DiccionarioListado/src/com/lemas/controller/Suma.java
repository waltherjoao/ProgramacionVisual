package com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Suma {

	public JFrame frmSuma;
	private JTextField txtNumero1;
	private JTextField txtNumero2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suma window = new Suma();
					window.frmSuma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Suma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSuma = new JFrame();
		frmSuma.setTitle("Suma");
		frmSuma.setBounds(100, 100, 310, 300);
		frmSuma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSuma.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
		lblNewLabel.setBounds(43, 48, 76, 14);
		frmSuma.getContentPane().add(lblNewLabel);
		
		txtNumero1 = new JTextField();
		txtNumero1.setBounds(129, 45, 86, 20);
		frmSuma.getContentPane().add(txtNumero1);
		txtNumero1.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero 2");
		lblNmero.setBounds(43, 79, 76, 14);
		frmSuma.getContentPane().add(lblNmero);
		
		txtNumero2 = new JTextField();
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(129, 76, 86, 20);
		frmSuma.getContentPane().add(txtNumero2);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(43, 206, 205, 14);
		frmSuma.getContentPane().add(lblResultado);
		
		JButton btnCalcularSuma = new JButton("Calcular");
		btnCalcularSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = Integer.parseInt(txtNumero1.getText()) + Integer.parseInt(txtNumero2.getText());
				lblResultado.setText("El resultado de la suma es "+resultado);
			}
		});
		btnCalcularSuma.setBounds(95, 131, 89, 23);
		frmSuma.getContentPane().add(btnCalcularSuma);
	}

}
