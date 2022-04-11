package modelo.persistencia.interfaz;

import modelo.entidad.Usuario;

public interface DaoUsuario {

	Usuario buscarPorCredenciales(String nombre, String contraseña);
	
}
