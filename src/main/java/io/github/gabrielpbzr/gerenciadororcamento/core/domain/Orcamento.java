package io.github.gabrielpbzr.gerenciadororcamento.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Orcamento {
    private String orcamentoID;
    private String descricao;
    private final Set<Lancamento> lancamentos;
    private BigDecimal total;

    public Orcamento(String descricao) {
        this.descricao = descricao;
        this.lancamentos = new HashSet<>();
        this.total = BigDecimal.valueOf(0.0);
    }

    public Orcamento(String orcamentoID, String descricao, Set<Lancamento> lancamentos, BigDecimal total) {
        this.orcamentoID = orcamentoID;
        this.descricao = descricao;
        this.lancamentos = lancamentos;
        this.total = total;
    }

    public String getOrcamentoID() {
        return orcamentoID;
    }

    public void setOrcamentoID(String orcamentoID) {
        this.orcamentoID = orcamentoID;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void lancaDespesa(LocalDate data, String descricao, BigDecimal valor) {
        Lancamento lancamento = new Lancamento(data, descricao, valor, Lancamento.Tipo.DESPESA);
        this.lancamentos.add(lancamento);
        atualizaTotal();
    }

    public void lancaReceita(LocalDate data, String descricao, BigDecimal valor) {
        Lancamento lancamento = new Lancamento(data, descricao, valor, Lancamento.Tipo.RECEITA);
        this.lancamentos.add(lancamento);
        atualizaTotal();
    }

    private void atualizaTotal() {
        this.total = BigDecimal.ZERO;
        this.lancamentos.forEach(lancamento -> {
            if (lancamento.getTipo() == Lancamento.Tipo.DESPESA) {
                total = total.subtract(lancamento.getValor());
                return;
            }
            total = total.add(lancamento.getValor());
        });
    }
}
