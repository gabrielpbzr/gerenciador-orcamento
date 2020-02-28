package io.github.gabrielpbzr.gerenciadororcamento.core;

import io.github.gabrielpbzr.gerenciadororcamento.core.domain.Orcamento;

import java.util.List;
import java.util.Optional;

public interface OrcamentoRepository {
    /**
     * Busca um orcamento pelo seu identificador
     *
     * @param id identificador do orçamento
     * @return Um optional contendo o orçamento com o identificador fornecido ou vazio caso não o encontre
     */
    Optional<Orcamento> getById(String id);

    /**
     * Retorna uma lista com os orçamentos armazenados no repositório
     *
     * @return orçamentos armazenados no repositório
     */
    List<Orcamento> getOrcamentos();

    /**
     * Salva um orcamento e retorna o ID gerado para o mesmo
     *
     * @param orcamento Uma instância de orçamento a ser persistida
     * @return Identificador único gerado para o mesmo
     */
    String salvar(Orcamento orcamento);
}
