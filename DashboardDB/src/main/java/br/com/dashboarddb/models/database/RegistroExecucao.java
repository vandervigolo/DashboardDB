package br.com.dashboarddb.models.database;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "dashboarddb", name = "registro_execucao", indexes = {
		@Index(name = "ixRegistroExecucao_Conexao", columnList = "id_conexao"),
		@Index(name = "ixRegistroExecucao_Query", columnList = "id_query"),
		@Index(name = "ixRegistroExecucao_DataHora", columnList = "data_hora_execucao"),
		@Index(name = "ixRegistroExecucao_Sucesso", columnList = "sucesso") })
@SequenceGenerator(schema = "dashboarddb", name = "seq_registro_execucao", sequenceName = "seq_registro_execucao", initialValue = 1, allocationSize = 1)
public class RegistroExecucao implements Serializable {

	private static final long serialVersionUID = -5984500803173546920L;

	@Id
	@GeneratedValue(generator = "seq_registro_execucao", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkRegistroExecucao_Query"))
	private Query query;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conexao", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkRegistroExecucao_Conexao"))
	private Conexao conexao;

	@Column(name = "data_hora_execucao", nullable = false)
	private LocalDateTime dataHoraExecucao;

	@Column(name = "sucesso", columnDefinition = "boolean not null default false")
	private Boolean sucesso;

	@Column(name = "resultado", columnDefinition = "TEXT", nullable = false)
	private String resultado;

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

	public Conexao getConexao() {
		return conexao;
	}

	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}

	public LocalDateTime getDataHoraExecucao() {
		return dataHoraExecucao;
	}

	public void setDataHoraExecucao(LocalDateTime dataHoraExecucao) {
		this.dataHoraExecucao = dataHoraExecucao;
	}

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conexao == null) ? 0 : conexao.hashCode());
		result = prime * result + ((dataHoraExecucao == null) ? 0 : dataHoraExecucao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
		result = prime * result + ((sucesso == null) ? 0 : sucesso.hashCode());
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
		RegistroExecucao other = (RegistroExecucao) obj;
		if (conexao == null) {
			if (other.conexao != null)
				return false;
		} else if (!conexao.equals(other.conexao))
			return false;
		if (dataHoraExecucao == null) {
			if (other.dataHoraExecucao != null)
				return false;
		} else if (!dataHoraExecucao.equals(other.dataHoraExecucao))
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
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		if (sucesso == null) {
			if (other.sucesso != null)
				return false;
		} else if (!sucesso.equals(other.sucesso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegistroExecucao [id=" + id + ", query=" + query + ", conexao=" + conexao + ", dataHoraExecucao="
				+ dataHoraExecucao + ", sucesso=" + sucesso + ", resultado=" + resultado + "]";
	}

}
