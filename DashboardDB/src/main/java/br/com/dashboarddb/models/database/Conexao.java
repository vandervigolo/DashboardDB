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
		@Index(name = "ixConexao_Ativo", columnList = "ativo")
})
@SequenceGenerator(schema = "dashboarddb", name = "seq_conexao", sequenceName = "seq_conexao", initialValue = 1, allocationSize = 1)
public class Conexao implements Serializable {

	private static final long serialVersionUID = 8340633223251105665L;

	@Id
	@GeneratedValue(generator = "seq_conexao", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fkConexao_Usuario"))
	private Usuario usuario_cadastro;

	@Column(name = "driver", nullable = false)
	private String driver;

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "usuario_conexao", nullable = false)
	private String usuario_conexao;

	@Column(name = "senha_conexao", nullable = false)
	private String senha_conexao;

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

	public Usuario getUsuario_cadastro() {
		return usuario_cadastro;
	}

	public void setUsuario_cadastro(Usuario usuario_cadastro) {
		this.usuario_cadastro = usuario_cadastro;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		result = prime * result + ((driver == null) ? 0 : driver.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha_conexao == null) ? 0 : senha_conexao.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((usuario_cadastro == null) ? 0 : usuario_cadastro.hashCode());
		result = prime * result + ((usuario_conexao == null) ? 0 : usuario_conexao.hashCode());
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
		if (driver == null) {
			if (other.driver != null)
				return false;
		} else if (!driver.equals(other.driver))
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
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
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
		return true;
	}

	@Override
	public String toString() {
		return "Conexao [id=" + id + ", nome=" + nome + ", usuario_cadastro=" + usuario_cadastro + ", driver=" + driver
				+ ", url=" + url + ", usuario_conexao=" + usuario_conexao + ", senha_conexao=" + senha_conexao
				+ ", ativo=" + ativo + "]";
	}

}
