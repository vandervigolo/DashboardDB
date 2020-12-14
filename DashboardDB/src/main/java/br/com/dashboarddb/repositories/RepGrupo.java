package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Grupo;

public interface RepGrupo extends JpaRepository<Grupo, Long>{

}
