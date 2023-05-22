package org.unb.tppe.tests;

import org.junit.*;
import org.unb.tppe.model.entity.Autor;
import org.unb.tppe.model.entity.JournalPublicacao;
import org.unb.tppe.model.entity.Publicacao;
import org.unb.tppe.model.repository.PublicacaoRepositoryImpl;
import org.unb.tppe.model.util.CompletudeCamposUtil;
import org.unb.tppe.model.util.CompletudeRegistrosUtil;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompletudeCamposTest {

    private List<Publicacao> publicacoes;

    private Random random;

    @Before
    public void initialize() {
        publicacoes = new PublicacaoRepositoryImpl().findAll();
        random = new Random();
    }

    @Test
    public void testCompletudeCamposOrExclusivo() {
        assertTrue(CompletudeCamposUtil.calcularCompletudeCamposOrExclusivo(getRandomPublicacao()));
    }

    @Test
    public void testCompletudeRegistrosMultiCampos() {
        Autor autor = Autor.builder()
                            .nome("João da Silva")
                            .ordemAutoria("1")
                            .identificadorLattes("1234567890")
                            .nacionalidade("Brasileiro")
                            .cidadeNascimento("Brasília")
                            .estadoNascimento("DF")
                            .paisNascimento("Brasil")
                            .build();

        JournalPublicacao journal = JournalPublicacao.builder()
                .issn("12345678")
                .nome("Nome do Journal")
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
                .journalPublicacao(journal)
                .autores(Collections.singletonList(autor))
                .build();

        assertFalse(CompletudeRegistrosUtil.calcularCompletudeRegistrosMultiCampos(publicacao));
    }

    private Publicacao getRandomPublicacao() {
        return publicacoes.get(random.nextInt(publicacoes.size()));
    }
}

