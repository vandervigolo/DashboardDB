package br.com.dashboarddb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dashboarddb.models.database.Agendamento;

public interface RepAgendamento extends JpaRepository<Agendamento, Long>{

}
