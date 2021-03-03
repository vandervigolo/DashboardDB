package br.com.DashboardDB.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.DashboardDB.Models.Database.Valores;

public interface RepValores extends JpaRepository<Valores, Long>{

}
