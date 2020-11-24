package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.utils.BallsUtil;
import javafx.geometry.Bounds;

import java.util.Collection;

public class UpdateBallPosition extends Thread {

    private final Collection<Ball> listBall;
    private final int deltaT;
    private final double widthBackground;
    private final double heightBackground;

    public UpdateBallPosition(Collection<Ball> listBall, int deltaT, double width, double height) {
        this.listBall = listBall;
        this.deltaT = deltaT;
        this.widthBackground = width;
        this.heightBackground = height;
    }

    @Override
    public void run() {
        for (Ball ball: listBall) {
            ball.move(deltaT);                 // mise a jour position et vitesse de cette bille
            ball.manageAcceleration(listBall);      // calcul de l'acceleration subie par cette bille
            ball.manageCollision(0,0, widthBackground, heightBackground);
            BallsUtil.isInCollisionWithABall(ball, listBall);
        }
    }
}
