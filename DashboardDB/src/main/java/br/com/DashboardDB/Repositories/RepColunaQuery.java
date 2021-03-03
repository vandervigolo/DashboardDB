package br.com.DashboardDB.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.DashboardDB.Models.Database.ColunaQuery;

public interface RepColunaQuery extends JpaRepository<ColunaQuery, Long>{

}
