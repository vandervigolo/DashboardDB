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
@Table(schema = "dashboarddb", name = "conexao", indexes = {
		@Index(name = "ixConexao_Usuario", columnList = "id_usuario"),
		@Index(name = "ixConexao_Ativo", columnList = "ativo") })
@SequenceGenerator(schema = "dashboarddb", name = "seq_conexao", sequenceName = "seq_conexao", initialValue = 1, allocationSize = 1)
public class Conexao implements Serializable {

	private static final long serialVersionUID = 8340633223251105665L;

	@Id
	@GeneratedValue(generator = "seq_conexao", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkConexao_Usuario"))
	private Usuario usuario_cadastro;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@Column(name = "database", nullable = false)
	private String database;

	@Column(name = "usuario_conexao", nullable = false)
	private String usuario_conexao;

	@Column(name = "senha_conexao", nullable = false)
	private String senha_conexao;

	@Column(name = "fabricante", nullable = false)
	private String fabricante;

	@Column(name = "versao", nullable = false)
	private String versao;

	@Column(name = "driver", nullable = false)
	private String driver;

	@Column(name = "somente_leitura", columnDefinition = "boolean not null default true")
	private Boolean somenteLeitura;

	@Column(name = "ativo", columnDefinition = "boolean not null default false")
	private Boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario_cadastro() {
		return usuario_cadastro;
	}

	public void setUsuario_cadastro(Usuario usuario_cadastro) {
		this.usuario_cadastro = usuario_cadastro;
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

	public String getUsuario_conexao() {
		return usuario_conexao;
	}

	public void setUsuario_conexao(String usuario_conexao) {
		this.usuario_conexao = usuario_conexao;
	}

	public String getSenha_conexao() {
		return senha_conexao;
	}

	public void setSenha_conexao(String senha_conexao) {
		this.senha_conexao = senha_conexao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public Boolean getSomenteLeitura() {
		return somenteLeitura;
	}

	public void setSomenteLeitura(Boolean somenteLeitura) {
		this.somenteLeitura = somenteLeitura;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((database == null) ? 0 : database.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((driver == null) ? 0 : driver.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha_conexao == null) ? 0 : senha_conexao.hashCode());
		result = prime * result + ((somenteLeitura == null) ? 0 : somenteLeitura.hashCode());
		result = prime * result + ((usuario_cadastro == null) ? 0 : usuario_cadastro.hashCode());
		result = prime * result + ((usuario_conexao == null) ? 0 : usuario_conexao.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
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
		Conexao other = (Conexao) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (database == null) {
			if (other.database != null)
				return false;
		} else if (!database.equals(other.database))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (driver == null) {
			if (other.driver != null)
				return false;
		} else if (!driver.equals(other.driver))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha_conexao == null) {
			if (other.senha_conexao != null)
				return false;
		} else if (!senha_conexao.equals(other.senha_conexao))
			return false;
		if (somenteLeitura == null) {
			if (other.somenteLeitura != null)
				return false;
		} else if (!somenteLeitura.equals(other.somenteLeitura))
			return false;
		if (usuario_cadastro == null) {
			if (other.usuario_cadastro != null)
				return false;
		} else if (!usuario_cadastro.equals(other.usuario_cadastro))
			return false;
		if (usuario_conexao == null) {
			if (other.usuario_conexao != null)
				return false;
		} else if (!usuario_conexao.equals(other.usuario_conexao))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conexao [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", usuario_cadastro="
				+ usuario_cadastro + ", endereco=" + endereco + ", database=" + database + ", usuario_conexao="
				+ usuario_conexao + ", senha_conexao=" + senha_conexao + ", fabricante=" + fabricante + ", versao="
				+ versao + ", driver=" + driver + ", somenteLeitura=" + somenteLeitura + ", ativo=" + ativo + "]";
	}

}
