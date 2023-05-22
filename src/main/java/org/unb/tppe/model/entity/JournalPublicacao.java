package org.unb.tppe.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JournalPublicacao {

    @JsonProperty("identifier.issn")
    private String issn;

    @JsonProperty("title")
    private String nome;

}