package com.ufr.mim.angryballs.core.dto;

import mesmaths.geometrie.base.Vecteur;

/**
 * DTO de simple balls
 */
public class SimpleBallDTO {
    private final int id;
    private final double radius;
    private final String color;
    private final Vecteur position;

    public SimpleBallDTO(int id, double radius, String color, Vecteur position) {
        this.id = id;
        this.radius = radius;
        this.color = color;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public Vecteur getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "SimpleBallDTO{" +
                "id=" + id +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                ", position=" + position +
                '}';
    }
}
