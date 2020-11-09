package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;
import mesmaths.cinematique.Collisions;

/**
 * Classe qui muni une bille d'un blocage par les bords
 */
public final class Blocked extends BallOption {

    public Blocked(final IBall ball) {
        super(ball);
    }

    @Override
    public void manageCollision(double xAxis, double yAxis, double width, double height) {
        Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(),this.getRadius(),this.getSpeed(), xAxis, width);
        Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRadius(), this.getSpeed(), yAxis, height);
    }

    @Override
    public String toString() {
        return "Blocked{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
