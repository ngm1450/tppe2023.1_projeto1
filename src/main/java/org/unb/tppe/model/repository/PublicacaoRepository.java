package org.unb.tppe.model.repository;

import org.unb.tppe.model.entity.Publicacao;

import java.io.IOException;
import java.util.List;

public interface PublicacaoRepository {

    List<Publicacao> findAll() throws IOException;
}
