package com.ufr.mim.angryballs.client.view;

import com.ufr.mim.angryballs.core.dto.SimpleBallDTO;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Collection;

/**
 * Classe qui permet de dessiner une bille en javafx avec {@link Circle}
 */
public class DrawBallsWithFx extends DrawBallsFactory<Circle> {

    public DrawBallsWithFx(Collection<SimpleBallDTO> balls) {
        super(balls, ball -> new Circle(ball.getPosition().x, ball.getPosition().y,
                ball.getRadius(), Color.valueOf(ball.getColor())));
    }
}
