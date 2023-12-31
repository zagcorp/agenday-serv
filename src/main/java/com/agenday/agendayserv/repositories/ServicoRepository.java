package com.agenday.agendayserv.repositories;

import com.agenday.agendayserv.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>, CustomQuerydslPredicateExecutor<Servico> {
}
