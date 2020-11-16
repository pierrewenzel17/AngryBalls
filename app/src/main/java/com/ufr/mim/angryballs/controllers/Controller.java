package com.ufr.mim.angryballs.controllers;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.Color;
import com.ufr.mim.angryballs.models.SimpleBall;
import com.ufr.mim.angryballs.models.balloptions.*;
import com.ufr.mim.angryballs.views.draw.DrawBallsFactory;
import com.ufr.mim.angryballs.views.draw.DrawBallsWithFx;
import com.ufr.mim.angryballs.views.draw.UpdateBallPosition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import mesmaths.geometrie.base.Vecteur;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public AnchorPane background = new AnchorPane();
    private double dx = 4, dy = 3;
    private Timeline timeline = null;
    private static boolean timelineOnPause = false;
    private Ball redBall, yellowBall, greenBall, blueBall, blackBall, whiteBall;
    private Collection<Ball> listBall;
    private DrawBallsFactory<Circle> drawBallsWithFx;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double vMax = 0.1;
        Bounds bounds = background.getBoundsInLocal();
        double xMax = bounds.getWidth();
        double yMax = bounds.getHeight();

        Vecteur p0, p1, p2, p3, p4, p5;

        p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
        p5 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

        this.redBall = new SimpleBall(10, 1, Color.RED, p0, Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax));
        this.yellowBall = new Gravity(new AirFriction(new SimpleBall(20, 1, Color.YELLOW, p1, Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0))), new Vecteur(0, 0.001));
        this.greenBall = new Newton(new AirFriction(new SimpleBall(20, 1, Color.GREEN, p2, Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax))));
        this.blueBall =  new WallPass(new SimpleBall(15, 1, Color.BLUE, p3, Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax)));
        this.blackBall = new Newton(new Blocked(new SimpleBall(70, 1, Color.BLACK, p4, Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax))));
        //this.whiteBall = new Pilot(new SimpleBall(50, 1, Color.WHITE, p5, Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax)));

        listBall = new ArrayList<>();
        listBall.add(this.redBall);
        listBall.add(this.yellowBall);
        listBall.add(this.greenBall);
        listBall.add(this.blueBall);
        listBall.add(this.blackBall);
        //listBall.add(this.whiteBall);

        drawBallsWithFx = new DrawBallsWithFx(listBall);

        for (Ball ball : listBall) {
            this.background.getChildren().add(drawBallsWithFx.getShape(ball));
        }
    }

    @FXML
    public void lancerBoules() {
        if (timeline == null || timelineOnPause) {
            int deltaT = 20;
            timelineOnPause = false;
            timeline = new Timeline(new KeyFrame(Duration.millis(deltaT), t -> {
                Bounds bounds = background.getBoundsInLocal();
                UpdateBallPosition updateBallPosition = new UpdateBallPosition(listBall, deltaT, bounds);
                updateBallPosition.start();

                for (Ball ball: listBall) {
                    drawBallsWithFx.getShape(ball).setCenterX(ball.getPosition().x);
                    drawBallsWithFx.getShape(ball).setCenterY(ball.getPosition().y);
                }
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }

    @FXML
    public void arreterBoules() {
        timeline.pause();
        timelineOnPause = true;
    }

    @FXML
    public void quitter() {
        Platform.exit();
    }
}
