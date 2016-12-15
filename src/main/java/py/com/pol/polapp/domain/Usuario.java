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
@Table(uniqueConstraints = { @UniqueConstraint(name = "usuario_codigo_uk", columnNames = { "codigo" }) })
public class Usuario extends GenericEntity {
	private static final String SECUENCIA = "usuario_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	// convencion para el mensaje de not nul, para luego usar en la i18n
	// entidad.nombreCampo.nombredenotnull
	@NotNull(message = "usuario.codigo.notNull")
	@NotBlank(message = "usuario.codigo.notBlank")
	@Size(max = 18, message = "usuario.codigo.size")
	private String codigo;

	@NotNull(message = "usuario.nombre.notNull")
	@NotBlank(message = "usuario.nombre.notBlank")
	@Size(max = 60, message = "usuario.nombre.size")
	private String nombre;

	@NotNull(message = "usuario.apellido.notNull")
	@NotBlank(message = "usuario.apellido.notBlank")
	@Size(max = 60, message = "usuario.apellido.size")
	private String apellido;

	@NotNull(message = "usuario.pass.notNull")
	@NotBlank(message = "usuario.pass.notBlank")
	@Size(max = 60, message = "usuario.pass.size")
	private String password;

	public Usuario() {
	}

	@Override
	public Long getId() {

		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", codigo=" + codigo + ", usaurio=" + nombre + ", apellido=" + apellido + "]";
	}

}
