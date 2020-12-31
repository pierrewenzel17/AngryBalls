package com.ufr.mim.angryballs.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ufr.mim.angryballs.core.models.Ball;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.List;

public class ClientBalls implements Runnable {

  private final Socket socket;
  private final CharlesHelpMe charlesHelpMe;

  public ClientBalls(Socket socket, CharlesHelpMe charlesHelpMe) {
    this.socket = socket;
    this.charlesHelpMe = charlesHelpMe;
  }

  @Override
  public void run() {
    try {
      while (!Thread.interrupted()) {
        synchronized (charlesHelpMe) {
          while (!charlesHelpMe.isSending()) charlesHelpMe.wait();
          this.sendBall(charlesHelpMe.getBalls());
          charlesHelpMe.setSend(false);
          charlesHelpMe.notifyAll();
        }
      }
    } catch (InterruptedException interruptedException) {

    } catch (IOException exception)  {
      exception.printStackTrace();
    }
  }

  private String listBallsToJson(List<Ball> balls) {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    System.out.println("test : " + balls);
    final String test = gson.toJson(balls);
    System.out.println("test2 : " + test);
    return test;
  }

  public void sendBall(List<Ball> balls) throws IOException {
    final ObjectOutputStream writer = new ObjectOutputStream(this.socket.getOutputStream());
    writer.writeObject(listBallsToJson(balls));
  }

  public Collection receiveMouseEvent(String json) {
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.fromJson(json, Collection.class);
  }
}
