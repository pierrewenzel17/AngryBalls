package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.Ball;
import mesmaths.cinematique.Collisions;

/**
 * Classe qui muni une bille d'un franchissement des parois et réapparition sur le côté opposé
 */
public final class WallPass extends BallOption {

    public WallPass(final Ball ball) {
        super(ball);
    }

    @Override
    public void manageCollision(double xAxis, double yAxis, double width, double height) {
        Collisions.collisionBilleContourPasseMuraille(this.getPosition(), xAxis, yAxis, width, height);
    }

    @Override
    public String toString() {
        return "Crossing{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
