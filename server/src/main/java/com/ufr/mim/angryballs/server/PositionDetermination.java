package com.ufr.mim.angryballs.server;

import com.ufr.mim.angryballs.core.utils.BallsUtil;

public final class PositionDetermination implements Runnable {

    private final CharlesHelpMe charlesHelpMe;

    public PositionDetermination(CharlesHelpMe charlesHelpMe) {
        this.charlesHelpMe = charlesHelpMe;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (charlesHelpMe) {
                    while(charlesHelpMe.isSending()) { charlesHelpMe.wait(); }
                    int deltaT = 20;
                    for (int i = 0; i < charlesHelpMe.getBalls().size(); i++) {
                        charlesHelpMe.getBalls().get(i).move(deltaT);
                        charlesHelpMe.getBalls().get(i).manageAcceleration(charlesHelpMe.getBalls());
                        charlesHelpMe.getBalls().get(i).manageCollision(0,0, 650, 400);
                        BallsUtil.bumpInto(charlesHelpMe.getBalls().get(i), charlesHelpMe.getBalls());
                    }
                    System.out.println("j'ai calculer:" + charlesHelpMe.getBalls().hashCode() +" result : " + charlesHelpMe.getBalls());
                    charlesHelpMe.setSend(true);
                    charlesHelpMe.notifyAll();
                }
            }
        } catch (InterruptedException e) {}
    }
}
