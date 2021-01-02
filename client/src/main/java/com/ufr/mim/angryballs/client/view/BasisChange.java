package com.ufr.mim.angryballs.client.view;

import com.ufr.mim.angryballs.core.dto.SimpleBallDTO;
import javafx.scene.layout.AnchorPane;

import java.util.Collection;


public final class BasisChange {

    private BasisChange() { throw new IllegalAccessError("not instantiable"); }

    public static void basisChange(Collection<SimpleBallDTO> balls, AnchorPane background) {
        balls.forEach(ball -> { ball.getPosition().x = (ball.getPosition().x * background.getWidth())/650;
            ball.getPosition().y = (ball.getPosition().y * background.getHeight())/400; });
    }
}
