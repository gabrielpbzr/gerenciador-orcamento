package io.github.gabrielpbzr.gerenciadororcamento.utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringsTest {
    @Test
    public void deveRetornarTrueQuandoForPassadaUmaStringNulaParaOMetodoIsNullOrEmpty() {
        String str = null;
        assertTrue(Strings.isNullOrEmpty(str));
    }

    @Test
    public void deveRetornarTrueQuandoForPassadaUmaStringVaziaParaOMetodoIsNullOrEmpty() {
        String str = "";
        assertTrue(Strings.isNullOrEmpty(str));
    }

    @Test
    public void deveRetornarFalseQuandoForPassadaUmaStringNaoVaziaParaOMetodoIsNullOrEmpty() {
        String str = "a";
        assertFalse(Strings.isNullOrEmpty(str));
    }
}
