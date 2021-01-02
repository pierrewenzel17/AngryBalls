package com.ufr.mim.angryballs.client.services;

import com.ufr.mim.angryballs.client.view.BasisChange;
import com.ufr.mim.angryballs.client.view.DrawBallsFactory;
import com.ufr.mim.angryballs.core.dto.SimpleBallDTO;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Collection;

/**
 * Gestion de la récupération des billes et de leur affichage
 */
public class UpdateBallsPosition extends Thread {

    private final DrawBallsFactory<Circle> drawBallsFactory;
    private ObjectInputStream reader;
    private boolean lancer = true;
    private AnchorPane background;

    public UpdateBallsPosition(DrawBallsFactory<Circle> drawBallsFactory, AnchorPane background) {
        this.drawBallsFactory = drawBallsFactory;
        this.background = background;
    }

    @Override
    public void interrupt() {
        super.interrupt();
        lancer = false;
        /*try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void run() {
        while (lancer) {
            try {
                Socket socket = DataSendingManager.getSocket();
                reader = new ObjectInputStream(socket.getInputStream());
                Collection<SimpleBallDTO> simpleBallDTOCollection = DataSendingManager.receiveJSONObject(reader);
                BasisChange.basisChange(simpleBallDTOCollection, background);
                for (SimpleBallDTO simpleBallDTO: simpleBallDTOCollection) {
                    drawBallsFactory.getShape(simpleBallDTO).setCenterX(simpleBallDTO.getPosition().x);
                    drawBallsFactory.getShape(simpleBallDTO).setCenterY(simpleBallDTO.getPosition().y);
                }
            } catch (InterruptedIOException e) {
                Thread.currentThread().interrupt();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
