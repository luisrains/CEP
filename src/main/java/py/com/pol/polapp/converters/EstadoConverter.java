package py.com.pol.polapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.pol.polapp.domain.Estado;

@Component
public class EstadoConverter implements Converter<String, Estado> {

	@Override
	public Estado convert(String idStr) {
		Estado estado = new Estado();
		Long id = Long.parseLong(idStr);
		estado.setId(id);
		// return tipoClienteDao.find(id);
		return estado;
	}

}
