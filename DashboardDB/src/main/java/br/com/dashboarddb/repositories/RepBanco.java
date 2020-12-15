package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Banco;

public interface RepBanco extends JpaRepository<Banco, Long>{

}
