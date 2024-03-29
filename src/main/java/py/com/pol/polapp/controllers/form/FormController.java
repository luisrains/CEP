package py.com.pol.polapp.controllers.form;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import py.com.pol.polapp.dao.Dao;
import py.com.pol.polapp.domain.GenericEntity;
import py.com.pol.polapp.main.Message;
import py.com.pol.polapp.main.SesionUsuario;

public abstract class FormController<T extends GenericEntity> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected Message msg;

	@Autowired
	private SesionUsuario session;

	@RequestMapping
	public String index(ModelMap map) {
		if (session.isLogger()) {

			map.addAttribute(getNombreObjeto(), getNuevaInstancia());
			agregarValoresAdicionales(map);
			return getTemplatePath();// "cliente/cliente_index";
		} else {
			return "redirect:/login?next=/reserva/";
		}
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String guardar(ModelMap map, @Valid T obj, BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				map.addAttribute("error", msg.get("errores_validacion"));
				List<FieldError> errores = bindingResult.getFieldErrors();
				map.addAttribute("errorList", errores);
			} else {
				if (obj.getId() == null) {
					getDao().create(obj);
					map.addAttribute("msgExito", msg.get("Registro agregado"));
				} else {
					getDao().edit(obj);
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

	@RequestMapping("edit/{id}") // "cliente/edit/{id}"
	public String edit(ModelMap map, @PathVariable Long id) {
		try {
			T obj = getDao().find(id);
			if (obj == null) {
				map.addAttribute("error", "No se encontró registros con el id " + id);
				obj = getNuevaInstancia();
			}
			map.addAttribute(getNombreObjeto(), obj);
		} catch (Exception ex) {
			map.addAttribute("error", "Error al buscar registro. " + ex.getMessage());
			map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		}

		agregarValoresAdicionales(map);
		return getTemplatePath();
		// return "cliente/cliente_index";
	}

	@RequestMapping("delete/{id}") // "cliente/delete/{id}"
	public String eliminar(ModelMap map, @PathVariable Long id) {
		try {
			T obj = getDao().find(id);
			if (obj == null) {
				map.addAttribute("error", "No se encontró registros con el id " + id);
			} else {
				getDao().destroy(obj);
				obj = getNuevaInstancia();
				map.addAttribute(getNombreObjeto(), obj);
				map.addAttribute("msgExito", msg.get("Registro eliminado"));
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

	@RequestMapping("view/{id}") // "cliente/edit/{id}"
	public String ver(ModelMap map, @PathVariable Long id) {
		try {
			T obj = getDao().find(id);
			if (obj == null) {
				map.addAttribute("error", "No se encontró registros con el id " + id);
				obj = getNuevaInstancia();
			}
			map.addAttribute(getNombreObjeto(), obj);
		} catch (Exception ex) {
			map.addAttribute("error", "Error al buscar registro. " + ex.getMessage());
			map.addAttribute(getNombreObjeto(), getNuevaInstancia());
		}

		agregarValoresAdicionales(map);
		return "reserva/reserva_index1";
		// return "cliente/cliente_index";
	}

	/**
	 * Cuando ocurre una excepción, el error que se muestra es muy genérico. Se
	 * debe recorrer el stack de error y verificar si no fue error de constraint
	 * (valores duplicados, etc.)
	 */
	protected String getErrorFromException(final Exception exception) {
		Throwable th = exception;
		while (th != null) {
			if (th.getClass().equals(org.hibernate.exception.ConstraintViolationException.class)) {
				ConstraintViolationException cve = (ConstraintViolationException) th;
				return msg.get(cve.getConstraintName());
			}
			th = th.getCause();
		}
		return exception.getMessage();
	}

	public void agregarValoresAdicionales(ModelMap map) {

	}

	public abstract String getTemplatePath();

	public abstract String getNombreObjeto();

	public abstract T getNuevaInstancia();

	public abstract Dao<T> getDao();
}
