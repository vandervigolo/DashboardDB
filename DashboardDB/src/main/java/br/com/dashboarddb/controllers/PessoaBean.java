package br.com.dashboarddb.controllers;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.dashboarddb.models.views.PessoaVw;
import br.com.dashboarddb.services.PessoaService;
import br.com.dashboarddb.util.MensagensUsuario;

@Component(value = "pessoaBean")
@Scope("session")
public class PessoaBean {

	private static final String ENDERECO_CADASTRO = "/paginas/pessoa/cadastro.xhtml";
	private static final String ENDERECO_CONSULTA = "/paginas/pessoa/consulta.xhtml";
	private static final String ENDERECO_EDICAO = "/paginas/pessoa/editar.xhtml";

	@Autowired
	private PessoaService pessoaService;
	private List<PessoaVw> pessoas;
	private PessoaVw pessoaVw;
	private String buscaNome;

	public void cadastroPessoa() throws IOException {

		pessoaVw = new PessoaVw();
		FacesContext.getCurrentInstance().getExternalContext().redirect(ENDERECO_CADASTRO);
	}

	public void consultarPessoa() throws IOException {

		if (buscaNome == null) {
			pessoas = pessoaService.PessoasVw();
		} else {
			pessoas = pessoaService.PessoasVw(buscaNome);
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect(ENDERECO_CONSULTA);
	}
	
	public void editarPessoa(PessoaVw pessoaVw) throws IOException {
		this.pessoaVw = pessoaVw;
		FacesContext.getCurrentInstance().getExternalContext().redirect(ENDERECO_EDICAO);
	}
	
	public void excluirPessoa(PessoaVw pessoaVw) {
		
	}

	public void salvar() {
		try {
			pessoaService.salvar(pessoaVw);
			consultarPessoa();
			MensagensUsuario.informacao("Operação realizada com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
			MensagensUsuario.erroSistema("Ocorreu um erro de sistema!");
		} catch (Exception e) {
			e.printStackTrace();
			MensagensUsuario.erro("Ocorreu um erro!");
		}
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

	public String getBuscaNome() {
		return buscaNome;
	}

	public void setBuscaNome(String buscaNome) {
		this.buscaNome = buscaNome;
	}

}
