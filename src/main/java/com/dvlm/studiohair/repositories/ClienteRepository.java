package com.dvlm.studiohair.repositories;

import com.dvlm.studiohair.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
}
