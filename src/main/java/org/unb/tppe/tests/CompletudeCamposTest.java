package org.unb.tppe.tests;

import org.junit.*;
import org.unb.tppe.model.entity.Publicacao;
import org.unb.tppe.model.repository.PublicacaoRepository;
import org.unb.tppe.model.repository.PublicacaoRepositoryImpl;
import org.unb.tppe.model.util.CompletudeCamposUtil;
import org.unb.tppe.model.util.Util;

import java.util.List;
import java.util.Random;

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

    private Publicacao getRandomPublicacao() {
        return publicacoes.get(random.nextInt(publicacoes.size()));
    }
}

