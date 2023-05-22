package org.unb.tppe.infra.exception;

import java.io.IOException;

public class PublicacaoException extends IOException {

    public PublicacaoException() {
        super("Erro ao carregar publicações. Verifique o caminho do arquivo e tente novamente.");
    }

}
