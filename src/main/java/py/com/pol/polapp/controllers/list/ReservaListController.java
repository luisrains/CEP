package py.com.pol.polapp.controllers.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.pol.polapp.dao.ReservaDao;
import py.com.pol.polapp.domain.Reserva;

@Controller
@Scope("session")
@RequestMapping("reserva")
public class ReservaListController extends ListController<Reserva> {

	@Autowired
	private ReservaDao reservaDao;

	@Override
	public ReservaDao getDao() {

		return reservaDao;
	}

}
