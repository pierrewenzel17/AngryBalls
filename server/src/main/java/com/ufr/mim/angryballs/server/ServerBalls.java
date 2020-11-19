package com.ufr.mim.angryballs.server;

import com.ufr.mim.angryballs.core.models.Ball;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Collection;
import java.util.List;

public final class ServerBalls implements Runnable {

    private final ServerSocket socket;
    private final Collection<Ball> balls;


    public ServerBalls(int port, final String ip, Ball... balls) throws IOException {
        this(port, ip, List.of(balls));
    }

    public ServerBalls(int port, final String ip, Collection<Ball> balls) throws IOException {
        this.socket = new ServerSocket(port,50, InetAddress.getByName(ip));
        this.balls = balls;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            //accept des clients
            // calcul les bille
            PositionDetermination.getInstance().determinate(this.balls);
            // les envoient au clients
        }
    }

    @Override
    public String toString() {
        return "Server{" +
                "port=" + socket.getLocalPort() +
                "address=" + socket.getInetAddress() +
                '}';
    }
}
