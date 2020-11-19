package com.ufr.mim.angryballs.core.models;

/**
 * Énumérations des couleurs possible pour le back-end
 * @author Pierre Wenzel
 */
public enum Color {

    WHITE(16777215),
    BLACK(0),
    YELLOW(16773888),
    BLUE(55551),
    RED(15938869),
    PURPLE( 12006899),
    ORANGE(16731392),
    GREEN(1889581),
    BEIGE( 13995804);

    private final int rgb;

    Color(int rgb) { this.rgb = 0xff000000 | rgb; }

    public int getRGB() { return rgb; }

    public int getRed() { return (getRGB() >> 16) & 0xFF; }

    public int getBlue() { return (getRGB()) & 0xFF; }

    public int getGreen() { return (getRGB() >> 8) & 0xFF; }

    public int getAlpha() { return (getRGB() >> 24) & 0xff; }

    public String getHexadecimal() { return String.format( "#%02x%02x%02x", getRed(), getGreen(), getBlue()); }

    @Override
    public String toString() {
        return "ColorForm{" +
                "RGB=" + rgb +
                "RED=" + getRed() +
                "BLUE=" + getBlue() +
                "GREEN=" + getGreen() +
                "HEXADECIMAL=" + getHexadecimal() +
                '}';
    }
}
