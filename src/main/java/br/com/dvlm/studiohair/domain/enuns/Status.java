package br.com.dvlm.studiohair.domain.enuns;

public enum Status {

    ABERTO(0, "ABERTO"),
    ENCERRADO(1, "ENCERRADO"),
    CANCELADO(2, "CANCELADO");

    private Integer cod;
    private String status;

    Status(Integer cod, String status) {
        this.cod = cod;
        this.status = status;
    }

    public Integer getCod() {
        return cod;
    }

    public String getStatus() {
        return status;
    }

    public static Status toEnum(Integer cod){

        if (cod == null){
            return null;
        }

        for (Status status1 : Status.values()){
            if (cod.equals(status1.getCod())){
                return status1;
            }
        }
        throw new IllegalArgumentException("Status inválido! "+ cod);
    }
}
