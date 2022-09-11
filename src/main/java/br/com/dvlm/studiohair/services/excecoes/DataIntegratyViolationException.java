package br.com.dvlm.studiohair.services.excecoes;

public class DataIntegratyViolationException extends RuntimeException {


    private static final long serialVersionUID = -262788456467236946L;

    public DataIntegratyViolationException(String message) {
        super(message);
    }

    public DataIntegratyViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
