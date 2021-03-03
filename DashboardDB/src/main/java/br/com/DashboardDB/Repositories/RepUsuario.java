package br.com.DashboardDB.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.DashboardDB.Models.Database.Usuario;

public interface RepUsuario extends JpaRepository<Usuario, Long>{

}
