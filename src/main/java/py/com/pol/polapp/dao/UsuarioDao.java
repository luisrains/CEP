package py.com.pol.polapp.dao;

import py.com.pol.polapp.domain.Usuario;

public interface UsuarioDao extends Dao<Usuario> {
	/**
	 * @param password
	 *            la contraseñade usuario sin encriptar
	 * @return null si no existe el usuario
	 * @return Usuario
	 *
	 */
	Usuario buscar(String codigo, String password);
}