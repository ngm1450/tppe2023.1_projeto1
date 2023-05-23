package org.unb.tppe.infra.exception;

public class PublicacaoException extends Exception {

    public PublicacaoException() {
        super("Erro ao carregar publicações. Verifique o caminho do arquivo e tente novamente.");
    }

}
