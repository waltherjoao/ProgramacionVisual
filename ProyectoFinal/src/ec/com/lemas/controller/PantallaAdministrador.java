package ec.com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PantallaAdministrador {

	public JFrame frmBienvenido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAdministrador window = new PantallaAdministrador();
					window.frmBienvenido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaAdministrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBienvenido = new JFrame();
		frmBienvenido.setTitle("Bienvenido");
		frmBienvenido.setBounds(100, 100, 450, 300);
		frmBienvenido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBienvenido.getContentPane().setLayout(null);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.setBounds(20, 83, 121, 23);
		frmBienvenido.getContentPane().add(btnUsuario);
		
		JButton btnTipoUsuario = new JButton("Tipo de Usuario");
		btnTipoUsuario.setBounds(253, 83, 132, 23);
		frmBienvenido.getContentPane().add(btnTipoUsuario);
		
		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.setBounds(20, 147, 121, 23);
		frmBienvenido.getContentPane().add(btnEmpleado);
		
		JButton btnTipoEmpleado = new JButton("Tipo de Empleado");
		btnTipoEmpleado.setBounds(253, 147, 132, 23);
		frmBienvenido.getContentPane().add(btnTipoEmpleado);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Administrador");
		lblNewLabel.setBounds(137, 25, 159, 14);
		frmBienvenido.getContentPane().add(lblNewLabel);
	}
}
