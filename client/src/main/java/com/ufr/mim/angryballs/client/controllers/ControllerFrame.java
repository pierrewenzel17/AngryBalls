package com.ufr.mim.angryballs.client.controllers;

import com.ufr.mim.angryballs.client.model.SimpleBallDTO;
import com.ufr.mim.angryballs.client.services.DataSendingManager;
import com.ufr.mim.angryballs.client.services.UpdateBallsPosition;
import com.ufr.mim.angryballs.client.view.DrawBallsFactory;
import com.ufr.mim.angryballs.client.view.DrawBallsWithFx;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import mesmaths.geometrie.base.Vecteur;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Gestion de l'initialisation de l'interface graphique
 * Mise-à-jour des coordonnées
 */
public class ControllerFrame implements Initializable {

    @FXML
    public AnchorPane background = new AnchorPane();
    private boolean serviceNotRunning = true;
    private Collection<SimpleBallDTO> listBalls;
    private DrawBallsFactory<Circle> drawBallsWithFx;
    private UpdateBallsPosition updateBallsPosition;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listBalls = DataSendingManager.initializeListBalls();

        drawBallsWithFx = new DrawBallsWithFx(listBalls);
        listBalls.stream().map(drawBallsWithFx::getShape).forEach(background.getChildren()::add);

        manageMouseListener();
    }

    /**
     * Initialise le mouvement des {@link SimpleBallDTO billes} lors de l'appui sur le bouton associé
     */
    @FXML
    public void throwBall() {
        if (serviceNotRunning) {
            serviceNotRunning = false;
            updateBallsPosition = new UpdateBallsPosition(drawBallsWithFx);
            updateBallsPosition.start();
        }
    }

    /**
     * Fonction qui met en pause le mouvement des {@link SimpleBallDTO billes} lors de l'appui sur le bouton associé
     */
    @FXML
    public void stopBall() {
        serviceNotRunning = true;
        if (updateBallsPosition != null) updateBallsPosition.interrupt();
    }

    @FXML
    public void quit() {
        Platform.exit();
    }

    /**
     * Permet au programme de spécifier ce qu'il doit faire lors d'un interaction avec la sourie
     */
    private void manageMouseListener() {
        AtomicReference<SimpleBallDTO> ballSelect = new AtomicReference<>();
        Platform.runLater(() -> {
            background.setOnMousePressed(mouseEvent -> ballSelect.set(listBalls.stream().filter(ball -> isBallSelected(mouseEvent, ball)).findFirst().orElse(null)));
            background.setOnMouseReleased(mouseEvent -> {
                if (ballSelect.get() != null) {
                    DataSendingManager.sendJSONObject(ballSelect.get().getHashcode(), new Vecteur(mouseEvent.getX(), mouseEvent.getY()));
                }
            });
        });
    }

    /**
     * Vérifie qu'on sélectionne bien la bille attrapée
     * @param event : MouseEvent lié au click
     * @param ball : bille que l'on cherche à attraper
     * @return true : bonne bille
     *         false : autre bille
     */
    private boolean isBallSelected(MouseEvent event, SimpleBallDTO ball) {
        return getDistanceBetweenMouseAndBall(event, ball) <= ball.getRadius();
    }

    /**
     * @return la distance entre la position de la sourie et la bille
     */
    private double getDistanceBetweenMouseAndBall(MouseEvent event, SimpleBallDTO ball) {
        return Math.hypot(event.getX() - ball.getPosition().x, event.getY() - ball.getPosition().y);
    }
}
