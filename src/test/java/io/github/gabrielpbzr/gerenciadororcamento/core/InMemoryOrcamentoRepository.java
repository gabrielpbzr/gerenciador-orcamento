package io.github.gabrielpbzr.gerenciadororcamento.core;

import io.github.gabrielpbzr.gerenciadororcamento.core.domain.Orcamento;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryOrcamentoRepository implements OrcamentoRepository {
    private final HashMap<String, Orcamento> orcamentos;

    public InMemoryOrcamentoRepository() {
        this.orcamentos = new HashMap<>();
    }

    @Override
    public Optional<Orcamento> getById(String id) {
        Orcamento orcamento = orcamentos.get(id);
        if (orcamento == null) {
            return Optional.empty();
        }
        return Optional.of(orcamento);
    }

    @Override
    public List<Orcamento> getOrcamentos() {
        return (List<Orcamento>) orcamentos.values();
    }

    @Override
    public String salvar(Orcamento orcamento) {
        if (orcamentos.containsKey(orcamento.getOrcamentoID())) {
            this.orcamentos.put(orcamento.getOrcamentoID(), orcamento);
            return orcamento.getOrcamentoID();
        }
        String id = UUID.randomUUID().toString();
        orcamento.setOrcamentoID(id);
        orcamentos.put(id, orcamento);

        return id;
    }
}
