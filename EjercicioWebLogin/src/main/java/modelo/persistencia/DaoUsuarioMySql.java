package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.entidad.Usuario;
import modelo.persistencia.interfaz.DaoUsuario;

public class DaoUsuarioMySql implements DaoUsuario{
	
	private Connection conexion;

	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Usuario buscarPorCredenciales(String nombre, String contraseña) {
		if(!abrirConexion()){
			return null;
		}		
		Usuario usuario = null;
		
		String query = "select ID,NOMBRE,PASSWORD from usuarios WHERE nombre = ? AND password = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ps.setString(1, nombre);
			ps.setString(2, contraseña);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				usuario = new Usuario(rs.getInt(1), rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("BuscarPorCrendenciales -> error al obtener el usuario con nombre " + nombre + " y contraseña " + contraseña);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return usuario;
	}

}
