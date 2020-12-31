package com.ufr.mim.angryballs.client.services;

import com.ufr.mim.angryballs.client.model.SimpleBallDTO;
import com.ufr.mim.angryballs.client.view.DrawBallsFactory;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Gestion de la récupération des billes et de leur affichage
 */
public class UpdateBallsPosition extends Thread {

    private final DrawBallsFactory<Circle> drawBallsFactory;
    private ObjectInputStream reader;

    public UpdateBallsPosition(DrawBallsFactory<Circle> drawBallsFactory) {
        this.drawBallsFactory = drawBallsFactory;
    }

    @Override
    public void interrupt() {
        super.interrupt();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = DataSendingManager.getSocket();
                reader = new ObjectInputStream(socket.getInputStream());
                SimpleBallDTO simpleBallDTO = DataSendingManager.receiveJSONObject(reader);

                drawBallsFactory.getShape(simpleBallDTO).setCenterX(simpleBallDTO.getPosition().x);
                drawBallsFactory.getShape(simpleBallDTO).setCenterY(simpleBallDTO.getPosition().y);
            } catch (InterruptedIOException e) {
                Thread.currentThread().interrupt();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
