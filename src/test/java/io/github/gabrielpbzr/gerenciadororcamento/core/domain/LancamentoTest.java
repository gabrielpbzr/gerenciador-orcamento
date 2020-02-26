package io.github.gabrielpbzr.gerenciadororcamento.core.domain;

import org.junit.Test;

import io.github.gabrielpbzr.gerenciadororcamento.core.domain.Lancamento.Tipo;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class LancamentoTest {
    @Test
    public void deveInicializarUmLancamentoComADataAtualCasoAMesmaNaoSejaInformada() {
        Lancamento l = new Lancamento("Teste", BigDecimal.valueOf(9.99), Lancamento.Tipo.DESPESA);
        
        assertEquals(LocalDate.now(), l.getData());
        assertEquals("Teste", l.getDescricao());
        assertEquals(BigDecimal.valueOf(9.99), l.getValor());
        assertEquals(Lancamento.Tipo.DESPESA, l.getTipo());
        assertNull(l.getLancamentoID());
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
        new Lancamento(LocalDate.now(), descricao, BigDecimal.valueOf(99.99), Lancamento.Tipo.DESPESA);
        fail("A descrição do lançamento não pode ser nula");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoSeUmaDescricaoVaziaForInformada() {
        String descricao = "";
        new Lancamento(descricao, BigDecimal.valueOf(99.99), Lancamento.Tipo.DESPESA);
        new Lancamento(LocalDate.now(), descricao, BigDecimal.valueOf(99.99), Lancamento.Tipo.DESPESA);
        fail("A descrição do lançamento não pode ser nula");
    }

    @Test
    public void deveCompararComoIguaisDoisLancamentosComOMesmoId() {
        Lancamento l1 = new Lancamento("Lancamento 1", BigDecimal.valueOf(9.99), Tipo.DESPESA);
        l1.setLancamentoID("1");
        Lancamento l2 = new Lancamento("Lancamento 1", BigDecimal.valueOf(9.99), Tipo.DESPESA);
        l2.setLancamentoID("1");

        assertEquals(l1, l2);
    }

    @Test
    public void deveCompararComoIgualOProprioObjeto() {
        Lancamento l1 = new Lancamento("Lancamento 1", BigDecimal.valueOf(9.99), Tipo.DESPESA);
        l1.setLancamentoID("1");
        
        assertEquals(l1, l1);
    }
}
