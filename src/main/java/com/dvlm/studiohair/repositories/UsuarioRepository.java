package com.dvlm.studiohair.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dvlm.studiohair.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

    Optional<Usuario> findByCpf(String cpf);
    Optional<Usuario> findByEmail (String email);
}
