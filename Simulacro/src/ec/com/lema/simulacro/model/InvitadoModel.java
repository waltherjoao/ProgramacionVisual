package ec.com.lema.simulacro.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ec.com.lema.simulacro.dao.EventoDao;

public class InvitadoModel implements TableModel{

	List<EventoDao> listadoEventos;
	private ArrayList<TableModelListener> listener;
	
	public InvitadoModel(List<EventoDao> lstEvento) {
		this.listadoEventos = lstEvento;
		this.listener = new ArrayList<TableModelListener>();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listadoEventos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: 
			return "cedula";
		case 1:
			return "nombre";
		case 2: 
			return "celular";
		case 3:
			return "edad";
		case 4: 
			return "correo";
		case 5:
			return "dirección";
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: 
			return listadoEventos.get(rowIndex).getCedula();
		case 1:
			return listadoEventos.get(rowIndex).getNombre();
		case 2: 
			return listadoEventos.get(rowIndex).getCelular();
		case 3:
			return listadoEventos.get(rowIndex).getEdad();
		case 4: 
			return listadoEventos.get(rowIndex).getCorreo();
		case 5:
			return listadoEventos.get(rowIndex).getDireccion();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: 
			listadoEventos.get(rowIndex).setCedula((String) aValue);
		case 1:
			listadoEventos.get(rowIndex).setNombre((String) aValue);
		case 2: 
			 listadoEventos.get(rowIndex).setCelular((String) aValue);
		case 3:
			 listadoEventos.get(rowIndex).setEdad((Integer) aValue);
		case 4: 
			 listadoEventos.get(rowIndex).setCorreo((String) aValue);
		case 5:
			 listadoEventos.get(rowIndex).setDireccion((String) aValue);
		
		}
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		listener.add(l);
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
