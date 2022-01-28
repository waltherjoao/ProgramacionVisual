package com.lemas.vista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lemas.db.Conexion;

public class LoginServices {

	public boolean esValidoElUsuario(String usuario, String password) {
		Connection con = Conexion.getConexion();
		try {
			PreparedStatement pstmt = con.prepareStatement("Select usuario FROM tblUsuario WHERE usuario = ? and contrasenia = ?");
			pstmt.setString(1, usuario);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("El usuario existe  "+rs.getString("usuario"));
				con.close();
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
