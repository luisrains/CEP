package py.com.pol.polapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "alumno_cedula_uk", columnNames = { "cedula" }) })
public class Alumno extends GenericEntity {
	private static final String SECUENCIA = "alumno_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	// convencion para el mensaje de not nul, para luego usar en la i18n
	// entidad.nombreCampo.nombredenotnull
	@NotNull(message = "alumno.cedula.notNull")
	@NotBlank(message = "alumno.cedula.notBlank")
	@Size(max = 18, message = "alumno.cedula.size")
	private String cedula;

	@NotNull(message = "alumno.nombre.notNull")
	@NotBlank(message = "alumno.nombre.notBlank")
	@Size(max = 60, message = "alumno.nombre.size")
	private String nombre;

	@NotNull(message = "alumno.apellido.notNull")
	@NotBlank(message = "alumno.apellido.notBlank")
	@Size(max = 60, message = "alumno.apellido.size")
	private String apellido;

	@Size(max = 100, message = "alumno.correo.size")
	private String correo;

	@NotNull(message = "alumno.carrera.notNull")
	@NotBlank(message = "alumno.carrera.notBlank")
	@Size(max = 100, message = "alumno.carrera.size")
	private String carrera;

	@Size(max = 100, message = "alumno.telefono.size")
	private String telefono;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Alumno() {
	}

	public Alumno(Long id, String cedula, String nombre, String apellido, String correo, String carrera) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.carrera = carrera;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo="
				+ correo + ", carrera=" + carrera + ", telefono=" + telefono + "]";
	}

}
