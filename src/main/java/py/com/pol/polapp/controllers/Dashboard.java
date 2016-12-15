package py.com.pol.polapp.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Luis Méndez
 * @since 1.0
 * @version 1 10/16/2016
 *
 */
@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Dashboard {

	@RequestMapping("/")
	public String index() {

		return "index";
	}

	@RequestMapping("/index")
	public String index2() {
		return "index";
	}

	@RequestMapping("/services")
	public String serviceIndex() {
		return "services";
	}

	@RequestMapping("/contact")
	public String contacIndex() {
		return "contact";
	}

	@RequestMapping("/donde")
	public String dondeIndex() {
		return "donde";
	}

	@RequestMapping("/about")
	public String aboutIndex() {
		return "about";
	}
}
