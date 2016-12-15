package py.com.pol.polapp.dao;

import java.util.List;

public interface Dao<T> {
	/**
	 * Inserta un registro de TipoCliente en la base de datos
	 */
	void create(T obj);

	/**
	 * Actualiza el registro de TipoCliente en la base de datos
	 */
	void edit(T obj);

	/**
	 * @return {@link TipoCliente} con el id indicado
	 */
	T find(Long id);

	/**
	 * Elimina un registro de TipoCliente de la base de datos.
	 */
	void destroy(T obj);

	/**
	 * @return registros de la tabla TipoCliente
	 *
	 */
	List<T> getList(Integer filaInicio, Integer filaFin, String sSearch);

}
