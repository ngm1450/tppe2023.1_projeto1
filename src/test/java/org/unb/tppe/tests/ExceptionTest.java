package org.unb.tppe.tests;

import org.junit.jupiter.api.Test;
import org.unb.tppe.model.entity.Autor;
import org.unb.tppe.model.entity.Publicacao;
import org.unb.tppe.model.util.CompletudeRegistrosUtil;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @Test
    public void testExceptionThrownWhenAutorIsNull() {
        assertThrows(NullPointerException.class, () -> CompletudeRegistrosUtil.calcularCompletudeRegistrosMultiCampos(new Publicacao()));
    }

    @Test
    public void testExceptionThrownWhenJournalPublicacaoIsNull() {
        Autor autor = Autor.builder()
                .nome("João da Silva")
                .nacionalidade("Brasileiro")
                .cidadeNascimento("Brasília")
                .estadoNascimento("DF")
                .paisNascimento("Brasil")
                .build();

        Publicacao publicacao = Publicacao.builder()
                .doi("10.123/abc")
                .titulo("Título do Artigo")
                .idioma("Português")
                .dataPublicacao("2022-01-01")
                .volume("10")
                .paginaInicio("1")
                .paginaFim("10")
                .tipo("Artigo Científico")
                .autores(Collections.singletonList(autor))
                .build();

        assertThrows(NullPointerException.class, () -> CompletudeRegistrosUtil.calcularCompletudeRegistrosMultiCampos(publicacao));
    }

}
