package io.github.gabrielpbzr.gerenciadororcamento.core.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class OrcamentoTest {
    private static final String NOME_ORCAMENTO = "Orçamento Teste";
    @Test
    public void deveIniciarUmOrcamentoComTotalZero() {
        Orcamento orcamento = new Orcamento(NOME_ORCAMENTO);

        assertEquals(NOME_ORCAMENTO, orcamento.getDescricao());
        assertEquals(BigDecimal.valueOf(0.0), orcamento.getTotal());
    }

    @Test
    public void aoLancarUmaDespesaOValorDeveSerSubtraidoDoTotalDoOrcamento() {
        Orcamento orcamento = new Orcamento(NOME_ORCAMENTO);
        orcamento.lancaDespesa(LocalDate.now(), "Luz", BigDecimal.valueOf(95.86));
        assertEquals(BigDecimal.valueOf(-95.86), orcamento.getTotal());
    }

    @Test
    public void aoLancarUmaReceitaOValorDeveSerAdicionadoAoTotalDoOrcamento() {
        Orcamento orcamento = new Orcamento(NOME_ORCAMENTO);
        orcamento.lancaReceita(LocalDate.now(), "Salario", BigDecimal.valueOf(1950.36));
        assertEquals(BigDecimal.valueOf(1950.36), orcamento.getTotal());
    }
}
