package io.github.gabrielpbzr.gerenciadororcamento.utils;

public final class Strings {
    private Strings() {
        // Para esconder o construtor padrao
    }
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }
}
