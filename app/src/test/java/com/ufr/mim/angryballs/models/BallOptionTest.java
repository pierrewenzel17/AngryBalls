package com.ufr.mim.angryballs.models;

import com.ufr.mim.angryballs.models.balloptions.*;
import mesmaths.geometrie.base.Vecteur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class BallOptionTest {

    private IBall redBall, yellowBall, greenBall, blueBall, blackBall, whiteBall;

    @BeforeEach
    void setUp() {
        this.redBall = new UniformRectilinear(new Bounce(new Ball(1, Color.RED)));
        this.yellowBall = new Gravity(new AirFriction(new Bounce(new Ball(1, Color.YELLOW))), new Vecteur());
        this.greenBall = new Newton(new AirFriction(new Bounce(new Ball(1, Color.GREEN))));
        this.blueBall = new UniformRectilinear(new WallPass(new Ball(1, Color.BLUE)));
        this.blackBall = new Newton(new Blocked(new Ball(1, Color.BLACK)));
        this.whiteBall = new Pilot(new UniformRectilinear(new Bounce(new Ball(1, Color.WHITE))));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void optionTypeTest() {

    }
}