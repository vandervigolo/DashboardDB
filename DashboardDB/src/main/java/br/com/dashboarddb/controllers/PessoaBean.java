package br.com.dashboarddb.controllers;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.dashboarddb.models.views.PessoaVw;
import br.com.dashboarddb.services.PessoaService;

@Component(value = "pessoaBean")
@Scope("session")
public class PessoaBean {

	private static final String ENDERECO_CADASTRO = "/paginas/pessoa/cadastro.xhtml";
	private static final String ENDERECO_CONSULTA = "/paginas/pessoa/consulta.xhtml";

	@Autowired
	private PessoaService pessoaService;

	private List<PessoaVw> pessoas;

	private PessoaVw pessoaVw;

	public PessoaBean() {
	}

	public void cadastroPessoa() throws IOException {

		pessoaVw = new PessoaVw();
		FacesContext.getCurrentInstance().getExternalContext().redirect(ENDERECO_CADASTRO);
	}

	public void consultarPessoa() throws IOException {

		pessoas = pessoaService.PessoasVw();
		FacesContext.getCurrentInstance().getExternalContext().redirect(ENDERECO_CONSULTA);
	}

	public void cadastrar() throws IOException {
		pessoaService.salvar(pessoaVw);
		consultarPessoa();
	}

	public List<PessoaVw> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaVw> pessoas) {
		this.pessoas = pessoas;
	}

	public PessoaVw getPessoaVw() {
		return pessoaVw;
	}

	public void setPessoaVw(PessoaVw pessoaVw) {
		this.pessoaVw = pessoaVw;
	}

}
