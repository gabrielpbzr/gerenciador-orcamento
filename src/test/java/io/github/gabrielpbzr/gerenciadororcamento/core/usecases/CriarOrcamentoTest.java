package io.github.gabrielpbzr.gerenciadororcamento.core.usecases;

import io.github.gabrielpbzr.gerenciadororcamento.core.InMemoryOrcamentoRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CriarOrcamentoTest {

    private CriarOrcamento criarOrcamentoUseCase;

    @Before
    public void setup() {
        criarOrcamentoUseCase = new CriarOrcamento(new InMemoryOrcamentoRepository());
    }

    @Test
    public void deveCriarUmOrcamentoQuandoFornecidoONomeValidoParaOMesmo() {
        final String nomeOrcamento = "Orçamento 1";
        String orcamentoId = criarOrcamentoUseCase.criaOrcamento(nomeOrcamento);

        assertNotNull(orcamentoId);
        assertFalse(orcamentoId.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarUmaExcecaoQuandoNaoForFornecidoUmNomeParaOOrcamento() {
        criarOrcamentoUseCase.criaOrcamento(null);
        fail("O teste deveria ter lançado uma exceção para o nome nulo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarUmaExcecaoQuandoForFornecidoUmNomeVazioParaOOrcamento() {
        final String nomeOrcamento = "";
        criarOrcamentoUseCase.criaOrcamento(nomeOrcamento);
        fail("O teste deveria ter lançado uma exceção para o nome nulo");
    }

}
