package br.com.dvlm.studiohair.domain.enuns;

public enum Servico {

    CORTE(0, "CORTE"),
    PENTEADO(1, "PENTEADO"),
    TINGIMENTO(2, "TINGIMENTO"),
    MANICURE(3, "MANICURE"),
    PEDICURE(4, "PEDICURE"),
    OUTROS(5, "OUTROS");

    private Integer cod;
    private String descricao;

    Servico(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Servico toEnum(Integer cod){
        if (cod == null){
            return null;
        }
        for (Servico servico : Servico.values()){
            if (cod.equals(servico.getCod())){
                return servico;
            }
        }
        throw new IllegalArgumentException("Serviço Inválido" + cod);
    }
}
