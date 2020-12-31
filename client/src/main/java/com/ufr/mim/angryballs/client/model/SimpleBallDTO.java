package com.ufr.mim.angryballs.client.model;

import com.ufr.mim.angryballs.core.models.Color;
import mesmaths.geometrie.base.Vecteur;

import java.io.Serializable;

/**
 * Objets DTO que l'on utilise pour le transfert et l'affichage des billes
 */
public class SimpleBallDTO implements Serializable {
    private final int hashcode;
    private final double radius;
    private final Color color;
    private final Vecteur position;

    public SimpleBallDTO(int hashcode, double radius, Color color, Vecteur position) {
        this.hashcode = hashcode;
        this.radius = radius;
        this.color = color;
        this.position = position;
    }

    public int getHashcode() {
        return hashcode;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public Vecteur getPosition() {
        return position;
    }
}
