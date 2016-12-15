package py.com.pol.polapp.dao.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import py.com.pol.polapp.dao.ReservaDao;
import py.com.pol.polapp.domain.Reserva;

@Repository
@Scope("session")
public class ReservaDaoImpl extends DaoImpl<Reserva> implements ReservaDao {

	@Override
	public String getCamposFiltrables() {
		// TODO Auto-generated method stub
		return "hora_recepcion";
	}

}
