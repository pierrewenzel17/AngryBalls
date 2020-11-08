package com.ufr.mim.angryballs.models;

import com.ufr.mim.angryballs.models.enums.ColorForm;
import mesmaths.geometrie.base.Vecteur;

/**
 * class qui represente une forme geometrique
 */
public abstract class Form implements Drawable {
    /**
     * Getter du rayon
     * @return le rayon de la forme
     */
    public abstract double getRadius();
    //public abstract void setRadius(double radius);
    public abstract ColorForm getColor();
    //public abstract void setColor(RGBColor color);
    public abstract Vecteur getPosition();
    //public abstract void setPosition(Vecteur position);
    public abstract Vecteur getSpeed();
    //public abstract void setSpeed(Vecteur speed);
    public abstract Vecteur getAcceleration();
    //public abstract void setAcceleration(Vecteur acceleration);
    /**
     * Calcul la masse d'une bille
     * @return la masse de cette bille (floattant)
     */
    public abstract double mass();
    /**
     *
     * @param xAxis :
     * @param yAxis :
     * @param width :
     * @param height :
     */
    public abstract void collision(double xAxis, double yAxis, double width, double height);
}
