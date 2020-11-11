package com.ufr.mim.angryballs.models;

import com.ufr.mim.angryballs.views.draw.IDrawVisitor;
import mesmaths.geometrie.base.Vecteur;

import java.util.List;

public interface IBall {
    double getRadius();
    Color getColor();
    Vecteur getPosition();
    Vecteur getSpeed();
    Vecteur getAcceleration();
    double mass();
    void move(double deltaT);
    void manageCollision(double xAxis, double yAxis, double width, double height);
    void manageAcceleration(List<IBall> balls);
    <GRAPHIC> void draw(final IDrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g);
}
