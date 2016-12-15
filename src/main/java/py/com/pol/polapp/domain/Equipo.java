package py.com.pol.polapp.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "equipo_codigo_uk", columnNames = { "codigo" }) })
public class Equipo extends GenericEntity {

	private static final String SECUENCIA = "equipo_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "equipo.codigo.notNull")
	@NotBlank(message = "equipo.codigo.notBlank")
	@Size(max = 5, message = "equipo.codigo.size")
	private String codigo;

	@NotNull(message = "equipo.descripcion.notNull")
	@NotBlank(message = "equipo.descripcion.notBlank")
	@Size(max = 100, message = "equipo.descripcion.size")
	private String descripcion;

	@ManyToOne
	@NotNull(message = "equipo.estado.notNull")
	@JoinColumn(foreignKey = @ForeignKey(name = "equipo_estado_fk"))
	private Estado estado;

	public Equipo(Long id, String codigo, String descripcion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Equipo() {

	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}

}
