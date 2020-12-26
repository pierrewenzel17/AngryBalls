package com.ufr.mim.angryballs.services;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.utils.BallsUtil;
import com.ufr.mim.angryballs.views.draw.DrawBallsFactory;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.shape.Circle;

import java.util.Collection;

public class MovingBallsScheduledService extends ScheduledService<Void> {

    private final Collection<Ball> listBall;
    private final int deltaT;
    private final double widthBackground;
    private final double heightBackground;
    private final DrawBallsFactory<Circle> drawBallsWithFx;

    public MovingBallsScheduledService(Collection<Ball> listBall, int deltaT, double width, double height, DrawBallsFactory<Circle> drawBallsWithFx) {
        this.listBall = listBall;
        this.deltaT = deltaT;
        this.widthBackground = width;
        this.heightBackground = height;
        this.drawBallsWithFx = drawBallsWithFx;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<>() {
            @Override
            protected Void call() {
                for (Ball ball: listBall) {
                    ball.move(deltaT);                 // mise a jour position et vitesse de cette bille
                    ball.manageAcceleration(listBall);      // calcul de l'acceleration subie par cette bille
                    ball.manageCollision(0,0, widthBackground, heightBackground);
                    BallsUtil.isInCollisionWithABall(ball, listBall);
                }

                listBall.forEach(ball -> {
                    drawBallsWithFx.getShape(ball).setCenterX(ball.getPosition().x);
                    drawBallsWithFx.getShape(ball).setCenterY(ball.getPosition().y);
                });

                return null;
            }
        };
    }
}
