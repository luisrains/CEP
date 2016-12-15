package py.com.pol.polapp.main;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import py.com.pol.polapp.domain.Usuario;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SesionUsuario {

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogger() {
		return usuario != null;
	}
}
