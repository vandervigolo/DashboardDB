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
@Table(schema = "dashboarddb", name = "conexao_query", indexes = {
		@Index(name = "ixConexaoQuery_Conexao", columnList = "id_conexao"),
		@Index(name = "ixConexaoQuery_Query", columnList = "id_query") })
@SequenceGenerator(name = "seq_conexao_query", sequenceName = "seq_conexao_query", schema = "dashboarddb", initialValue = 1, allocationSize = 1)
public class ConexaoQuery implements Serializable {

	private static final long serialVersionUID = -3037984545881855972L;

	@Id
	@GeneratedValue(generator = "seq_conexao_query", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conexao", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkConexaoQuery_Conexao"))
	private Conexao conexao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkConexaoQuery_Query"))
	private Query query;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		ConexaoQuery other = (ConexaoQuery) obj;
		if (conexao == null) {
			if (other.conexao != null)
				return false;
		} else if (!conexao.equals(other.conexao))
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
		return "ConexaoQuery [id=" + id + ", conexao=" + conexao + ", query=" + query + "]";
	}
}
