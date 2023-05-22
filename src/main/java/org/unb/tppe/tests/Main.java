package org.unb.tppe.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.unb.tppe.model.entity.Publicacao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String extratoFiocruzPath = Paths.get("")
                                         .toAbsolutePath()
                                         .toString()
                                         .concat("\\src\\main\\java\\org\\unb\\tppe\\data\\extrato_fiocruz.json");
        File extratoFiocruz = new File(extratoFiocruzPath);
        try {
            Publicacao[] publicacoes = objectMapper.readValue(extratoFiocruz, Publicacao[].class);
            for (Publicacao publicacao : publicacoes) {
                System.out.println(publicacao.getTitulo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}