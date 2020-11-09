package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;
import mesmaths.cinematique.Collisions;

/**
 * Classe qui muni une bille d'un rebond sur les bords
 */
public final class Bounce extends BallOption {

    public Bounce(final IBall ball) {
        super(ball);
    }

    @Override
    public void manageCollision(double xAxis, double yAxis, double width, double height) {
        Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRadius(),
                this.getSpeed(), xAxis, yAxis, width, height);
    }

    @Override
    public String toString() {
        return "Bounce{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
