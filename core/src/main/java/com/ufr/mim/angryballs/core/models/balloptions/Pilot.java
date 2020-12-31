package com.ufr.mim.angryballs.core.models.balloptions;


import com.ufr.mim.angryballs.core.models.Ball;

public final class Pilot extends BallOption {

    public Pilot(final Ball ball) {
        super(ball);
    }

    @Override
    public String toString() {
        return "Pilot{" +
          "ballWithOption=" + ballWithOption +
          '}';
    }
}
