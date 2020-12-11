package br.com.dashboarddb.models.database;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "dashboarddb", name = "perfil", indexes = {
		@Index(name = "ixPerfil_nome", columnList = "nome", unique = true),
		@Index(name = "ixPerfil_Ativo", columnList = "ativo")
})
@SequenceGenerator(schema = "dashboarddb", name = "seq_perfil", sequenceName = "seq_perfil", initialValue = 1, allocationSize = 1)
public class Perfil implements Serializable {

	private static final long serialVersionUID = 8701405328276992500L;

	@Id
	@GeneratedValue(generator = "seq_perfil", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Perfil other = (Perfil) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
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
		return true;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nome=" + nome + ", ativo=" + ativo + "]";
	}

}
