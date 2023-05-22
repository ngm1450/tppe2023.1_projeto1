package org.unb.tppe.model.repository;

import org.unb.tppe.model.entity.Publicacao;

import java.util.List;

public interface PublicacaoRepository {

    List<Publicacao> findAll();
}
