package org.unb.tppe.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Publicacao {

    @JsonProperty("identifier.doi")
    private String doi;

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("language")
    private String idioma;

    @JsonProperty("publicationDate")
    private String dataPublicacao;

    @JsonProperty("volume")
    private String volume;

    @JsonProperty("series")
    private String series;

    @JsonProperty("startPage")
    private String paginaInicio;

    @JsonProperty("endPage")
    private String paginaFim;

    @JsonProperty("type")
    private String tipo;

    @JsonProperty("keyword")
    private List<String> palavrasChave;

    @JsonProperty("researchArea.cnpq")
    private List<String> areasPesquisaCnpq;

    @JsonProperty("resourceUrl")
    private String urlRecurso;

    @JsonProperty("PublisherJournal")
    private JournalPublicacao journalPublicacao;

    @JsonProperty("authors")
    private List<Autor> autores;

}
