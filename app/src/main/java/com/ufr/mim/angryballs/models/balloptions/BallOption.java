package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.Color;
import mesmaths.geometrie.base.Vecteur;

import java.util.Collection;

/**
 * Classe mère de toute les options que peu avoir une bille
 */
abstract class BallOption implements Ball {

    protected Ball ballWithOption;

    protected BallOption(final Ball ballWithOption) {
        this.ballWithOption = ballWithOption;
    }

    @Override
    public double getRadius() {
        return this.ballWithOption.getRadius();
    }

    @Override
    public double getDensity() { return this.ballWithOption.getDensity(); }

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
    public double getMass() {
        return this.ballWithOption.getMass();
    }

    @Override
    public void move(double deltaT) {
        this.ballWithOption.move(deltaT);
    }

    @Override
    public void manageCollision(double xAxis, double yAxis, double width, double height) {
        this.ballWithOption.manageCollision(xAxis, yAxis, width, height);
    }

    @Override
    public void manageAcceleration(final Collection<Ball> balls) { this.ballWithOption.manageAcceleration(balls); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        var ballOption = (BallOption) o;
        return ballWithOption.equals(ballOption.ballWithOption);
    }

    @Override
    public int hashCode() {
        return this.ballWithOption.hashCode();
    }
}

