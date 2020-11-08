package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;

public final class UniformRectilinear extends BallOption {

    public UniformRectilinear(IBall ball) {
        super(ball);
    }

    @Override
    public void collision(double xAxis, double yAxis, double width, double height) {
        //TODO
    }

    @Override
    public String toString() {
        return "UniformRectilinear{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
