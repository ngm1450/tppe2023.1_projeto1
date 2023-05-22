package org.unb.tppe.model.util;

import org.unb.tppe.model.entity.Autor;
import org.unb.tppe.model.entity.Publicacao;

import java.util.List;


public class CompletudeRegistrosUtil {

    public static boolean calcularCompletudeRegistrosMultiCampos(Publicacao publicacao) {
        // Verifica se todos os campos do objeto Publicacao estão presentes
        if (publicacao.getDoi() != null
            && publicacao.getTitulo() != null
            && publicacao.getIdioma() != null
            && publicacao.getDataPublicacao() != null
            && publicacao.getVolume() != null
            && publicacao.getSeries() != null
            && publicacao.getPaginaInicio() != null
            && publicacao.getPaginaFim() != null
            && publicacao.getTipo() != null
            && publicacao.getPalavrasChave() != null
            && publicacao.getAreasPesquisaCnpq() != null
            && publicacao.getUrlRecurso() != null
            && publicacao.getJournalPublicacao() != null
            && publicacao.getAutores() != null) {

            List<Autor> autores = publicacao.getAutores();
            for (Autor autor : autores) {
                if (!isAutorCompleto(autor)) {
                    return false;
                }
            }
            return true;

        }
        return false;
    }

    private static boolean isAutorCompleto(Autor autor) {
        // Verifica se pelo menos um dos campos do objeto Autor está presente
        return  autor.getNome() != null
                || autor.getOrdemAutoria() != null
                || autor.getNomesCitacao() != null
                || autor.getIdentificadorLattes() != null
                || autor.getIdentificadorOrcid() != null
                || autor.getNacionalidade() != null
                || autor.getCidadeNascimento() != null
                || autor.getEstadoNascimento() != null
                || autor.getPaisNascimento() != null
                || autor.getAreasPesquisa() != null
                || autor.getMiniBiografia() != null
                || autor.getMiniBiografiaIngles() != null;
    }



}
