package ec.com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import ec.com.lemas.views.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
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
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 285, 209);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(30, 37, 46, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(154, 37, 86, 20);
		frmLogin.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(30, 74, 93, 14);
		frmLogin.getContentPane().add(lblContrasea);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(154, 71, 86, 20);
		frmLogin.getContentPane().add(txtContrasenia);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText().toString();
				String contrasenia = txtContrasenia.getText().toString();
				Usuario user = new Usuario();
				user.buscar(usuario, contrasenia);
			}
		});
		btnNewButton.setBounds(79, 123, 89, 23);
		frmLogin.getContentPane().add(btnNewButton);
	}
}
