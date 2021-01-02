package com.ufr.mim.angryballs.server;

import com.ufr.mim.angryballs.core.models.Ball;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Boolean.TRUE;

public class CharlesHelpMe {

  private final Collection<Ball> balls;

  private final Map<Integer, Boolean> send = new ConcurrentHashMap<>();

  public CharlesHelpMe(Ball... balls) {
    this(List.of(balls));
  }

  public CharlesHelpMe(Collection<Ball> balls) {
    this.balls = balls;
  }

  public Collection<Ball> getBalls() {
    return balls;
  }

  public synchronized boolean isSendingAll() {
    return !send.isEmpty() && send.entrySet().stream().allMatch(entry -> TRUE.equals(entry.getValue()));
  }

  public synchronized void setAllFalse() {
    send.replaceAll((key, value) -> false);
  }

  public synchronized Map<Integer, Boolean> getSend() {
    return send;
  }
}
