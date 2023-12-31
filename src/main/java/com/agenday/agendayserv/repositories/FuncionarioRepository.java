package com.agenday.agendayserv.repositories;

import com.agenday.agendayserv.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, CustomQuerydslPredicateExecutor<Funcionario> {
}
