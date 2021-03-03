package br.com.DashboardDB.Models.Database;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(schema = "dashboarddb", name = "agendamento", indexes = {
		@Index(name = "ixAgendamento_Query", columnList = "id_query"),
		@Index(name = "ixAgendamento_Conexao", columnList = "id_conexao"),
		@Index(name = "ixAgendamento_ProximaExecucao", columnList = "proxima_execucao") })
@SequenceGenerator(schema = "dashboarddb", name = "seq_agendamento", sequenceName = "seq_agendamento", initialValue = 1, allocationSize = 1)
public class Agendamento implements Serializable {

	private static final long serialVersionUID = -2657041327705139063L;

	@Id
	@GeneratedValue(generator = "seq_agendamento", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "id_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkAgendamento_Query"))
	private Query query;

	@ManyToOne()
	@JoinColumn(name = "id_conexao", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkAgendamento_Conexao"))
	private Conexao conexao;

	@Column(name = "cron", nullable = false)
	private String cron;

	@Column(name = "ultima_execucao", nullable = false)
	private LocalDateTime ultimaExecucao;

	@Column(name = "proxima_execucao", nullable = false)
	private LocalDateTime proximaExecucao;

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

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public LocalDateTime getUltimaExecucao() {
		return ultimaExecucao;
	}

	public void setUltimaExecucao(LocalDateTime ultimaExecucao) {
		this.ultimaExecucao = ultimaExecucao;
	}

	public LocalDateTime getProximaExecucao() {
		return proximaExecucao;
	}

	public void setProximaExecucao(LocalDateTime proximaExecucao) {
		this.proximaExecucao = proximaExecucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conexao == null) ? 0 : conexao.hashCode());
		result = prime * result + ((cron == null) ? 0 : cron.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((proximaExecucao == null) ? 0 : proximaExecucao.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result + ((ultimaExecucao == null) ? 0 : ultimaExecucao.hashCode());
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
		Agendamento other = (Agendamento) obj;
		if (conexao == null) {
			if (other.conexao != null)
				return false;
		} else if (!conexao.equals(other.conexao))
			return false;
		if (cron == null) {
			if (other.cron != null)
				return false;
		} else if (!cron.equals(other.cron))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (proximaExecucao == null) {
			if (other.proximaExecucao != null)
				return false;
		} else if (!proximaExecucao.equals(other.proximaExecucao))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		if (ultimaExecucao == null) {
			if (other.ultimaExecucao != null)
				return false;
		} else if (!ultimaExecucao.equals(other.ultimaExecucao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendamento [id=" + id + ", query=" + query + ", conexao=" + conexao + ", cron=" + cron
				+ ", ultimaExecucao=" + ultimaExecucao + ", proximaExecucao=" + proximaExecucao + "]";
	}

}
