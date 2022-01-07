package ec.com.lemas.controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HolaMundo extends JFrame {

	private JPanel contentPane;
	private JTextField txtHolaMundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HolaMundo frame = new HolaMundo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HolaMundo() {
		setTitle("Hola Mundo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClickeame = new JButton("Clickeame!!!");
		btnClickeame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHolaMundo.setText("Hola Mundo");
			}
		});
		btnClickeame.setBounds(78, 158, 100, 23);
		contentPane.add(btnClickeame);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHolaMundo.setText("");
			}
		});
		btnLimpiar.setBounds(215, 158, 89, 23);
		contentPane.add(btnLimpiar);
		
		txtHolaMundo = new JTextField();
		txtHolaMundo.setBounds(78, 94, 226, 20);
		contentPane.add(txtHolaMundo);
		txtHolaMundo.setColumns(10);
	}
}
