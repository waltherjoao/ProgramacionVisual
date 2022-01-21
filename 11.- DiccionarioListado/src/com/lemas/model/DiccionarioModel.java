package com.lemas.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.lemas.entidad.Palabra;

public class DiccionarioModel implements TableModel{
	
	List<Palabra> listadoPalabras;
	private ArrayList<TableModelListener> listener;

	public DiccionarioModel(List<Palabra> lstPalabra) {
		this.listadoPalabras = lstPalabra;
		this.listener = new ArrayList<TableModelListener>();
	}

	@Override
	public int getRowCount() {
		return listadoPalabras.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		case 0: 
			return "Español";
		case 1:
			return "Ingles";
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
		switch (columnIndex) {
		case 0:
			return listadoPalabras.get(rowIndex).getPalabraEspaniol();
		case 1:
			return listadoPalabras.get(rowIndex).getPalabraIngles();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			listadoPalabras.get(rowIndex).setPalabraEspaniol((String) aValue);
		case 1:
			listadoPalabras.get(rowIndex).setPalabraIngles((String) aValue);
		}
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listener.add(l);
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
