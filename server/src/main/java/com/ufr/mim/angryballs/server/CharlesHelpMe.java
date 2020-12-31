package com.ufr.mim.angryballs.server;

import com.ufr.mim.angryballs.core.models.Ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CharlesHelpMe {

  private final Collection<Ball> balls;

  private boolean send = false;

  public CharlesHelpMe(Ball... balls) {
    this(Arrays.asList(balls));
  }

  public CharlesHelpMe(Collection<Ball> balls) {
    this.balls = balls;
  }

  public List<Ball> getBalls() {
    return new ArrayList<>(balls);
  }

  public synchronized boolean isSending() {
    return send;
  }

  public void setSend(boolean send) {
    this.send = send;
  }
}
