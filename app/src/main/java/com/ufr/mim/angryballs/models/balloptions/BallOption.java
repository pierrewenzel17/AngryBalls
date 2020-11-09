package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;
import com.ufr.mim.angryballs.models.Color;
import com.ufr.mim.angryballs.views.draw.IDrawVisitor;
import mesmaths.geometrie.base.Vecteur;

import java.util.List;

abstract class BallOption implements IBall {

    protected IBall ballWithOption;

    protected BallOption(final IBall ballWithOption) {
        this.ballWithOption = ballWithOption;
    }

    @Override
    public double getRadius() {
        return this.ballWithOption.getRadius();
    }

    @Override
    public Color getColor() {
        return this.ballWithOption.getColor();
    }

    @Override
    public Vecteur getPosition() {
        return this.ballWithOption.getPosition();
    }

    @Override
    public Vecteur getSpeed() {
        return this.ballWithOption.getSpeed();
    }

    @Override
    public Vecteur getAcceleration() {
        return this.ballWithOption.getAcceleration();
    }

    @Override
    public double mass() {
        return this.ballWithOption.mass();
    }

    @Override
    public void manageCollision(double xAxis, double yAxis, double width, double height) {
        this.ballWithOption.manageCollision(xAxis, yAxis, width, height);
    }

    @Override
    public void manageAcceleration(List<IBall> balls) { this.ballWithOption.manageAcceleration(balls); }

    @Override
    public <GRAPHIC> void draw(IDrawVisitor<GRAPHIC> drawVisitor, GRAPHIC g) {
        this.ballWithOption.draw(drawVisitor, g);
    }
}
