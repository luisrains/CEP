package py.com.pol.polapp.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.pol.polapp.dao.AlumnoDao;
import py.com.pol.polapp.domain.Alumno;

@Controller
@Scope("request")
@RequestMapping("alumno")
public class AlumnoFormController extends FormController<Alumno> {

	@Autowired
	private AlumnoDao alumnoDao;

	@Override
	public String getTemplatePath() {

		return "alumno/alumno_index";
	}

	@Override
	public String getNombreObjeto() {

		return "alumno";
	}

	@Override
	public Alumno getNuevaInstancia() {

		return new Alumno();
	}

	@Override
	public AlumnoDao getDao() {

		return alumnoDao;
	}

}
