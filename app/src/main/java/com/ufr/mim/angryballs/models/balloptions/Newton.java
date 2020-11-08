package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;

public final class Newton extends BallOption {

    public Newton(IBall ball) {
        super(ball);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {
        //TODO
    }

    @Override
    public String toString() {
        return "Newton{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
