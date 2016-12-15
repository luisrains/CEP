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
@Table(uniqueConstraints = { @UniqueConstraint(name = "estado_codigo_uk", columnNames = { "codigo" }) })
public class Estado extends GenericEntity {

	private static final String SECUENCIA = "estado_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SECUENCIA)
	@SequenceGenerator(name = SECUENCIA, sequenceName = SECUENCIA)
	private Long id;

	@NotNull(message = "estado.codigo.notNull")
	@NotBlank(message = "estado.codigo.notBlank")
	@Size(max = 5, message = "estado.codigo.size")
	private String codigo;

	@NotNull(message = "estado.estado.notNull")
	@NotBlank(message = "estado.estado.notBlank")
	@Size(max = 100, message = "estado.estado.size")
	private String estado;

	public Estado() {
	}

	public Estado(Long id, String codigo, String estado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.estado = estado;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public void setId(Long id) {

		this.id = id;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", codigo=" + codigo + ", estado=" + estado + "]";
	}

}
