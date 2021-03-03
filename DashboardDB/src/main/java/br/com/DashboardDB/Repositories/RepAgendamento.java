package br.com.DashboardDB.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.DashboardDB.Models.Database.Agendamento;

public interface RepAgendamento extends JpaRepository<Agendamento, Long>{

}
