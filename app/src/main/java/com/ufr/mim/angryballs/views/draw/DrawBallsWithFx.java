package com.ufr.mim.angryballs.views.draw;

import com.ufr.mim.angryballs.models.Ball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Collection;

/**
 * Classe qui permet de dessiner une bille en javafx avec {@link Circle}
 */
public class DrawBallsWithFx extends DrawBallsFactory<Circle> {

    public DrawBallsWithFx(Collection<Ball> balls) {
        super(balls, ball -> new Circle(ball.getPosition().x, ball.getPosition().y,
                ball.getRadius(), Color.valueOf(ball.getColor().getHexadecimal())));
    }
}
