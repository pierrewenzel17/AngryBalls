package com.ufr.mim.angryballs.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ufr.mim.angryballs.core.dto.SimpleBallDTO;
import com.ufr.mim.angryballs.core.models.Ball;
import com.ufr.mim.angryballs.core.utils.BallsUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClientBalls implements Runnable {

  private final Socket socket;
  private final CharlesHelpMe charlesHelpMe;

  static final Logger logger = Logger.getLogger(ClientBalls.class);

  public ClientBalls(Socket socket, CharlesHelpMe charlesHelpMe) {
    this.socket = socket;
    this.charlesHelpMe = charlesHelpMe;
    this.charlesHelpMe.getSend().put(hashCode(), false);
  }

  @Override
  public void run() {
    try {
      while (!Thread.interrupted()) {
        synchronized (charlesHelpMe) {
          while (charlesHelpMe.getSend().get(hashCode())) charlesHelpMe.wait();
          this.sendBall(charlesHelpMe.getBalls());
          charlesHelpMe.getSend().replace(hashCode(), true);
          charlesHelpMe.notifyAll();
        }
      }
    } catch (InterruptedException interruptedException) {
      logger.info("Thread d'envoie coupé");
    } catch (IOException exception)  {
      this.charlesHelpMe.getSend().remove(hashCode());
      logger.info("Deconnextion " + this.charlesHelpMe.getSend());
      logger.info("Client "+ socket.hashCode() +" déconnecté");
    }
  }

  private String listBallsToJson(Collection<Ball> balls) {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Collection<SimpleBallDTO> simpleBallDTOCollection = balls.stream().map(BallsUtil::BallToDto).collect(Collectors.toList());
    return gson.toJson(simpleBallDTOCollection);
  }

  public void sendBall(Collection<Ball> balls) throws IOException {
    final ObjectOutputStream writer = new ObjectOutputStream(this.socket.getOutputStream());
    writer.writeObject(listBallsToJson(balls));
  }

  public Collection receiveMouseEvent(String json) {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.fromJson(json, Collection.class);
  }

  @Override
  public int hashCode() {
    return Objects.hash(socket, charlesHelpMe);
  }
}
