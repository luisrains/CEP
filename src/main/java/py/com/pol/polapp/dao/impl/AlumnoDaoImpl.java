package py.com.pol.polapp.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.pol.polapp.dao.AlumnoDao;
import py.com.pol.polapp.domain.Alumno;

@Repository
@Scope("session")
public class AlumnoDaoImpl extends DaoImpl<Alumno> implements AlumnoDao {

	@Override
	public String getCamposFiltrables() {
		return "cedula||nombre||apellido||carrera";
	}

}
