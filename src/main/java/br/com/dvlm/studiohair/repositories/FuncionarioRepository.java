package br.com.dvlm.studiohair.repositories;

import br.com.dvlm.studiohair.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT funcionario FROM Funcionario funcionario WHERE funcionario.cpf =:cpf")
    Funcionario buscarPorCPF(@Param("cpf") String cpf);
}
