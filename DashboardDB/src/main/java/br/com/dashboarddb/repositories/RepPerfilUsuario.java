package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.PerfilUsuario;

public interface RepPerfilUsuario extends JpaRepository<PerfilUsuario, Long>{

}
