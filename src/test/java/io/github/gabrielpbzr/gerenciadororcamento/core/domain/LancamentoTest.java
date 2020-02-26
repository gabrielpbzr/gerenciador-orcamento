package io.github.gabrielpbzr.gerenciadororcamento.core.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class LancamentoTest {
    @Test
    public void deveInicializarUmLancamentoComADataAtualCasoAMesmaNaoSejaInformada() {
        Lancamento l = new Lancamento("Teste", BigDecimal.valueOf(9.99), Lancamento.Tipo.DESPESA);
        assertEquals(LocalDate.now(), l.getData());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeUmaDataNulaForInformada() {
        String descricao = "Lançamento sem data";
        new Lancamento(null, descricao, BigDecimal.valueOf(99.99), Lancamento.Tipo.DESPESA);
        fail("A data do lançamento não pode ser nula");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeUmaDescricaoNulaForInformada() {
        String descricao = null;
        new Lancamento(descricao, BigDecimal.valueOf(99.99), Lancamento.Tipo.DESPESA);
        fail("A descrição do lançamento não pode ser nula");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeUmaDescricaoVaziaForInformada() {
        String descricao = "";
        new Lancamento(descricao, BigDecimal.valueOf(99.99), Lancamento.Tipo.DESPESA);
        fail("A descrição do lançamento não pode ser nula");
    }
}
