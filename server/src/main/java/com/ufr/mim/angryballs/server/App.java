package com.ufr.mim.angryballs.server;

import com.ufr.mim.angryballs.core.models.Color;
import com.ufr.mim.angryballs.core.models.SimpleBall;
import com.ufr.mim.angryballs.core.models.balloptions.*;
import com.ufr.mim.angryballs.core.utils.ConstantsUtil;
import mesmaths.geometrie.base.Vecteur;
import org.apache.log4j.Logger;

import java.io.IOException;

public final class App {

  static final Logger logger = Logger.getLogger(App.class);

  public static void main(String[] args) {
    try {
      var properties = new PropertiesLoader(App.class.getResource(ConstantsUtil.PROPERTIES_FILE));
      var server = new ServerBalls(properties.getPort(), properties.getIp(),
        new SimpleBall(1, Color.RED),
        new Gravity(new AirFriction(new SimpleBall(1, Color.YELLOW)), new Vecteur()),
        new Newton(new AirFriction(new SimpleBall(1, Color.GREEN))),
        new WallPass(new SimpleBall(1, Color.BLUE)),
        new Newton(new Blocked(new SimpleBall(1, Color.BLACK))),
        new Pilot(new SimpleBall(1, Color.WHITE)));
      logger.info(server);
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }
}
