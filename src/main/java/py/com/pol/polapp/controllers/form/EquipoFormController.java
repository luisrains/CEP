package py.com.pol.polapp.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.pol.polapp.dao.EquipoDao;
import py.com.pol.polapp.dao.EstadoDao;
import py.com.pol.polapp.domain.Equipo;

@Controller
@Scope("request")
@RequestMapping("equipo")
public class EquipoFormController extends FormController<Equipo> {

	@Autowired
	private EquipoDao equipoDao;

	@Autowired
	private EstadoDao estadoDao;

	@Override
	public String getTemplatePath() {

		return "equipo/equipo_index";
	}

	@Override
	public String getNombreObjeto() {

		return "equipo";
	}

	@Override
	public Equipo getNuevaInstancia() {

		return new Equipo();
	}

	@Override
	public EquipoDao getDao() {
		return equipoDao;
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("estadoList", estadoDao.getList(0, 20, null));
		super.agregarValoresAdicionales(map);
	}

}
