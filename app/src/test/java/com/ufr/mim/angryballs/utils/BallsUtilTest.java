package com.ufr.mim.angryballs.utils;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.Color;
import com.ufr.mim.angryballs.models.SimpleBall;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class BallsUtilTest {

    private Collection<Ball> balls;
    private Ball redBall;
    private Ball blueBall;
    private Ball greenBall;

    @BeforeEach
    void setUp() {
        redBall = new SimpleBall(1, Color.RED);
        blueBall = new SimpleBall(1, Color.BLUE);
        greenBall = new SimpleBall(1,Color.GREEN);
        balls = new ArrayList<>();
        balls.add(redBall);
        balls.add(blueBall);
        balls.add(greenBall);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void otherBalls() {
        var ballCopy = new ArrayList<>(List.copyOf(balls));
        assertNotSame(ballCopy, balls);
        ballCopy.remove(redBall);
        assertEquals(ballCopy, BallsUtil.otherBalls(redBall, balls));
        assertNotSame(balls, BallsUtil.otherBalls(redBall, balls));
        ballCopy.remove(blueBall);
        assertNotEquals(ballCopy, BallsUtil.otherBalls(redBall, balls));
        assertEquals(ballCopy, BallsUtil.otherBalls(blueBall, BallsUtil.otherBalls(redBall, balls)));
        ballCopy.add(greenBall);
        var ballCopy2 = BallsUtil.otherBalls(blueBall, BallsUtil.otherBalls(redBall, balls));
        ballCopy2.add(greenBall);
        assertEquals(ballCopy, ballCopy2);
    }

    @Test
    void isInCollisionWithABall() {
    }
}