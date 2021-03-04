package br.com.DashboardDB.Models.Database;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "dashboarddb", name = "papel_perfil", indexes = {
		@Index(name = "ixPapelPerfil_Papel", columnList = "id_papel"),
		@Index(name = "ixPapelPerfil_Perfil", columnList = "id_perfil") })
@SequenceGenerator(name = "seq_papel_perfil", sequenceName = "seq_papel_perfil", schema = "dashboarddb", initialValue = 1, allocationSize = 1)
public class PapelPerfil implements Serializable {

	private static final long serialVersionUID = -2547183443040873482L;

	@Id
	@GeneratedValue(generator = "seq_papel_perfil", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_papel", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkPapelPerfil_Papel"))
	private Papel papel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkPapelPerfil_Perfil"))
	private Perfil perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((papel == null) ? 0 : papel.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PapelPerfil other = (PapelPerfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (papel == null) {
			if (other.papel != null)
				return false;
		} else if (!papel.equals(other.papel))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PapelPerfil [id=" + id + ", papel=" + papel + ", perfil=" + perfil + "]";
	}

}
