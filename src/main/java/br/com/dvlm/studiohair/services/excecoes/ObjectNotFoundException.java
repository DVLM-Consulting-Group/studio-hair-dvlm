package br.com.dvlm.studiohair.services.excecoes;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -755217894726769944L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
