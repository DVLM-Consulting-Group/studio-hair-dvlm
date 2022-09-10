package com.dvlm.studiohair.repositories;

import com.dvlm.studiohair.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Integer> {
}
