package com.ufr.mim.angryballs.server;

import com.ufr.mim.angryballs.core.models.Ball;
import com.ufr.mim.angryballs.core.models.Color;
import com.ufr.mim.angryballs.core.models.SimpleBall;
import com.ufr.mim.angryballs.core.utils.ConstantsUtil;
import com.ufr.mim.angryballs.core.models.balloptions.*;
import mesmaths.geometrie.base.Vecteur;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public final class App {

  static final Logger logger = Logger.getLogger(App.class);

  public static final Collection<Ball> balls = List.of(
    new Pilot(new SimpleBall(20, 1, Color.RED, Vecteur.créationAléatoire(0, 0, ServerConstant.xMax, ServerConstant.yMax), Vecteur.créationAléatoire(-ServerConstant.vMax, -ServerConstant.vMax, ServerConstant.vMax, ServerConstant.vMax))),
    new Pilot(new Gravity(new AirFriction(new SimpleBall(20, 1, Color.YELLOW, Vecteur.créationAléatoire(0, 0, ServerConstant.xMax, ServerConstant.yMax), Vecteur.créationAléatoire(-ServerConstant.vMax, -ServerConstant.vMax, ServerConstant.vMax, 0))), new Vecteur(0, 0.001))),
    new Pilot(new Newton(new AirFriction(new SimpleBall(20, 1, Color.GREEN, Vecteur.créationAléatoire(0, 0, ServerConstant.xMax, ServerConstant.yMax), Vecteur.créationAléatoire(-ServerConstant.vMax, -ServerConstant.vMax, ServerConstant.vMax, ServerConstant.vMax))))),
    new Pilot(new WallPass(new SimpleBall(20, 1, Color.BLUE, Vecteur.créationAléatoire(0, 0, ServerConstant.xMax, ServerConstant.yMax), Vecteur.créationAléatoire(-ServerConstant.vMax, -ServerConstant.vMax, ServerConstant.vMax, ServerConstant.vMax)))),
    new Pilot(new Newton(new Blocked(new SimpleBall(20, 1, Color.BLACK, Vecteur.créationAléatoire(0, 0, ServerConstant.xMax, ServerConstant.yMax), Vecteur.créationAléatoire(-ServerConstant.vMax, -ServerConstant.vMax, ServerConstant.vMax, ServerConstant.vMax))))),
    new Pilot(new SimpleBall(20, 1, Color.ORANGE, Vecteur.créationAléatoire(0, 0, ServerConstant.xMax, ServerConstant.yMax), Vecteur.créationAléatoire(-ServerConstant.vMax, -ServerConstant.vMax, ServerConstant.vMax, ServerConstant.vMax))));

  public static void main(String[] args) {
    try {
      var properties = new PropertiesLoader(App.class.getResource(ConstantsUtil.PROPERTIES_FILE));
      var charles = new CharlesHelpMe(balls);
      var server = new ServerBalls(properties.getPort(), properties.getIp(),charles);
      var positionDetermination = new PositionDetermination(charles);
      Thread serverThread = new Thread(server);
      serverThread.start();
      Thread calculateThread = new Thread(positionDetermination);
      calculateThread.start();
      logger.info("Server is started");
      logger.info("Calculate thread is running");
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }
}
