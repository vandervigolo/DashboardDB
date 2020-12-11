package br.com.dashboarddb.models.database;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "dashboarddb", name = "coluna_query", indexes = {
		@Index(name = "ixColunaQuery_Query", columnList = "id_query"),
		@Index(name = "ixColunaQuery_CampoQuery", columnList = "id_campo_query") })
@SequenceGenerator(schema = "dashboarddb", name = "seq_coluna_query", sequenceName = "seq_coluna_query", initialValue = 1, allocationSize = 1)
public class ColunaQuery implements Serializable {

	private static final long serialVersionUID = -151385287297557724L;

	@Id
	@GeneratedValue(generator = "seq_coluna_query", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkColunaQuery_Query"))
	private Query query;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_campo_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkColunaQuery_CampoQuery"))
	private CampoQuery campoQuery;

	@Column(name = "sequencia", nullable = false)
	private Integer sequencia;

	@OneToMany(mappedBy = "colunaQuery", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Valores> valores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public CampoQuery getCampoQuery() {
		return campoQuery;
	}

	public void setCampoQuery(CampoQuery campoQuery) {
		this.campoQuery = campoQuery;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public List<Valores> getValores() {
		return valores;
	}

	public void setValores(List<Valores> valores) {
		this.valores = valores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campoQuery == null) ? 0 : campoQuery.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result + ((sequencia == null) ? 0 : sequencia.hashCode());
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
		ColunaQuery other = (ColunaQuery) obj;
		if (campoQuery == null) {
			if (other.campoQuery != null)
				return false;
		} else if (!campoQuery.equals(other.campoQuery))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		if (sequencia == null) {
			if (other.sequencia != null)
				return false;
		} else if (!sequencia.equals(other.sequencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColunaQuery [id=" + id + ", query=" + query + ", campoQuery=" + campoQuery + ", sequencia=" + sequencia
				+ "]";
	}

}
