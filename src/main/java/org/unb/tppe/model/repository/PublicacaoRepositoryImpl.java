package org.unb.tppe.model.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.unb.tppe.model.entity.Publicacao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PublicacaoRepositoryImpl implements PublicacaoRepository {

    @Override
    public List<Publicacao> findAll() throws IOException {
        List<Publicacao> publicacoes;
        ObjectMapper objectMapper = new ObjectMapper();
        String extratoFiocruzPath = Paths.get("")
                                         .toAbsolutePath()
                                         .toString()
                                         .concat("\\src\\main\\java\\org\\unb\\tppe\\data\\extrato_fiocruz.json");
        File extratoFiocruz = new File(extratoFiocruzPath);
        publicacoes = new ArrayList<>(List.of(objectMapper.readValue(extratoFiocruz, Publicacao[].class)));
        return publicacoes;
    }
}
