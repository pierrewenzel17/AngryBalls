package com.ufr.mim.angryballs.server;

import com.ufr.mim.angryballs.core.models.Ball;
import com.ufr.mim.angryballs.core.utils.BallsUtil;

import java.util.Collection;

public final class PositionDetermination {

    public static PositionDetermination getInstance() {
        return PositionDeterminationHolder.INSTANCE.value;
    }

    private PositionDetermination() {}

    public void determinate(Collection<Ball> balls) {
        int deltaT = 20;
        for (Ball ball: balls) {
            ball.move(deltaT);
            ball.manageAcceleration(balls);
            ball.manageCollision(0,0, 650, 400);
            BallsUtil.bumpInto(ball, balls);
        }
    }

    private enum PositionDeterminationHolder {

        INSTANCE(new PositionDetermination());

        protected PositionDetermination value;

        PositionDeterminationHolder(PositionDetermination positionDetermination) {
            this.value = positionDetermination;
        }
    }
}
