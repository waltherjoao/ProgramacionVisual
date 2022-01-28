package com.lemas.vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lemas.db.Conexion;
import com.lemas.entidad.Palabra;

public class DiccionarioService {
	
	public Palabra guardarPalabra(Palabra palabra) {
		Connection con = Conexion.getConexion();
		if(palabra.getPalabraEspaniol().isEmpty() && palabra.getPalabraIngles().isEmpty()) {
			return null;
		} else {
			try {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO tblPalabras (palabEspaniol, palabIngles) VALUES (?,?)");
				pstmt.setString(1, palabra.getPalabraEspaniol());
				pstmt.setString(2, palabra.getPalabraIngles());
				pstmt.executeUpdate();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return palabra;
		}
	}
	
	public List<Palabra> getListadoPalabras(){
		Connection con = Conexion.getConexion();
		List<Palabra> lstPalabra = new ArrayList<Palabra>();
		try {
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT palabEspaniol, palabIngles FROM tblPalabras");
			while(rs.next()) {
				Palabra palabra = new Palabra();
				palabra.setPalabraEspaniol(rs.getString("palabEspaniol"));
				palabra.setPalabraIngles(rs.getString("palabIngles"));
				lstPalabra.add(palabra);
			}
			con.close();
			return lstPalabra;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Palabra getPalabraEspaniol(Palabra objPalabra) {
		Connection con = Conexion.getConexion();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT palabEspaniol, palabIngles FROM tblPalabras where palabIngles = ?");
			pstmt.setString(1, objPalabra.getPalabraIngles());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Palabra palabra = new Palabra();
				palabra.setPalabraEspaniol(rs.getString("palabEspaniol"));
				palabra.setPalabraIngles(rs.getString("palabIngles"));
				con.close();
				return palabra;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Palabra getPalabraIngles(Palabra objPalabra) {
		Connection con = Conexion.getConexion();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT palabEspaniol, palabIngles FROM tblPalabras where palabEspaniol = ?");
			pstmt.setString(1, objPalabra.getPalabraEspaniol());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Palabra palabra = new Palabra();
				palabra.setPalabraEspaniol(rs.getString("palabEspaniol"));
				palabra.setPalabraIngles(rs.getString("palabIngles"));
				con.close();
				return palabra;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
