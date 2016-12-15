package py.com.pol.polapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.pol.polapp.domain.Equipo;

@Component
public class EquipoConverter implements Converter<String, Equipo> {

	@Override
	public Equipo convert(String idStr) {
		Equipo equipo = new Equipo();
		Long id = Long.parseLong(idStr);
		equipo.setId(id);
		// return tipoClienteDao.find(id);
		return equipo;
	}

}
