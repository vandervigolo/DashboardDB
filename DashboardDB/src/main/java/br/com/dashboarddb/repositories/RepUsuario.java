package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Usuario;

public interface RepUsuario extends JpaRepository<Usuario, Long>{

}
