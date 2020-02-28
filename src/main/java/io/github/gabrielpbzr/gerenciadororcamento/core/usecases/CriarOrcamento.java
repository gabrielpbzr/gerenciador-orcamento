package io.github.gabrielpbzr.gerenciadororcamento.core.usecases;

import io.github.gabrielpbzr.gerenciadororcamento.core.OrcamentoRepository;
import io.github.gabrielpbzr.gerenciadororcamento.core.domain.Orcamento;
import io.github.gabrielpbzr.gerenciadororcamento.utils.Strings;

public class CriarOrcamento {

    private final OrcamentoRepository orcamentoRepository;

    public CriarOrcamento(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    /**
     * Cria um orcamento no sistema e retorna o identificador para o mesmo
     *
     * @param nomeOrcamento nome do orçamento a ser criado
     * @return Identificador do orçamento
     * @throws IllegalArgumentException caso o nome do orçamento seja vazio ou nulo
     * @throws RuntimeException         caso haja algum problema com a persistência do orçamento
     */
    public String criaOrcamento(String nomeOrcamento) {
        if (Strings.isNullOrEmpty(nomeOrcamento)) {
            throw new IllegalArgumentException("Um nome deve ser fornecido para identificar o orçamento");
        }

        Orcamento orcamento = new Orcamento(nomeOrcamento);
        return orcamentoRepository.salvar(orcamento);
    }
}
