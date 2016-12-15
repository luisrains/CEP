package py.com.pol.polapp.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.pol.polapp.dao.EstadoDao;
import py.com.pol.polapp.domain.Estado;

@Controller
@Scope("session")
@RequestMapping("estado")
public class EstadoListController extends ListController<Estado> {

	@Autowired
	private EstadoDao estadoDao;

	@Override
	public EstadoDao getDao() {

		return estadoDao;
	}

}
