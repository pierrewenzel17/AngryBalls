package com.ufr.mim.angryballs.server;

import com.ufr.mim.angryballs.core.models.Ball;
import com.ufr.mim.angryballs.core.utils.BallsUtil;
import org.apache.log4j.Logger;

public final class PositionDetermination implements Runnable {

    static final Logger logger = Logger.getLogger(PositionDetermination.class);

    private final CharlesHelpMe charlesHelpMe;

    public PositionDetermination(CharlesHelpMe charlesHelpMe) {
        this.charlesHelpMe = charlesHelpMe;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (charlesHelpMe) {
                    while(!charlesHelpMe.isSendingAll()) { charlesHelpMe.wait(); }
                    int deltaT = 20;
                    for (Ball ball :  charlesHelpMe.getBalls()) {
                        ball.move(deltaT);
                        ball.manageAcceleration(charlesHelpMe.getBalls());
                        ball.manageCollision(0,0, 650, 400);
                        BallsUtil.bumpInto(ball, charlesHelpMe.getBalls());
                    }
                    logger.info("j'ai calculé: " + charlesHelpMe.getBalls());
                    Thread.sleep(40);
                    charlesHelpMe.setAllFalse();
                    charlesHelpMe.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            logger.info("Thread coupé");
        }
    }
}
