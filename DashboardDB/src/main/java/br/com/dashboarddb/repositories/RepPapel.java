package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Papel;

public interface RepPapel extends JpaRepository<Papel, Long>{

}
