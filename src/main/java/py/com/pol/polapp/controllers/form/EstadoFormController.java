package py.com.pol.polapp.controllers.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.com.pol.polapp.dao.EstadoDao;
import py.com.pol.polapp.domain.Estado;

@Controller
@Scope("request")
@RequestMapping("estado")
public class EstadoFormController extends FormController<Estado> {

	@Autowired
	private EstadoDao estadoDao;

	@Override
	public String getTemplatePath() {

		return "estado/estado_index";
	}

	@Override
	public String getNombreObjeto() {

		return "estado";
	}

	@Override
	public Estado getNuevaInstancia() {

		return new Estado();
	}

	@Override
	public EstadoDao getDao() {

		return estadoDao;
	}

}
