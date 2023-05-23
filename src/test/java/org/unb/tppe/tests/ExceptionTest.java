package org.unb.tppe.tests;

import org.junit.jupiter.api.Test;
import org.unb.tppe.model.entity.JournalPublicacao;
import org.unb.tppe.model.entity.Publicacao;
import org.unb.tppe.model.util.CompletudeCamposUtil;
import org.unb.tppe.model.util.CompletudeRegistrosUtil;
import org.unb.tppe.model.util.Util;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @Test
    public void testExceptionThrownWhenAutorIsNull() {
        Publicacao publicacao = getPublicacaoPreenchida();
        publicacao.setJournalPublicacao(new JournalPublicacao());
        publicacao.setSeries(Util.getDummyString());
        publicacao.setPalavrasChave(Collections.singletonList(Util.getDummyString()));
        publicacao.setAreasPesquisaCnpq(Collections.singletonList(Util.getDummyString()));
        publicacao.setUrlRecurso(Util.getDummyString());
        assertThrows(NullPointerException.class, () -> CompletudeRegistrosUtil.calcularCompletudeRegistrosMultiCampos(publicacao));
    }

    @Test
    public void testExceptionThrownWhenJournalPublicacaoIsNull() {
        assertThrows(NullPointerException.class, () -> CompletudeCamposUtil.calcularCompletudeCamposOrExclusivo(null));
    }

    private Publicacao getPublicacaoPreenchida() {
        return Publicacao.builder()
                .doi("10.123/abc")
                .titulo("Título do Artigo")
                .idioma("Português")
                .dataPublicacao("2022-01-01")
                .volume("10")
                .paginaInicio("1")
                .paginaFim("10")
                .tipo("Artigo Científico")
                .build();
    }

}
