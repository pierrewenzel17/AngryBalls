package com.ufr.mim.angryballs.core.models;

/**
 * Énumérations des couleurs possible pour le back-end
 * @author Pierre Wenzel
 */
public enum Color {

    WHITE(16777215, "blanc"),
    BLACK(0, "noir"),
    YELLOW(16773888, "jaune"),
    BLUE(55551, "blue"),
    RED(15938869, "rouge"),
    PURPLE( 12006899, "violet"),
    ORANGE(16731392, "orange"),
    GREEN(1889581, "vert"),
    BEIGE( 13995804, "beige");

    private final int rgb;
    private final String name;

    Color(int rgb, String name) { this.rgb = 0xff000000 | rgb; this.name = name; }

    public int getRGB() { return rgb; }

    public int getRed() { return (getRGB() >> 16) & 0xFF; }

    public int getBlue() { return (getRGB()) & 0xFF; }

    public int getGreen() { return (getRGB() >> 8) & 0xFF; }

    public int getAlpha() { return (getRGB() >> 24) & 0xff; }

    public String getHexadecimal() { return String.format( "#%02x%02x%02x", getRed(), getGreen(), getBlue()); }

    @Override
    public String toString() {
        return "ColorForm{" +
                "Name=" + name +
                '}';
    }
}
