package org.unb.tppe.infra.exception;

public class PublicacaoException extends RuntimeException {

    public PublicacaoException() {
        super("Erro ao carregar publicações. Verifique o caminho do arquivo na PublicacaoRepositoryImpl e tente novamente.");
    }

}
