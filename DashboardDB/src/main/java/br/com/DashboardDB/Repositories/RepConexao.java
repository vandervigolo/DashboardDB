package br.com.DashboardDB.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.DashboardDB.Models.Database.Conexao;

public interface RepConexao extends JpaRepository<Conexao, Long>{

}
