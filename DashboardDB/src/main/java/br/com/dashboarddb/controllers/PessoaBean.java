package br.com.dashboarddb.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.dashboarddb.models.database.Pessoa;
import br.com.dashboarddb.util.MensagensUsuario;

@Component(value = "pessoaBean")
@Scope("session")
public class PessoaBean {
	
	private static final String ENDERECO_CADASTRO = "/paginas/pessoa/cadastro.xhtml";
	private static final String ENDERECO_CONSULTA = "/paginas/pessoa/consulta.xhtml";
	
	private List<Pessoa> pessoas;
	
	


	public PessoaBean() {
		pessoas = new ArrayList<Pessoa>();
		Pessoa pessoa = new Pessoa();
		pessoa.setEmail("teste@teste.com.br");
		pessoa.setNome("fulano");
		pessoa.setEndereco("ruas do fulanino que temd que der bem grande, ruas do fulanino que temd que der bem grande");
		pessoas.add(pessoa);
	}


	public void cadastroPessoa() throws IOException {

		System.out.println("Teste, passei Aqui @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		FacesContext.getCurrentInstance().getExternalContext().redirect(ENDERECO_CADASTRO);	
	}
	

	public void consultarPessoa() throws IOException {

		System.out.println("Teste, passei Aqui @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		FacesContext.getCurrentInstance().getExternalContext().redirect(ENDERECO_CONSULTA);	
	}
	
	public void cadastrar() {
		MensagensUsuario.erroSistema("teste");
	}


	public List<Pessoa> getPessoas() {
		return pessoas;
	}


	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	


}
