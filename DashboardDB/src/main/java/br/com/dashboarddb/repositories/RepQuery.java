package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Query;

public interface RepQuery extends JpaRepository<Query, Long>{

}
