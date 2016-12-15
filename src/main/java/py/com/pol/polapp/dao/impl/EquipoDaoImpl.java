package py.com.pol.polapp.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.pol.polapp.dao.EquipoDao;
import py.com.pol.polapp.domain.Equipo;

@Repository
@Scope("session")
public class EquipoDaoImpl extends DaoImpl<Equipo> implements EquipoDao {

	@Override
	public String getCamposFiltrables() {
		return "codigo||descripcion||estado";
	}

}
