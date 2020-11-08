package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;

public final class Gravity extends BallOption {

    public Gravity(IBall ball) {
        super(ball);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {
        //TODO
    }

    @Override
    public String toString() {
        return "Gravity{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
