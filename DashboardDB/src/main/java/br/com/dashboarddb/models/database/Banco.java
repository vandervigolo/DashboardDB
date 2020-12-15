package br.com.dashboarddb.models.database;

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
@Table(schema = "dashboarddb", name = "conexao", indexes = { @Index(name = "ixBanco_RDMBS", columnList = "id_rdbms") })
@SequenceGenerator(schema = "dashboarddb", name = "seq_banco", sequenceName = "seq_banco", initialValue = 1, allocationSize = 1)
public class Banco implements Serializable {

	private static final long serialVersionUID = 7047946301577349547L;

	@Id
	@GeneratedValue(generator = "seq_banco", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rdbms", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkBanco_RDBMS"))
	private Rdbms rdbms;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@Column(name = "database", nullable = false)
	private String database;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rdbms getRdbms() {
		return rdbms;
	}

	public void setRdbms(Rdbms rdbms) {
		this.rdbms = rdbms;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((database == null) ? 0 : database.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rdbms == null) ? 0 : rdbms.hashCode());
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
		Banco other = (Banco) obj;
		if (database == null) {
			if (other.database != null)
				return false;
		} else if (!database.equals(other.database))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rdbms == null) {
			if (other.rdbms != null)
				return false;
		} else if (!rdbms.equals(other.rdbms))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Banco [id=" + id + ", rdbms=" + rdbms + ", endereco=" + endereco + ", database=" + database + "]";
	}

}
