package br.com.dvlm.studiohair.domain;

public class Cliente extends Pessoa{

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String telefone, String email) {
        super(id, nome, cpf, telefone, email);
    }
}
