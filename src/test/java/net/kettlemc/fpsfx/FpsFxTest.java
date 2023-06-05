package net.kettlemc.fpsfx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Basic tests for FpsFx.
 * Does not test the actual FPS calculation.
 */
public class FpsFxTest {

    @Test
    public void doubleSetup() {
        FpsFx fpsFx = new FpsFx();
        fpsFx.setup();
        assertThrows(IllegalStateException.class, fpsFx::setup);
    }

    @Test
    public void stopWithoutSetup() {
        FpsFx fpsFx = new FpsFx();
        assertThrows(IllegalStateException.class, fpsFx::stop);
    }

    @Test
    public void average() {
        double[] array = {1, 2, 3, 4, 5};
        assertEquals(3, FpsFx.average(array));
    }

    @Test
    public void averageWithInvalids() {
        double[] array = {1, 3, 5, -1};
        assertEquals(3, FpsFx.average(array));
    }

    @Test
    public void averageOnlyInvalids() {
        double[] array = {-1, -1};
        assertEquals(0, FpsFx.average(array));
    }

}
