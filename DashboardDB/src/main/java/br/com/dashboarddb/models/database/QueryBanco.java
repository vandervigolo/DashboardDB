package br.com.dashboarddb.models.database;

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
@Table(schema = "dashboarddb", name = "query_banco", indexes = {
		@Index(name = "ixQueryBanco_Query_Banco", columnList = "id_query, id_banco", unique = true) })
@SequenceGenerator(name = "seq_query_banco", sequenceName = "seq_query_banco", schema = "dashboarddb", initialValue = 1, allocationSize = 1)
public class QueryBanco implements Serializable {

	private static final long serialVersionUID = -3514490023452452175L;

	@Id
	@GeneratedValue(generator = "seq_query_banco", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkQueryBanco_Query"))
	private Query query;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_banco", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkQueryBanco_Banco"))
	private Banco banco;

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

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		QueryBanco other = (QueryBanco) obj;
		if (banco == null) {
			if (other.banco != null)
				return false;
		} else if (!banco.equals(other.banco))
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
		return true;
	}

	@Override
	public String toString() {
		return "QueryBanco [id=" + id + ", query=" + query + ", banco=" + banco + "]";
	}

}
