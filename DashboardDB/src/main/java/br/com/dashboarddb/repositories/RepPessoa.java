package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dashboarddb.models.database.Pessoa;

@Repository
public interface RepPessoa extends JpaRepository<Pessoa, Long>{

	public Pessoa findByNome(String Nome);

	public Pessoa findByEmail(String email);
}
