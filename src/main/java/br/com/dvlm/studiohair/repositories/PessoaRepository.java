package br.com.dvlm.studiohair.repositories;

import br.com.dvlm.studiohair.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    @Query("SELECT obj FROM TB_PESSOA obj WHERE obj.cpf =:cpf")
    Pessoa buscarPorCPF(@Param("cpf") String cpf);

}
