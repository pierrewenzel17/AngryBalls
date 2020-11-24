package com.ufr.mim.angryballs.controllers;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.Color;
import com.ufr.mim.angryballs.models.SimpleBall;
import com.ufr.mim.angryballs.models.balloptions.*;
import com.ufr.mim.angryballs.views.draw.DrawBallsFactory;
import com.ufr.mim.angryballs.views.draw.DrawBallsWithFx;
import com.ufr.mim.angryballs.views.draw.UpdateBallPosition;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import mesmaths.geometrie.base.Vecteur;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Gestion de l'initialisation de l'interface graphique
 * Mise-à-jour des coordonnées
 */
public class ControllerFrame implements Initializable {

    @FXML
    public AnchorPane background = new AnchorPane();
    private Timeline timeline = null;
    private boolean timelineOnPause = true;
    private Collection<Ball> listBall;
    private DrawBallsFactory<Circle> drawBallsWithFx;
    private Pilot pilot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double vMax = 0.1;
        double xMax = 650;
        double yMax = 400;

        pilot = new Pilot(new SimpleBall(20, 1, Color.ORANGE, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax)));

        listBall = List.of(
          new SimpleBall(20, 1, Color.RED, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax)),
          new Gravity(new AirFriction(new SimpleBall(20, 1, Color.YELLOW, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0))), new Vecteur(0, 0.001)),
          new Newton(new AirFriction(new SimpleBall(20, 1, Color.GREEN, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax)))),
          new WallPass(new SimpleBall(20, 1, Color.BLUE, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax))),
          new Newton(new Blocked(new SimpleBall(20, 1, Color.BLACK, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax)))),
          pilot
        );

        drawBallsWithFx = new DrawBallsWithFx(listBall);
        listBall.stream().map(drawBallsWithFx::getShape).forEach(background.getChildren()::add);

        background.setOnMouseDragged(t -> {
            pilot.setClickPosition(new Vecteur(t.getX(), t.getY()));
            //System.out.println(pilot.getClickPosition());
        });
    }

    /**
     * Initialise le mouvement des {@link Ball billes} lors de l'appui sur le bouton associé
     */
    @FXML
    public void throwBall() {
        if (timelineOnPause) {
            int deltaT = 20;    //taux de rafraichissement
            timelineOnPause = false;

            timeline = new Timeline(new KeyFrame(Duration.millis(deltaT), t -> updatesPositions(deltaT)));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    /**
     * Met-à-jour la position des {@link Ball billes} en fonction d'un intervalle de temps
     * @param deltaT : intervalle de temps en millisecondes
     */
    private void updatesPositions(int deltaT) {
        UpdateBallPosition updateBallPosition = new UpdateBallPosition(listBall, deltaT, background.getWidth(), background.getHeight());
        updateBallPosition.start();
        listBall.forEach(ball -> {
            drawBallsWithFx.getShape(ball).setCenterX(ball.getPosition().x);
            drawBallsWithFx.getShape(ball).setCenterY(ball.getPosition().y);
        });
    }

    /**
     * Fonction qui met en pause le mouvement des {@link Ball billes} lors de l'appui sur le bouton associé
     */
    @FXML
    public void stopBall() {
        timeline.pause();
        timelineOnPause = true;
    }

    @FXML
    public void quit() {
        Platform.exit();
    }
}
