package com.ufr.mim.angryballs.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class ColorFormTest {

    @Test
    void testWhite() {
        assertTrue("#FFFFFF".equalsIgnoreCase(Color.WHITE.getHexadecimal()));
        assertEquals(255, Color.WHITE.getRed());
        assertEquals(255, Color.WHITE.getGreen());
        assertEquals(255, Color.WHITE.getBlue());
        assertEquals(255, Color.WHITE.getAlpha());
    }

    @Test
    void testBlack() {
        assertTrue("#000000".equalsIgnoreCase(Color.BLACK.getHexadecimal()));
        assertEquals(0, Color.BLACK.getRed());
        assertEquals(0, Color.BLACK.getGreen());
        assertEquals(0, Color.BLACK.getBlue());
        assertEquals(255, Color.BLACK.getAlpha());
    }

    @Test
    void testYellow() {
        assertTrue("#FFF300".equalsIgnoreCase(Color.YELLOW.getHexadecimal()));
        assertEquals(255, Color.YELLOW.getRed());
        assertEquals(243, Color.YELLOW.getGreen());
        assertEquals(0, Color.YELLOW.getBlue());
        assertEquals(255, Color.YELLOW.getAlpha());
    }

    @Test
    void testBlue() {
        assertTrue("#00D8FF".equalsIgnoreCase(Color.BLUE.getHexadecimal()));
        assertEquals(0, Color.BLUE.getRed());
        assertEquals(216, Color.BLUE.getGreen());
        assertEquals(255, Color.BLUE.getBlue());
        assertEquals(255, Color.BLUE.getAlpha());
    }

    @Test
    void testRed() {
        assertTrue("#F33535".equalsIgnoreCase(Color.RED.getHexadecimal()));
        assertEquals(243, Color.RED.getRed());
        assertEquals(53, Color.RED.getGreen());
        assertEquals(53, Color.RED.getBlue());
        assertEquals(255, Color.RED.getAlpha());
    }

    @Test
    void testPurple() {
        assertTrue("#B735F3".equalsIgnoreCase(Color.PURPLE.getHexadecimal()));
        assertEquals(183, Color.PURPLE.getRed());
        assertEquals(53, Color.PURPLE.getGreen());
        assertEquals(243, Color.PURPLE.getBlue());
        assertEquals(255, Color.PURPLE.getAlpha());
    }

    @Test
    void testOrange() {
        assertTrue("#FF4D00".equalsIgnoreCase(Color.ORANGE.getHexadecimal()));
        assertEquals(255, Color.ORANGE.getRed());
        assertEquals(77, Color.ORANGE.getGreen());
        assertEquals(0, Color.ORANGE.getBlue());
        assertEquals(255, Color.ORANGE.getAlpha());
    }

    @Test
    void testGreen() {
        assertTrue("#1CD52D".equalsIgnoreCase(Color.GREEN.getHexadecimal()));
        assertEquals(28, Color.GREEN.getRed());
        assertEquals(213, Color.GREEN.getGreen());
        assertEquals(45, Color.GREEN.getBlue());
        assertEquals(255, Color.GREEN.getAlpha());
    }

    @Test
    void testBeige() {
        assertTrue("#D58F1C".equalsIgnoreCase(Color.BEIGE.getHexadecimal()));
        assertEquals(213, Color.BEIGE.getRed());
        assertEquals(143, Color.BEIGE.getGreen());
        assertEquals(28, Color.BEIGE.getBlue());
        assertEquals(255, Color.BEIGE.getAlpha());
    }
}