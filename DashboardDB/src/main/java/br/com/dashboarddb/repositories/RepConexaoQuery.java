package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.ConexaoQuery;

public interface RepConexaoQuery extends JpaRepository<ConexaoQuery, Long>{

}
