package py.com.pol.polapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import py.com.pol.polapp.domain.Alumno;

@Component
public class AlumnoConverter implements Converter<String, Alumno> {

	@Override
	public Alumno convert(String idStr) {
		Alumno alumno = new Alumno();
		Long id = Long.parseLong(idStr);
		alumno.setId(id);
		// return tipoClienteDao.find(id);
		return alumno;
	}

}
