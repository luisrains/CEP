package py.com.pol.polapp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "reserva_id_uk", columnNames = { "id" }) })
public class Reserva extends GenericEntity {
	private static final String SECUENCIA = "reserva_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@OneToOne
	@NotNull(message = "reserva.equipo.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "reserva_equipo_fk"))
	private Equipo equipo;

	@ManyToOne
	@NotNull(message = "reserva.alumno.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "reserva_alumno_fk"))
	private Alumno alumno;

	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Type(type = "date")
	private Date fecha_recepcion;

	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Type(type = "date")
	private Date fecha_devolucion;

	@Size(max = 5, message = "reserva.hora_recepcion.size")
	private String hora_recepcion;

	@Size(max = 5, message = "reserva.hora_devolucion.size")
	private String hora_devolucion;

	public Reserva() {
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Date getFecha_recepcion() {
		return fecha_recepcion;
	}

	public void setFecha_recepcion(Date fecha_recepcion) {
		this.fecha_recepcion = fecha_recepcion;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public String getHora_recepcion() {
		return hora_recepcion;
	}

	public void setHora_recepcion(String hora_recepcion) {
		this.hora_recepcion = hora_recepcion;
	}

	public String getHora_devolucion() {
		return hora_devolucion;
	}

	public void setHora_devolucion(String hora_devolucion) {
		this.hora_devolucion = hora_devolucion;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", equipo=" + equipo + ", alumno=" + alumno + ", fecha_recepcion="
				+ fecha_recepcion + ", fecha_devolucion=" + fecha_devolucion + ", hora_recepcion=" + hora_recepcion
				+ ", hora_devolucion=" + hora_devolucion + "]";
	}

}
