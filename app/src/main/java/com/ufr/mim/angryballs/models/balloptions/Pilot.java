package com.ufr.mim.angryballs.models.balloptions;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.StateClic;

public final class Pilot extends BallOption {

    private StateClic state;

    public Pilot(final Ball ball) {
        super(ball);
        state = null;
    }

    public void setState(StateClic stateClic) {
        this.state = stateClic;
    }

    public StateClic getState() {
        return state;
    }
}
