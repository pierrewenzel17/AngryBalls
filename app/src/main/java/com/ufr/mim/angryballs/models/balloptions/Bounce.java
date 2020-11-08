package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;
import mesmaths.cinematique.Collisions;

/**
 * Cette class permet de rajouté un comportement de rebond a une form.
 */
public final class Bounce extends BallOption {

    public Bounce(IBall ball) {
        super(ball);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {
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
