package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.RegistroExecucao;

public interface RepRegistroExecucao extends JpaRepository<RegistroExecucao, Long>{

}
