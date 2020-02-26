package io.github.gabrielpbzr.gerenciadororcamento.core.domain;

import io.github.gabrielpbzr.gerenciadororcamento.utils.Strings;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Lancamento {
    public enum Tipo {
        RECEITA,
        DESPESA
    }

    private String lancamentoID;
    private String descricao;
    private LocalDate data;
    private BigDecimal valor;
    private Tipo tipo;

    Lancamento(String descricao, BigDecimal valor, Tipo tipo) {
        if (Strings.isNullOrEmpty(descricao)) {
            throw new IllegalArgumentException("Descrição não informada");
        }

        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.data = LocalDate.now();
    }

    Lancamento(LocalDate data, String descricao, BigDecimal valor, Tipo tipo) {
        this(descricao, valor, tipo);
        if (data == null) {
            throw new IllegalArgumentException("Data do lançamento não informado");
        }
        this.data = data;
    }

    public void setLancamentoID(String lancamentoID) {
        this.lancamentoID = lancamentoID;
    }

    public String getLancamentoID() {
        return lancamentoID;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return this.data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lancamento)) return false;
        Lancamento that = (Lancamento) o;
        return Objects.equals(lancamentoID, that.lancamentoID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lancamentoID);
    }
}
