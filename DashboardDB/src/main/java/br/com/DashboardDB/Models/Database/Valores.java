package br.com.DashboardDB.Models.Database;

import java.io.Serializable;

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
@Table(schema = "dashboarddb", name = "valores", indexes = {
		@Index(name = "ixValores_ColunaQuery", columnList = "id_coluna_query"), 
		@Index(name = "ixValores_RegistroExecucao", columnList = "id_registro_execucao")
})
@SequenceGenerator(name = "seq_valores", sequenceName = "seq_valores", schema = "dashboarddb", initialValue = 1, allocationSize = 1)
public class Valores implements Serializable {

	private static final long serialVersionUID = -2162636057815015861L;

	@Id
	@GeneratedValue(generator = "seq_valores", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_coluna_query", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkValores_ColunaQuery"))
	private ColunaQuery colunaQuery;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_registro_execucao", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkValores_Registro_Execucao"))
	private RegistroExecucao registroExecucao;

	@Column(name = "valor", nullable = false)
	private String valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ColunaQuery getColunaQuery() {
		return colunaQuery;
	}

	public void setColunaQuery(ColunaQuery colunaQuery) {
		this.colunaQuery = colunaQuery;
	}

	public RegistroExecucao getRegistroExecucao() {
		return registroExecucao;
	}

	public void setRegistroExecucao(RegistroExecucao registroExecucao) {
		this.registroExecucao = registroExecucao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colunaQuery == null) ? 0 : colunaQuery.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((registroExecucao == null) ? 0 : registroExecucao.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Valores other = (Valores) obj;
		if (colunaQuery == null) {
			if (other.colunaQuery != null)
				return false;
		} else if (!colunaQuery.equals(other.colunaQuery))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (registroExecucao == null) {
			if (other.registroExecucao != null)
				return false;
		} else if (!registroExecucao.equals(other.registroExecucao))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Valores [id=" + id + ", colunaQuery=" + colunaQuery + ", registroExecucao=" + registroExecucao
				+ ", valor=" + valor + "]";
	}

}
