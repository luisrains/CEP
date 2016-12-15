package py.com.pol.polapp.controllers.list;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import py.com.pol.polapp.dao.Dao;
import py.com.pol.polapp.main.DataTable;

public abstract class ListController<T> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "json", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseBody
	// required=false es opcional el parametro de la url
	public DataTable<T> json(@RequestParam(required = false) String sSearch,
			@RequestParam(required = false, defaultValue = "0") Integer iDisplayStart,
			@RequestParam(required = false, defaultValue = "10") Integer iDisplayLength) {

		logger.info("json?sSearch={}, iDisplayStart={}, iDisplayLength={}",
				new Object[] { sSearch, iDisplayStart, iDisplayLength });

		try {
			DataTable<T> dt = new DataTable<>();
			List<T> list = getDao().getList(iDisplayStart, iDisplayStart + iDisplayLength, sSearch);
			Long size = Long.valueOf(list.size());
			dt.setRecordsTotal(size);
			dt.setAaData(list);
			return dt;
		} catch (Exception ex) {
			logger.error("No se pudo obtener lista", ex);
			return new DataTable<>();
		}
	}

	public abstract Dao<T> getDao();
}
