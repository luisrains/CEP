package py.com.pol.polapp.controllers.form;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.com.pol.polapp.dao.AlumnoDao;
import py.com.pol.polapp.dao.EquipoDao;
import py.com.pol.polapp.dao.EstadoDao;
import py.com.pol.polapp.dao.ReservaDao;
import py.com.pol.polapp.domain.Equipo;
import py.com.pol.polapp.domain.Reserva;

@Controller
@Scope("request")
@RequestMapping("reserva")
public class ReservaFormController extends FormController<Reserva> {

	@Autowired
	private ReservaDao reservaDao;

	@Autowired
	private AlumnoDao alumnoDao;

	@Autowired
	private EquipoDao equipoDao;

	@Autowired
	private EstadoDao estadoDao;

	@Override
	public String getTemplatePath() {

		return "reserva/reserva_index";
	}

	@Override
	public String getNombreObjeto() {

		return "reserva";
	}

	@Override
	public Reserva getNuevaInstancia() {

		return new Reserva();
	}

	@Override
	public ReservaDao getDao() {
		return reservaDao;
	}

	@Override
	public void agregarValoresAdicionales(ModelMap map) {
		map.addAttribute("equipoList", equipoDao.getList(0, 20, null));
		map.addAttribute("alumnoList", alumnoDao.getList(0, 20, null));
		super.agregarValoresAdicionales(map);
	}

	@RequestMapping(value = "save_r", method = RequestMethod.POST)
	public String guardar_r(ModelMap map, @Valid Reserva obj, BindingResult bindingResult) {
		Long id_estado = (long) 0;
		try {
			if (bindingResult.hasErrors()) {
				map.addAttribute("error", msg.get("errores_validacion"));
				List<FieldError> errores = bindingResult.getFieldErrors();
				map.addAttribute("errorList", errores);
			} else {
				if (obj.getId() == null) {
					id_estado = (long) 52;
					getDao().create(obj);
					Equipo equipo = equipoDao.find(obj.getEquipo().getId());
					logger.info("equipo1 {}", equipo);
					equipo.setEstado(estadoDao.find(id_estado));
					equipoDao.edit(equipo);
					logger.info("equipo {}", equipo);
					map.addAttribute("msgExito", msg.get("Registro Agregado"));
				} else {
					id_estado = (long) 1;
					getDao().edit(obj);
					Equipo equipo = equipoDao.find(obj.getEquipo().getId());
					equipo.setEstado(estadoDao.find(id_estado));
					equipoDao.edit(equipo);
					map.addAttribute("msgExito", msg.get("Registro Actualizado"));
				}

			}
		} catch (Exception ex) {
			// TODO: tener en cuenta si es nuevo o edit
			obj.setId(null);
			map.addAttribute("error", getErrorFromException(ex));

		}
		map.addAttribute(getNombreObjeto(), obj);
		agregarValoresAdicionales(map);
		return getTemplatePath();
		/*
		 * map.addAttribute("cliente",cliente); return"cliente/cliente_index";
		 */
	}

	@Override
	@RequestMapping("delete_r/{id}") // "cliente/delete/{id}"
	public String eliminar(ModelMap map, @PathVariable Long id) {
		try {
			Reserva obj = getDao().find(id);
			if (obj == null) {
				map.addAttribute("error", "No se encontró registros con el id " + id);
			} else {
				long id_estado = 1;
				Equipo equipo = equipoDao.find(obj.getEquipo().getId());
				equipo.setEstado(estadoDao.find(id_estado));
				equipoDao.edit(equipo);
				getDao().destroy(obj);
				obj = getNuevaInstancia();
				map.addAttribute(getNombreObjeto(), obj);

				map.addAttribute("msgExito", msg.get("Registro Eliminado"));
				logger.info("registro eliminado");
			}
		} catch (Exception ex) {
			map.addAttribute("error", "Error al eliminar registro. " + ex.getMessage());

		}
		agregarValoresAdicionales(map);
		logger.info("registro retorna {}", getTemplatePath());
		return getTemplatePath();
		/*
		 * map.addAttribute("cliente",cliente); return"cliente/cliente_index";
		 */
	}

}
