package py.com.pol.polapp.controllers.form;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import py.com.pol.polapp.dao.UsuarioDao;
import py.com.pol.polapp.domain.Usuario;
import py.com.pol.polapp.main.SesionUsuario;

@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private SesionUsuario session;

	@RequestMapping("/logout")
	public String logout() {
		session.setUsuario(null);
		return "login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(required = false) String next, ModelMap modelMap) {
		modelMap.addAttribute("next", next);
		if (session.isLogger()) {
			return "redirect:/reserva/";
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login2(@RequestParam(required = false) String next, ModelMap modelMap, @RequestParam String username,
			@RequestParam String password) {
		try {
			Usuario usuario = usuarioDao.buscar(username, password);

			if (usuario == null) {
				modelMap.addAttribute("error", "Usuario o contraseña incorrectos");

			} else {
				session.setUsuario(usuario);
				logger.info("Usuario '{}' inició sesion -> ", username, new Date());
				if (next != null && !next.isEmpty()) {
					logger.info("redirect con next '{}' next -> ", next);
					return "redirect:" + next;

				} else {
					return "redirect:/reserva/";
				}
			}
		} catch (Exception e) {
			logger.error("Error BD al buscar usuario", e);

		}
		return "login";
	}
}
