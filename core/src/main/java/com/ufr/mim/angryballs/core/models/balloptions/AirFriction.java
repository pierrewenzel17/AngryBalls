package com.ufr.mim.angryballs.core.models.balloptions;

import com.ufr.mim.angryballs.core.models.Ball;
import mesmaths.mecanique.MecaniquePoint;

import java.util.Collection;

/**
 * Classe qui muni une bille d'un freinage dû aux frottements dans l'air
 */
public final class AirFriction extends BallOption {

    public AirFriction(final Ball ball) {
        super(ball);
    }

    @Override
    public void manageAcceleration(final Collection<Ball> balls) {
        super.manageAcceleration(balls);
        this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.getMass(), this.getSpeed()));
    }

    @Override
    public String toString() {
        return "AirFriction{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
