package br.com.dashboarddb.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.dashboarddb.models.database.Pessoa;
import br.com.dashboarddb.models.views.PessoaVw;
import br.com.dashboarddb.repositories.RepPessoa;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PessoaService {

	@Autowired
	private RepPessoa repPessoa;
	
	public List<PessoaVw> PessoasVw(){
		List<Pessoa> pessoas = repPessoa.findAllByOrderByNome();
		List<PessoaVw> pessoasVw = new ArrayList<PessoaVw>();
		for (Pessoa pessoa : pessoas) {
			pessoasVw.add(new PessoaVw(pessoa));
		}
		return pessoasVw;
	}
	
	public List<PessoaVw> PessoasVw(String nome){
		//List<Pessoa> pessoas = repPessoa.findByNomeContainsIgnoreCaseOrderByNome(nome);
		List<Pessoa> pessoas = repPessoa.findByNomeContainsIgnoreCase(nome, Sort.by(Sort.Direction.ASC, "nome"));
		List<PessoaVw> pessoasVw = new ArrayList<PessoaVw>();
		for (Pessoa pessoa : pessoas) {
			pessoasVw.add(new PessoaVw(pessoa));
		}
		return pessoasVw;
	}

	@Transactional(readOnly = false)
	public void salvar(PessoaVw pessoaVw) {
		Pessoa pessoa;
		if (pessoaVw.getId() == null) {
			pessoa = new Pessoa();
			pessoa.setAtivo(true);
			pessoa.setDataCadastro(LocalDateTime.now());
		} else {
			pessoa = repPessoa.findById(pessoaVw.getId()).get();
			pessoa.setAtivo(pessoaVw.getAtivo());
			pessoa.setDataCadastro(pessoaVw.getDataCadastro());
		}
		pessoa.setEmail(pessoaVw.getEmail());
		pessoa.setEndereco(pessoaVw.getEndereco());
		pessoa.setNome(pessoaVw.getNome());
		repPessoa.save(pessoa);
	}

	@Transactional(readOnly = false)
	public void eliminar(PessoaVw pessoaVw) {
		eliminar(pessoaVw.getId());
	}

	@Transactional(readOnly = false)
	public void eliminar(Long id) {
		repPessoa.deleteById(id);
	}
}
