package br.com.DashboardDB.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.DashboardDB.Models.Database.Query;

public interface RepQuery extends JpaRepository<Query, Long>{

}
