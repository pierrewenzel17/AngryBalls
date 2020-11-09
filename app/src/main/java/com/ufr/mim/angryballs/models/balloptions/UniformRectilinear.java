package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.IBall;

public final class UniformRectilinear extends BallOption {

    public UniformRectilinear(final IBall ball) {
        super(ball);
    }

    @Override
    public String toString() {
        return "UniformRectilinear{" +
                "ballWithOption=" + ballWithOption +
                '}';
    }
}
