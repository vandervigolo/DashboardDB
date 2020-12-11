package br.com.dashboarddb.models.database;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "dashboarddb", name = "papel_perfil", indexes = {
		@Index(name = "ixPapelPerfil_Papel", columnList = "id_papel"),
		@Index(name = "ixPapelPerfil_Perfil", columnList = "id_perfil")
})
public class PapelPerfil implements Serializable {

	private static final long serialVersionUID = -2547183443040873482L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_papel", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkPapelPerfil_Papel"))
	private Papel papel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkPapelPerfil_Perfil"))
	private Perfil perfil;

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
		return "PapelPerfil [papel=" + papel + ", perfil=" + perfil + "]";
	}

}
