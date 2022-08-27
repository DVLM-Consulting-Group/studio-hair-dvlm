package br.com.dvlm.studiohair.domain;

public class Funcionario extends Pessoa{

    public Funcionario() {
        super();
    }

    public Funcionario(Integer id, String nome, String cpf, String telefone, String email) {
        super(id, nome, cpf, telefone, email);
    }
}
