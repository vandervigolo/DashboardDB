package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Valores;

public interface RepValores extends JpaRepository<Valores, Long>{

}
