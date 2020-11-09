package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;
import mesmaths.mecanique.MecaniquePoint;

import java.util.List;

/**
 * Classe qui muni une bille d'un freinage dû aux frottements dans l'air
 */
public final class AirFriction extends BallOption {

    public AirFriction(final IBall ball) {
        super(ball);
    }

    @Override
    public void manageAcceleration(List<IBall> balls) {
        super.manageAcceleration(balls);
        this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.mass(), this.getSpeed()));
    }

    @Override
    public String toString() {
        return "AirFriction{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
