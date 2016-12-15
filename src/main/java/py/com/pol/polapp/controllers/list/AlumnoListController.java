package py.com.pol.polapp.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.pol.polapp.dao.AlumnoDao;
import py.com.pol.polapp.domain.Alumno;

@Controller
@Scope("session")
@RequestMapping("alumno")
public class AlumnoListController extends ListController<Alumno> {
	@Autowired
	private AlumnoDao alumnoDao;

	@Override
	public AlumnoDao getDao() {

		return alumnoDao;
	}

}
