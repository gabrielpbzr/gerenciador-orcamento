package io.github.gabrielpbzr.gerenciadororcamento;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp()
    {
        App.logger = LoggerFactory.getLogger("TestLogger");
        App.main(null);
        assertTrue( true );
    }
}
