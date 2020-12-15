package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Rdbms;

public interface RepRdbms extends JpaRepository<Rdbms, Long>{

}
