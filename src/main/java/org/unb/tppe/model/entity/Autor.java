package org.unb.tppe.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Autor {

    @JsonProperty("name")
    private String nome;

    @JsonProperty("ordemAutoria")
    private String ordemAutoria;

    @JsonProperty("citationName")
    private List<String> nomesCitacao;

    @JsonProperty("identifier.lattes")
    private String identificadorLattes;

    @JsonProperty("identifier.orcid")
    private String identificadorOrcid;

    @JsonProperty("nationality")
    private String nacionalidade;

    @JsonProperty("birthCity")
    private String cidadeNascimento;

    @JsonProperty("birthState")
    private String estadoNascimento;

    @JsonProperty("birthCountry")
    private String paisNascimento;

    @JsonProperty("researchArea")
    private List<String> areasPesquisa;

    @JsonProperty("miniBiography")
    private String miniBiografia;

    @JsonProperty("miniBiography_eng")
    private String miniBiografiaIngles;

}
