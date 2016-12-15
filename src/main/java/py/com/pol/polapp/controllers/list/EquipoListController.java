package py.com.pol.polapp.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.pol.polapp.dao.EquipoDao;
import py.com.pol.polapp.domain.Equipo;

@Controller
@Scope("session")
@RequestMapping("equipo")
public class EquipoListController extends ListController<Equipo> {

	@Autowired
	private EquipoDao equipoDao;

	@Override
	public EquipoDao getDao() {

		return equipoDao;
	}

}
