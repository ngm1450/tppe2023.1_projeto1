package org.unb.tppe.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.unb.tppe.infra.exception.PublicacaoException;
import org.unb.tppe.model.entity.Autor;
import org.unb.tppe.model.entity.JournalPublicacao;
import org.unb.tppe.model.entity.Publicacao;
import org.unb.tppe.model.repository.PublicacaoRepositoryImpl;
import org.unb.tppe.model.util.CompletudeCamposUtil;
import org.unb.tppe.model.util.CompletudeRegistrosUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class CompletudeCamposTest {
    static List<Publicacao> publicacoes;
    private static final Random random = new Random();

    @ParameterizedTest
    @MethodSource("getPublicacoesForCompletudeCamposOrExclusivo")
    public void testCompletudeCamposOrExclusivo(Publicacao publicacao) {
        Assertions.assertTrue(CompletudeCamposUtil.calcularCompletudeCamposOrExclusivo(publicacao));
    }

    @ParameterizedTest
    @MethodSource("getPublicacoesForCompletudeCamposOrExclusivo2")
    public void testCompletudeCamposOrExclusivo2(Publicacao publicacao) {
        Assertions.assertFalse(CompletudeCamposUtil.calcularCompletudeCamposOrExclusivo(publicacao));
    }

    @ParameterizedTest
    @MethodSource("getPublicacoesForCompletudeCamposOrExclusivo3")
    public void testCompletudeCamposOrExclusivo3(Publicacao publicacao) {
        Assertions.assertTrue(CompletudeCamposUtil.calcularCompletudeCamposOrExclusivo(publicacao));
    }

    @ParameterizedTest
    @MethodSource("getPublicacoesForCompletudeRegistrosMultiCampos")
    public void testCompletudeRegistrosMultiCampos(Publicacao publicacao, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, CompletudeRegistrosUtil.calcularCompletudeRegistrosMultiCampos(publicacao));
    }

    private static Stream<Publicacao> getPublicacoesForCompletudeCamposOrExclusivo() {
        return Stream.of(
                getRandomPublicacao(),
                Publicacao.builder().paginaFim("Número página fim").build(),
                Publicacao.builder().titulo("Título do Artigo").build()
        );
    }

    private static Stream<Publicacao> getPublicacoesForCompletudeCamposOrExclusivo2() {
        return Stream.of(
                new Publicacao()
        );
    }

    private static Stream<Publicacao> getPublicacoesForCompletudeCamposOrExclusivo3() {
        return Stream.of(
                Publicacao.builder().titulo("Título do Artigo").build()
        );
    }

    private static Stream<Arguments> getPublicacoesForCompletudeRegistrosMultiCampos() {
        Autor autor1 = Autor.builder()
                .nome("João da Silva")
                .ordemAutoria("1")
                .identificadorLattes("1234567890")
                .nacionalidade("Brasileiro")
                .cidadeNascimento("Brasília")
                .estadoNascimento("DF")
                .paisNascimento("Brasil")
                .build();

        JournalPublicacao journal1 = JournalPublicacao.builder()
                .issn("12345678")
                .nome("Nome do Journal")
                .build();

        Publicacao publicacao1 = Publicacao.builder()
                .doi("10.123/abc")
                .titulo("Título do Artigo")
                .idioma("Português")
                .dataPublicacao("2022-01-01")
                .volume("10")
                .paginaInicio("1")
                .paginaFim("10")
                .tipo("Artigo Científico")
                .journalPublicacao(journal1)
                .autores(Collections.singletonList(autor1))
                .build();

        Autor autor2 = Autor.builder()
                .nome("João da Silva")
                .identificadorLattes("1234567890")
                .nacionalidade("Brasileiro")
                .cidadeNascimento("Brasília")
                .estadoNascimento("DF")
                .paisNascimento("Brasil")
                .build();

        JournalPublicacao journal2 = JournalPublicacao.builder()
                .issn("12345678")
                .nome("Nome do Journal")
                .build();

        Publicacao publicacao2 = Publicacao.builder()
                .doi("10.123/abc")
                .titulo("Título do Artigo")
                .idioma("Português")
                .dataPublicacao("2022-01-01")
                .volume("10")
                .paginaInicio("1")
                .paginaFim("10")
                .tipo("Artigo Científico")
                .journalPublicacao(journal2)
                .autores(Collections.singletonList(autor2))
                .build();

        Autor autor3 = Autor.builder()
                .nome("João da Silva")
                .nacionalidade("Brasileiro")
                .cidadeNascimento("Brasília")
                .estadoNascimento("DF")
                .paisNascimento("Brasil")
                .build();

        JournalPublicacao journal3 = JournalPublicacao.builder()
                .issn("12345678")
                .nome("Nome do Journal")
                .build();

        Publicacao publicacao3 = Publicacao.builder()
                .doi("10.123/abc")
                .titulo("Título do Artigo")
                .idioma("Português")
                .dataPublicacao("2022-01-01")
                .volume("10")
                .paginaInicio("1")
                .paginaFim("10")
                .tipo("Artigo Científico")
                .journalPublicacao(journal3)
                .autores(Collections.singletonList(autor3))
                .build();

        return Stream.of(
                Arguments.of(publicacao1, false),
                Arguments.of(publicacao2, false),
                Arguments.of(publicacao3, false)
        );
    }

    private static Publicacao getRandomPublicacao() {
        if (publicacoes == null || publicacoes.isEmpty()) {
            try {
                publicacoes = new PublicacaoRepositoryImpl().findAll();
            } catch (IOException e) {
                throw new PublicacaoException();
            }
        }
        int randomIndex = random.nextInt(publicacoes.size());
        return publicacoes.get(randomIndex);
    }
}

