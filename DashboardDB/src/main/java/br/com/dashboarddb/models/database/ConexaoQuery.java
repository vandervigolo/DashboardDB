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
@Table(schema = "dashboarddb", name = "conexao_query", indexes = {
		@Index(name = "ixConexaoQuery_Conexao", columnList = "id_conexao"),
		@Index(name = "ixConexaoQuery_Query", columnList = "id_query") })
public class ConexaoQuery implements Serializable {

	private static final long serialVersionUID = -3037984545881855972L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conexao", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkConexaoQuery_Conexao"))
	private Conexao conexao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkConexaoQuery_Query"))
	private Query query;

	public Conexao getConexao() {
		return conexao;
	}

	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
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
		result = prime * result + ((conexao == null) ? 0 : conexao.hashCode());
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
		ConexaoQuery other = (ConexaoQuery) obj;
		if (conexao == null) {
			if (other.conexao != null)
				return false;
		} else if (!conexao.equals(other.conexao))
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
		return "ConexaoQuery [conexao=" + conexao + ", query=" + query + "]";
	}

}
