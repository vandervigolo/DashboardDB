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
@Table(schema = "dashboarddb", name = "usuario_grupo", indexes = {
		@Index(name = "ixQueryGrupo_Grupo", columnList = "id_grupo"),
		@Index(name = "ixQueryGrupo_Query", columnList = "id_query") })
public class QueryGrupo implements Serializable {

	private static final long serialVersionUID = -3458040537877908674L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_grupo", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkQueryGrupo_Grupo"))
	private Grupo grupo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkQueryGrupo_Query"))
	private Query query;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
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
		QueryGrupo other = (QueryGrupo) obj;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QueryGrupo [grupo=" + grupo + ", query=" + query + "]";
	}

}
