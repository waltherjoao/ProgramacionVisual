package ec.com.lemas.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Diccionario {

	private JFrame frmDiccionario;
	private JTextField txtEspaniol;
	private JTextField txtIngles;
	private JTable lstPalabras;

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
		frmDiccionario.getContentPane().setBackground(UIManager.getColor("info"));
		frmDiccionario.getContentPane().setLayout(null);
		HashMap<String, String> diccionario = new HashMap<>();
		diccionario.put("ordenador", "computer");
		diccionario.put("gato", "cat");
		diccionario.put("rojo", "red");
		diccionario.put("árbol", "tree");
		diccionario.put("pingüino", "penguin");
		diccionario.put("sol", "sun");
		diccionario.put("agua", "water");	
		diccionario.put("viento", "wind");	
		diccionario.put("siesta", "siesta");	
		diccionario.put("arriba", "up");
		diccionario.put("ratón", "mouse");
		diccionario.put("estadio", "arena");
		diccionario.put("calumnia", "aspersion");
		diccionario.put("aguacate", "avocado");
		diccionario.put("cuerpo", "body");	
		diccionario.put("concurso", "contest");			
		diccionario.put("cena", "dinner");	
		diccionario.put("salida", "exit");	
		diccionario.put("lenteja", "lentil");	
		diccionario.put("cacerola", "pan");	
		diccionario.put("pastel", "pie");	
		diccionario.put("membrillo", "quince");
		
		
		JLabel lblNewLabel = new JLabel("Ingrese palabra en espa\u00F1ol:");
		lblNewLabel.setBounds(79, 84, 143, 28);
		frmDiccionario.getContentPane().add(lblNewLabel);
		
		txtEspaniol = new JTextField();
		txtEspaniol.setBounds(255, 88, 86, 20);
		frmDiccionario.getContentPane().add(txtEspaniol);
		txtEspaniol.setColumns(10);
		
		JLabel lblIngresePalabraEn = new JLabel("Ingrese palabra en ingles:");
		lblIngresePalabraEn.setBounds(79, 142, 143, 28);
		frmDiccionario.getContentPane().add(lblIngresePalabraEn);
		
		txtIngles = new JTextField();
		txtIngles.setColumns(10);
		txtIngles.setBounds(255, 146, 86, 20);
		frmDiccionario.getContentPane().add(txtIngles);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\walte\\Documents\\Java\\ProgramacionVisual\\10.- Diccionario\\res\\guardar.png"));
		btnGuardar.setForeground(new Color(0, 0, 255));
		btnGuardar.setBackground(new Color(255, 228, 181));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(diccionario.containsKey(txtEspaniol.getText())) {
					txtIngles.setText(diccionario.get(txtEspaniol.getText()));
				}else {
					JOptionPane.showMessageDialog(null, "Palabra no existe");
				}
				
			}
		});
		btnGuardar.setBounds(144, 205, 177, 89);
		frmDiccionario.getContentPane().add(btnGuardar);
		
		lstPalabras = new JTable();
		lstPalabras.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		lstPalabras.setBackground(new Color(0, 0, 128));
		lstPalabras.setBounds(332, 514, -285, -166);
		frmDiccionario.getContentPane().add(lstPalabras);
		frmDiccionario.setBackground(UIManager.getColor("info"));
		frmDiccionario.setTitle("DICCIONARIO");
		frmDiccionario.setBounds(100, 100, 462, 620);
		frmDiccionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
