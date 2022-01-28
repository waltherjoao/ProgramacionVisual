package com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.lemas.vista.LoginServices;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(32, 178, 170));
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(34, 76, 100, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(181, 75, 86, 20);
		frmLogin.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasea.setBounds(34, 107, 100, 14);
		frmLogin.getContentPane().add(lblContrasea);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginServices loginServices = new LoginServices();
				boolean esValido = loginServices.esValidoElUsuario(txtUsuario.getText(), txtContrasenia.getText());
				if(esValido) {
					Menu pantMenu = new Menu();
					pantMenu.frmMenu.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Credenciales Incorrectas!!!!");
				}
			}
		});
		btnNewButton.setBounds(112, 157, 89, 23);
		frmLogin.getContentPane().add(btnNewButton);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(181, 106, 86, 20);
		frmLogin.getContentPane().add(txtContrasenia);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 311, 284);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
