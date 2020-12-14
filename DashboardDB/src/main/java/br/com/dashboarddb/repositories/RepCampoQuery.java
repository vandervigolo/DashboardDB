package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.CampoQuery;

public interface RepCampoQuery extends JpaRepository<CampoQuery, Long>{

}
