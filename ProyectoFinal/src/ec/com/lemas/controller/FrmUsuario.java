package ec.com.lemas.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ec.com.lemas.DAO.UsuarioDao;
import ec.com.lemas.models.Conexion;
import ec.com.lemas.views.Usuario;
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

public class FrmUsuario {

	private JFrame frmUsuario;
	private JTextField txtIdUsuario;
	private JTextField txtNombre;
	private JTextField txtPassword;
	private JTextField txtTipoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuario window = new FrmUsuario();
					window.frmUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUsuario = new JFrame();
		frmUsuario.setTitle("Usuario");
		frmUsuario.setBounds(100, 100, 450, 300);
		frmUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id Usuario");
		lblNewLabel.setBounds(21, 33, 72, 14);
		frmUsuario.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(21, 71, 46, 14);
		frmUsuario.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(21, 108, 72, 14);
		frmUsuario.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo Usuario");
		lblNewLabel_1_1.setBounds(21, 146, 92, 14);
		frmUsuario.getContentPane().add(lblNewLabel_1_1);
		
		txtIdUsuario = new JTextField();
		txtIdUsuario.setBounds(135, 30, 86, 20);
		frmUsuario.getContentPane().add(txtIdUsuario);
		txtIdUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(135, 71, 86, 20);
		frmUsuario.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(135, 105, 86, 20);
		frmUsuario.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtTipoUsuario = new JTextField();
		txtTipoUsuario.setBounds(135, 143, 86, 20);
		frmUsuario.getContentPane().add(txtTipoUsuario);
		txtTipoUsuario.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDao busquedaObj = new UsuarioDao();
				busquedaObj.setCodigoUsuario(txtIdUsuario.getText().toString());
				Usuario usuario = new Usuario();
				UsuarioDao usuarioEncontrado = usuario.buscarPorId(busquedaObj);
				txtIdUsuario.setText(usuarioEncontrado.getCodigoUsuario());
				txtNombre.setText(usuarioEncontrado.getUsuario());
				txtPassword.setText(usuarioEncontrado.getClave());
				txtTipoUsuario.setText(usuarioEncontrado.getFactor1());
			}
		});
		btnBuscar.setBounds(250, 29, 89, 23);
		frmUsuario.getContentPane().add(btnBuscar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDao nombreObj = new UsuarioDao();
				nombreObj.setCodigoUsuario(txtIdUsuario.getText());
				nombreObj.setUsuario(txtNombre.getText());
				nombreObj.setClave(txtPassword.getText());
				nombreObj.setFactor1(txtTipoUsuario.getText());
				nombreObj.setEstado("Activo");
				Usuario usuario = new Usuario();
				String resp = usuario.agregar(nombreObj);
				JOptionPane.showMessageDialog(null, resp);
			}
		});
		btnRegistrar.setBounds(21, 199, 89, 23);
		frmUsuario.getContentPane().add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDao nuevUsuario = new UsuarioDao();
				nuevUsuario.setCodigoUsuario(txtIdUsuario.getText().toString());
				nuevUsuario.setUsuario(txtNombre.getText().toString());
				nuevUsuario.setClave(txtPassword.getText().toString());
				nuevUsuario.setFactor1(txtTipoUsuario.getText().toString());
				Usuario actUsuario = new Usuario();
				String mensajeActulizacion = actUsuario.actualizar(nuevUsuario);
				JOptionPane.showMessageDialog(null, mensajeActulizacion);
				limpiarFormulario();
			}
		});
		btnActualizar.setBounds(156, 199, 108, 23);
		frmUsuario.getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDao busquedaObj = new UsuarioDao();
				busquedaObj.setCodigoUsuario(txtIdUsuario.getText().toString());
				Usuario delUsuario = new Usuario();
				String mensajeDel = delUsuario.eliminar(busquedaObj);
				JOptionPane.showMessageDialog(null, mensajeDel);
				limpiarFormulario();
			}
		});
		btnEliminar.setBounds(310, 199, 89, 23);
		frmUsuario.getContentPane().add(btnEliminar);
		
		JButton btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JasperReport jasperReport = JasperCompileManager
													.compileReport("C:\\Users\\walte\\JaspersoftWorkspace\\SecondReport\\Cherry.jrxml");
					Connection conn = Conexion.conectar();
					 // Parameters for report
				     Map<String, Object> parameters = new HashMap<String, Object>();
				     JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
				     
				     File outDir = new File("C:\\Users\\walte\\Documents\\Java\\ProgramacionVisual\\ProyectoFinal\\Reportes");
				     outDir.mkdirs();
				     
				     JRPdfExporter exporter = new JRPdfExporter();
				     
				     ExporterInput exporterInput = new SimpleExporterInput(print);
				     exporter.setExporterInput(exporterInput);
				     
				     OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("C:\\Users\\walte\\Documents\\Java\\ProgramacionVisual\\ProyectoFinal\\Reportes\\ReporteCreado.csv");
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
		btnReporte.setBounds(250, 104, 89, 23);
		frmUsuario.getContentPane().add(btnReporte);
	}

	private void limpiarFormulario() {
		txtIdUsuario.setText("");
		txtNombre.setText("");
		txtPassword.setText("");
		txtTipoUsuario.setText("");
	}
	

}
