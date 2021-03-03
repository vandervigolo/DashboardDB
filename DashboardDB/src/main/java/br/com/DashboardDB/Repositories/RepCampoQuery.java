package br.com.DashboardDB.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.DashboardDB.Models.Database.CampoQuery;

public interface RepCampoQuery extends JpaRepository<CampoQuery, Long>{

}
