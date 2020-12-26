package com.ufr.mim.angryballs.controllers;

import com.ufr.mim.angryballs.models.Ball;
import com.ufr.mim.angryballs.models.Color;
import com.ufr.mim.angryballs.models.SimpleBall;
import com.ufr.mim.angryballs.models.StateClic;
import com.ufr.mim.angryballs.models.balloptions.*;
import com.ufr.mim.angryballs.services.MovingBallsScheduledService;
import com.ufr.mim.angryballs.views.draw.DrawBallsFactory;
import com.ufr.mim.angryballs.views.draw.DrawBallsWithFx;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import mesmaths.geometrie.base.Vecteur;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Gestion de l'initialisation de l'interface graphique
 * Mise-à-jour des coordonnées
 */
public class ControllerFrame implements Initializable {

    @FXML
    public AnchorPane background = new AnchorPane();
    private MovingBallsScheduledService service;
    private boolean serviceNotRunning = true;
    private Collection<Ball> listBall;
    private DrawBallsFactory<Circle> drawBallsWithFx;
    private StateClic state;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double vMax = 0.1;  double xMax = 500;  double yMax = 300;

        listBall = List.of(
            new Pilot(new SimpleBall(20, 1, Color.RED, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax))),
            new Pilot(new Gravity(new AirFriction(new SimpleBall(20, 1, Color.YELLOW, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0))), new Vecteur(0, 0.001))),
            new Pilot(new Newton(new AirFriction(new SimpleBall(20, 1, Color.GREEN, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax))))),
            new Pilot(new WallPass(new SimpleBall(20, 1, Color.BLUE, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax)))),
            new Pilot(new Newton(new Blocked(new SimpleBall(20, 1, Color.BLACK, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax))))),
            new Pilot(new SimpleBall(20, 1, Color.ORANGE, Vecteur.créationAléatoire(0, 0, xMax, yMax), Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax)))
        );

        drawBallsWithFx = new DrawBallsWithFx(listBall);
        listBall.stream().map(drawBallsWithFx::getShape).forEach(background.getChildren()::add);

        manageMouseListener();
    }

    /**
     * Initialise le mouvement des {@link Ball billes} lors de l'appui sur le bouton associé
     */
    @FXML
    public void throwBall() {
        if (serviceNotRunning) {
            final int deltaT = 20;    //taux de rafraichissement
            serviceNotRunning = false;

            service = new MovingBallsScheduledService(listBall, deltaT, background.getWidth(), background.getHeight(), drawBallsWithFx);
            service.setPeriod(Duration.millis(deltaT));
            service.start();
        }
    }

    /**
     * Fonction qui met en pause le mouvement des {@link Ball billes} lors de l'appui sur le bouton associé
     */
    @FXML
    public void stopBall() {
        service.cancel();
        serviceNotRunning = true;
    }

    @FXML
    public void quit() {
        Platform.exit();
    }

    /**
     * Permet au programme de spécifier ce qu'il doit faire lors d'un interaction avec la sourie
     */
    private void manageMouseListener() {
        AtomicReference<Ball> ballSelect = new AtomicReference<>();

        Platform.runLater(() -> {
            background.setOnMousePressed(event -> {
                state = new StateClic.Play();
                ballSelect.set(listBall.stream().filter(ball -> ball instanceof Pilot && isBallSelected(event, ball)).findFirst().orElse(null));
            });
            background.setOnMouseReleased(event -> {
                if (ballSelect.get() != null) {
                    state.run((Pilot) ballSelect.get(), new Vecteur(event.getX() - ballSelect.get().getX(), event.getY() - ballSelect.get().getY()));
                }
                state = new StateClic.Stop();
            });
        });
    }

    /**
     * Vérifie qu'on sélectionne bien la bille attrapée
     * @param event : MouseEvent lié au click
     * @param ball : bille que l'on cherche à attraper
     * @return true : bonne bille
     *          false : autre bille
     */
    private boolean isBallSelected(MouseEvent event, Ball ball) {
        return getDistanceBetweenMouseAndBall(event, ball) <= ball.getRadius();
    }

    /**
     * @return la distance entre la position de la sourie et la bille
     */
    private double getDistanceBetweenMouseAndBall(MouseEvent event, Ball ball) {
        return Math.hypot(event.getX() - ball.getX(), event.getY() - ball.getY());
    }
}
