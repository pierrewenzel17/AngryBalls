package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;

import java.util.List;

/**
 * Classe qui muni une bille d'une attraction par les autres billes
 * (attraction universelle due à la force de Newton)
 */
public final class Newton extends BallOption {

    public Newton(final IBall ball) {
        super(ball);
    }

    @Override
    public void manageAcceleration(List<IBall> balls) {
        super.manageAcceleration(balls);
        //this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, balls));
    }

    @Override
    public String toString() {
        return "Newton{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
