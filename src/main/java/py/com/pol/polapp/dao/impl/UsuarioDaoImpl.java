package py.com.pol.polapp.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.pol.polapp.dao.UsuarioDao;
import py.com.pol.polapp.domain.Usuario;

@Repository
@Scope("session")
public class UsuarioDaoImpl extends DaoImpl<Usuario> implements UsuarioDao {

	@Override
	public String getCamposFiltrables() {
		return "nombre||apellido||codigo";
	}

	@Override
	public Usuario buscar(String codigo, String password) {

		String sql = "SELECT object(U) FROM Usuario AS U WHERE codigo = ?1 and password = ?2";
		Query query = em.createQuery(sql);
		query.setParameter(1, codigo);
		query.setParameter(2, password);

		try {
			Usuario usuario = (Usuario) query.getSingleResult();
			logger.info("Se encontro el usuario {}'", codigo);
			return usuario;
		} catch (NoResultException e) {
			logger.info("No se encontro el usuario {}", codigo);
			return null;
		}

	}

}
