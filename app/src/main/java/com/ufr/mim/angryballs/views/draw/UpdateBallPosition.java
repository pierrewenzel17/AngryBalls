package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.utils.BallsUtil;
import javafx.geometry.Bounds;

import java.util.Collection;

public class UpdateBallPosition extends Thread {

    private final Collection<Ball> listBall;
    private final int deltaT;
    private final Bounds circleBorder;

    public UpdateBallPosition(Collection<Ball> listBall, int deltaT, Bounds circleBorder) {
        this.listBall = listBall;
        this.deltaT = deltaT;
        this.circleBorder = circleBorder;
    }

    @Override
    public void run() {
        for (Ball ball: listBall) {
            ball.move(deltaT);                 // mise a jour position et vitesse de cette bille
            ball.manageAcceleration(listBall);      // calcul de l'acceleration subie par cette bille
            ball.manageCollision(0,0, circleBorder.getWidth(), circleBorder.getHeight());
            BallsUtil.isInCollisionWithABall(ball, listBall);
        }
    }
}
