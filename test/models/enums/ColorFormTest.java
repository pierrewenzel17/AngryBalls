package models.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorFormTest {

    @Test
    void testWhite() {
        assertTrue("#FFFFFF".equalsIgnoreCase(ColorForm.WHITE.getHexadecimal()));
        assertEquals(255, ColorForm.WHITE.getRed());
        assertEquals(255, ColorForm.WHITE.getGreen());
        assertEquals(255, ColorForm.WHITE.getBlue());
        assertEquals(255, ColorForm.WHITE.getAlpha());
    }

    @Test
    void testBlack() {
        assertTrue("#000000".equalsIgnoreCase(ColorForm.BLACK.getHexadecimal()));
        assertEquals(0, ColorForm.BLACK.getRed());
        assertEquals(0, ColorForm.BLACK.getGreen());
        assertEquals(0, ColorForm.BLACK.getBlue());
        assertEquals(255, ColorForm.BLACK.getAlpha());
    }

    @Test
    void testYellow() {
        assertTrue("#FFF300".equalsIgnoreCase(ColorForm.YELLOW.getHexadecimal()));
        assertEquals(255, ColorForm.YELLOW.getRed());
        assertEquals(243, ColorForm.YELLOW.getGreen());
        assertEquals(0, ColorForm.YELLOW.getBlue());
        assertEquals(255, ColorForm.YELLOW.getAlpha());
    }

    @Test
    void testBlue() {
        assertTrue("#00D8FF".equalsIgnoreCase(ColorForm.BLUE.getHexadecimal()));
        assertEquals(0, ColorForm.BLUE.getRed());
        assertEquals(216, ColorForm.BLUE.getGreen());
        assertEquals(255, ColorForm.BLUE.getBlue());
        assertEquals(255, ColorForm.BLUE.getAlpha());
    }

    @Test
    void testRed() {
        assertTrue("#F33535".equalsIgnoreCase(ColorForm.RED.getHexadecimal()));
        assertEquals(243, ColorForm.RED.getRed());
        assertEquals(53, ColorForm.RED.getGreen());
        assertEquals(53, ColorForm.RED.getBlue());
        assertEquals(255, ColorForm.RED.getAlpha());
    }

    @Test
    void testPurple() {
        assertTrue("#B735F3".equalsIgnoreCase(ColorForm.PURPLE.getHexadecimal()));
        assertEquals(183, ColorForm.PURPLE.getRed());
        assertEquals(53, ColorForm.PURPLE.getGreen());
        assertEquals(243, ColorForm.PURPLE.getBlue());
        assertEquals(255, ColorForm.PURPLE.getAlpha());
    }

    @Test
    void testOrange() {
        assertTrue("#FF4D00".equalsIgnoreCase(ColorForm.ORANGE.getHexadecimal()));
        assertEquals(255, ColorForm.ORANGE.getRed());
        assertEquals(77, ColorForm.ORANGE.getGreen());
        assertEquals(0, ColorForm.ORANGE.getBlue());
        assertEquals(255, ColorForm.ORANGE.getAlpha());
    }

    @Test
    void testGreen() {
        assertTrue("#1CD52D".equalsIgnoreCase(ColorForm.GREEN.getHexadecimal()));
        assertEquals(28, ColorForm.GREEN.getRed());
        assertEquals(213, ColorForm.GREEN.getGreen());
        assertEquals(45, ColorForm.GREEN.getBlue());
        assertEquals(255, ColorForm.GREEN.getAlpha());
    }

    @Test
    void testBeige() {
        assertTrue("#D58F1C".equalsIgnoreCase(ColorForm.BEIGE.getHexadecimal()));
        assertEquals(213, ColorForm.BEIGE.getRed());
        assertEquals(143, ColorForm.BEIGE.getGreen());
        assertEquals(28, ColorForm.BEIGE.getBlue());
        assertEquals(255, ColorForm.BEIGE.getAlpha());
    }
}