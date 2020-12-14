package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Perfil;

public interface RepPerfil extends JpaRepository<Perfil, Long>{

}
