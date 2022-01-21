package com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lemas.entidad.Palabra;
import com.lemas.model.DiccionarioModel;
import com.lemas.vista.DiccionarioService;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Diccionario {

	public JFrame frmDiccionario;
	private JTextField txtEspaniol;
	private JTextField txtIngles;
	private JScrollPane scrollPane;
	private JTable table;
	DiccionarioModel diccionarioModel;
	List<Palabra> lstPalabras = new ArrayList<Palabra>();
	Palabra palabras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diccionario window = new Diccionario();
					window.frmDiccionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Diccionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDiccionario = new JFrame();
		frmDiccionario.getContentPane().setBackground(UIManager.getColor("Table.sortIconLight"));
		frmDiccionario.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese palabra en espa\u00F1ol");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(38, 54, 239, 28);
		frmDiccionario.getContentPane().add(lblNewLabel);
		
		txtEspaniol = new JTextField();
		txtEspaniol.setBounds(287, 61, 148, 20);
		frmDiccionario.getContentPane().add(txtEspaniol);
		txtEspaniol.setColumns(10);
		
		JLabel lblIngresePalabraEn = new JLabel("Ingrese palabra en ingl\u00E9s");
		lblIngresePalabraEn.setForeground(Color.RED);
		lblIngresePalabraEn.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIngresePalabraEn.setBounds(38, 109, 239, 28);
		frmDiccionario.getContentPane().add(lblIngresePalabraEn);
		
		txtIngles = new JTextField();
		txtIngles.setColumns(10);
		txtIngles.setBounds(287, 116, 148, 20);
		frmDiccionario.getContentPane().add(txtIngles);
		
		JButton btnGuardar = new JButton("Grabar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Palabra palabraDiccionario = new Palabra();
				palabraDiccionario.setPalabraEspaniol(txtEspaniol.getText());
				palabraDiccionario.setPalabraIngles(txtIngles.getText());
				DiccionarioService diccionarioService = new DiccionarioService();
				palabras = diccionarioService.guardarPalabra(palabraDiccionario);
				if(palabras != null) {
					lstPalabras.add(palabras);
					table.updateUI();
					txtEspaniol.setText(null);
					txtIngles.setText(null);
				}else {
					JOptionPane.showMessageDialog(null, "Formulario erroneo");
				}
				
			}
		});
		btnGuardar.setBounds(164, 166, 89, 23);
		frmDiccionario.getContentPane().add(btnGuardar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 200, 342, 202);
		frmDiccionario.getContentPane().add(scrollPane);
		
		diccionarioModel = new DiccionarioModel(lstPalabras);
		table = new JTable(diccionarioModel);
		scrollPane.setViewportView(table);
		
		frmDiccionario.setBackground(Color.WHITE);
		frmDiccionario.setTitle("Diccionario");
		frmDiccionario.setBounds(100, 100, 493, 492);
		frmDiccionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
