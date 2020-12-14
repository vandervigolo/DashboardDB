package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.ColunaQuery;

public interface RepColunaQuery extends JpaRepository<ColunaQuery, Long>{

}
