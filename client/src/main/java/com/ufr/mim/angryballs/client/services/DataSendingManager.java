package com.ufr.mim.angryballs.client.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ufr.mim.angryballs.core.models.balloptions.Pilot;
import com.ufr.mim.angryballs.client.model.SimpleBallDTO;

import com.ufr.mim.angryballs.client.utils.ConstantsUtil;
import mesmaths.geometrie.base.Vecteur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Gestion de l'échange de données entre le client et le serveur
 */
public class DataSendingManager {

    private static Socket socket = null;

    /**
     * @return socket actuelle ou nouvelle socket si elle n'est pas instanciée
     */
    public static Socket getSocket() throws IOException {
        if (socket == null) {
            socket = new Socket(ConstantsUtil.host, ConstantsUtil.port);
        }
        return socket;
    }

    /**
     * Recupère l'ensemble des billes au démarrage de l'application
     * @return listBalls : liste de l'ensemble des {@link SimpleBallDTO} que l'on affiche
     */
    public static Collection<SimpleBallDTO> initializeListBalls() {
        Collection<SimpleBallDTO> listBalls = new ArrayList<>();
        //while(true) {
            try {
                Socket socket = getSocket();
                ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
                String message = (String) reader.readObject();

                reader.close();

                final GsonBuilder builder = new GsonBuilder();
                final Gson gson = builder.setPrettyPrinting().create();
                SimpleBallDTO simpleBallDTO = gson.fromJson(message, SimpleBallDTO.class);

                listBalls.add(simpleBallDTO);
            } catch (ClassNotFoundException ee) {
                ee.printStackTrace();
                //break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        //}
        return listBalls;
    }

    /**
     * Envoi des données en paramètres au serveur pour la gestion de {@link Pilot}
     * @param hashcode : hashcode de la bille
     * @param positionSourie : position en x et y de la sourie lors du clic sur un bille
     */
    public static void sendJSONObject(int hashcode, Vecteur positionSourie) {
        try {
            final ObjectOutputStream writer = new ObjectOutputStream(getSocket().getOutputStream());
            final GsonBuilder builder = new GsonBuilder();
            final Gson gson = builder.create();

            final List<Object> list = new ArrayList<>();
            list.add(hashcode);
            list.add(positionSourie);

            writer.writeObject(gson.toJson(list));

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupération des nouvelles coordonnées de chaque bille
     * @param reader
     * @return la bille reçue du serveur
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static SimpleBallDTO receiveJSONObject(ObjectInputStream reader) throws IOException, ClassNotFoundException {
        final String message = (String) reader.readObject();
        reader.close();

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(message, SimpleBallDTO.class);
    }
}
