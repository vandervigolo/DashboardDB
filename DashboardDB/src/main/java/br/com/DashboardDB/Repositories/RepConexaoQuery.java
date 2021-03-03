package br.com.DashboardDB.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.DashboardDB.Models.Database.ConexaoQuery;

public interface RepConexaoQuery extends JpaRepository<ConexaoQuery, Long>{

}
