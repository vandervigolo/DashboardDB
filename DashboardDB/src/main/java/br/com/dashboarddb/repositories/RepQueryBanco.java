package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.QueryBanco;

public interface RepQueryBanco extends JpaRepository<QueryBanco, Long>{

}
