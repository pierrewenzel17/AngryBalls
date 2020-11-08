package com.ufr.mim.angryballs.models;

import com.ufr.mim.angryballs.views.draw.IDrawVisitor;
import mesmaths.geometrie.base.Vecteur;

public interface IBall {
    double getRadius();
    Color getColor();
    Vecteur getPosition();
    Vecteur getSpeed();
    Vecteur getAcceleration();
    double mass();
    void collision(double xAxis, double yAxis, double width, double height);
    <GRAPHIC> void draw(final IDrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g);
}
