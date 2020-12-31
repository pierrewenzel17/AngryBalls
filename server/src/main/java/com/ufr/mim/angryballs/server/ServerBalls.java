package com.ufr.mim.angryballs.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public final class ServerBalls implements Runnable {

    static final Logger logger = Logger.getLogger(ServerBalls.class);

    private final ServerSocket socket;

    private final CharlesHelpMe charlesHelpMe;

    private boolean isRunning = true;

    public ServerBalls(int port, final String ip, CharlesHelpMe charlesHelpMe) throws IOException {
        this.socket = new ServerSocket(port, 50, InetAddress.getByName(ip));
        this.charlesHelpMe = charlesHelpMe;
    }

    @Override
    public void run() {
        try {
            while (isRunning) {
                Socket client = socket.accept();
                logger.info("Connexion client reçu.");
                var clientBalls = new ClientBalls(client, charlesHelpMe);
                Thread threadClient = new Thread(clientBalls);
                threadClient.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
