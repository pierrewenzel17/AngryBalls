package com.ufr.mim.angryballs.core.models.balloptions;

import com.ufr.mim.angryballs.core.models.Ball;
import mesmaths.geometrie.base.Vecteur;

import java.util.Collection;

/**
 * Classe qui muni une bille attraction vers le bas (pesanteur)
 */
public final class Gravity extends BallOption {

    private final Vecteur gravityVector;

    public Gravity(final Ball ball, final Vecteur gravity) {
        super(ball);
        this.gravityVector = gravity;
    }

    @Override
    public void manageAcceleration(final Collection<Ball> balls) {
        super.manageAcceleration(balls);
        this.getAcceleration().ajoute(this.gravityVector);
    }

    @Override
    public String toString() {
        return "Gravity{" +
                "gravity=" + gravityVector +
                ", ballWithOption=" + ballWithOption +
                '}';
    }
}
