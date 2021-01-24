package br.com.dashboarddb.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dashboarddb.models.database.Pessoa;

@Repository
public interface RepPessoa extends JpaRepository<Pessoa, Long>{

	public Pessoa findByNome(String Nome);
	public Pessoa findByEmail(String email);
	public List<Pessoa> findAllByOrderByNome();
	public List<Pessoa> findByAtivo(Boolean ativo);
	public List<Pessoa> findByAtivoOrderByNome(Boolean ativo);
	public List<Pessoa> findByNomeContainsIgnoreCase(String nome);
	public List<Pessoa> findByNomeContainsIgnoreCaseOrderByNome(String nome);
	
	// List<Pessoa> pessoas = findByNomeContainsIgnoreCase("nome", Sort.by(Sort.Direction.ASC, "nome"));
	public List<Pessoa> findByNomeContainsIgnoreCase(String nome, Sort ordem);
	public List<Pessoa> findFirst20ByNomeContainsIgnoreCase(String nome);
	public List<Pessoa> findFirst20ByNomeContainsIgnoreCaseOrderByNome(String nome);
}
