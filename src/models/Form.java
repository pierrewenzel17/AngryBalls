package models;

import mesmaths.geometrie.base.Vecteur;
import org.w3c.dom.css.RGBColor;

/**
 * class qui represente une forme geometrique
 */
public abstract class Form {
    public abstract double getRadius();
    //public abstract void setRadius(double radius);
    public abstract RGBColor getColor();
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
}
