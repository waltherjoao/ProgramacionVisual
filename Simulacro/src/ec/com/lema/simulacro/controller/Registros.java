package ec.com.lema.simulacro.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import ec.com.lema.simulacro.dao.EventoDao;
import ec.com.lema.simulacro.db.Connecion;
import ec.com.lema.simulacro.model.InvitadoModel;
import ec.com.lema.simulacro.view.RegistrosServices;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class Registros {

	private JFrame frmInvitados;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtCelular;
	private JTextField txtEdad;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JTable table;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registros window = new Registros();
					window.frmInvitados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInvitados = new JFrame();
		frmInvitados.setTitle("Invitados");
		frmInvitados.setBounds(100, 100, 678, 439);
		frmInvitados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInvitados.getContentPane().setBackground(UIManager.getColor("Table.sortIconLight"));
		frmInvitados.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setBounds(10, 49, 46, 14);
		frmInvitados.getContentPane().add(lblNewLabel);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(98, 46, 86, 20);
		frmInvitados.getContentPane().add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 77, 46, 14);
		frmInvitados.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(98, 74, 86, 20);
		frmInvitados.getContentPane().add(txtNombre);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 111, 46, 14);
		frmInvitados.getContentPane().add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(98, 108, 86, 20);
		frmInvitados.getContentPane().add(txtCelular);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 139, 46, 14);
		frmInvitados.getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(98, 136, 86, 20);
		frmInvitados.getContentPane().add(txtEdad);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(10, 167, 46, 14);
		frmInvitados.getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(98, 164, 86, 20);
		frmInvitados.getContentPane().add(txtCorreo);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 201, 46, 14);
		frmInvitados.getContentPane().add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(98, 198, 86, 20);
		frmInvitados.getContentPane().add(txtDireccion);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventoDao eventoDao = new EventoDao();
				eventoDao.setCedula(txtCedula.getText());
				RegistrosServices registrosServices = new RegistrosServices();
				EventoDao invitadoEncontrado = registrosServices.buscarInvitados(eventoDao);
				if(invitadoEncontrado != null) {
					txtCedula.setText(invitadoEncontrado.getCedula());
					txtNombre.setText(invitadoEncontrado.getNombre());
					txtCelular.setText(invitadoEncontrado.getCelular());
					txtEdad.setText(invitadoEncontrado.getEdad()+"");
					txtCorreo.setText(invitadoEncontrado.getCorreo());
					txtDireccion.setText(invitadoEncontrado.getDireccion());
				} else {
					JOptionPane.showMessageDialog(null, "Regitro no encontrado");
				}
			}
		});
		btnBuscar.setBounds(194, 45, 89, 23);
		frmInvitados.getContentPane().add(btnBuscar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventoDao eventoDao = new EventoDao();
				eventoDao.setCedula(txtCedula.getText());
				eventoDao.setNombre(txtNombre.getText());
				eventoDao.setCelular(txtCelular.getText());
				eventoDao.setEdad(Integer.valueOf(txtEdad.getText()));
				eventoDao.setCorreo(txtCorreo.getText());
				eventoDao.setDireccion(txtDireccion.getText());
				RegistrosServices registrosServices = new RegistrosServices();
				String mensajeBD = registrosServices.registrarInvitados(eventoDao);
				JOptionPane.showMessageDialog(null, mensajeBD);
			}
		});
		btnGuardar.setBounds(10, 295, 89, 23);
		frmInvitados.getContentPane().add(btnGuardar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventoDao eventoDao = new EventoDao();
				eventoDao.setCedula(txtCedula.getText());
				eventoDao.setNombre(txtNombre.getText());
				eventoDao.setCelular(txtCelular.getText());
				eventoDao.setEdad(Integer.valueOf(txtEdad.getText()));
				eventoDao.setCorreo(txtCorreo.getText());
				eventoDao.setDireccion(txtDireccion.getText());
				RegistrosServices registrosServices = new RegistrosServices();
				String mensajeBD = registrosServices.actualizarInvitados(eventoDao);
				JOptionPane.showMessageDialog(null, mensajeBD);
			}
		});
		btnActualizar.setBounds(142, 295, 89, 23);
		frmInvitados.getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventoDao eventoDao = new EventoDao();
				eventoDao.setCedula(txtCedula.getText());
				RegistrosServices registrosServices = new RegistrosServices();
				boolean seElimino = registrosServices.eliminarInvitados(eventoDao);
				if(seElimino) {
					JOptionPane.showMessageDialog(null, "Regitro elminado");
				} else {
					JOptionPane.showMessageDialog(null, "El registro no pudo ser eliminado");
				}
			}
		});
		btnEliminar.setBounds(265, 295, 89, 23);
		frmInvitados.getContentPane().add(btnEliminar);
		
		JButton btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JasperReport jasperReport = JasperCompileManager
													.compileReport("C:\\Users\\walte\\JaspersoftWorkspace\\Simulacro\\InvitadosReporte.jrxml");
					Connection conn = Connecion.conectar();
					 // Parameters for report
				     Map<String, Object> parameters = new HashMap<String, Object>();
				     JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
				     
				     File outDir = new File("C:\\Users\\walte\\Documents\\Java\\ProgramacionVisual\\Simulacro\\Reportes");
				     outDir.mkdirs();
				     
				     JRPdfExporter exporter = new JRPdfExporter();
				     
				     ExporterInput exporterInput = new SimpleExporterInput(print);
				     exporter.setExporterInput(exporterInput);
				     
				     OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("C:\\Users\\walte\\Documents\\Java\\ProgramacionVisual\\Simulacro\\Reportes\\ReporteCreado.pdf");
				     exporter.setExporterOutput(exporterOutput);
				     
				     SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
				     exporter.setConfiguration(configuration);
				     exporter.exportReport();
				     
				     System.out.println("Generado el pdf");
				     
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReporte.setBounds(398, 295, 89, 23);
		frmInvitados.getContentPane().add(btnReporte);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajasTexto();
			}
		});
		btnLimpiar.setBounds(208, 351, 89, 23);
		frmInvitados.getContentPane().add(btnLimpiar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(575, 225, -344, -134);
		frmInvitados.getContentPane().add(scrollPane);
		
		RegistrosServices registrosServices = new RegistrosServices();
		List<EventoDao> lstEvento = registrosServices.buscarTodosInvitados();
		InvitadoModel invitadoModel = new InvitadoModel(lstEvento);
		table = new JTable(invitadoModel);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 68, 270, 183);
		frmInvitados.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(invitadoModel);
		scrollPane.setViewportView(table);
		
	}

	private void limpiarCajasTexto() {
		txtCedula.setText("");
		txtNombre.setText("");
		txtCelular.setText("");
		txtEdad.setText("");
		txtCorreo.setText("");
		txtDireccion.setText("");
	}
}
