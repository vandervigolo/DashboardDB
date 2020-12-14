package br.com.dashboarddb.models.database;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "dashboarddb", name = "query")
@SequenceGenerator(schema = "dashboarddb", name = "seq_query", sequenceName = "seq_query", initialValue = 1, allocationSize = 1)
public class Query implements Serializable {

	private static final long serialVersionUID = 9013209007254907218L;

	@Id
	@GeneratedValue(generator = "seq_query", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "query", columnDefinition = "TEXT", nullable = false)
	private String query;

	@Column(name = "qtd_max_resultado", nullable = false)
	private Long qtdMaxResultado;

	@Column(name = "ativo", columnDefinition = "boolean not null default false")
	private Boolean ativo;

	@OneToMany(mappedBy = "query", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<ColunaQuery> colunas;

	@OneToMany(mappedBy = "query", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<RegistroExecucao> execucoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Long getQtdMaxResultado() {
		return qtdMaxResultado;
	}

	public void setQtdMaxResultado(Long qtdMaxResultado) {
		this.qtdMaxResultado = qtdMaxResultado;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<ColunaQuery> getColunas() {
		return colunas;
	}

	public void setColunas(List<ColunaQuery> colunas) {
		this.colunas = colunas;
	}

	public List<RegistroExecucao> getExecucoes() {
		return execucoes;
	}

	public void setExecucoes(List<RegistroExecucao> execucoes) {
		this.execucoes = execucoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((colunas == null) ? 0 : colunas.hashCode());
		result = prime * result + ((execucoes == null) ? 0 : execucoes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qtdMaxResultado == null) ? 0 : qtdMaxResultado.hashCode());
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
		Query other = (Query) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (colunas == null) {
			if (other.colunas != null)
				return false;
		} else if (!colunas.equals(other.colunas))
			return false;
		if (execucoes == null) {
			if (other.execucoes != null)
				return false;
		} else if (!execucoes.equals(other.execucoes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qtdMaxResultado == null) {
			if (other.qtdMaxResultado != null)
				return false;
		} else if (!qtdMaxResultado.equals(other.qtdMaxResultado))
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
		return "Query [id=" + id + ", query=" + query + ", qtdMaxResultado=" + qtdMaxResultado + ", ativo=" + ativo
				+ ", colunas=" + colunas + ", execucoes=" + execucoes + "]";
	}

}
