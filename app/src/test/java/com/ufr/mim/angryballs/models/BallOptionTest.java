package com.ufr.mim.angryballs.models;

import com.ufr.mim.angryballs.models.balloptions.*;
import mesmaths.geometrie.base.Vecteur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class BallOptionTest {

    private Ball redBall, yellowBall, greenBall, blueBall, blackBall, whiteBall;

    @BeforeEach
    void setUp() {
        this.redBall = new SimpleBall(1, Color.RED);
        this.yellowBall = new Gravity(new AirFriction(new SimpleBall(1, Color.YELLOW)), new Vecteur());
        this.greenBall = new Newton(new AirFriction(new SimpleBall(1, Color.GREEN)));
        this.blueBall =  new WallPass(new SimpleBall(1, Color.BLUE));
        this.blackBall = new Newton(new Blocked(new SimpleBall(1, Color.BLACK)));
        this.whiteBall = new Pilot(new SimpleBall(1, Color.WHITE));
        yellowBall.getColor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void optionTypeTest() {

    }
}