package modelo.negocio;

import modelo.entidad.Usuario;
import modelo.persistencia.DaoUsuarioMySql;
import modelo.persistencia.interfaz.DaoUsuario;

public class GestorUsuario {
	
	private DaoUsuario daoUsuario = new DaoUsuarioMySql();
	
	public boolean estaRegistrado(String nombre, String contraseña) {
		Usuario u = daoUsuario.buscarPorCredenciales(nombre, contraseña);
		
		if(u==null) {
			return false;
		}else{
			return true;
		}
	}
	
}
