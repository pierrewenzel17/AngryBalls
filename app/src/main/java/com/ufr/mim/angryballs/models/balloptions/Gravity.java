package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.Ball;
import mesmaths.geometrie.base.Vecteur;

import java.util.Collection;
import java.util.List;

/**
 * Classe qui muni une bille attraction vers le bas (pesanteur)
 */
public final class Gravity extends BallOption {

    private final Vecteur gravity;

    public Gravity(final Ball ball, final Vecteur gravity) {
        super(ball);
        this.gravity = gravity;
    }

    @Override
    public void manageAcceleration(final Collection<Ball> balls) {
        super.manageAcceleration(balls);
        this.getAcceleration().ajoute(this.gravity);
    }

    @Override
    public String toString() {
        return "Gravity{" +
                "gravity=" + gravity +
                ", ballWithOption=" + ballWithOption +
                '}';
    }
}
