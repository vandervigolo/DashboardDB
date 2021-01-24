package br.com.dashboarddb.models.views;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.dashboarddb.models.database.Pessoa;
import br.com.dashboarddb.models.database.Usuario;

public class PessoaVw {

	private Long id;
	private String nome;
	private String endereco;
	private String email;
	private LocalDateTime dataCadastro;
	private Boolean ativo;
	private Usuario usuario;

	public PessoaVw() {
	}

	public PessoaVw(Long id, String nome, String endereco, String email, LocalDateTime dataCadastro, Boolean ativo,
			Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
		this.usuario = usuario;
	}

	public PessoaVw(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.endereco = pessoa.getEndereco();
		this.email = pessoa.getEmail();
		this.dataCadastro = pessoa.getDataCadastro();
		this.ativo = pessoa.getAtivo();
		this.usuario = pessoa.getUsuario();
	}

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDataFormatada() {
		return dataCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
}
