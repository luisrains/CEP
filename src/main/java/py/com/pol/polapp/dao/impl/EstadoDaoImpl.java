package py.com.pol.polapp.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.pol.polapp.dao.EstadoDao;
import py.com.pol.polapp.domain.Estado;

@Repository
@Scope("session")
public class EstadoDaoImpl extends DaoImpl<Estado> implements EstadoDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||estado";
	}

}
