package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.Ball;
import mesmaths.mecanique.MecaniquePoint;

import java.util.Collection;
import java.util.List;

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
